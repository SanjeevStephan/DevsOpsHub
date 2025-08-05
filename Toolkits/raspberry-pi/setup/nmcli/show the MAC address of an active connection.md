Yes, you can use `nmcli` to show the MAC address of an active connection. Here’s how to do it:

### Steps to Display the MAC Address

1. **Identify Active Connections**: First, you need to find out the name of the active connection. You can do this by running:

   ```bash
   nmcli connection show --active
   ```

2. **Get Device Information**: Once you have the connection name, you can find the associated device and its MAC address using the following command:

   ```bash
   nmcli device show <device-name>
   ```

   Replace `<device-name>` with the actual name of your network device (e.g., `enp0s3`, `wlan0`, etc.). 

3. **Locate the MAC Address**: In the output, look for a line that starts with `GENERAL.HWADDR`. This line displays the MAC address of the device.

### Example

Assuming you have an active Ethernet connection and your device name is `enp0s3`, you would run:

```bash
nmcli device show enp0s3
```

if connected to wireless adapter 

```shell
nmcli device show wlan0
```

The output will include a line similar to:

```
GENERAL.HWADDR: 00:1A:2B:3C:4D:5E
```

This indicates that the MAC address of the active connection is `00:1A:2B:3C:4D:5E`.

### Summary

Using `nmcli`, you can easily retrieve detailed information about your network devices, including their MAC addresses, by following these simple steps. This is particularly useful for network management and troubleshooting tasks.

Citations:
[1] https://www.oreilly.com/library/view/centos-quick-start/9781789344875/0a39b4e2-8adb-409f-972d-04b9d15fed41.xhtml
[2] https://www.tecmint.com/nmcli-configure-network-connection/
[3] https://delightlylinux.wordpress.com/2024/02/04/monitor-network-connections-with-nmcli/
[4] https://docs.oracle.com/en/learn/nmcli_ip_linux8/index.html
[5] https://docs.oracle.com/en/learn/ol-nmcli/
[6] https://www.geeksforgeeks.org/nmcli-command-in-linux-with-examples/
[7] https://ubuntu.com/core/docs/networkmanager/exploring-network-status
[8] https://docs.redhat.com/en/documentation/red_hat_enterprise_linux/8/html/configuring_and_managing_networking/assembly_configuring-network-devices-to-accept-traffic-from-all-mac-addresses_configuring-and-managing-networking