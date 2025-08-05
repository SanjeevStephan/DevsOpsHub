To autostart a script named `startupscript.sh` located in the user's home directory (`/home/rpi/startupscript.sh`) using `rc.local`, follow these steps:

### Steps to Configure rc.local

1. **Open the rc.local File**:
   You need to edit the `/etc/rc.local` file with root permissions. Use your preferred text editor, such as `nano`:

   ```bash
   sudo nano /etc/rc.local
   ```

2. **Add Your Script**:
   Before the `exit 0` line at the end of the file, add the command to execute your script. It’s important to use the full path to the script. Your entry should look like this:

   ```bash
   /home/rpi/startupscript.sh &
   ```

   The ampersand (`&`) at the end allows the script to run in the background, which is essential if your script runs indefinitely or takes time to execute.

3. **Ensure rc.local is Executable**:
   Make sure that the `rc.local` file has executable permissions. Run the following command:

   ```bash
   sudo chmod +x /etc/rc.local
   ```

4. **Enable rc.local Service**:
   If your system uses `systemd`, you may need to enable the `rc-local` service to ensure that it runs at startup:

   ```bash
   sudo systemctl enable rc-local
   ```

5. **Start the Service (Optional)**:
   You can start the service immediately without rebooting by running:

   ```bash
   sudo systemctl start rc-local
   ```

6. **Reboot and Test**:
   Finally, reboot your system to test if the script runs on startup:

   ```bash
   sudo reboot
   ```

### Example of rc.local

Your `/etc/rc.local` file should look something like this:

```bash
#!/bin/sh -e

# This script is executed at the end of each multiuser runlevel.
# Make sure that this script will "exit 0" on success or any other value on error.

# Start your script
/home/rpi/startupscript.sh &

exit 0
```

### Notes

- Ensure that your script (`startupscript.sh`) has executable permissions as well:

  ```bash
  chmod +x /home/rpi/startupscript.sh
  ```

- If your script produces output, consider redirecting it to a log file for debugging purposes:

  ```bash
  /home/rpi/startupscript.sh >> /home/rpi/startup.log 2>&1 &
  ```

By following these steps, you can successfully configure your system to run `startupscript.sh` automatically at boot using `rc.local`.

Citations:
[1] https://www.youtube.com/watch?v=aMtMqPIC0Zw
[2] https://www.dexterindustries.com/howto/run-a-program-on-your-raspberry-pi-at-startup/
[3] https://www.linuxbabe.com/linux-server/how-to-enable-etcrc-local-with-systemd
[4] https://stackoverflow.com/questions/7783341/run-script-with-rc-local-script-works-but-not-at-boot
[5] https://community.ipfire.org/t/been-hours-trying-please-help-me-start-a-sciprt-on-boot-rc-local-init-d-rcx-d-cant-get-any-to-work-please/9320
[6] https://delightlylinux.wordpress.com/2024/02/04/monitor-network-connections-with-nmcli/
[7] https://docs.oracle.com/en/learn/ol-nmcli/
[8] https://docs.oracle.com/en/learn/nmcli_ip_linux8/index.html