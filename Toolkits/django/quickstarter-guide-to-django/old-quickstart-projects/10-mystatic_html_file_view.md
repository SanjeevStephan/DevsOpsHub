


Here's a complete example of a simple HTML website with custom CSS and JavaScript that changes text when a button is clicked. The CSS and JS are placed in separate files 
```

mystaticapp/
├── static
	├── style.css
	└── script.js
├── templates
|	└── index.html
└── script.js


```


> index.html

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Text Changer</title>
  <link rel="stylesheet" href="style.css" />
</head>
<body>
  <div class="container">
    <h1 id="main-text">Hello, World!</h1>
    <button onclick="changeText()">Click Me</button>
  </div>

  <script src="script.js"></script>
</body>
</html>

```


> style.css

```css
body {
  font-family: Arial, sans-serif;
  background-color: #f0f4f8;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  margin: 0;
}

.container {
  text-align: center;
  background-color: #ffffff;
  padding: 40px;
  border-radius: 10px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

h1 {
  color: #333;
  margin-bottom: 20px;
}

button {
  padding: 10px 20px;
  font-size: 16px;
  background-color: #0077cc;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #005fa3;
}

```

>script.js

```javascript
function changeText() {
  const textElement = document.getElementById("main-text");
  textElement.textContent = "You clicked the button!";
}

```


## redirect to static resources from `views.py`

```python
def more_about_person_view(request,name):

static_file_url = f"{settings.STATIC_URL}{'webpage/'}{name}.html"

return HttpResponseRedirect(static_file_url)
```

#### adding settings in `urls.py` to be able to display `media` files


```python
from django.urls import path
from django.conf import settings
from django.conf.urls.static import static
from . import views

urlpatterns = [


path('profile/about/<name>',views.more_about_person_view, name='more_about_the_person_view')

] + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT )
```



> home.html

```html
{% load static %}

<a href="/profile/about/sanjeev"> View Sanjeev's Profile </a>

```

