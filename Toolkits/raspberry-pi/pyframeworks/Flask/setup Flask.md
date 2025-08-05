To set up **Flask** on your **Raspberry Pi**, follow these detailed steps. This guide will help you install Flask, create a simple web application, and run it.

## Step 1: Update Your System

Before installing any new packages, ensure your system is up to date. Open a terminal on your Raspberry Pi and run:

```bash
sudo apt update
sudo apt upgrade -y
```

## Step 2: Install Flask

### Option 1: Using `apt-get`

You can install Flask directly using the package manager:

```bash
sudo apt-get install python3-flask
```

### Option 2: Using `pip`

Alternatively, you can use `pip`, which is the Python package manager. If you don't have `pip` installed, you can install it with:

```bash
sudo apt install python3-pip
```

Then, install Flask using:

```bash
pip3 install flask
```

## Step 3: Create a Project Directory

Organize your Flask application by creating a dedicated directory. For example:

```bash
mkdir ~/flask_app
cd ~/flask_app
```

## Step 4: Create a Simple Flask Application

Create a new Python file for your Flask application. You can name it `app.py`:

```bash
nano app.py
```

Add the following code to `app.py`:

```python
from flask import Flask

app = Flask(__name__)

@app.route('/')
def hello():
    return 'Hello, World!'

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
```

This code sets up a basic Flask application that returns "Hello, World!" when accessed.

## Step 5: Run Your Flask Application

To run your Flask app, use the following command:

```bash
python3 app.py
```

You should see output indicating that the server is running, typically something like:

```
 * Running on http://0.0.0.0:5000/ (Press CTRL+C to quit)
```

## Step 6: Access Your Application

Open a web browser on any device connected to the same network as your Raspberry Pi. Enter the IP address of your Raspberry Pi followed by the port number (5000). You can find your Raspberry Pi's IP address by running:

```bash
hostname -I
```

For example, if your Raspberry Pi's IP address is `192.168.1.100`, navigate to:

```
http://192.168.1.100:5000/
```

You should see "Hello, World!" displayed in your browser.

## Step 7: Running Flask in Production (Optional)

For production use, consider using a production server like **Gunicorn** or **uWSGI** behind a reverse proxy like **Nginx**.

### Install Gunicorn

You can install Gunicorn using pip:

```bash
pip3 install gunicorn
```

### Run Your App with Gunicorn

You can run your Flask app with Gunicorn like this:

```bash
gunicorn --bind 0.0.0.0:8000 app:app
```

This command binds Gunicorn to port 8000.

### Set Up Nginx (Optional)

If you want to serve your application through Nginx, you’ll need to install it:

```bash
sudo apt install nginx
```

Then configure Nginx to reverse proxy requests to your Gunicorn server.

## Conclusion

By following these steps, you have successfully set up Flask on your Raspberry Pi and created a simple web application. You can now expand this application by adding more routes and functionality as needed! For more advanced features and configurations, refer to the [Flask documentation](https://flask.palletsprojects.com/).

Citations:
[1] https://buffml.com/run-flask-on-raspberry-pi/
[2] https://www.instructables.com/Python-WebServer-With-Flask-and-Raspberry-Pi/
[3] https://www.easyprogramming.net/raspberrypi/pi_flask_app_server.php
[4] https://forums.raspberrypi.com/viewtopic.php?t=271303
[5] https://towardsdatascience.com/python-webserver-with-flask-and-raspberry-pi-398423cc6f5d?gi=b4afd4d0b3ef
[6] https://roboticsbackend.com/raspberry-pi-create-a-flask-server/
[7] https://www.youtube.com/watch?v=zcYMB-uXKNs
[8] https://www.youtube.com/watch?v=Oy52MqsWQdM