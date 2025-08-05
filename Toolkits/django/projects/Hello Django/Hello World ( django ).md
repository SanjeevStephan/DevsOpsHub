
# The Table

1. [[#Initial Setup]]
	1. [[#Setup Python Virtual Environment]]
		1. [[#create python `.venv`]]
		2. [[#activate virtual environment]]
		3. [[#install required python libraries]]
	2. [[#Setup Django Project]]
		1. [[#create django project]]
			1. [[#create django app]] 
2. [[#Configuring the Project's `settings.py`for Development]]
	1. [[#basic `thewatchdog` directory structure]]
	2. [[#initial configurations in project's `settings.py`]]
		1. [[#add `import os` & add some entries in `ALLOWED_HOSTS`]]
		2. [[#add `the_dashboard_app` to the `INSTALLED_APPS`]]
		3. [[#add `templates` directory to `TEMPLATES=[..]` in `settings.py`]]
		4. [[#add `STATICFILES_DIRS` in `settings.py`]]
		5. [[#add `MEDIA_ROOT` path in `settings.py`]]
		6. [[#know your database -> `db.sqlite3`]]
	3. [[#initially run -> `python manage.py makemigrations` & `migrate`]]
3. [[#Modifying the Project's `urls.py` to Redirect REQUESTS]]
	1. [[#URL configuration for `thewatchdog` project.]]
	2. [[#Include `the_dashboard_app` in Project's `urls.py`]]
4. [[#`Hello, Django`]]
	1. [[#`master.html`]] <- From App's `templates` directory
	2. [[#`hello.html`]] <- From Project's `templates` directory
	3. [[#`views.py`]]
		1. [[#render]]
		2. [[#request]]
		3. [[#hello.html]]
		4. [[#context]]
		5. [[#Example-01]]
			1. [[#Task-01 Greet to 5 Friends Individually]]
			2. [[#Task-02 Adding Photos along with name to greet the correct person]]
	4. [[#`urls.py`]]
	5. [[#`./manage.py runserver 10.42.0.125 80`]]
5. [[#Hello, Superuser]]
	1. [[#Create a superuser]]
	2. [[#Create Database Table using `models.py`]]
		1. [[#Step-01 Decide what types of data, you want to store]]
		2. [[#Step-02 Create definition in the `Models.py`]]
		3. [[#Step-03 Register the `models.py`'s class in the `admins.py`]]
		4. [[#Step-04 `python manage.py makemigrations`]]
		5. [[#Step-05 `python manage.py migrate`]]
	3. [[#Finally, Say Hello to `superuser` in admin panel at http //127.0.0.1 80/admin]]
6. [[#Give Admin `superuser` -> some work to do!]]
	1. [[#Assignment-00 Admin's Assignment Check-List]]
	2. [[#Assignment-01]]
		1. [[#Task-01 Put some data on the fields]]
		2. [[#Task-02 Save the Data]]
	3. [[#Assignment-02 Making Sure his DATA is SAFE]]
		1. [[#Task-01 Backup the Database's Table]]
			1. [[#Backup-01 Backing up the whole database]]
			2. [[#Backup-02 Backing up the specific app's table]]
		2. [[#Task-02 Delete the data]]
		3. [[#Task-03 Restore the Data from `backup.json`]]
			1. [[#Restore-01 Restoring the whole database]]
			2. [[#Restore-02 Restore the Data for Specific Table]]
		4. [[#Task-04 Bypasss the Admin Panel to add Multiple data at once]]
			1. [[#Bypass Prerequisites ( Making sure everything goes as expected )]]
			2. [[#Make Necessary Changes]]
			3. [[#Restoring App Specific Tables]]
		5. [[#Task-05 Automate Backup & Restore using Shell Scripts]]
			1. [[#Step-01 Create the Script with ==`.sh`== extension]]
			2. [[#Step-02 Insert Command as per your needs]]
			3. [[#Step-03 Make it Executable]]
			4. [[#Step-04 Execute it]]
7. [[#Wielding the power of Django's built-in database]]
	1. [[#Accessing the data from database using `models.py` in `views.py`]]
	2. [[#Using the HTML Templates to display our Data]]
		1. [[#`profile.html`]]
		2. [[#including new template in `hello.html`]]
		3. [[#adding settings in `urls.py` to be able to display `media` files]]
	3. [[#Output of HTML Webpage (`P0V ` At Client's side)]]
	4. [[#Finally, Serving HTML Webpage to the end-client]]
8. [[#Powering the website using `static` electricity (css,js)]]
	1. [[#navigation menu (`navbar.html`)]]
	2. [[#stylesheet (`mystyle.css`)]]
	3. [[#adding css to `master.html`]]
	4. [[#adding hyperlink to our `profile.html` template]]
	5. [[#`detail.html`]]
9. [[#FAQs]]
	1. [[#How to make webpage fits the mobile-screen]]
	2. [[#How to Make `media` files readily available]]
	3. [[#How to back app's data in the database]]


---
# The Structure

```python
myproject/  
├── profileapp/ 
│   ├── migrations/
│	├── static/ 
│   │   └── css/ 
│   │      └── mystyles.css
│   ├── templates/ 
│   │      └── master.html
│   ├── hello.html 
│  	├── admins.py 
│  	├── models.py 
│  	├── views.py 
│	└── urls.py 
|
├── static/ 
│ └── css/ 
│     └── styles.css
│ 
├── jsons/ 
│   ├── db_backup.json
│   └── profile_app_data.json
│ 
├── media/ 
│   ├── background/
│   └── uploads/
│ 
├── templates/ 
│   ├── hello.html 
│   ├── navbar.html 
│   ├── profile.html 
│   ├── detail.html 
│   └── contact.html 
|
├── hello/ 
│   ├── settings.py 
│   ├── urls.py 
│   └── wsgi.py 
│ 
├─── backup_profile_app.py
├─── launch.sh
├─── db.sqlite3
└──  manage.py
```
# The Contents
## Initial Setup

#### Setup Python Virtual Environment

##### create python `.venv`

```python
mkdir 'Hello Django'
cd 'Hello Django'
python -m venv .venv
```
##### activate virtual environment
```python
source .venv/bin/activate
```

##### install required python libraries
```python
pip install -r requirements.txt
pip list
		Package              Version
		-------------------- --------
		asgiref              3.8.1
		diff-match-patch     20230430
		Django               5.1.1
		django-import-export 4.1.1
		pillow               10.4.0
		pip                  24.2
		setuptools           70.3.0
		sqlparse             0.5.1
		tablib               3.5.0
		whitenoise           6.7.0

pip freeze > requirements.txt
```

#### Setup Django Project

##### create django project
```python
django-admin startproject hello
```

##### create django app

navigate inside the project `thewatch` using `cd thewatchdog` 

```python
python manage.py startapp profileapp
```

##### launch the `server` (for first time)
```python
python manage.py runserver
```

## Configuring the Project's `settings.py`for Development

#### basic `thewatchdog` directory structure

```python       
Permissions  User    Types     Title                The Purpose
-rw-r--r-- 1 cipher  File      db.sqlite3        -> The Database
-rwxrwxr-x 2 cipher  File      manage.py         -> For Shell Command
drwxrwxr-x 3 cipher  Directory profileapp -> The App
drwxrwxr-x 4 cipher  Directory hello       -> The Project 
```

#### initial configurations in project's `settings.py`
> check your ip-address 

```python
ifconfig

wlan0: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet 10.42.0.125  netmask 255.255.255.0  broadcast 10.42.0.255
```

> open project in `vscode` 


| Shortcuts  | What does it Do ?                                               |
| ---------- | --------------------------------------------------------------- |
| `CTRL + ~` | Click the Terminal & Use Shortcut to Toggle VSCode's `Terminal` |
| `CTRL + B` | Toggle File Explorer                                            |
> activate the python virtual environment in vscode 

```python
┌──(cipher㉿watchdog)-[~/HTTP/TheWatchdogServer/thewatchdog]
└─$ source ../.venv/bin/activate
```

> stop the apache2 server if running

```python
sudo systemctl status apache2      # Check the status of apache2 web server.
sudo systemctl stop apache2        # Stop the apache2 web server if running
sudo systemctl disable apache2     # Disable the server from auto-start
```

> relaunch the server on different port

```python
┌──(.venv)─(cipher㉿watchdog)-[~/HTTP/TheWatchdogServer/thewatchdog]
└─$ ./manage.py runserver 80
```

```python
# THe Output
┌──(.venv)─(cipher㉿watchdog)-[~/HTTP/TheWatchdogServer/thewatchdog]
└─$ ./manage.py runserver   

# Watching for file changes with StatReloader
# Performing system checks...

# System check identified no issues (0 silenced).

# You have 18 unapplied migration(s). Your project may not work properly until you apply the migrations for app(s): admin, auth, contenttypes, sessions.
Run 'python manage.py migrate' to apply them.
#September 16, 2024 - 08:56:41
#Django version 5.1.1, using settings 'thewatchdog.settings'
Starting development server at http://127.0.0.1:8000/
Quit the server with CONTROL-C.

#[16/Sep/2024 08:56:44] "GET / HTTP/1.1" 200 12068
#[16/Sep/2024 08:56:55] "GET / HTTP/1.1" 200 12068
```

> visit the django's website here at default HTTP-PORT -> http://127.0.0.1:8000/


![[django-project-launched-successfully-on-first-run.png]]


##### add `import os` & add some entries in `ALLOWED_HOSTS=[ ]`

> [!done] add `import os` & add some entries in `ALLOWED_HOSTS`
> In Order for your website to be accessed by other devices in your local network. 
> > Using the `Server's IP ADDRESS` or the Specified `LocalDNS` name 

```python
import os

# SECURITY WARNING: don't run with debug turned on in production!
ALLOWED_HOSTS = ['127.0.0.1','10.42.0.125']
```

##### add `the_dashboard_app` to the `INSTALLED_APPS=[..]` 

> [!done]  add `hello` to the `INSTALLED_APPS` 
> To be able to use the app -> it has to be mentioned specifically manually below

```python
# Application definition

INSTALLED_APPS = [
	'django.contrib.admin','..',
	'hello'  # The APP
	]
```

##### add `templates` directory to `TEMPLATES=[..]` in `settings.py`

```python
TEMPLATES = [
		{
			'BACKEND': 'django.template.backends.django.DjangoTemplates',
			'DIRS': [BASE_DIR / 'templates'], 
			'...',

		},
]
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
			'default': {
			'ENGINE': 'django.db.backends.sqlite3',
			'NAME': BASE_DIR / 'db.sqlite3',
			}
		}
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


## Modifying the Project's `urls.py` to Redirect REQUESTS

#### URL configuration for `thewatchdog` project.

> [!done] The `urlpatterns` list routes URLs to views. 
> > For more information please see: 
>> https://docs.djangoproject.com/en/5.1/topics/http/urls/

Examples:

>Function views

1. Add an import: from my_app import views
2. Add a URL to urlpatterns: path('', views.home, name='home')

>Class-based views

1. Add an import: from other_app.views import Home
2. Add a URL to urlpatterns: path('', Home.as_view(), name='home')

>Including another URLconf

1. Import the include() function: from django.urls import include, path
2. Add a URL to urlpatterns: path('blog/', include('blog.urls'))


#### Include `the_dashboard_app` in Project's `urls.py`

> [!Done] The `urlpatterns` will routes URLs to app's views. 
> Below statement will redirect all the `url-requests` to `the_dashboard_app`'s `urls.py`
> Which we will create in next Step 
> This allows the URLs Request received by the Project's `urls.py` to be routed to Individual App's `urls.py`

```python
# from django.contrib import admin
# from django.urls import include, path

# urlpatterns = [
	path('', include('profileapp.urls')),
  # path('admin/', admin.site.urls),
]
```

	
## `Hello, Django`  

#### `master.html` 

> [!todo] Create `master.html` in the App's `templates` directory 
> - Create `templates` directory in App ->`the_dashboard_app`'s directory
> - Create `master.html` file in the -> App's `templates`s directory
> - Below Code will act as a html template which we'll reuse in next step
> - Simpley, Copy & Paste -> below code to quickly for next steps


```html
{% load static %}
<!-- master.html -->
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title> {% block title %} Put Your Title Here {% endblock %}</title>
	</head>
	<body>
		<h1>Hello, {% block content %} World {% endblock %}</h1>
	</body>
</html>
```

>Here is What's Happening

1. we are using the django's tags `{% .. %}` for the first time which allows us to execute python instructions or logical code from within the HTML Document when called upon.
2. then we are using tags like this -> `{% load static %} ` which tells django that we are serving static-files from `static` directory such as { images, css , js } on our website.
3. without the { step-2 }-> we won't be able to server any static files. let alone the django will literally disregard from serving any static files and won't register any other tags mentioned in { step-1 }
4. further we we using `{% block title %}` `{% endblock %}` -> any content put between those tag blocks will be override the default content when extended or called upon by other html files by further using the `{% extends 'master.html' %}` 

##### HTML Meta Tag to Make Webpage Fits the Mobile-Device Screen

```html
<meta name="viewport" content="width=device-width, initial-scale=1">
```


#### `hello.html`

> [!todo] Similarly, Create `hello.html` in the Main Project's `templates` (root) directory 
> - Create `templates` directory in Project's -> root directory
> - Create `hello.html` file in the -> Project's `templates`s directory
> - Copy & Paste -> below code to quickly for next steps
> - This further ensures that the `templates` directory outside app's is operational

```python
{% extends 'master.html' %}

{% block title %} This is a Simple Hello Message {% endblock %}
{% block content %} {{ title }} {% endblock %}
```

> Here is what's happening

1. we first used `{% extends 'master.html' %}` block to  mirror all the code from `master.html` to this `hello.html`. This helps in reusing the code and making necessary changes without even touching the `master.html` codebase.
			1. whenever we use blocks like `{% block title %}` or `{% block content %}` we are basically saying that whatever content is placed between those `{% endblock %}` blocks in the original `master.html` file -> we are going to override its content and replaces it with the new and interesting one without affecting the original `master.html` code.

#### `views.py`

```python
from django.shortcuts import render
# Create your views here.

def the_dashboard_home_view(request):
	context = { 'title' : 'Django'}
	return render(request, 'hello.html', context)
```

> This is what's happening

1. First we have to `import render` function from `django.shortcuts` modules to render the webpage in order to serve the client who request using the urls from [[#`urls.py`]]
2. Then we define the function to handle the HTTP Requests and then -> serves the client with the HTML webpage along with necessary information they are looking for
3. Whenever we are referring to tags like `{{ title }}` you saw in [[#`hello.html`]] . we are basically picking up the value from this dictionary named `context = { key : value }`
4. when are are done processing the request we then humbly return the request along with `{ request, 'hello.html', context }`
	1. `request` -> 
	2. `hello.html` ->
	3. `context` ->

##### request

##### context


> [!NOTE] Context 
> Context variable  is basically of `<type> dictionary = { 'key' : 'value' }` 

whenever we see tags like this `{{ title }}` in the html documents we are basically keywords whose value we are pulling from either context dictionary variable defined in the function `def` in `views.py` or from the sqlite database itself.
we have already seen that in [[#`views.py`]] which was hard-coded in the code, which is not a preferred way of doing it.
The preferred of doing it is from pulling value from the database itself.

Let's Understand this with an example -> [[#The Profile App ( Example)]]
#### `urls.py`

> [!warning] Note : This files is not created by default -> you have to create it { `urls.py` }

```python
from django.urls import path

from . import views

	urlpatterns = [
	path('' , views.the_profileapp_view, name='the_profileapp_view'),
	path('profile/detail/<pk>', views.the_profile_detail_view, name='the_profile_detail_view')

]
```


#### `./manage.py runserver 10.42.0.125:80`

> Let's Quickly -> Test the Operations of our previous steps.

we'll be running it on host's ip address, if you forgot by then now then following instructions
-> from step { [[#add `import os` & add some entries in `ALLOWED_HOSTS=[ ]`]]}
```python
python manage.py runserver 10.42.0.125:80
```

> The Command Process

```python
┌──(.venv)─(cipher㉿watchdog)-[~/HTTP/TheWatchdogServer/thewatchdog]
└─$ python manage.py runserver 10.42.0.125:80
Watching for file changes with StatReloader
Performing system checks...

System check identified no issues (0 silenced).
September 16, 2024 - 10:54:19
Django version 5.1.1, using settings 'thewatchdog.settings'
Starting development server at http://10.42.0.125:80/
Quit the server with CONTROL-C.

[16/Sep/2024 10:54:38] "GET / HTTP/1.1" 200 190
Not Found: /favicon.ico
[16/Sep/2024 10:54:38] "GET /favicon.ico HTTP/1.1" 404 2475
[16/Sep/2024 10:54:41] "GET / HTTP/1.1" 200 190

```

> Result 

![[Pasted image 20240916162946.png]]


## Hello, Superuser

#### Create a superuser 

> [!todo] Create a `superuser`
> for managing all the admin related tasks 


```python
./manage.py createsuperuser
```

```python
└─$ ./manage.py createsuperuser
Username (leave blank to use 'cipher'): 
Email address: c1ph3rwolf@gmail.com
Password: 764289
Password (again): 
This password is too short. It must contain at least 8 characters.
This password is entirely numeric.
Bypass password validation and create user anyway? [y/N]: y
Superuser created successfully.                      
```

![[Pasted image 20240917033521.png]]
Now we have `superuser` with us. He needs works to do and his greatest superpower is his ability to manage database. right now we don't have none -> so let's create quickly

#### Create Database Table using `models.py`

In order to create a Table for the Django's database we have to define what sort of information we want to collect or looking for the admin `superuser` to manage.

![[#Profile-Table]]

##### Step-01 | Decide what types of data, you want to store

if we carefully look at the table,we will notice that `data` are categorised in -> four(4) column 
1. Profile-Photo -> Which is of type `ImageField`
2. Name -> Which is of type `CharField()` for it `max_length` should be not more than 50
3. Country -> Which is of type `CharField()` and `max_leng` would be same as above
4. Profession -> Which is of type `CharField()` and `max_leng` would be same as above

##### Step-02 | Create definition in the `Models.py`

```python
from django.db import models

# Create your models here.

class ProfileModel(models.Model):
	image      = models.ImageField(upload_to='uploads/')
	name       = models.CharField(max_length=50)
	country    = models.CharField(max_length=50)
	profession = models.CharField(max_length=50)

def __str__(self):
	return f"{self.name} - {self.profession}"
```

##### Step-03 | Register the `models.py`'s class in the `admins.py`

```python
from django.contrib import admin
from .models import ProfileModel

# Register your models here.

class ProfileAdminPanel(admin.ModelAdmin):
	list_display = ("name","profession")

admin.site.register(ProfileModel,ProfileAdminPanel)
```

##### Step-04 | `python manage.py makemigrations`

In order for you to actually be able to create table in the database itself -> you need to run this command 
```python
python manage.py makemigrations
```

```python
# Run Below Command
└─> python manage.py makemigrations     
# The Output Below
Migrations for 'profileapp':
  profileapp/migrations/0001_initial.py
    + Create model ProfileModel
```

##### Step-05 | `python manage.py migrate`

```python
└─> ./manage.py migrate       
Operations to perform:
  Apply all migrations: admin, auth, contenttypes, profileapp, sessions
Running migrations:
  Applying profileapp.0001_initial... OK
```

##### Finally, Say Hello to `superuser` in admin panel at http://127.0.0.1:80/admin

> [!done] Login into your admin panel using the credentials

![[#Create a superuser]]


![[Pasted image 20240917024404.png]]

## Give Admin `superuser` -> some work to do!
### Assignment-00 | Admin's Assignment Check-List 

> [!todo] 
> We starts counting from zero because we are programmers -> we use `array=[0,1,..]`

Now we have the data on the database table but the admin's works is not done yet
-> its just getting started.
> Let's Quickly Summarise the Steps we have take so far to reach here & appreciate it!
> OR Consider it as your assignment to cross down some to-do list
- [ ] admin has been tasked to decide what data points and its types to collect
- [ ] admin has be able to defined the definition in `models.py` required to create the table
- [ ] admin successfully login-ed into his admin-panel and saved some data 
- [ ] admin has to make sure that the directory `/media/uploads` is able to receive image file
- [ ] Lastly, admin has the responsibility to make sure his data is safely & securely (backup)


### Assignment-01 | Save the Data

##### Task-01 | Put some data on the fields

![[Pasted image 20240917023529.png]]

##### Task-02 | Save the Data 

![[Pasted image 20240917025154.png]]

### Assignment-02 | Making Sure his DATA is SAFE
#### Task-01 | Backup the Database's Table

we will use terminal to backup the data using some `python manage.py` shell commands

##### Backup-01 | Backing up the whole database

```python
 python manage.py dumpdata --indent 2 > backup.json
```

#####  Backup-02 | Backing up the specific app's table

> Command to Backup Only Specific Database's Table.
```python
python manage.py dumpdata profileapp.ProfileModel --indent 2 > profile_app_data.json
```

>[!done] `profile_app_data.json`

> The Output <- `profile_app_data.json`
```json
[
	{
	
	"model": "profileapp.profilemodel",
	"pk": 1,
	"fields": 
		{
		"image": "uploads/alex.jpg",
		"name": "Alex",
		"country": "America",
		"profession": "Artist"
		}
	}
]
```

##### Backup-03 | Backing up the Admin Users

> Command to Backup -> Admin Superuser
```python
python manage.py dumpdata auth.user --indent 2 > user_auth.json   
```

> Output <- `user_auth.json`

```json
[

	{
	
	"model": "auth.user",
	"pk": 1,
	"fields": 
		{
		"password": "pbkdf2_sha256$870000$BpW9lulrSgMdB1p9g4RY9i$AB4USfXu4VLahZMvohD6RUzxd0WNPLhqmzXCJ7PygaI=",
		"last_login": "2024-09-16T21:04:51.083Z",
		"is_superuser": true,
		"username": "cipher",
		"first_name": "",
		"last_name": "",
		"email": "c1ph3rwolf@gmail.com",
		"is_staff": true,
		"is_active": true,
		"date_joined": "2024-09-16T16:31:27.844Z",
		"groups": [],
		"user_permissions": []
		
		}
	
	}

]
```

#### Task-02 | Delete the data
> Select the data you want to delete
![[Pasted image 20240917032819.png]]
> Now Actually Delete the Data
![[Pasted image 20240917040139.png]]
#### Task-03 | Restore the Data from `backup.json`

##### Restore-01 | Restoring the whole database

```python
└─$ python manage.py loaddata backup.json             
Installed 40 object(s) from 1 fixture(s)
```

> Note : Restore fresh database

- When you backup whole database by using `dumpdata` command, it will backup all the database tables
- If you use this database dump to load the fresh database(in another django project), it can be causes `IntegrityError` (If you `loaddata` in same database it works fine)
- To fix this problem, make sure to backup the database by excluding `contenttypes` and `auth.permissions` tables

```python
./manage.py dumpdata --exclude auth.permission --exclude contenttypes > db.json
```
##### Restore-02 | Restore the Data for Specific Table

```python
└─$ python manage.py loaddata backup/profile_app_data.json
Installed 1 object(s) from 1 fixture(s)
```

#### Task-04 | Bypasss the Admin Panel to add Multiple data at once

##### Bypass Prerequisites ( Making sure everything goes as expected )
Now that we know what and how the app's database table looks like, using the previously gained knowledge of restoring from step { [[#Restore-02 Restore the Data for Specific Table]] }
-> we can now manually automate the process of adding each and every individual data
-> for that open up the file `profile_app_data.json` from step { [[#Backup-02 Backing up the specific app's table]] }

> Restoring Checklist 
- [ ] Duplicate the data between the tag `{ .. }` along with the `{` tag 
	![[Pasted image 20240917043337.png]]
- [ ] Don't forget to put `,` after each `{..}`  <- ==Important==
- [ ] Make necessary changes in the ==`json`== file 
- [ ] Place the necessary `image files` in their respective directory ==`/media/uploads`==
	![[Pasted image 20240917043216.png]]
- [ ] Run Restore Command 

##### Make Necessary Changes 
> [!todo] These are the keys you need to make changes in
> Here is your reference -> Take a Look { [[#Profile-Table]] }
1. ==`'pk`== : Primary Key (pk=1) -> Increment the Value from 1 to the number of entries u add
2. ==`'image'`== : change the image-filename of the individual
3. ==`'name'`== : change the name of the person
4. ==`'country'`== change the country's name ^[from where the person belongs]
5. ==`'profession'`== change the Profession 

> [!todo] Copy the below data and paste it back into the 
>> JSON File -> ==`profile_app_data.json`==
```json
[
	{
	
	"model": "profileapp.profilemodel",
	"pk": 1,
	"fields": 
		{
		"image": "uploads/alex.jpg",
		"name": "Alex",
		"country": "America",
		"profession": "Artist"
		}
	},
	{
	"model": "profileapp.profilemodel",
	"pk": 2,
	"fields": 
		{
		"image": "uploads/bruce.jpg",
		"name": "Bruce",
		"country": "Brazil",
		"profession": "Bodyguard"
		}
	},
	{
	
	"model": "profileapp.profilemodel",
	"pk": 3,
	"fields": 
		{
		"image": "uploads/caroline.jpg",
		"name": "Caroline",
		"country": "Canada",
		"profession": "Consultant"
		}
	},
	{
	
	"model": "profileapp.profilemodel",
	"pk": 4,
	"fields": 
		{
		"image": "uploads/danny.jpg",
		"name": "Danny",
		"country": "Denmark",
		"profession": "Dentist"
		}
	},
	{
	
	"model": "profileapp.profilemodel",
	"pk": 5,
	"fields": 
		{
		"image": "uploads/fred.jpg",
		"name": "Fred",
		"country": "France",
		"profession": "Freelancer"
		}
	}
]
```

##### Restoring App Specific Tables 

```python
└─> python manage.py loaddata backup/profile_app_data.json
Installed 5 object(s) from 1 fixture(s)
```

![[Pasted image 20240917045317.png]]

#### Task-05 | Automate Backup & Restore using Shell Scripts

##### Step-01 | Create the Script with ==`.sh`== extension
```python
# In Linux 
touch backup_whole_database.sh
# In Windows
new-item backup_whole_database.ps1
```
##### Step-02 | Insert Command as per your needs
> On Linux ( bash script )

```
# Edit File in Terminal 
nano backup_whole_database.sh
```

backup specific whole database
```python
# Insert below Command

python manage.py dumpdata --indent 2 > backup_whole_database.json
```

backup specific app's table
```python
# Insert below Command

#! /bin/bash
python manage.py dumpdata profileapp.ProfileModel --indent 2 > profile_app_data.json
```

> On Windows ( powershell script)

```python
# Edit File in Notepad 
notepad profile_app_data.ps1
```

```python
# Insert below Command

python manage.py dumpdata profileapp.ProfileModel --indent 2 > profile_app_data.json
```

##### Step-03 | Make it Executable
> In Linux 

```python
chmod +x profile_app_data.sh
```
> In Window

```powershell
# set-executionpolicy policy ? 
```

##### Step-04 | Execute it 
> In Linux

```python
sh profile_app_data.sh
```

> In Windows 

```
./profile_app_data.ps1
```




---
## Wielding the power of Django's built-in database

### Accessing the data from database using `models.py` in `views.py`

We have the Data in our database namely below

![[#Restoring App Specific Tables]]

But its of no good -> if we can access it and being able to serve our client the requested information when needed, so.
Let's Access the data, shall we !

> [!done] Only way is through the `models.py`. yeah let me say that again 
> Only way is through the `models.py` via -> `views.py` then -> `hello.html`
> 

This is the code we have in `views.py`
![[#`views.py`]]


> Let's Make some changes in the `views.py`

Here are the check-list
- [ ] First, import the `model` class from `modles.py` -> `from .models import ProfileModel`
- [ ] Second, create an instances of that class -> a temporary allocation in memory to store our value -> `profile = ProfileModel.objects.all()`
- [ ] Third, Passing it down to the context -> `context = [ 'profile' : profile ]`


```python
from django.shortcuts import render
from .models import ProfileModel

# Code from `views.py`

def the_profileapp_view(request):
	profile = ProfileModel.objects.all()
	context = { 'title' : 'Django', 'profile' : profile }
	
	return render(request, 'hello.html', context)
```


### Using the HTML Templates to display our Data

#### `profile.html` 
Previously we have see that, we used the `master.html` HTML Document file as template to extend its code onto another file now we have to include a new html template since the request of the client has been changed and wanted different data to be severed this time. more specifically we have to design a table something like the one below 

![[#Profile-Table]]


The above table has 5 row & 5 column. Lets write a code for it

We'll create a separate file named `profile.html` in the project root's `template` directory

```html
<table border="1" style="text-align: center;">

<tr>
	<th>Photo </th>
	<th>Name</th>
	<th>Country</th>
	<th>Profession</th>
</tr>

{% for item in profile %}
	<tr>
		<td><img src="{{ item.image.url }}" width="100" height="150"/></td>
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

{% include 'profile.html' %}


{% endblock %}
```

#### adding settings in `urls.py` to be able to display `media` files


```python
from django.urls import path
from django.conf import settings
from django.conf.urls.static import static
from . import views

  

urlpatterns = [

path('' , views.the_profileapp_view, name='the_profileapp_view'),
path('profile/detail/<pk>', views.the_profile_detail_view, name='the_profile_detail_view'),
path('profile/about/<name>',views.more_about_person_view, name='more_about_the_person_view')

] + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT )
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

### Finally, Serving HTML Webpage to the end-client

![[Pasted image 20240917094621.png]]


## Powering the website using `static` electricity (css,js)

> [!done] Let's Recap what we have accomplished till now
> We are able to Launch Django website which uses isolated python libraries running inside a separate virtual environmental container in {`.venv` } . Great thing about this website is that its uses reusable html templates which pull up data from the database which also includes images from `media/uploads` directory and this database is fully managed by superuser who can create database table using the help of object oriented `models.py` class and he can also delete database, can backup its data & restore it from the JSON File

> There is lot of room for Improvement such as 

1. This sample website lack a basic navigation menu to navigate around
2. No Styling such as css or js to make the webpage look interesting
3. This landing page leads client nowhere -> forces the client to view the boring single page.
4. No dynamic URLs .
5. 

Let's address the issue one by one

### navigation menu (`navbar.html`)
put this code in [[#`master.html`]] between the `<body> </body>` tags at the beginning of it.
```html

<!-- navbar.html -->
<div class="navbar">

	<a href="/">Home</a>
	
	<a href="/contact">Contact</a>
	
	<a href="/resume">About</a>

</div>
```


### stylesheet (`mystyle.css`)

```css
 
body {

font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;

background-image: url('/media/background/luke-unsplash.jpg');

}

.navbar {

	overflow: hidden;

}

.navbar a {

		float : left;
		
		display: block;
		
		color: #000000;
		
		text-align: center;
		
		padding: 10px 10px;
		
		text-decoration: none;

}

.nav a:hover {

		background-color: #000000;
		
		color: rgb(255, 255, 255);

}
```

### adding css to `master.html`
you need to place below tag within the `<head> .. </head>`
-> kindly notice the tag `{% static '..' %}` which means the resource is placed in `static` directory of the app's directory.
```html
<link rel="stylesheet" href="{% static 'css/mystyle.css' %}" ></link>
```

> after making changes to `master.html`

```html
{% load static %}

<!-- master.html -->

<!DOCTYPE html>

<html>

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title> {% block title %} Put Your Title Here {% endblock %}</title>
	<link rel="stylesheet" href="{% static 'css/mystyle.css' %}" ></link>
</head>

<body>
	{% include 'navbar.html' %}
	
	{% block content %} Hello, World {% endblock %}
</body>

</html>
```

### adding hyperlink to our `profile.html` template

here we'll be adding another column to the table which will be our about column which will points to a page which display a general details about the person using the already available data from database.

```html
<!-- profile.html -->
<a href="{% url 'the_profile_detail_view' item.pk %}">More About Me</a>

```


> after making new changes

```html
<!-- profile.html -->
<table class='mytable' border="1" style="text-align: center;">

<tr>

	<th>Photo </th>
	<th>Name</th>
	<th>Country</th>
	<th>Profession</th>
	<th>About</th>

</tr>

{% for item in profile %}

<tr>

	<td><img src="{{ item.image.url }}" width="100" height="150"/></td>
	<td>{{ item.name }}</td>
	<td>{{ item.country }}</td>
	<td>{{ item.profession }}</td>
	<td>
		<a href="{% url 'the_profile_detail_view' item.pk %}">More About Me</a>
	</td>

</tr>


{% endfor %}

</table>
```

for that we need to create another html template named `detail.html`  with the following content

> This is what will happen

1. when we list a list of person details from the database on the page [[#Using the HTML Templates to display our Data#`profile.html`]] . This list also contains the `primary-key` which is a unique-id generated automatically by the django-admin system when you add an item to the database table.
2. so when we mention `{% url 'the_profile_detail_view' item.pk %}`
	1. `url` : this means we are looking for the URL from the list of URLs declared in the file named `urls.py` any where in the system.
	2. `the_profile_detail_view` : above `url` is further identified by the keyword or name which was declared along in the `path(..)` function of the `urlspatterns = [..]` in the file `urls.py`
	3. `item.pk` : lastly when we iterate over the database's table we are looking for the `pk` key which holds unique and serial number based on the entries of an item.
3. This URL will redirect the views `name='the_profile_detail_view'` in `urls.py`

> snapshot of `urls.py`

```python
# profileapp/urls.py
from django.urls import path
from django.conf import settings
from django.conf.urls.static import static
from . import views

urlpatterns = [

	path('' , views.the_profileapp_view, name='the_profileapp_view'),
	
	path('profile/detail/<pk>', views.the_profile_detail_view, name='the_profile_detail_view')
	
	] + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT )
```


### `detail.html`

```python
<!-- templates/details.html -->
{% extends 'master.html' %}

{% block title %} Profile Detail {% endblock %}

{% block content %}

	<h3>Hey My Name is {{ person.name }}, i am from {{ person.country }} and I make a living as a {{ person.profession }}</h3>

{% endblock %}
```


### handling the HTTP request in `views.py`

```python
def more_about_person_view(request,name):

static_file_url = f"{settings.STATIC_URL}{'webpage/'}{name}.html"
# static_file_url = f"{settings.MYSTATIC_URL}/{name}.html"
return HttpResponseRedirect(static_file_url)
```





---
# The FAQs




# Examples Tasks

Let's Understand in detail using an example below

1. [[#Task-01 Greet to 5 Friends Individually]]
2. [[#Task-02 Adding Photos along with name to greet the correct person]]


##### Task-01 | Greet to 5 Friends Individually
> [!todo] -> how we can manipulate python code to generate dynamic html contents
> Let's suppose you have 5 friends whose names are {Alex, Bruce, Caroline , Danny, Fred}
> And we want to generate code to greet them individually.
> Here is how we can do it.

```python
# In your Views.py

MyFriends = ['Alex', 'Bruce', 'Caroline', 'Danny', 'Fred']
```

Now we need to pass it down to the context in order to be received by the html doc to at on this information 
```python
context = {
	'title'  : 'Django',
	'friends': MyFriends
}
```

Rest will be the same from previous steps as stated in [[#`views.py`]]

Your `views.py` should look something like below 

```python
from django.shortcuts import render
# Code from `views.py`
def the_profileapp_view(request):
	MyFriends = ['Alex', 'Bruce', 'Caroline', 'Danny', 'Fred']
	context = { 'title' : 'Django', 'friends' : MyFriends }
	return render(request, 'hello.html', context)
```


>`hello.html`

Now we have the information passed down from the `context` in `views.py` we have to do something with it -> which is to display a hello message to the number of friends.

> Previously -> `hello.html`

```html
<!-- In hello.html, we have below statement which need to be changed  -->
<!-- in order to anticipate the information we have received -->
<h1>Hello, {% block content %} World {% endblock %}</h1>
```

> Now -> Make below changes in `hello.html`

```html
{% block content %}

	{% for friend in friends %}
		<h1>Hello, {{ friend }}</h1>
	{% endfor %}

{% endblock %}
```

##### Task-02 | Adding Photos along with name to greet the correct person
We have successfully created instructions to greet each friends individually but there is a problem we haven't met those friends in person and chances are we might not remember who is alex or fred when we meet them in person. In order to avoid the confusion of greeting the wrong person we need to use their photos as well

Now we have their photos as well you might be wondering

- How are we going to manage their information along with their photos together ?
	-> we are going to use django's built in database functions more specifically `db.sqlite3` database to manage their profile along with their photos.
- How are we going to retrieve those files and display them in `hello.html` ?
	we are going to use the django's `models.py` to write definition about the database's table schema and then further use it to retrieve the value from the `models.py` in `views.py` 
- How are we going to upload those files in the first place ?
	we are not going to write code on _how to upload image files_ , it will be taken care by django's built-in features.


in order to answer those questions we need to create new `superuser` who have `superhero` abilities as well.


# Profile-App

## Profile-Table

| Photo                  | Name     | Country | Profession | About |
| ---------------------- | -------- | ------- | ---------- | ----- |
| ![[alex.jpg\|100]]     | Alex     | America | Artist     |       |
| ![[How-To/Django Web Framework/Hello Django/hello-django ( photos )/bruce.jpg\|100]]    | Bruce    | Brazil  | Bodyguard  |       |
| ![[caroline.jpg\|100]] | Caroline | Canada  | Consultant |       |
| ![[danny.jpg\|100]]    | Danny    | Denmark | Dentist    |       |
| ![[fred.jpg\|100]]     | Fred     | France  | Freelancer |       |

# FAQs

### How to make webpage fits the mobile-screen
-> Place this meta tag between the `<head> </head>` tags 
```html
<meta name="viewport" content="width=device-width, initial-scale=1">
```

---
### How to Make `media` files readily available 

![[#adding settings in `urls.py` to be able to display `media` files]]


### How to register the database in the `admins.py`

![[#Step-03 Register the `models.py`'s class in the `admins.py`]]

---
### How to back app's data in the database

![[#Backup-02 Backing up the specific app's table]]

### How to redirect to static resources from `views.py`



```python
def more_about_person_view(request,name):

static_file_url = f"{settings.STATIC_URL}{'webpage/'}{name}.html"

return HttpResponseRedirect(static_file_url)
```
