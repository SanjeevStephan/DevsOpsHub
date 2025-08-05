To activate a saved network connection using `nmcli`, you can use the following command:

```bash
sudo nmcli connection up <connection-name>
```

### Steps to Activate a Connection

1. **Identify the Connection Name**: First, you need to know the exact name of the connection you wish to activate. You can list all saved connections with:

   ```bash
   nmcli connection show
   ```

2. **Activate the Connection**: Once you have the connection name, replace `<connection-name>` in the command above with the actual name. For example, if your connection is named "MyOfficeConnection", you would run:

   ```bash
   sudo nmcli connection up MyOfficeConnection
   ```

3. **Verify Activation**: To confirm that the connection has been successfully activated, you can check the list of active connections with:

   ```bash
   nmcli connection show --active
   ```

This command will display all currently active connections, allowing you to verify that your desired connection is now active.

### Example

Here’s a complete example of activating a saved Ethernet connection named "Wired connection 1":

```bash
# List all saved connections
nmcli connection show

# Activate the desired connection
sudo nmcli connection up 'Wired connection 1'

# Verify activation
nmcli connection show --active
```

Using these commands, you can easily manage and activate your network connections through `nmcli`.

Citations:
[1] https://infotechys.com/manage-network-connections-using-the-nmcli-utility/
[2] https://opensource.com/article/20/7/nmcli
[3] https://www.oreilly.com/library/view/centos-quick-start/9781789344875/0a39b4e2-8adb-409f-972d-04b9d15fed41.xhtml
[4] https://access.redhat.com/solutions/647383
[5] https://www.liquidweb.com/blog/how-to-install-and-configure-nmcli/
[6] https://www.tecmint.com/configure-network-connections-using-nmcli-tool-in-linux/
[7] https://docs.redhat.com/en/documentation/red_hat_enterprise_linux/7/html/networking_guide/sec-configuring_ip_networking_with_nmcli
[8] https://www.tecmint.com/nmcli-configure-network-connection/