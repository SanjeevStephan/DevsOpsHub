---
tags:
  - python
---

## 🐍 `Python_QuickStart.md`



Absolutely, Sam! Here's a beginner-friendly guide to get you started with Python — from installation to running your first command and installing libraries. I’ll keep it structured and practical, just the way you like it.

---

## 🐍 Getting Started with Python: Setup & First Steps

### ✅ Step 1: Install Python

#### 🔹 Windows / macOS / Linux

- Go to the official site: [https://www.python.org/downloads](https://www.python.org/downloads)
- Download the latest stable version (e.g., Python 3.12.x)
- **Windows Tip**: During installation, check ✅ “Add Python to PATH”

#### 🔹 Verify Installation

Open your terminal or command prompt and run:

```bash
python --version
# or
python3 --version
```

You should see something like:

```
Python 3.12.2
```

---

### 🧪 Step 2: Run Your First Python Command

#### 🔹 Using the Terminal (Interactive Mode)

```bash
python
```

Then type:

```python
print("Hello, Python!")
```

Press Enter, and you’ll see:

```
Hello, Python!
```

To exit:

```python
exit()
```

#### 🔹 Using a `.py` File

Create a file named `hello.py` and add:

```python
print("Hello from a Python file!")
```

Run it via terminal:

```bash
python hello.py
```

---

### 📦 Step 3: Install a Python Library

#### 🔹 Using `pip` (Python’s Package Installer)

Example: Install `requests` (for HTTP requests)

```bash
pip install requests
```

#### 🔹 Verify Installation

```bash
pip list
```

You’ll see something like:

```
requests 2.31.0
```

---

### 🧰 Step 4: Use the Installed Library

Create a file `get_google.py`:

```python
import requests

response = requests.get("https://www.google.com")
print("Status Code:", response.status_code)
```

Run it:

```bash
python get_google.py
```

Expected output:

```
Status Code: 200
```

---

### 🧠 Bonus: Create a Virtual Environment (Recommended for Projects)

```bash
python -m venv myenv
source myenv/bin/activate  # macOS/Linux
myenv\Scripts\activate     # Windows
```

Then install libraries inside this isolated environment.

---

Would you like a markdown version of this guide to save or share with your students? Or maybe a quiz to reinforce these steps interactively?


---

## 🧠 Bonus: Create a Virtual Environment

### 🔹 Create Environment

```bash
python -m venv myenv
```

### 🔹 Activate Environment

- macOS/Linux:

```bash
source myenv/bin/activate
```

- Windows:

```bash
myenv\Scripts\activate
```

### 🔹 Install Libraries Inside Environment

```bash
pip install numpy pandas
```

---

## 📌 Tips

- Use `pip freeze > requirements.txt` to save dependencies
- Use `deactivate` to exit virtual environment
- Explore IDEs like VS Code or PyCharm for better experience

---

🧠 _“Start simple, stay curious, and let Python do the heavy lifting.”_

```

---

Would you like me to turn this into a printable PDF or add a quiz section at the end for practice?
```