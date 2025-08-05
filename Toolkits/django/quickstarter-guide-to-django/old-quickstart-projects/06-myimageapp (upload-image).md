
Proceeds this after completing the tasks in the [[activity-02]]
- [ ] Create another app called `myimageapp` 
- [ ] Add `import os` in the project's setting.py
- [ ] add `STATICFILES_DIRS` in `settings.py`
- [ ] add `MEDIA_ROOT` path in `settings.py`
- [ ]  repeat the tasks from the [[activity-02]]
- [ ] then Create Models defining the parameters for the database `sqlite3.db`
- [ ] Register the models in the `admin.py`
- [ ] Create a superuser using `python manage.py createsuperuser`


### Add `import os` in the `project's settings.py`
```python
import os

```

##### add `STATICFILES_DIRS` in `settings.py`

```python
# Static files (CSS, JavaScript, Images)

# https://docs.djangoproject.com/en/5.1/howto/static-files/

STATIC_URL = 'static/'
STATICFILES_DIRS = BASE_DIR / 'allstaticfiles'
```
##### add `MEDIA_ROOT` path in `settings.py`

```python
MEDIA_ROOT = os.path.join(BASE_DIR,'media')
MEDIA_URL = '/media/'
```
##### know your database -> `db.sqlite3`

```python
# Django's Local Database

# https://docs.djangoproject.com/en/5.1/ref/settings/#databases
DATABASES = {
			#'default': {
			#'ENGINE': 'django.db.backends.sqlite3',
			'NAME': BASE_DIR / 'db.sqlite3',
			}
		}
```


## create a media directory at the project's root

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
├── media/ 
│   └── uploads
│  
├── myproject/ 
│   ├── settings.py 
│   └── urls.py 
|
└── manage.py
```

## Add a parameter  `upload_to` in the app's models.py

```python
from django.db import models

# Create your models here.

class MemberModel(models.Model):

    image = models.ImageField(upload_to='uploads/')  ## add this entry
    name  = models.CharField(max_length=120)
    country = models.CharField(max_length=60)
    profession = models.CharField(max_length=60)
    hobby   = models.CharField(max_length=60)
    joindate = models.DateField()

    OPTIONS = [
        ("married", "Married"),
        ("unmarried", "Unmarried"),
	    ]

    martial_status = models.CharField(max_length=120, choices=OPTIONS,default="unmarried")
    
def __str__(self):
	return f"{self.name} - {self.profession}"
```
#### initially run -> `python manage.py makemigrations` & `migrate`

> [!done] Firstly `makemigrations`
> In Order to create new Table in Django's Database using the definition from `models.py`

```python
┌──(.venv)─(cipher㉿watchdog)-[~/HTTP/TheWatchdogServer/thewatchdog]
└─$ ./manage.py makemigrations        
No changes detected
    ```

> [!done] Lastly `migrate` 
> This will create a `snapshots` of all the necessary changes you made to your `models.py`

```python
┌──(.venv)─(cipher㉿watchdog)-[~/HTTP/TheWatchdogServer/thewatchdog]
└─$ ./manage.py migrate       
Operations to perform:
  Apply all migrations: admin, auth, contenttypes, sessions
Running migrations:
  Applying contenttypes.0001_initial... OK
  Applying auth.0001_initial... OK
  Applying admin.0001_initial... OK
  Applying admin.0002_logentry_remove_auto_add... OK
  Applying admin.0003_logentry_add_action_flag_choices... OK
  Applying contenttypes.0002_remove_content_type_name... OK
  Applying auth.0002_alter_permission_name_max_length... OK
  Applying auth.0003_alter_user_email_max_length... OK
  Applying auth.0004_alter_user_username_opts... OK
  Applying auth.0005_alter_user_last_login_null... OK
  Applying auth.0006_require_contenttypes_0002... OK
  Applying auth.0007_alter_validators_add_error_messages... OK
  Applying auth.0008_alter_user_username_max_length... OK
  Applying auth.0009_alter_user_last_name_max_length... OK
  Applying auth.0010_alter_group_name_max_length... OK
  Applying auth.0011_update_proxy_permissions... OK
  Applying auth.0012_alter_user_first_name_max_length... OK
  Applying sessions.0001_initial... OK                                       
```

We'll create a separate file named `members.html` in the project root's `template` directory

```html
{% load static %}

<table border="1" style="text-align: center;">

    <tr>
        <th>Photo </th>
        <th>Name</th>
        <th>Country</th>
        <th>Profession</th>
    </tr>

    {% for item in profile %}

        <tr>
            <td><img src="{{ item.image.url }}" width="150" height="200"/></td>
            <td>{{ item.name }}</td>
            <td>{{ item.country }}</td>
            <td>{{ item.profession }}</td>
        </tr>
    {% endfor %}

    </table>
```

#### including new template in `hello.html`


```python
{% extends 'master.html' %}


{% block title %} This is a Simple Hello Message {% endblock %}
{% block content %}
{% include 'members.html' %}

{% endblock %}
```

#### adding settings in `urls.py` to be able to display `media` files

add this line after the `urlpatterns = [] `
```python
+ static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT )
```
like this below
```python
from django.urls import path
from django.conf import settings
from django.conf.urls.static import static
from . import views

urlpatterns = [

    path('', views.the_members_view, name="the_members_view"),

] + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT )
```


```cmd
path('profile/detail/<pk>', views.the_profile_detail_view, name='the_profile_detail_view'),
path('profile/about/<name>',views.more_about_person_view, name='more_about_the_person_view')
```


### Output of HTML Webpage (`P0V:` At Client's side)

This part of the HTML will be visible by the end users after all the processing we did at the back-end.

```html
<!-- master.html -->

<!DOCTYPE html>

<html>
	<head>
	<title> This is a Simple Hello Message </title>
	</head>
<body>

	<table border="1" style="text-align: center;">
	
	<tr>
		<th>Photo </th>
		<th>Name</th>
		<th>Country</th>
		<th>Profession</th>
	</tr>
	<tr>
		<td><img src="/media/uploads/alex.jpg" width="100" height="150"/></td>
		<td>Alex</td>
		<td>America</td>
		<td>Artist</td>
	</tr>
	
	<tr>
		<td><img src="/media/uploads/bruce.jpg" width="100" height="150"/></td>
		<td>Bruce</td>
		<td>Brazil</td>
		<td>Bodyguard</td>
	</tr>
	
	<tr>
	
		<td><img src="/media/uploads/caroline.jpg" width="100" height="150"/></td>
		<td>Caroline</td>
		<td>Canada</td>
		<td>Consultant</td>
	
	</tr>
	<tr>
		<td><img src="/media/uploads/danny.jpg" width="100" height="150"/></td>
		<td>Danny</td>
		<td>Denmark</td>
		<td>Dentist</td>
	</tr>
	<tr>
		<td><img src="/media/uploads/fred.jpg" width="100" height="150"/></td>
		<td>Fred</td>
		<td>France</td>
		<td>Freelancer</td>
	
	</tr>
	</table>
	
</body>

</html>
```
