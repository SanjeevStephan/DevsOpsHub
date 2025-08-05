## What is Django



> [!done] Django
> Django is a Python framework that makes it easier to create web sites using Python^[Django takes care of the difficult stuff so that you can concentrate on building your web applications.] ^[Django emphasizes reusability of components, also referred to as DRY (Don't Repeat Yourself), and comes with ready-to-use features like login system, database connection and CRUD operations (Create Read Update Delete).]
> > [How does Django Works](https://www.w3schools.com/django/django_intro.php)

# Table of Contents

0. [[#What is Django]]
1. [[#How does Django Works ?]]
2. [[#Create Virtual Environment]]
	1. [[#Create Virtual Environment]]
	2. [[#Activate the Environment]]
3. [[#Install Django]]
	1. [[#windows]]
	2. [[#linux]]
4. [[#Check Versions]]
	1. [[#Python]]
	2. [[#Django]]
5. [[#Create App]]
	1. [[#What is an App?]]
	2. [[#Create An App]]
	3. 
6. [[#FAQ]]
	1. [[#A Sample Django Project]]
	2. [[#how to structure the project to ensure consistent navigation across all pages]]
	3. [[#how to send context data to `anyfile.html`]]
	4. [[#difference between {% include %} & {% block %}]]
	5. [[#how to send context data to `anyfile.html`]]
	6. [[#redirect to page or resource stored in `staticfiles` directory from `views.py`]]
	7. [[#the zip function to iterate over multiple lists in Django]]

# The Mind-Map
![[Getting Started with Django.canvas|Working of Django]]
![[Django App.canvas|Django App]]
# The Contents

## How does Django Works ?

Django follows the MVT design pattern (Model View Template).

- Model - The data you want to present, usually data from a database.
- View - A request handler that returns the relevant template and content - based on the request from the user.
- Template - A text file (like an HTML file) containing the layout of the web page, with logic on how to display the data.

#### Model

The model provides data from the database.

In Django, the data is delivered as an Object Relational Mapping (ORM), which is a technique designed to make it easier to work with databases.

The most common way to extract data from a database is SQL. One problem with SQL is that you have to have a pretty good understanding of the database structure to be able to work with it.

Django, with ORM, makes it easier to communicate with the database, without having to write complex SQL statements.

The models are usually located in a file called `models.py`.

#### View

A view is a function or method that takes http requests as arguments, imports the relevant model(s), and finds out what data to send to the template, and returns the final result.

The views are usually located in a file called `views.py`.
#### Template

A template is a file where you describe how the result should be represented.

Templates are often .html files, with HTML code describing the layout of a web page, but it can also be in other file formats to present other results, but we will concentrate on .html files.

Django uses standard HTML to describe the layout, but uses Django tags to add logic:

```django
<h1>My Homepage</h1>

<p>My name is {{ firstname }}.</p>
```

The templates of an application is located in a folder named `templates`.
#### URLs

Django also provides a way to navigate around the different pages in a website.
When a user requests a URL, Django decides which _view_ it will send it to.
This is done in a file called `urls.py`.
#### So, What is Going On?


When you have installed Django and created your first Django web application, and the browser requests the URL, this is basically what happens:

1. Django receives the URL, checks the `urls.py` file, and calls the view that matches the URL.
2. The view, located in `views.py`, checks for relevant models.
3. The models are imported from the `models.py` file.
4. The view then sends the data to a specified template in the `template` folder.
5. The template contains HTML and Django tags, and with the data it returns finished HTML content back to the browser.

Django can do a lot more than this, but this is basically what you will learn in this tutorial, and are the basic steps in a simple web application made with Django.

> [!done]  Django History
> Django was invented by Lawrence Journal-World in 2003, to meet the short deadlines in the newspaper and at the same time meeting the demands of experienced web developers.
> > Initial release to the public was in July 2005.
> > Latest version of Django is 4.0.3 (March 2022).
## Create Virtual Environment

It is suggested to have a dedicated virtual environment for each Django Project, and one way to manage a virtual environment is `venv` which is in-built in python.
#### Command to Create `venv`

```python
python -m venv myworld
```

#### Activate the Environment

> Windows

```python
myworld\Scripts\activate.bat
```

> Linux

```python
source myworld/bin/activate
```

## Install Django
Now, that we have created a virtual environment, we are ready to install Django.
Django is installed using pip, with this command:


#### windows
```
(myworld) > py -m pip install Django
```

#### linux
```
(myworld) ... $ python -m pip install Django
```

That's it! Now you have installed Django in your new project, running in a virtual environment!

## Check Versions

#### Python

> Windows

```
py --version
```

> Linux

```
python --version
```
#### Django

```python
(myworld) > django-admin --version
```
## Create Django App

#### What is an App?

> [!done] Django App
> An app is a web application that has a specific meaning in your project, like a home page, a contact form, or a members database. ^[In this tutorial we will create an app that allows us to list and register members in a database.]

But first, let's just create a simple Django app that displays "Hello World!".


#### Create An App

- [ ] I will name my app `members`.
- [ ] Start by navigating to the selected location where you want to store the app, in my case the `my_tennis_club` folder, and run the command below.
- [ ] press` [CTRL]` `[BREAK]`, or `[CTRL] [C]` to stop the server. ^[If the server is still running, and you are not able to write commands. so you need to to stop the server]

```python
py manage.py startapp members
```
Django creates a folder named `members` in my project, with this content:
```
my_tennis_club  
    manage.py  
    my_tennis_club/  
    members/  
        migrations/  
            __init__.py  
        __init__.py  
        admin.py  
        apps.py  
        models.py  
        tests.py  
        views.py
```

These are all files and folders with a specific meaning. 

First, take a look at the file called `views.py`.






# FAQ
### A Sample Django Project

> The Mind-Map 

![[thesample-project.canvas|thesample-project]]


Sure, here's a sample Django project that incorporates the concepts from the previous responses, including template inheritance and consistent navigation across pages:

##### Project Structure
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
│   ├── base.html 
│   ├── home.html 
│   ├── about.html 
│   ├── services.html 
│   └── contact.html 
│  
├── myproject/ 
│   ├── settings.py 
│   ├── urls.py 
│   └── wsgi.py 
|
└── manage.py
```

> `base.html`

```python
<!-- base.html --> 
<!DOCTYPE html> 
<html lang="en"> 
	<head> 
	<meta charset="UTF-8"> 
		<title>{% block title %}My Django Project{% endblock %}</title> 
	</head> 
	<body> 
		<header> 
		<nav> 
			<ul> 
				<li><a href="/">Home</a></li> 
				<li><a href="/about/">About</a></li> 
				<li><a href="/services/">Services</a></li> 
				<li><a href="/contact/">Contact</a></li> 
			</ul> 
		</nav> 
		</header> 
		<main> 
			{% block content %}{% endblock %} </main> 
		<footer> <p>&copy; 2023 My Django Project</p> </footer> 
	</body> 
</html>
```

> `home.html`  `../templates/home.html`)

```python
<!-- home.html --> 
{% extends 'base.html' %} 
{% block title %}Home{% endblock %} 

{% block content %} 
	<h1>Welcome to My Django Project</h1> 
	<p>This is the home page content.</p> 
{% endblock %}
```

> `about.html`  (`../templates/about.html`)

```python
<!-- about.html --> 
{% extends 'base.html' %} 
{% block title %}About{% endblock %} 
{% block content %} 
	<h1>About Our Project</h1> 
	<p>This is the about page content.</p> 
{% endblock %}
```

>  `services.html` (`../templates/services.html`)

```python
<!-- services.html --> 
{% extends 'base.html' %} 
{% block title %}Services{% endblock %} 
{% block content %} 
	<h1>Our Services</h1> 
	<ul> 
		<li>Service 1</li> 
		<li>Service 2</li> 
		<li>Service 3</li> 
	</ul> 
{% endblock %}
```

> `contact.html` (`../templates/contact.html`)

```python
<!-- contact.html --> 
{% extends 'base.html' %} 
{% block title %}Contact{% endblock %} 

{% block content %} 
	<h1>Contact Us</h1> 
	<form> 
		<label for="name">Name:</label> 
		<input type="text" id="name" name="name"><br> 
			<label for="email">Email:</label> 
		<input type="email" id="email" name="email"><br> 
			<label for="message">Message:</label> 
		<textarea id="message" name="message"></textarea><br> 
			<input type="submit" value="Submit"> </form> 
{% endblock %}
```

> `style.css` (`../mystatic/css/style.css`)

```css
/* static/css/styles.css */ 
body { 
	font-family: Arial, sans-serif; 
	margin: 0; 
	padding: 0; 
	} 
header { 
	background-color: #333; 
	color: #fff; 
	padding: 20px; 
	} 
nav ul { 
	list-style-type: none; 
	margin: 0; 
	padding: 0; 
	display: flex; 
	} 
nav li { 
	margin-right: 20px; 
	} 
nav a { 
	color: #fff; 
	text-decoration: none; 
	} 
main { 
	padding: 20px; 
	} 
footer { 
	background-color: #333; 
	color: #fff; 
	padding: 10px; 
	text-align: center; 
	}
```

> `views.py` ( `../myapp/views.py`)

```python
from django.shortcuts import render 

def home_view(request): 
	return render(request, 'home.html') 
	
def about_view(request): 
	return render(request, 'about.html') 
	
def services_view(request): 
	return render(request, 'services.html') 
	
def contact_view(request): 
	return render(request, 'contact.html')
```

> `urls.py`  `../myapp/urls.py`)

```python
from django.urls import path 
from . import views 

urlpatterns = [ 
	   path('', views.home_view, name='home'), 
	   path('about/', views.about_view, name='about'), 
	   path('services/', views.services_view, name='services'), 
	   path('contact/', views.contact_view, name='contact'), 
   ]
```

> `settings.py`

```python
TEMPLATES = [ 
	 { 'BACKEND': 'django.template.backends.django.DjangoTemplates',
	   'DIRS': [BASE_DIR / 'templates'], 
	   'APP_DIRS': True, 
	   'OPTIONS': { 
		   'context_processors': [ 
			   'django.template.context_processors.debug',
			   'django.template.context_processors.request',
			   'django.contrib.auth.context_processors.auth',
			   'django.contrib.messages.context_processors.messages',
			   'django.template.context_processors.static', 
			   ], 
		   }, 
	   }, 
   ] 
   
STATIC_URL = '/static/' 
STATICFILES_DIRS = [ 
			BASE_DIR / 'static', 
		]
```


In this sample project:

1. The `base.html` template defines the overall structure and includes the navigation menu.
2. Child templates (`home.html`, `about.html`, `services.html`, `contact.html`) extend the base template and override the `title` and `content` blocks.
3. A new `static` directory is created to store the global CSS file.
4. The `styles.css` file is added to the `static/css` directory, containing global styles for the project.
5. In the `base.html` template, a `{% static %}` tag is used to link the `styles.css` file in the `<head>` section.
6. The `views.py` file defines the view functions that render the corresponding child templates.
7. The `urls.py` file maps the URLs to the view functions.
8. The `settings.py` file is configured to `recognize` the `templates` directory.
9. The `settings.py` file is updated to configure the static file settings:
    
    - The `django.template.context_processors.static` context processor is added to the `TEMPLATES` setting.
    - The `STATIC_URL` and `STATICFILES_DIRS` settings are added to specify the URL and directory for static files.


By applying global CSS in this manner, the styles defined in `styles.css` will be applied consistently across all pages that extend the `base.html` template. This ensures a unified look and feel for your Django project.

By following this structure, you can easily maintain consistent navigation across all pages of your Django project while allowing for `customization` of individual pages through template inheritance.

Remember to run `python manage.py collectstatic` to collect and copy the static files to the specified location.
### how to structure the project to ensure consistent navigation across all pages

> To ensure consistent navigation across all pages of your Django project, you can follow these structured steps:

#### 1. Create a Base Template

> [!abstract] What to Do ?
> Start by creating a base template that includes the navigation bar and any other common elements (like the header and footer) that you want to appear on every page. 
> 
> 	This template will serve as the foundation for all other templates.

> Example of `base.html`

```
<!-- base.html --> 
<!DOCTYPE html> <html lang="en"> <head> <meta charset="UTF-8"> <title>{% block title %}My Website{% endblock %}</title> </head> <body> <header> <nav> <ul> <li><a href="/">Home</a></li> <li><a href="/about/">About</a></li> <li><a href="/services/">Services</a></li> <li><a href="/contact/">Contact</a></li> </ul> </nav> </header> <main> {% block content %}{% endblock %} </main> <footer> <p>&copy; 2023 My Website</p> </footer> </body> </html>
```




##### 2. Create Child Templates

For each page of your website, create child templates that extend the base template. These templates will inherit the navigation structure defined in `base.html`.

> Example of `home.html`

```html
<!-- home.html --> 
% extends 'base.html' %} 
{% block title %}Home{% endblock %} 
{% block content %} 
	<h1>Welcome to My Website</h1> <p>This is the home page content.</p> 
{% endblock %}
```

> Example of `about.html`

```
<!-- about.html --> {% extends 'base.html' %} {% block title %}About Us{% endblock %} {% block content %} <h1>About Us</h1> <p>This is the about page content.</p> {% endblock %}
```

##### 3. Organize Your Templates

Place your templates in a structured directory within your Django project. A common practice is to have a `templates` directory at the root of your project or within each app.

```
myproject/ │ ├── templates/ │ ├── base.html │ ├── home.html │ └── about.html
```


##### 4. Configure Template Settings

Ensure that your Django settings are configured to recognize your templates directory. In your `settings.py`, specify the `DIRS` option in the `TEMPLATES` setting.

```
TEMPLATES = [ { 'BACKEND': 'django.template.backends.django.DjangoTemplates', 'DIRS': [BASE_DIR / 'templates'], 'APP_DIRS': True, 'OPTIONS': { 'context_processors': [ 'django.template.context_processors.debug', 'django.template.context_processors.request', 'django.contrib.auth.context_processors.auth', 'django.contrib.messages.context_processors.messages', ], }, }, ]
```

##### 5. Use Consistent Navigation Design

- **Consistency**: Ensure that the navigation links and their order remain the same across all pages. This helps users predict where they can find information, enhancing their experience[](https://webflow.com/blog/website-navigation)[](https://www.netguru.com/blog/ux-tips-to-improve-website-navigation)[](https://blog.hubspot.com/website/main-website-navigation-ht).
- **Visibility**: Place the navigation menu in a location where users expect to find it, typically at the top of the page[](https://webflow.com/blog/website-navigation)[](https://www.netguru.com/blog/ux-tips-to-improve-website-navigation).
- **Clarity**: Use clear and descriptive labels for navigation links so users understand what to expect when they click on them[](https://www.netguru.com/blog/ux-tips-to-improve-website-navigation)

##### 6. Render the Templates in Views

In your Django views, render the child templates as needed.

> Example Views

```
from django.shortcuts import render def home_view(request): return render(request, 'home.html') def about_view(request): return render(request, 'about.html')
```

By following these steps, you can create a structured Django project that maintains consistent navigation across all pages, enhancing user experience and site usability.


### difference between `{% include %}` &  `{% block %}`

The difference between `{% include %}` and `{% block %}` in Django templates lies in their purposes and how they are used in template inheritance and composition.

#### `{% block %}`

- **Purpose**: The `{% block %}` tag is used for defining sections in a template that can be overridden by child templates. It is a fundamental part of Django's template inheritance system.
- **Usage**: When you create a base template, you can define blocks that child templates can fill with their own content. This allows for a consistent layout across multiple pages while enabling specific content to vary.
- **Example**: `base.html`
```html
<!-- base.html --> 
<!DOCTYPE html> 
<html lang="en"> 
	<head> 
		<title>{% block title %}Default Title{% endblock %}</title> 
	</head> 
	<body> 
		<header> 
			<h1>My Website</h1> 
		</header> 
		<main> 
			{% block content %}{% endblock %} 
		</main> 
		<footer> 
			<p>&copy; 2023 My Website</p> 
		</footer> 
	</body> 
</html>
```

- **In Child Template**:
```html
<!-- home.html --> 

{% extends 'base.html' %}  

{% block title %}Home Page{% endblock %} 

{% block content %} 
	<h2>Welcome to the Home Page</h2> 
	<p>This is the main content of the home page.</p> 
{% endblock %}
```

#### `% include %}`

- **Purpose**: The `{% include %}` tag is used to include another template within the current template. It allows for `reusability` of template fragments without needing to define a block.
- **Usage**: You can use `{% include %}` to insert a template into another template, which can be useful for components like navigation bars, footers, or other repeated sections. The included template can also receive context variables.
- **Example**:
```html
<!-- navbar.html --> 
<nav> 
	<ul> <li><a href="/">Home</a></li> 
		<li><a href="/about/">About</a></li> 
	</ul> </nav>
```

- **In Another Template**:
```html
<!-- base.html --> 
<!DOCTYPE html> 
<html lang="en"> 
	<head> 
		<title>{% block title %}Default Title{% endblock %}</title> 
	</head> 
	<body> 
		{% include 'navbar.html' %} 
		<main> {% block content %}{% endblock %} </main> 
	<footer> <p>&copy; 2023 My Website</p> </footer> 
	</body> 
</html>
```

#### Summary

- **Block Inheritance**: The `{% block %}` tag is used for defining sections of a template that can be overridden by child templates. It is essential for creating a base template structure that can be extended.
- **Template Inclusion**: The `{% include %}` tag is used to insert another template within the current template. It is useful for including reusable components without the need for inheritance.

In essence, use `{% block %}` for defining areas of a template that can be `customized` in child templates, and use `{% include %}` for embedding reusable templates directly into other templates.

---
### how to send context data to `anyfile.html`

To send context data to a template such as `services.html` that includes a heading like `<h1> Our {{ heading }} </h1>`, you can follow these steps:

##### Step 1: Define Your View

In your Django view, you will need to create a context dictionary that includes the data you want to pass to the `services.html` template. For example, you can define a heading and pass it to the template.

> Example View in `views.py`

```python
from django.shortcuts import render 

def services_view(request): 
# Define the heading you want to pass to the template 

context = { 
	   'heading': 'Services Offered' 
	} 
	return render(request, 'services.html', context)
```

##### Step 2: Create the Template

In your `services.html` template, you can use the `{{ heading }}` variable to display the heading passed from the view.

> Example Template `services.html`

```html
<!-- services.html --> 
{% extends 'base.html' %} 

{% block title %}Our Services{% endblock %} 
{% block content %} 
	<h1>Our {{ heading }}</h1> 
	<p>Here are the services we offer:</p> 
	<ul> 
		<li>Service 1</li> 
		<li>Service 2</li> 
		<li>Service 3</li> 
	</ul> 
{% endblock %}
```

##### Step 3: Configure URLs

Make sure to configure the URL routing to point to the `services_view` function in your `urls.py`.

> Example URL Configuration in `urls.py`

```python
from django.urls import path 
from .views import services_view 

urlpatterns = [ 
	path('services/', services_view, name='services'), 
	]
```

##### Step 4: Access the Page

Now, when you navigate to `/services/` in your browser, the `services.html` template will be rendered, and you will see the heading "Our Services Offered" displayed as specified in the view.

##### Summary

- **View**: The view function retrieves or defines the context data (in this case, the heading) and passes it to the template.
- **Template**: The template uses the context variable `{{ heading }}` to dynamically display the heading.
- **URL Configuration**: Ensure that the URL is correctly mapped to the view function.

This approach allows you to send any context data to your templates in Django, making your web application dynamic and data-driven.
### redirect to page or resource stored in `staticfiles` directory from `views.py`

o redirect a page stored in the `staticfiles` directory from `views.py` in Django, you can utilize the `HttpResponseRedirect` class in your view function. However, it's important to note that serving static files directly through views is generally not recommended for production environments. Instead, static files should be served by a web server (like Nginx or Apache) or through Django's development server when `DEBUG` is set to `True`. Here’s a step-by-step guide on how to achieve this:

#### Step 1: Configure Static Files

Ensure you have the necessary settings in your `settings.py` file:

```python
STATIC_URL = '/static/' 
STATICFILES_DIRS = [ 
	BASE_DIR / "staticfiles", # Adjust this path as necessary 
	]
```


#### Step 2: Create Your View

In your `views.py`, create a view function that redirects to the static file:

`theapp/views.py`

``` python
from django.http import HttpResponseRedirect 
from django.conf import settings 

def redirect_to_static(request):     
	static_file_url = f"{settings.STATIC_URL}path/to/your/static/file.ext"    
	return HttpResponseRedirect(static_file_url)
```

Replace `path/to/your/static/file.ext` with the actual path to your static file relative to the `STATIC_URL`.

> In Our Case -> It would be something like this 

```python
def learn_django_view(request):

static_file_url = f"{settings.STATIC_URL}learn/django/index.html"

return HttpResponseRedirect(static_file_url)
```
#### Step 3: Update URLs

In your `urls.py`, add a URL pattern that maps to your new view:

`theapp/urls.py`

```python
from django.urls import path 
from .views import redirect_to_static 

urlpatterns = [     
   path('redirect-to-static/', redirect_to_static, name='redirect_to_static'), 
   ]
```


> In Our Case -> It would be something like this 

```python
from django.urls import path
from . import views

urlpatterns = [
	path('', views.home_view, name='home'),
	path('django/', views.learn_django_view, name='django')
]
```
#### Step 4: Access the Redirect

Now, when you navigate to `/redirect-to-static/`, it will redirect you to the specified static file.

#### Important Considerations

- **Development vs. Production**: The method described here is suitable for development. In production, static files should be served by a dedicated static file server or through a CDN.
- **Inefficiency**: Using Django views to serve static files can be inefficient and insecure, as noted in the Django documentation. This approach should be limited to development scenarios only
### the zip function to iterate over multiple lists in Django

To iterate over multiple lists in a Django template using the `zip` function, you can pass the zipped lists from your view to the template context. Here's how you can do it:

#### Step 1: Update Your View

In your view function, create the lists you want to iterate over and use the `zip` function to combine them. Then, pass the zipped lists to the template context:

> `view.py`

```python
from django.shortcuts import render 

def my_view(request):     
	numbers = [1, 2, 3]    
	letters = ['a', 'b', 'c']    
	animals = ['dog', 'cat', 'bird']         
	
	zipped_lists = zip(numbers, letters, animals)         
	
	context = { 'zipped_lists': zipped_lists }         
		return render(request, 'my_template.html', context)
```

#### Step 2: Update Your Template

In your template (e.g., `my_template.html`), you can iterate over the zipped lists using a `for` loop and unpack the values into separate variables:

> `my_template.html`

```python
{% for number, letter, animal in zipped_lists %}     

<p>Number: {{ number }}, Letter: {{ letter }}, Animal: {{ animal }}</p> 

{% endfor %}
```

Here's how it works:

1. In the view function, the `zip` function is used to combine the `numbers`, `letters`, and `animals` lists into a single iterable called `zipped_lists`. This iterable contains tuples, where each tuple has one element from each list.
2. The `zipped_lists` is passed to the template context under the key `'zipped_lists'`.
3. In the template, the `{% for %}` loop iterates over `zipped_lists`. The loop unpacks each tuple into separate variables (`number`, `letter`, and `animal`), allowing you to access the corresponding elements from each list.
4. Inside the loop, you can use the unpacked variables to display the values, as shown in the example template code.

When the template is rendered, it will display the zipped elements from the three lists in a loop, like this:


``` go
Number: 1, Letter: a, Animal: dog 
Number: 2, Letter: b, Animal: cat 
Number: 3, Letter: c, Animal: bird
```

By using the `zip` function in your view and unpacking the zipped tuples in your template, you can efficiently iterate over multiple lists simultaneously in a Django template.


### pass multiple lists to a single template in Django

To pass multiple lists to a single template in Django, you can include all the lists in the context dictionary when rendering the template. This allows you to access and iterate over each list within the same template. Here’s how you can do it:

#### Step 1: Update Your View

In your view function, create your lists and add them to the context dictionary. For example:

python

```python
from django.shortcuts import render 

def my_view(request):     
	pythonlib = [        
			{
				'title': 'Learn Python', 
				'url': 'learn/python',  
			},      
			{
				'title': 'Python library (Matplotlib)',
				 'url': 'learn/python/library/matplotlib',        
			 # Add more items as needed    
			 }
		 ]     
	 exercise = [        
			 {
				 'title': 'Python', 
				 'url': '/exercise/python',
			 },
			 {
				 'title': 'Numpy',
				 'url': '/exercise/numpy'
			  },        
			# Add more items as needed    
		]     
		
		context = {        
			'pythonlib': pythonlib,        
			'exercise': exercise,    
			}         
			
		return render(request, 'my_template.html', context)
```

#### Step 2: Update Your Template

In your template (e.g., `my_template.html`), you can iterate over both lists. Here’s an example of how to structure your template:

> `my_template.html`

```python
<h2>Python Libraries</h2> 
	<ul>     
	{% for item in pythonlib %}        
	
		<li><a href="{{ item.url }}">{{ item.title }}</a></li>    
	
	{% endfor %} 
	</ul> 

<h2>Exercises</h2> 
<ul>     
	{% for item in exercise %}        
	
		<li><a href="{{ item.url }}">{{ item.title }}</a></li>    
	
	{% endfor %} 
</ul>
```

#### Explanation

1. **View Function**: The `my_view` function creates two lists, `pythonlib` and `exercise`, and adds them to the context dictionary. This context is then passed to the template.
2. **Template Structure**: In the template, you can use separate sections to display each list. The `{% for %}` template tag is used to iterate over each list, allowing you to access the properties of each item.

#### Additional Options

If you want to combine the lists for a single iteration (e.g., if they are related), you can use Python's `zip` function in your view:


```python
combined = zip(pythonlib, exercise) 

context = { 'combined': combined, }
```

Then, in your template, you can iterate over the combined list:


```python
<h2>Combined List</h2> 
	<ul>     
		{% for lib, ex in combined %}        
		<li>            
			<a href="{{ lib.url }}">{{ lib.title }}</a> -            
			<a href="{{ ex.url }}">{{ ex.title }}</a>        
		</li>    
	</ul>

{% endfor %} </ul>
```

#### Conclusion

By following these steps, you can effectively pass multiple lists to a single template in Django and iterate over them as needed. This approach keeps your code organized and allows for flexible template rendering.