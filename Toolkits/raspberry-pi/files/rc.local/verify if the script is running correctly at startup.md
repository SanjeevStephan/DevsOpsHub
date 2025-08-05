To verify if your script (`startupscript.sh`) is running correctly at startup, you can use several methods. Here are the most effective approaches based on the provided information:

### 1. **Log Output to a File**
Modify your script to log its output and errors to a file. This way, you can check the log file after rebooting to see if the script executed successfully.

**Example Modification:**
Add the following line to the end of your `startupscript.sh`:

```bash
echo "Script executed at $(date)" >> /home/rpi/startup.log 2>&1
```

This will append a timestamp to `startup.log` every time the script runs, allowing you to confirm execution.

### 2. **Check rc.local Execution**
If you are using `rc.local` to run your script, ensure that it is configured correctly and has executable permissions. You can add logging directly in the `rc.local` file as well:

```bash
/home/rpi/startupscript.sh >> /home/rpi/rc.local.log 2>&1 &
```

This will log any output or errors from `startupscript.sh` to `rc.local.log`.

### 3. **Check System Logs**
You can check system logs for entries related to your script or `rc.local`. Use the following command to search for relevant entries:

```bash
grep -i rc.local /var/log/syslog
```

This will show you if `rc.local` was executed during boot and any messages associated with it.

### 4. **Use Temporary Files for Debugging**
You can create temporary files at the start and end of your script to track its execution:

```bash
touch /tmp/startupscript_started
# Your script logic here
touch /tmp/startupscript_finished
```

After rebooting, check for the existence of these files:

```bash
ls -l /tmp/startupscript_started /tmp/startupscript_finished
```

- If you see both files, it means the script started and finished successfully.
- If only the first file exists, the script started but did not finish.
- If neither file exists, the script did not run at all.

### 5. **Check Running Processes**
After rebooting, you can also check if your script is currently running by using:

```bash
ps aux | grep startupscript.sh
```

This will show if there are any active instances of your script.

### Summary
By implementing logging within your script and checking system logs or temporary files, you can effectively verify whether your startup script is executing as intended during system boot.

Citations:
[1] https://www.reddit.com/r/linuxquestions/comments/16nam4z/how_to_verify_that_cron_is_running_a_script_at/
[2] https://forum.mikrotik.com/viewtopic.php?t=135287
[3] https://stackoverflow.com/questions/16807876/how-to-check-if-another-instance-of-my-shell-script-is-running/76235028
[4] https://www.dexterindustries.com/howto/run-a-program-on-your-raspberry-pi-at-startup/
[5] https://community.spiceworks.com/t/check-if-there-is-unwanted-scripts-running-on-workstation/438070
[6] https://www.youtube.com/watch?v=aMtMqPIC0Zw
[7] https://stackoverflow.com/questions/7783341/run-script-with-rc-local-script-works-but-not-at-boot
[8] https://community.ipfire.org/t/been-hours-trying-please-help-me-start-a-sciprt-on-boot-rc-local-init-d-rcx-d-cant-get-any-to-work-please/9320