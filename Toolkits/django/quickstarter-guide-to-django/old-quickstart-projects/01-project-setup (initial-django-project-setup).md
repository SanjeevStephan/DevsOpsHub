## Initial Setup


#### Setup Python Virtual Environment

##### create python `.venv`

```python
mkdir 'Django Web Framework'
cd 'Django Web Framework'
python -m venv .venv
```
##### activate virtual environment
`windows`
```python
.\.venv\Scripts\Activate.ps1
```
`linux`
```python
source .venv/bin/activate
```

#### upgrade pip installer 
```python
python.exe -m pip install --upgrade pip
```
##### install python Libraries
```python
pip install django
pip install pillow
pip install whitenoise

or 
pip install -r requirements.txt
```

`requirements.txt`
```python
asgiref==3.8.1
Django==5.1.7
pillow==11.1.0
sqlparse==0.5.3
tzdata==2025.1
whitenoise==6.9.0
```
##### recommended python libraries
```python

pip list

Package    Version
---------- -------
asgiref    3.8.1
Django     5.1.7
pillow     11.1.0
pip        25.0.1
sqlparse   0.5.3
tzdata     2025.1
whitenoise 6.9.0

pip freeze > requirements.txt
or
pip freeze > requirements-for-django.txt
```

#### Setup Django Project

##### create django project
```python
django-admin startproject MyProject
```

##### create django app

navigate inside the project `thewatch` using `cd thewatchdog` 
`windows`
```python
python .\manage.py startapp myapp
```

`linux`
```python
python manage.py startapp myapp
```

##### launch the `server` (for first time)
```python
python manage.py runserver
```


#### server launched

```
Watching for file changes with StatReloader
Performing system checks...

System check identified no issues (0 silenced).

You have 18 unapplied migration(s). Your project may not work properly until you apply the migrations for app(s): admin, auth, contenttypes, sessions.
Run 'python manage.py migrate' to apply them.
July 28, 2025 - 21:45:15
Django version 5.1.7, using settings 'activity01.settings'
Starting development server at http://127.0.0.1:8000/
Quit the server with CTRL-BREAK.

[28/Jul/2025 21:45:24] "GET / HTTP/1.1" 200 12068
Not Found: /favicon.ico
[28/Jul/2025 21:45:24] "GET /favicon.ico HTTP/1.1" 404 2212
```



![[Pasted image 20250728214603.png]]