



```

mystaticapp/
├── static/
	├── index.html
	├── style.css
	└── script.js

```



```html
{% load static %}

<!DOCTYPE html>

<html lang="en">

<head>

  <meta charset="UTF-8" />

  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <title>My Resume</title>

  <link rel="stylesheet" href="{% static 'style.css' %}" />

</head>

<body>

  <div class="resume-container">

    <button onclick="showImage()" class="show-btn">Show Profile Image</button>

    <img src="{{ profile.image.url }}" alt="Profile Image" class="profile-img" id="profileImage" style="display: none;" />

    <h1 class="name">{{ profile.name }}</h1>

    <p><strong>Gender:</strong> {{ profile.gender }}</p>

    <p><strong>Hobby:</strong> {{ profile.hobby }}</p>

  </div>

  

  <script>

    function showImage() {

      const img = document.getElementById("profileImage");

      img.style.display = "block";

    }

  </script>

</body>

</html>

```


> style.css

```css
body {
  background-color: #f0f4f8;
  font-family: 'Segoe UI', sans-serif;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  margin: 0;
}

.resume-container {
  background-color: #fff;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 6px 16px rgba(0, 0, 0, 0.1);
  text-align: center;
  width: 300px;
}

.profile-img {
  width: 120px;
  height: 120px;
  border-radius: 50%;
  object-fit: cover;
  margin: 20px auto;
}

.name {
  font-size: 24px;
  margin-bottom: 10px;
  color: #333;
}

p {
  font-size: 16px;
  color: #555;
  margin: 8px 0;
}

.show-btn {
  padding: 10px 20px;
  font-size: 16px;
  background-color: #0077cc;
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  margin-bottom: 10px;
}

.show-btn:hover {
  background-color: #005fa3;
}

```

### What This Does

- The profile image is hidden by default (`display: none`).
- When the button is clicked, the image becomes visible (`display: block`).

> views.py


```python
from django.shortcuts import render

from django.shortcuts import render, get_object_or_404

from myapp.models import MyAppModel

  
  

# Create your views here.

def the_profile_detail_view(request, id):

    profiledata = get_object_or_404(MyAppModel, id=id)

    context = {

        'tilte' : "Person Profile Details",

        'profile' : profiledata

    }

    return render(request, 'profile_details.html', {'profile': profiledata})
```





```python
from django.urls import path

from django.conf import settings

from django.conf.urls.static import static

from . import views

  

urlpatterns = [

    path('profile/detail/<int:id>/', view=views.the_profile_detail_view, name='the_profile_detail_view')

] + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT )
```



```html
<a href="profile/detail/1"> Person 1</a>
<!--    [My Resume](http://127.0.0.1:8000/profile/detail/1/)    -->
```