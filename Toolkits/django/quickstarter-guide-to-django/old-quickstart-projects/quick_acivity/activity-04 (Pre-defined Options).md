


- [ ] Implement Pre-defined OPTIONS in the `models.py`
- [ ] Register and Apply changes to the database tables using `makemigrations & migrate`
- [ ] Login into `localhost/admin` -> add entries -> refresh the webpage


## 18-Add Pre-defined Options in `models.py`

```python
from django.db import models

# Create your models here.

class MemberModel(models.Model):

    name  = models.CharField(max_length=120)
    country = models.CharField(max_length=60)


  ## Add below entries
    OPTIONS = [
        ("married", "Married"),
        ("unmarried", "Unmarried"),
	    ]

    martial_status = models.CharField(max_length=120, choices=OPTIONS,default="unmarried")

## Already aded 
def __str__(self):
	return f"{self.name} - {self.profession}"
```


