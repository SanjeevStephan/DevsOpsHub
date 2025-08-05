
register the database models in the `admin.py`
```python
from django.contrib import admin

from .models import MasterTemplateSiteModel

# Register your models here.

class MasterTemplateSiteAdmins(admin.ModelAdmin):

    list_display = ('title','link','category','is_django_available')

  
  

admin.site.register(MasterTemplateSiteModel,MasterTemplateSiteAdmins)
```
