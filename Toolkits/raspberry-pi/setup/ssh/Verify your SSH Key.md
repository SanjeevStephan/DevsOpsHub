To verify that your SSH key is correctly set up on your Raspberry Pi, follow these steps:

### Step 1: Check the Authorized Keys on Raspberry Pi

1. **SSH into Your Raspberry Pi**:
   If you can still access your Raspberry Pi using a password, log in via SSH:
   ```bash
   ssh <username>@<ip_address>
   ```

2. **View the Authorized Keys File**:
   Once logged in, check the contents of the `authorized_keys` file where your public key should be stored:
   ```bash
   cat ~/.ssh/authorized_keys
   ```
   Ensure that your public key is listed in this file. If you do not see it, you need to add your public key.

### Step 2: Verify Your Public Key

1. **Locate Your Public Key on Your Local Machine**:
   On your local machine (Windows), find your public key, typically located at:
   - `C:\Users\<YourUsername>\.ssh\id_ed25519.pub` (for Ed25519 keys)
   - `C:\Users\<YourUsername>\.ssh\id_rsa.pub` (for RSA keys)

2. **Check the Contents of Your Public Key**:
   Open the public key file in a text editor and copy its entire content.

3. **Compare Keys**:
   Ensure that the content of your public key matches what is in the `authorized_keys` file on your Raspberry Pi.

### Step 3: Test SSH Key Authentication

1. **Attempt to SSH Without a Password**:
   Try connecting to your Raspberry Pi using SSH without entering a password:
   ```bash
   ssh <username>@<ip_address>
   ```
   If everything is set up correctly, you should connect without being prompted for a password.

### Step 4: Check SSH Configuration

If you are still prompted for a password, check the SSH configuration:

1. **Open the SSH Configuration File**:
   On your Raspberry Pi, open the SSH daemon configuration file:
   ```bash
   sudo nano /etc/ssh/sshd_config
   ```

2. **Ensure Public Key Authentication is Enabled**:
   Look for the following lines and ensure they are set correctly:
   ```plaintext
   PubkeyAuthentication yes
   PasswordAuthentication no  # Optional: Disable password authentication for security
   ```
   
3. **Restart the SSH Service**:
   After making any changes, restart the SSH service to apply them:
   ```bash
   sudo systemctl restart sshd
   ```

### Step 5: Troubleshooting

- If you still cannot log in using your SSH key, check the permissions of the `.ssh` directory and `authorized_keys` file on the Raspberry Pi:
  ```bash
  chmod 700 ~/.ssh
  chmod 600 ~/.ssh/authorized_keys
  ```

- Make sure that you are using the correct private key when connecting from your local machine. You can specify it explicitly with:
  ```bash
  ssh -i C:\Users\<YourUsername>\.ssh\id_ed25519 <username>@<ip_address>
  ```

By following these steps, you can verify that your SSH key authentication is correctly set up and troubleshoot any issues that may arise during the process.

Citations:
[1] https://pimylifeup.com/raspberry-pi-ssh-keys/
[2] https://littlebigtech.net/posts/automatic-ssh-key-authentication-raspberrypi/
[3] https://www.raspberrypi.com/documentation/computers/remote-access.html
[4] https://www.g7smy.co.uk/2022/04/setting-up-ssh-in-vs-code-to-connect-to-a-raspberry-pi/
[5] https://forums.raspberrypi.com/viewtopic.php?t=58677
[6] https://www.youtube.com/watch?v=R6VJE7WfXt8
[7] https://www.youtube.com/watch?v=9_Sl6Ci-h_0
[8] https://stackoverflow.com/questions/4411457/how-do-i-verify-check-test-validate-my-ssh-passphrase