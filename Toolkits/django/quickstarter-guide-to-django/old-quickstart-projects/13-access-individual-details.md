
To access and display individual details from your Django database using the URL path `profile/detail/1`, you’ll need to set up the following components in your Django project:

---

## ✅ Step-by-Step Setup

### 1. 🧱 **Model Setup** (`models.py`)

In your `myapp/models.py`, define the model that holds the data:

```python
from django.db import models

class Person(models.Model):
    name = models.CharField(max_length=100)
    hobby = models.TextField()
    gender = models.CharField(max_length=10)
    image = models.ImageField(upload_to='profile_images/')

    def __str__(self):
        return self.name
```

---

### 2. 🧭 **URL Configuration** (`myapp/urls.py`)

Create a URL pattern that captures the ID from the path:

```python
from django.urls import path
from .views import person_detail_view

urlpatterns = [
    path('profile/detail/<int:id>/', person_detail_view, name='person-detail'),
]
```

Make sure your project’s main `urls.py` includes `myapp.urls`:

```python
from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', include('myapp.urls')),
]
```

---

### 3. 🔍 **View Function** (`views.py`)

In `myapp/views.py`, fetch the person by ID and pass it to a template:

```python
from django.shortcuts import render, get_object_or_404
from .models import Person

def person_detail_view(request, id):
    person = get_object_or_404(Person, id=id)
    return render(request, 'person_detail.html', {'person': person})
```

---

### 4. 🎨 **Template** (`templates/person_detail.html`)

Create a template to display the details:

```html
<!DOCTYPE html>
<html>
<head>
    <title>{{ person.name }}'s Profile</title>
</head>
<body>
    <h1>{{ person.name }}</h1>
    <p><strong>Gender:</strong> {{ person.gender }}</p>
    <p><strong>Hobby:</strong> {{ person.hobby }}</p>
    <img src="{{ person.image.url }}" alt="Profile Image" width="200" />
</body>
</html>
```

---

### 5. 📦 **Media Settings** (in `settings.py`)

Ensure media files are served correctly:

```python
MEDIA_URL = '/media/'
MEDIA_ROOT = BASE_DIR / 'media'
```

And in your main `urls.py`, add:

```python
from django.conf import settings
from django.conf.urls.static import static

urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
```

---

### ✅ Final URL Example

Visiting `http://localhost:8000/profile/detail/1/` will render the profile of the person with ID `1`.

Would you like to add edit/delete buttons or style the profile page next?