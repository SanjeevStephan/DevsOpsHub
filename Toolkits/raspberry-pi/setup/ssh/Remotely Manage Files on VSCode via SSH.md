# Remotely Manage Files on VSCode via SSH
To set up SSH on your Raspberry Pi and connect to it from a Windows machine using public key authentication, follow these detailed steps. This guide will also cover how to explore files remotely using Visual Studio Code (VS Code).

### Step 1: Enable SSH on the Raspberry Pi

1. **Access Raspberry Pi**:
   - Connect your Raspberry Pi to a monitor, keyboard, and power supply.

2. **Open Terminal**:
   - Once logged in, open a terminal window.

3. **Enable SSH**:
   - Run the following command to open the Raspberry Pi configuration tool:
     ```bash
     sudo raspi-config
     ```
   - Navigate to **3 Interface Options** > **P2 SSH** and select **Yes** to enable SSH.
   - Exit the configuration tool and reboot your Raspberry Pi if prompted.

### Step 2: Install OpenSSH Client on Windows

1. **Open Settings**:
   - Go to **Settings** > **Apps** > **Optional Features**.

2. **Check for OpenSSH Client**:
   - Look for **OpenSSH Client** in the list. If it’s not installed, click on **Add a feature**, find **OpenSSH Client**, and install it.

### Step 3: Generate SSH Key Pair on Windows

1. **Open PowerShell or Command Prompt**:
   - You can use either PowerShell or Command Prompt.

2. **Generate SSH Key Pair**:
   - Run the following command to create an SSH key pair:
     ```bash
     ssh-keygen -t ed25519
     ```
   - Press Enter to accept the default file location (usually `C:\Users\<YourUsername>\.ssh\id_ed25519`).
   - Optionally, enter a passphrase for added security or leave it empty.

### Step 4: Copy Public Key to Raspberry Pi

1. **Find the Raspberry Pi’s IP Address**:
   - On your Raspberry Pi terminal, run:
     ```bash
     hostname -I
     ```
   - Note the IP address (e.g., `192.168.1.100`).

2. **Copy Public Key Using SCP**:
   - In PowerShell or Command Prompt, run the following command (replace `<username>` and `<ip_address>` with your actual username and IP address):
     ```bash
     scp C:\Users\<YourUsername>\.ssh\id_ed25519.pub <username>@<ip_address>:~/.ssh/authorized_keys
     ```
   - If prompted, enter the password for your Raspberry Pi user account.

3. **Set Permissions on Raspberry Pi**:
   - Log into your Raspberry Pi using SSH for the first time (you will need to enter the password):
     ```bash
     ssh <username>@<ip_address>
     ```
   - Once logged in, ensure the `.ssh` directory has correct permissions:
     ```bash
     chmod 700 ~/.ssh
     chmod 600 ~/.ssh/authorized_keys
     ```

### Step 5: Connect to Raspberry Pi Using SSH

Now you can connect without entering a password:

```bash
ssh <username>@<ip_address>
```

### Step 6: Set Up Visual Studio Code for Remote Access

1. **Install Remote Development Extension Pack**:
   - Open VS Code.
   - Go to Extensions (Ctrl+Shift+X) and search for "Remote Development".
   - Install the extension pack which includes Remote-SSH.

2. **Configure SSH in VS Code**:
   - Open the Command Palette (Ctrl+Shift+P) and type `Remote-SSH: Open Configuration File`.
   - Choose `C:\Users\<YourUsername>\.ssh\config` or create it if it doesn’t exist.
   - Add the following configuration (replace `<username>` and `<ip_address>`):
     ```plaintext
     Host raspberrypi
         HostName <ip_address>
         User <username>
         IdentityFile C:/Users/<YourUsername>/.ssh/id_ed25519
         ForwardAgent yes
     ```

3. **Connect to Raspberry Pi via VS Code**:
   - Click on the green icon in the bottom left corner of VS Code.
   - Select `Connect to Host...` and choose `raspberrypi`.
   - If prompted about Linux or Windows, select Linux.
   - You should now be connected to your Raspberry Pi.

### Step 7: Explore Files Remotely

- Use VS Code’s Explorer pane to navigate through files on your Raspberry Pi.
- You can open a terminal within VS Code (Ctrl+`) to run commands directly on your Raspberry Pi.

By following these steps, you will have successfully set up SSH access using public key authentication and configured Visual Studio Code for remote development on your Raspberry Pi. This setup allows you to work efficiently without needing physical access to your device while enjoying all of VS Code's features for coding and file management.

Citations:
[1] https://www.raspberrypi.com/documentation/computers/remote-access.html
[2] https://www.g7smy.co.uk/2022/04/setting-up-ssh-in-vs-code-to-connect-to-a-raspberry-pi/
[3] https://code.visualstudio.com/docs/remote/troubleshooting
[4] https://www.youtube.com/watch?v=R6VJE7WfXt8
[5] https://code.visualstudio.com/docs/remote/ssh-tutorial
[6] https://code.visualstudio.com/docs/remote/ssh?WT.mc_id=devcloud-30876-buhollan
[7] https://stackoverflow.com/questions/76484417/vscode-how-to-connect-to-remote-ssh-host-inside-an-ssh-host/76539563
[8] https://embeddedcomputing.com/technology/processing/interface-io/quick-start-raspberry-pi-gpio-terminal-interface