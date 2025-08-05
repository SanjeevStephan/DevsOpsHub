When setting up SSH keys on a Raspberry Pi, several common mistakes can lead to issues with authentication or connectivity. Here are key mistakes to avoid:

### 1. **Incorrect Key Type or Format**
   - **Mistake**: Using an unsupported key type or an incorrect format for the public key.
   - **Solution**: Use a secure key type like Ed25519 or RSA. When generating keys, ensure you use the command:
     ```bash
     ssh-keygen -t ed25519
     ```
     or for RSA:
     ```bash
     ssh-keygen -t rsa
     ```

### 2. **Not Copying the Public Key Correctly**
   - **Mistake**: Copying the private key instead of the public key to the Raspberry Pi.
   - **Solution**: Ensure you copy the contents of your public key file (e.g., `id_ed25519.pub` or `id_rsa.pub`) to the `~/.ssh/authorized_keys` file on the Raspberry Pi. Use:
     ```bash
     scp ~/.ssh/id_ed25519.pub <username>@<ip_address>:~/.ssh/
     ```
     Then, append it to `authorized_keys`:
     ```bash
     cat id_ed25519.pub >> ~/.ssh/authorized_keys
     ```

### 3. **Incorrect Permissions on SSH Files**
   - **Mistake**: Setting incorrect permissions on the `.ssh` directory or `authorized_keys` file.
   - **Solution**: Ensure that the `.ssh` directory has permissions set to `700` and the `authorized_keys` file is set to `600`:
     ```bash
     chmod 700 ~/.ssh
     chmod 600 ~/.ssh/authorized_keys
     ```

### 4. **SSH Service Not Running or Misconfigured**
   - **Mistake**: The SSH service is not running or is misconfigured.
   - **Solution**: Check if SSH is enabled and running:
     ```bash
     sudo systemctl status ssh
     ```
     If it's not running, enable it:
     ```bash
     sudo systemctl enable ssh
     sudo systemctl start ssh
     ```

### 5. **Disabling Password Authentication Prematurely**
   - **Mistake**: Disabling password authentication before confirming that SSH key authentication works.
   - **Solution**: First, ensure you can log in using your SSH key before modifying the SSH configuration to disable password authentication. Modify `/etc/ssh/sshd_config` only after successful key-based login.

### 6. **Using Wrong Username**
   - **Mistake**: Attempting to log in with an incorrect username.
   - **Solution**: Ensure you are using the correct username that exists on the Raspberry Pi (usually `pi`, unless changed).

### 7. **Firewall Issues**
   - **Mistake**: Firewall settings blocking SSH access.
   - **Solution**: Check your firewall settings and ensure that port 22 (default for SSH) is open.

### 8. **Network Configuration Issues**
   - **Mistake**: Not being able to reach the Raspberry Pi due to network issues.
   - **Solution**: Verify that your Raspberry Pi is connected to the network and check its IP address using:
     ```bash
     hostname -I
     ```

### Conclusion

By avoiding these common mistakes and following best practices, you can successfully set up SSH keys for secure access to your Raspberry Pi. Always test your configuration before making any changes that could lock you out, such as disabling password authentication.

Citations:
[1] https://www.raspberrypi.com/documentation/computers/remote-access.html
[2] https://pimylifeup.com/raspberry-pi-ssh-keys/
[3] https://littlebigtech.net/posts/automatic-ssh-key-authentication-raspberrypi/
[4] https://www.g7smy.co.uk/2022/04/setting-up-ssh-in-vs-code-to-connect-to-a-raspberry-pi/
[5] https://www.naturalborncoder.com/2022/11/configuring-ssh-keys-on-raspberry-pi-from-raspberry-pi/
[6] https://www.youtube.com/watch?v=R6VJE7WfXt8
[7] https://www.youtube.com/watch?v=9_Sl6Ci-h_0
[8] https://code.visualstudio.com/docs/remote/troubleshooting