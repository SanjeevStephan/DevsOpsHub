## Today's Activity


- [ ] create a web-app 'myapp' 
- [ ] Add 'templates' directory  [[#01-Add `templates`]]
- [ ]  Add 'myapp' to the project's settings.py [[#04-Add app's name]]
- [ ] Include 'myapp.urls' in the project's urls.py [[#05-Add myapp's urls` to `urls.py`]]
- [ ] Create 'master.html' in the project's templates [[#07- Create html files for the view]]
- [ ] Create two html files 'hello.html' & 'members.html' in the myapp's templates directory
- [ ] Create a function defining the html views inside the views.py [[#08- create a function inside the `view.py`]]
- [ ] Add the view's function in the app's urls.py [[#09-create a for the above function in the app's `url.py`]]
- [ ] Run the server using `python manage.py runserver` 


## 01-Add `templates`

```python
 TEMPLATES = [
    {
		 'DIRS': [BASE_DIR / 'templates'],
	}
]
```

## 02-create a templates directory at the project's root

```python
myproject/ 
│ 
├── myapp/ 
│   ├── views.py 
│   └── urls.py 
|
├── static/ 
│ └── css/ 
│     └── styles.css 
|
├── templates/ 
│   ├── master.html 
│   └── home.html 
│  
├── myproject/ 
│   ├── settings.py 
│   └── urls.py 
|
└── manage.py
```
## 03- Create An App

```python
python manage.py startapp myapp
```
## 04-Add app's name

```python
# Application definition
INSTALLED_APPS = [
    'myapp'
]
```

## 05-Add myapp's urls` to `urls.py`
```python
urlpatterns = [
    path('' , include('myapp.urls')),
    path('admin/', admin.site.urls),
]
```

## 06-create a templates directory inside the `myapp` directory

```python
myproject/ 
│ 
├── myapp/ 
│   ├── views.py 
│   ├─── urls.py 
|	|
│	└── templates/ 
│	   └── hello.html 
|
├── myproject/ 
│   ├── settings.py 
│   └── urls.py 
|
└── manage.py
```



## 07- Create html files for the view
1. One in the Outside `templates` directory with the name `master.html`
2. And one within the templates directory inside the app's directory.

>`master.html` (Location : myproject/templates/master.html )

```html
{% load static %}

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Master Site</title>
    </head>
    <h1>Master Page</h1>
    {% block content %} <h2> This is sample page</h2> {% endblock %}

</html>
```

>`hello.html` ( Location : myapp/templates/hello.html)

```

{% extends 'master.html' %}

    {% block content %}
    <h1>{{ heading_one }}</h1>
    {% endblock %}

```


## 08- create a function inside the `view.py`

```python
# Create your views here.

def the_members_view(request):

     context = {
        'heading' : "Hello World"
    }

    return render(request, 'hello.html', context)
```

## 09-create a  for the above function in the app's `url.py`
> Note : this file is not created by default, you have to create it manually.
```python
from django.urls import path

from . import views

urlpatterns = [

    path('', views.the_members_view, name='the_members_view')

]
```

## 10- Run the server to check if everything is setup correctly

```python
python manage.py runserver
```


