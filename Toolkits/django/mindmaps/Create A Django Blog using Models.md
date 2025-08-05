
# Table of Contents

1. [[#Setting up the Development Environment]]
	- [[#1. Create new virtual environment for the python project]]
	- [[#2. Create Django Project]]
	- [[#3. Create Django App]]
2. [[#Configure the Project before development]]
	1. [[#`settings.py`]]
		- [[#1. Add APP Name in the `settings.py`]]
		- [[#2. Add Templates Directory in the `settings.py`]]
		- [[#3. Add Static Directory in the `settings.py`]]
	2. [[#`urls.py`]]
3. [[#Setup a Sitemap (`Projects`)]]
	1. [[#basic app setup (`.. theindexapp `)]]
		-  [[#1. navigate to the `theindexapp`]]
		- [[#2. create a sitemap]]
		- [[#3 define new model class in `models.py`]]
	1. [[#create database & superuser and access (admin-panel)]]
		- [[#1. Create a database and migrate]]
		- [[#2. Create a Superuser]]
		- [[#3. Start the Development Server]]
		- [[#4. Access the Admin Interface]]
		- [[#5. Register the model `Project` at `models.py` in `admin.py`]]
		- [[#6. Add code to access '`models.py` data from `views.py`]]
		- [[#7. Add data in the `django-admin panel`]]
		- [[#8. Navigate or Refresh Homepage]]
1. [[#Create a Blog Website]]
2. [[#Deploying the Website]]








# The Contents
## Setting up the Development Environment

> Open a terminal and run the following commands:
###  1. Create new virtual environment for the python project

> 1.1 | Make New Directory the Python Project

```
mkdir BlackboxAI
cd .\BlackboxAI\
```

> 1.2 | Create and activate the virtual environement

```python
python -m venv .venv
.\.venv\Scripts\activate
```

> 1.3 | Install Required Python Library (separately) for the virtual environment

```python
pip install django
pip install whitenoise
pip install pillow
```

> 1.4 | Create A Requirement List of python libraries for this Django Project to work as intentded

```python
pip freeze > requirement.txt
cat .\requirement.txt
```

### 2. Create Django Project 

> 2.1 | Create a new Django Project using the command below

```python
django-admin startproject theaiproject
cd .\theaiproject\
```

> 2.2 | Confirm You are in the Right Directory and have the following files & directory

```python
(.venv) ┌──(SUPERUSER㉿10.42.0.176)-[E:\DJANGO\BlackboxAI]
└─$ PS>ls

    Directory: E:\DJANGO\BlackboxAI

Mode                 LastWriteTime         Length Name
----                 -------------         ------ ----
d----           9/13/2024  2:41 PM                .venv
d----           9/13/2024  2:47 PM                theaiproject
-a---           9/13/2024  2:43 PM             99 requirement.txt

```

> 2.3 | Navigate inside the `theaiproject` directory

```python
(.venv) ┌──(SUPERUSER㉿10.42.0.176)-[E:\DJANGO\BlackboxAI\theaiproject]
└─$ PS>ls

    Directory: E:\DJANGO\BlackboxAI\theaiproject

Mode                 LastWriteTime         Length Name
----                 -------------         ------ ----
d----           9/13/2024  2:46 PM                theaiproject
-a---           9/13/2024  2:46 PM            690 manage.py
```

Let's Create a django app..next!
### 3. Create Django App

> 3.1 | Create a new Django App
```python
python .\manage.py startapp theindexapp
```

> 3.1 | Open the Project '`theaiproject` in the vscode

```python
code .\theaiproject
```

> 3.3 | Activate the Python environment (again but this time in `vscode` )

| `..\.venv\Scripts\activate` |
| --------------------------- |

```python
┌──(SUPERUSER㉿10.42.0.176)-[E:\DJANGO\BlackboxAI\theaiproject]
└─$ ..\.venv\Scripts\activate
(.venv) ┌──(SUPERUSER㉿10.42.0.176)-[E:\DJANGO\BlackboxAI\theaiproject]
└─$
```
## Configure the Project before development

### `settings.py`

#### 1. Add APP Name in the `settings.py`

> Add Entries in the `INSTALLED_APPS` of the Project's `settings.py`

```python
# Application definition
INSTALLED_APPS = [
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
	'theindexapp'   
]
```

#### 2. Add Templates Directory in the `settings.py`

> Open the Terminal and make sure you are inside `theaiproject` directory             
> Execute the Below Command to Create `templates and staticfiles` directories

```python
mkdir templates, staticfiles
```

```python
TEMPLATES = [

    {

        'BACKEND': 'django.template.backends.django.DjangoTemplates',

        'DIRS': [BASE_DIR / 'templates'],
		...
]
```
#### 3. Add Static Directory in the `settings.py`

```python
# Static files (CSS, JavaScript, Images)

# https://docs.djangoproject.com/en/5.1/howto/static-files/

STATIC_URL = 'static/'

STATICFILES_DIRS = [ BASE_DIR / 'staticfiles' ]
```

### `urls.py`

> include the app's `url` in the project's `urls.py` every-time you create a new app
> added `include` after path followed by a comma (`,`)

```python
from django.contrib import admin

from django.urls import path, include

  

urlpatterns = [

    path('', include('theindexapp.urls')),

    path('admin/', admin.site.urls),

]
```





## Setup a Sitemap (`Projects`)

### basic app setup (`..\theindexapp\`)
#### 1. navigate to the `theindexapp` 

> Execute below code to create a new directory named `templates` inside `theindexapp`

```python
 cd .\theindexapp\
# Directory: E:\DJANGO\BlackboxAI\theaiproject\theindexapp
  mkdir templates, static  
```


#### 2. create a sitemap

##### 2.1 | Create basics `html` files in the `templates` directory
> `sitemap.html`

>[!todo] `templates\base.html`
> Create a new html file named `base.html` inside the `templates` directory and past below html

```html
{% load static %}

  

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

  

<head>

        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

        <meta name="description" content="HTTrack is an easy-to-use website mirror utility. It allows you to download a World Wide website from the Internet to a local directory,building recursively all structures, getting html, images, and other files from the server to your computer. Links are rebuiltrelatively so that you can freely browse to the local site (works with any browser). You can mirror several sites together so that you can jump from one toanother. You can, also, update an existing mirror site, or resume an interrupted download. The robot is fully configurable, with an integrated help" />

        <meta name="keywords" content="httrack, HTTRACK, HTTrack, winhttrack, WINHTTRACK, WinHTTrack, offline browser, web mirror utility, aspirateur web, surf offline, web capture, www mirror utility, browse offline, local  site builder, website mirroring, aspirateur www, internet grabber, capture de site web, internet tool, hors connexion, unix, dos, windows 95, windows 98, solaris, ibm580, AIX 4.0, HTS, HTGet, web aspirator, web aspirateur, libre, GPL, GNU, free software" />

        <title>{% block title %} {{ basics.title }} {% endblock %}</title>

        <!-- Mirror and index made by HTTrack Website Copier/3.49-5 [XR&CO'2014] -->

  

 {% include 'elements/stylesheet.html' %}

  

</head>

  

<body>

<table width="76%" border="0" align="center" cellspacing="0" cellpadding="3" class="tableWidth">

        <tr>

        <td id="subTitle">Completely Open Source & Offline (w3school) Tutorials</td>

        </tr>

</table>

<table width="76%" border="0" align="center" cellspacing="0" cellpadding="0" class="tableWidth">

<tr class="blak">

<td>

        <table width="100%" border="0" align="center" cellspacing="1" cellpadding="0">

        <tr>

        <td colspan="6">

                <table width="100%" border="0" align="center" cellspacing="0" cellpadding="10">

                <tr>

                <td id="pageContent">

<!-- ==================== End prologue ==================== -->

  
  

<h1 ALIGN=Center>{% block heading %} Index of locally available projects {% endblock %}</H1>

  
  

        <main>

  

                {% block content %}

  
  
  

                {% endblock %}

  

        </main>

  
  
  

        <BR>

        <H6 ALIGN="RIGHT">

         <I>{{ basics.credits }} {{ basics.author }}</I>

        </H6>

  

<!-- ==================== Start epilogue ==================== -->

                </td>

                </tr>

                </table>

        </td>

        </tr>

        </table>

</td>

</tr>

</table>

  

{% include 'elements/footer.html' %}

  

</body>

  

</html>
```


> `stylesheet.html`

```html
<style type="text/css">

  

    body {

            margin: 0;  padding: 0;  margin-bottom: 15px;  margin-top: 8px;

            background: #77b;

    }

    body, td {

            font: 14px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;

            }

    #subTitle {

            background: #000;  color: #fff;  padding: 4px;  font-weight: bold;

            }

    #siteNavigation a, #siteNavigation .current {

            font-weight: bold;  color: #448;

            }

    #siteNavigation a:link    { text-decoration: none; }

    #siteNavigation a:visited { text-decoration: none; }

    #siteNavigation .current { background-color: #ccd; }

    #siteNavigation a:hover   { text-decoration: none;  background-color: #fff;  color: #000; }

    #siteNavigation a:active  { text-decoration: none;  background-color: #ccc; }

    a:link    { text-decoration: underline;  color: #00f; }

    a:visited { text-decoration: underline;  color: #000; }

    a:hover   { text-decoration: underline;  color: #c00; }

    a:active  { text-decoration: underline; }

    #pageContent {

            clear: both;

            border-bottom: 6px solid #000;

            padding: 10px;  padding-top: 20px;

            line-height: 1.65em;

            background-image: url(" {% static 'assets\images\backblue.gif' %}");

            background-repeat: no-repeat;

            background-position: top right;

            }

    #pageContent, #siteNavigation {

            background-color: #ccd;

            }

    .imgLeft  { float: left;   margin-right: 10px;  margin-bottom: 10px; }

    .imgRight { float: right;  margin-left: 10px;   margin-bottom: 10px; }

    hr { height: 1px;  color: #000;  background-color: #000;  margin-bottom: 15px; }

    h1 { margin: 0;  font-weight: bold;  font-size: 2em; }

    h2 { margin: 0;  font-weight: bold;  font-size: 1.6em; }

    h3 { margin: 0;  font-weight: bold;  font-size: 1.3em; }

    h4 { margin: 0;  font-weight: bold;  font-size: 1.18em; }

    .blak { background-color: #000; }

    .hide { display: none; }

    .tableWidth { min-width: 400px; }

    .tblRegular       { border-collapse: collapse; }

    .tblRegular td    { padding: 6px;  background-image: url("{% static 'assets\images\fade.gif' %}");  border: 2px solid #99c; }

    .tblHeaderColor, .tblHeaderColor td { background: #99c; }

    .tblNoBorder td   { border: 0; }

    </style>
```

> `footer.html`

```html
<table width="76%" border="0" align="center" valign="bottom" cellspacing="0" cellpadding="0">

    <tr>

    <td id="footer"><small>&copy; 2024 Stephanware Inc. & Associates : c1ph3wolf - The Hacker.</small></td>

    </tr>

</table>
```

> `table.html`

```html
{% load static %}
<TABLE border="0" width="100%" cellspacing="1" cellpadding="0">

    <TH>

    <BR/>

        {{ category.project }}

    </TH>

  

        {% for x in combined_list.projects %}

        <TR>

            <TD BACKGROUND="fade.gif"> &middot; <A HREF='{{ x.url }}' target="_blank">{{ x.title }}</A>

  

            </TD>

        </TR>

        {% endfor %}

  

</TABLE>
```

##### 2.2 | define a function in `views.py` to handle `html` files from step 2.1

```python
from django.shortcuts import render

# Create your views here.

def the_site_map_view(request):
    return render(request, 'sitemap.html')
```

##### 2.3 create a `urls.py` inside the `theindexapp`

> open terminal and navigate to `..\theindexapp\` and create `urls.py`

```python
from django.urls import path

from . import views

urlpatterns = [

    path('', views.the_site_map_view, name='the_site_map')

]
```

##### 2.4 | Did you forget to register or load this tag?

> Check the `html` files in case you missed to include this `{% load static %}`

```python

{% load static %}

```
##### 2.5 add the app `theindexapp` in the `settings.py`

![[#1. Add APP Name in the `settings.py`]]

#### 3 define new model class in `models.py`

```python
from django.db import models

  

# Create your models here.

class Projects(models.Model):

    title = models.CharField(max_length=240)

    url   = models.CharField(max_length=240)

    created_at = models.DateTimeField(auto_now_add=True)

    updated_at = models.DateTimeField(auto_now_add=True)

  

    def __str__(self):

        return self.title
```


### create database & superuser and access (admin-panel)
#### 1. Create a database and migrate

```
python .\manage.py makemigrations 
python manage.py migrate
```

> You should see an output similar to this below

```
┌──(SUPERUSER㉿10.42.0.176)-[E:\DJANGO\BlackboxAI\theaiproject]
└─$ python .\manage.py makemigrations
Migrations for 'theindexapp':
  theindexapp\migrations\0001_initial.py
    + Create model Projects
┌──(SUPERUSER㉿10.42.0.176)-[E:\DJANGO\BlackboxAI\theaiproject]
└─$ python manage.py migrate
Operations to perform:
  Apply all migrations: admin, auth, contenttypes, sessions, theindexapp
Running migrations:
  Applying contenttypes.0001_initial... OK
  Applying auth.0001_initial... OK
  Applying admin.0001_initial... OK
  Applying admin.0002_logentry_remove_auto_add... OK
  Applying admin.0003_logentry_add_action_flag_choices... OK
  Applying contenttypes.0002_remove_content_type_name... OK
  ...
  Applying sessions.0001_initial... OK
  Applying theindexapp.0001_initial... OK
```


#### 2. Create a Superuser

> [!success] Managing Data using the Django Admin Interface  
> To manage data using the Django admin interface, follow the same steps

```
python manage.py createsuperuser
```

Follow the prompts to create a superuser account.

```
(.venv) ┌──(SUPERUSER㉿10.42.0.176)-[E:\DJANGO\BlackboxAI\theaiproject]
└─$ python .\manage.py createsuperuser
Username (leave blank to use 'samst'): stephan
Email address: samstephan069@gmail.com
Password: 764289
Password (again): 764289
This password is too short. It must contain at least 8 characters.
This password is entirely numeric.
Bypass password validation and create user anyway? [y/N]: y 
Superuser created successfully.
```


#### 3. Start the Development Server

```
python .\manage.py runserver 80
```

#### 4. Access the Admin Interface

Click this link or navigate to on the browser http://127.0.0.1/admin

| username | stephan                 |
| -------- | ----------------------- |
| password | 764289                  |
| email    | samstephan069@gamil.com |
Log in with above superuser credentials.
#### 5. Register the model `Project` at `models.py` in `admin.py`

>  Register the Model with the Admin Interface

In `theindexapp/admin.py`, add the following code:

```
from django.contrib import admin
from .models import Projects

admin.site.register(Projects)
```

#### 6. Add code to access '`models.py` data from `views.py`

```python
from django.shortcuts import render
from .models import Projects

# Create your views here.

def the_site_map_view(request):
    projects = Projects.objects.all()
    context = {
        'projects' : projects
    }
    return render(request, 'sitemap.html', context)
```

#### 7. Add data in the `django-admin panel`

![[Pasted image 20240913171711.png]]

#### 8. Navigate or Refresh Homepage

click this link [127.0.0.1](http://127.0.0.1/)

![[Pasted image 20240913171520.png]]


---
## Create a Blog Website

### blog project with upload and display images feature on posts:

#### Step 1: Create a new Django project and app  

Open a terminal and run the following commands:

```python
django-admin startproject blogproject 
cd blogproject 
python manage.py startapp blog`
```
#### Step 2: Define the Post model with image field  

In `blog/models.py`, add the following code:

```python
from django.db import models 

class Post(models.Model): 
	title = models.CharField(max_length=200)
	content = models.TextField()
	image = models.ImageField(upload_to='images/') 
	created_at = models.DateTimeField(auto_now_add=True) 
	updated_at = models.DateTimeField(auto_now=True) 
	
	def __str__(self):     
		return self.title`
```

#### Step 3: Create a database and migrate  

Run the following commands:

```python
python manage.py makemigrations blog 
python manage.py migrate
```

#### Step 4: Create views for the blog  

In `blog/views.py`, add the following code:

```python
from django.shortcuts import render 
from .models import Post 

def post_list(request): 
	posts = Post.objects.all()
	return render(request, 'post_list.html', {'posts': posts})
	
def post_detail(request, pk):
	post = Post.objects.get(pk=pk) 
	return render(request, 'post_detail.html', {'post': post})
```

#### Step 5: Create templates for the blog  

Create a new directory `templates` in the `blog` app, and add the following files:

> `post_list.html`:

```python
{% extends 'base.html' %} 

{% block content %} 
	<h1>Blog Posts</h1> 
<ul> 
	{% for post in posts %} 
	<li> 
		<a href="{% url 'post_detail' post.pk %}"> {{ post.title }}        
		<img src="{{ post.image.url }}" alt="{{ post.title }}" width="100">   
		</a>     
	</li> 
	{% endfor %} 
</ul> 
{% endblock %}
```

>`post_detail.html`:

```python
{% extends 'base.html' %} 

{% block content %} 
	<h1>{{ post.title }}</h1> 
	<p>{{ post.content }}</p> 
	<p> <img src="{{ post.image.url }}" alt="{{ post.title }}" width="300"> </p> 
	<p>Created at: {{ post.created_at }}</p> 
	<p>Updated at: {{ post.updated_at }}</p>
{% endblock %}
```

#### Step 6: Create a base template  

> `base.html`

Create a new file `base.html` in the `templates` directory:

```python
<!DOCTYPE html> 
	<html> 
		<head> 
			<title>My Blog</title> 
		</head> 
		<body>  
			<div id="content"> 
				{% block content %}{% endblock %} 
			</div> 
		</body> 
	</html>
```
  
#### Step 7: Add URL patterns  

>`urls.py`

In `blog/urls.py`, add the following code:

```python
from django.urls import path 
from . import views

urlpatterns = [ 
   path('posts/', views.post_list, name='post_list'), 
   path('posts/<pk>/', views.post_detail, name='post_detail'), 
   ]
```

#### Step 8: Include the blog app in the project  

In `blogproject/urls.py`, add the following code:

```python
from django.urls import include, path
urlpatterns = [ 
   path('', include('blog.urls')), ]
```

#### Step 9: Configure media settings  

>`settings.py`

In `blogproject/settings.py`, add the following code:

```python
import os # put it at th top of the file
MEDIA_ROOT = os.path.join(BASE_DIR, 'media') 
MEDIA_URL = '/media/'
```

#### Step 10: Create a directory for uploaded images  

Create a new directory `media` in the project root, and add a subdirectory `images` inside it.

```python
python manage.py runserver
```

Open a web browser and navigate to [http://127.0.1:8000/posts/](http://127.0.1:8000/posts/) to see the blog post list with images.
### Managing Data using the Django Admin Interface  

To manage data using the Django admin interface, ^[follow the same steps as before, but with the added image field.]

#### Step 1: Create a Superuser  

Open a terminal and run the following command:

```python
python manage.py createsuperuser
```

Follow the prompts to create a superuser account.

#### Step 2: Start the Development Server

Run the following command:

```python
python manage.py runserver
```

This will start the development server.

#### Step 3: Access the Admin Interface

Open a web browser and navigate to:

```python
http://localhost:8000/admin/
```

Log in with your superuser credentials.


#### Step 4: Register the Model with the Admin Interface  

In `blog/admin.py`, add the following code:

```python
from django.contrib import admin 
from .models import Post 

admin.site.register(Post)
```

This registers the `Post` model with the admin interface.
#### Step 5: Access the Post Model in the Admin Interface  
 
In the admin interface, click on the "Posts" link in the sidebar.
#### Step 6: Create a New Post  

Click on the "Add post" button.

#### Step 7: Fill in the Post Details  

Fill in the title, content, and image fields. You can upload an image by clicking on the "Choose file" button.

#### Step 8: Save the Post  

Click the "Save" button to save the post.

#### Step 9: View the Post List  

Click on the "Posts" link in the sidebar to view the list of posts.

#### Step 10: Edit a Post  

Click on the "Edit" link next to a post to edit it.

#### Step 11: Delete a Post  

Click on the "Delete" link next to a post to delete it.

#### Step 12: Confirm Deletion  

Confirm that you want to delete the post.

That's it! You can now manage your blog posts with images using the Django admin interface.

## Deploying the Website

### 1. Turn OFF `DEBUG` Mode ( `if you want to`)
> 
```
# SECURITY WARNING: don't run with debug turned on in production!

DEBUG = False

```
### 2. Allow Devices in local network to access Django website

> 5.1 Open Terminal and Check Your IP address

```python
└─$ PS>ipconfig

Windows IP Configuration

Wireless LAN adapter Wi-Fi:

   Connection-specific DNS Suffix  . :
   IPv4 Address. . . . . . . . . . . : 10.42.0.176
   Subnet Mask . . . . . . . . . . . : 255.255.255.0
   Default Gateway . . . . . . . . . : 10.42.0.1 
```

> 5.2 | Add Your Machine's IP with custom name in `hosts` file

```python
(.venv) ┌──(SUPERUSER㉿10.42.0.176)-[E:\DJANGO\BlackboxAI]
└─$ PS>cat C:\Windows\System32\drivers\etc\hosts

# Copyright (c) 1993-2009 Microsoft Corp.
#
# This is a sample HOSTS file used by Microsoft TCP/IP for Windows.
#
# This file contains the mappings of IP addresses to host names. Each
# entry should be kept on an individual line. The IP address should
# be placed in the first column followed by the corresponding host name.
# The IP address and the host name should be separated by at least one
# space.
#
# Additionally, comments (such as these) may be inserted on individual
# lines or following the machine name denoted by a '#' symbol.
#
# For example:
#
#      102.54.94.97     rhino.acme.com          # source server
#       38.25.63.10     x.acme.com              # x client host
# localhost name resolution is handled within DNS itself.
# 127.0.0.1   localhost
# ::1         localhost
  10.42.0.125 watchdog.local  # Linux Server
  10.42.0.176 mywebsite.local # Windows Server
```

> 5.3 | Add the IP address in the Allowed List

```python
ALLOWED_HOSTS = ['127.0.0.1','10.42.0.176','mywebsite.local']
```

### Finally Let Your website RUN Freely (`on your network`)

> Open the Terminal and Execute the Below Command
#### Run on your local host at default port

```python
python .\manage.py runserver 
```

#### Run on your local host at specific HTTP Port (80)

```python
python .\manage.py runserver 80
```

#### Run on your local network
```python
python .\manage.py runserver 10.42.0.176:80
```


![[Pasted image 20240913154729.png]]