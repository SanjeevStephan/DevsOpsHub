## redirect to static resources from `views.py`

```python
def more_about_person_view(request,name):

static_file_url = f"{settings.STATIC_URL}{'webpage/'}{name}.html"

return HttpResponseRedirect(static_file_url)
```
