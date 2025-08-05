

## first Create a Model  

> models.py

```python
from django.db import models

  

# Create your models here.

class MyHomeappModel(models.Model):

    title = models.CharField(max_length=50)

    link  = models.URLField(max_length=250)

  

    status_options = [

        ("active","ACTIVE"),

        ("inactive","INACTIVE")

    ]

  

    status = models.CharField(max_length=20, choices=status_options, default="inactive")

  

def __str__(self):

    return f"{self.name} - {self.link}"
```

## Register the model in the `admin.py`
> admin.py

```python
from django.contrib import admin

from .models import MyHomeappModel

  

# Register your models here.

class MyHomeappAdmin(admin.ModelAdmin):

    list_display = ("title", "link")

  

admin.site.register(MyHomeappModel, MyHomeappAdmin)
```

## Fetch and send the context data to the html file

```python
from django.shortcuts import render

  

from .models import MyHomeappModel

  

linksinfo = MyHomeappModel.objects.all()

  

# Create your views here.

def my_home_view(request):

    context = {

        "linksinfo": linksinfo

    }

    return render(request, 'home.html', context)
```

> home.html

```
{% extends 'base.html' %}

  

{% block content %}

    {% include 'links.html' %}

{% endblock %}
```

> links.html (`myhomeapp/templates/links.html`)

```python
{% load static %}

<ol>

   {% for link in linksinfo %}

   <li><a href="{{ link.link }}" >{{ link.title }}</a>  - ( {{ link.link }} ) </li>

   {% endfor %}

</ol>
```

> urls.py

```python
from django.urls import path

from . import views

  

urlpatterns = [

    path('' , views.my_home_view, name='my_home_view')

]
```


## Output

```html

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
    </head>
    <body>
        <h1>My Project</h1>
        <main>
            
    

<ol>
   
<li><a href="http://127.0.0.1:8000/" >home</a>  - ( http://127.0.0.1:8000/ ) </li>
<li><a href="http://127.0.0.1:8000/admin/"> admin</a>-(http://127.0.0.1:8000/admin/) </li>
   
</ol>

        </main>
    </body>
</html>
```


