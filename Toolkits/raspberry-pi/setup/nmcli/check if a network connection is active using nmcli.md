To check if a network connection is active using `nmcli`, you can use the following commands:

### 1. List Active Connections
To display only the active connections, run:

```bash
nmcli connection show --active
```

This command will show all currently active connections, including their names, UUIDs, types, and associated devices.

### 2. Check Device Status
You can also check the status of network devices to see if they are connected or disconnected:

```bash
nmcli device status
```

This command provides a summary of each device's state, indicating whether it is connected to a network.

### 3. General Connection Status
For a broader overview of all connections (both active and inactive), you can use:

```bash
nmcli connection show
```

This command lists all saved connections along with their current state (up or down).

### Example Output
When you run `nmcli connection show --active`, you might see output like this:

```
NAME                UUID                                  TYPE      DEVICE
Wired connection 1  ac3241e4-b424-35d6-aaa7-07498561688d  ethernet  enp0s3
```

This indicates that "Wired connection 1" is currently active on the device `enp0s3`.

Using these commands, you can effectively monitor the status of your network connections and devices in a Linux environment managed by NetworkManager.

Citations:
[1] https://www.oreilly.com/library/view/centos-quick-start/9781789344875/0a39b4e2-8adb-409f-972d-04b9d15fed41.xhtml
[2] https://ubuntu.com/core/docs/networkmanager/exploring-network-status
[3] https://www.geeksforgeeks.org/nmcli-command-in-linux-with-examples/
[4] https://www.tecmint.com/configure-network-connections-using-nmcli-tool-in-linux/
[5] https://docs.oracle.com/en/learn/ol-nmcli/
[6] https://www.liquidweb.com/blog/how-to-install-and-configure-nmcli/
[7] https://stackoverflow.com/questions/43228973/detect-if-current-connection-is-metered-with-networkmanager/54481683
[8] https://infotechys.com/manage-network-connections-using-the-nmcli-utility/