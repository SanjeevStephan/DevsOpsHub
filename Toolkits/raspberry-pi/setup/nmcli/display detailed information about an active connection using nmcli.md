To display detailed information about an active network connection using `nmcli`, you can use the following command:

```bash
nmcli connection show <connection-name>
```

### Steps to Display Connection Details

1. **Identify the Active Connection Name**: First, you need to know the name of the active connection you want to inspect. You can list all active connections with:

   ```bash
   nmcli connection show --active
   ```

2. **Display Detailed Information**: Replace `<connection-name>` in the command above with the actual name of your active connection. For example, if your connection is named "Wired connection 1", you would run:

   ```bash
   nmcli connection show 'Wired connection 1'
   ```

```shell
nmcli connection show 'SmartHome'
```
### Example Output
The output will provide comprehensive details about the specified connection, including:

- **General Information**: Connection UUID, type, and device.
- **IP Configuration**: IP address, subnet mask, gateway.
- **DNS Settings**: DNS servers used by the connection.
- **DHCP Information**: DHCP client ID and lease time (if applicable).

### Additional Command Options
If you want to see specific fields or sections of the connection details, you can use:

```bash
nmcli -f <fields> connection show <connection-name>
```

Replace `<fields>` with specific attributes you are interested in (e.g., `IP4.ADDRESS`, `IP4.GATEWAY`, `GENERAL.STATE`).

### Summary
Using `nmcli connection show <connection-name>`, you can effectively retrieve detailed information about any active network connection, which is useful for troubleshooting and network management tasks.

Citations:
[1] https://www.oreilly.com/library/view/centos-quick-start/9781789344875/0a39b4e2-8adb-409f-972d-04b9d15fed41.xhtml
[2] https://www.geeksforgeeks.org/nmcli-command-in-linux-with-examples/
[3] https://people.freedesktop.org/~lkundrak/nm-docs/nmcli.html
[4] https://ubuntu.com/core/docs/networkmanager/exploring-network-status
[5] https://docs.oracle.com/en/learn/nmcli_ip_linux8/index.html
[6] https://docs.oracle.com/en/learn/ol-nmcli/
[7] https://docs.redhat.com/en/documentation/red_hat_enterprise_linux/7/html/networking_guide/sec-configuring_ip_networking_with_nmcli
[8] https://www.liquidweb.com/blog/how-to-install-and-configure-nmcli/