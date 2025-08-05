To run a script in the background on a Linux system, you can use several methods. Here’s a concise overview of the most common approaches based on the search results:

### 1. Using the Ampersand (&)
You can run a script in the background by appending an ampersand (`&`) at the end of the command. This allows the shell to execute the script as a background process.

**Example:**
```bash
./startupscript.sh &
```

### 2. Redirecting Output
If you want to prevent the script's output from cluttering your terminal, you can redirect both standard output and standard error to `/dev/null` or to a log file.

**Redirect to /dev/null:**
```bash
./startupscript.sh &>/dev/null &
```

**Redirect to a log file:**
```bash
./startupscript.sh >> /path/to/logfile.log 2>&1 &
```

### 3. Using `nohup`
The `nohup` command allows you to run a script that will continue running even after you log out of the terminal session. It prevents the process from receiving a SIGHUP (hangup) signal.

**Example:**
```bash
nohup ./startupscript.sh &>/dev/null &
```

This command will keep your script running in the background and discard all output.

### 4. Using `disown`
If you start a process in the foreground and then decide to move it to the background, you can pause it with `Ctrl+Z`, then use `bg` to resume it in the background, and finally use `disown` to detach it from the terminal.

**Example:**
1. Start your script:
   ```bash
   ./startupscript.sh
   ```
2. Press `Ctrl+Z` (this stops the process).
3. Resume in the background:
   ```bash
   bg
   ```
4. Detach it:
   ```bash
   disown
   ```

### 5. Checking Background Processes
To verify that your script is running in the background, you can use:

```bash
jobs
```

This command lists all jobs started in the current shell session, including background processes.

### Summary
These methods allow you to effectively run scripts in the background on Linux, enabling you to continue using your terminal for other tasks while your script executes independently.

Citations:
[1] https://stackoverflow.com/questions/44222883/run-a-shell-script-and-immediately-background-it-however-keep-the-ability-to-in
[2] https://www.linuxtechi.com/run-linux-shell-command-in-background/
[3] https://www.scaler.com/topics/how-to-run-process-in-background-linux/
[4] https://phoenixnap.com/kb/linux-run-command-background
[5] https://www.youtube.com/watch?v=AHAAA7zfT7Q
[6] https://forum.mikrotik.com/viewtopic.php?t=135287
[7] https://www.dexterindustries.com/howto/run-a-program-on-your-raspberry-pi-at-startup/
[8] https://www.youtube.com/watch?v=aMtMqPIC0Zw