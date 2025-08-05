
Proceeds this after completing the tasks in the [[activity-02]]
- [ ] Create another app called `mydatabaseapp` 
- [ ]  repeat the tasks from the [[activity-02]]
- [ ] then Create Models defining the parameters for the database `sqlite3.db`
- [ ] Register the models in the `admin.py`
- [ ] Create a superuser using `python manage.py createsuperuser`


## 04-Add app's name

```python
# Application definition
INSTALLED_APPS = [
    'mydatabaseapp'
]
```

## 05-Add `myapp.urls` to project's urls.py

```python
from django.contrib import admin

from django.urls import path, include

urlpatterns = [

    path('',  include('myhomeapp.urls')),
    path('' , include('mydatabaseapp.urls')),

    path('admin/', admin.site.urls),
]
```

## 11-Create Models 

> `models.py` -> `admin.py`

```python

from django.db import models

class MemberModel(models.Model):
	name = models.CharField(max_length=120)
	country = models.CharField(max_length=60)
	profession = models.CharField(max_length=60)
	hobby = models.CharField(max_length=60)

def __str__(self):
	return f"{self.name} - {self.profession}"

```

## 12- Register  the models in the `admin.py`

```python
from django.contrib import admin

from .models import MemberModel

# Register your models here.

class MembersAdmin(admin.ModelAdmin):

    list_display = ("name","country","profession","hobby")

admin.site.register(MemberModel, MembersAdmin)
```


## 13- Create another html to display data from database


>`member.html` ( Location : myapp/templates/member.html)

```html
{% load static %}

<table border="1" style="text-align: center;">
    <tr>
        <th>Name</th>
        <th>Country</th>
        <th>Profession</th>
    </tr>

    {% for item in members %}

        <tr>
            <td>{{ item.name }}</td>
            <td>{{ item.country }}</td>
            <td>{{ item.profession }}</td>
        </tr>
    {% endfor %}
    </table>
```

>`hello.html` ( Location : myapp/templates/hello.html)

```

{% extends 'master.html' %}

    {% block content %}

{% include 'members.html' %}

{% endblock %}

```

## 14- create a function inside the `view.py` to fetch data 

```python
# Create your views here.

def the_members_view(request):

     member_data = MemberModel.objects.all()
     context = {

        'heading' : "Hello World"

    }
    return render(request, 'hello.html', context)
```


## 09-create a urlpatterns for the above function in the app's `url.py`

> Note : this file is not created by default, you have to create it manually.
```python
from django.urls import path

from . import views

  

urlpatterns = [

    path('members', views.my_database_app_view, name='my_database_app_view')

]
```

## 14 - Run `makemigrations` and `migrate` to create the database tables 


## 15-Create `createsuperuser`


```python
python .\manage.py createsuperuser
```

```python
└─$ PS>python .\manage.py createsuperuser
Username (leave blank to use 'samst'): stephan
Email address: samstephan069@gmail.com
Password: 7642
Password (again): 7642
This password is too short. It must contain at least 8 characters.
This password is entirely numeric.
Bypass password validation and create user anyway? [y/N]: y
Superuser created successfully.
```

## 16- Login into the `localhost/admin` panel and Add entries






