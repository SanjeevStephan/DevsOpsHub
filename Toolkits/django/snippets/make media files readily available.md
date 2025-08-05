## How to Make `media` files readily available 


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
