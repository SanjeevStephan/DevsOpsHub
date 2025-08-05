
```

mystaticapp/
├── static/
	├── index.html
	├── style.css
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


>style.css

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


> script.js

```javascript
function changeText() {

  const textElement = document.getElementById("main-text");

  textElement.textContent = "You clicked the button!";

}

```



> views.py

```python
from django.http import HttpResponseRedirect

from django.shortcuts import render

from django.conf import settings

  
  

# Create your views here.

def my_static_web_app_view(request):

    static_file_url = f"{settings.STATIC_URL}index.html"

    return HttpResponseRedirect(static_file_url)
```