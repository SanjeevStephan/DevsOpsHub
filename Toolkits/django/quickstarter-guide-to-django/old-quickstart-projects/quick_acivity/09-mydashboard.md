
Great choice, Sam! Let’s build a simple, stylish Django-powered website with:

- ✅ A top navigation bar
- ✅ A jumbotron-style box
- ✅ A two-column table inside the jumbotron
- ✅ Clean, responsive styling using Bootstrap

---

## 🛠️ Step-by-Step: Django Website with Styled Table and Navbar

### 📁 1. Project & App Setup

```bash
django-admin startproject mysite
cd mysite
python manage.py startapp dashboard
```

Add `'dashboard'` to `INSTALLED_APPS` in `mysite/settings.py`.

---

### 🌐 2. URL Configuration

In `mysite/urls.py`:

```python
from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', include('dashboard.urls')),
]
```

Create `dashboard/urls.py`:

```python
from django.urls import path
from . import views

urlpatterns = [
    path('', views.home, name='home'),
]
```

---

### 🧑‍💻 3. View Function

In `dashboard/views.py`:

```python
from django.shortcuts import render

def home(request):
    data = [
        {'label': 'Name', 'value': 'Sam'},
        {'label': 'Occupation', 'value': 'Teacher'},
        {'label': 'Location', 'value': 'Nawada, Bihar'},
        {'label': 'Interest', 'value': 'Programming'},
    ]
    return render(request, 'dashboard/home.html', {'data': data})
```

---

### 🧾 4. Template with Navbar, Jumbotron, and Table

Create folder: `dashboard/templates/dashboard/home.html`

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .jumbotron {
            background-color: #e9ecef;
            padding: 2rem;
            border-radius: 0.5rem;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .table td {
            vertical-align: middle;
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">MySite</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
    </button>
  </div>
</nav>

<!-- Jumbotron -->
<div class="container mt-4">
    <div class="jumbotron">
        <h2 class="mb-4">User Info</h2>
        <table class="table table-bordered table-striped">
            <tbody>
                {% for item in data %}
                <tr>
                    <td><strong>{{ item.label }}</strong></td>
                    <td>{{ item.value }}</td>
                </tr>
                {% endfor %}
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```

---

### ▶️ 5. Run the Server

```bash
python manage.py runserver
```

Visit `http://127.0.0.1:8000/` to see your styled dashboard!

---

## 🎯 What You’ve Learned

- Bootstrap integration for styling
- Django views and template rendering
- Dynamic table generation using context data
- Responsive layout with navbar and jumbotron

Would you like to add features like editing table data, saving it to a database, or switching themes dynamically? I can guide you through that next!