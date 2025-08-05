To list all saved network connections using `nmcli`, you can use the following command:

```bash
nmcli connection show
```

This command will display a list of all network connections that are configured on your system, regardless of whether they are currently active or inactive. The output includes details such as:

- **NAME**: The name of the connection.
- **UUID**: The unique identifier for the connection.
- **TYPE**: The type of connection (e.g., ethernet, wifi).
- **DEVICE**: The device associated with the connection (if any).

### Example Output
When you run the command, you might see output similar to this:

```
NAME                UUID                                  TYPE      DEVICE
Wired connection 1  ac3241e4-b424-35d6-aaa7-07498561688d  ethernet  enp0s3
Wired connection 2  2279d917-fa02-390c-8603-3083ec5a1d3e  ethernet  enp0s8
Wired connection 3  52d89737-de92-35ec-b082-8cf2e5ac36e6  ethernet  enp0s9
```

### Additional Options
- To see only active connections, use:
  ```bash
  nmcli connection show --active
  ```

These commands are useful for managing and troubleshooting network configurations in Linux environments.

Citations:
[1] https://www.oreilly.com/library/view/centos-quick-start/9781789344875/0a39b4e2-8adb-409f-972d-04b9d15fed41.xhtml
[2] https://people.freedesktop.org/~lkundrak/nm-docs/nmcli.html
[3] https://docs.redhat.com/en/documentation/red_hat_enterprise_linux/7/html/networking_guide/sec-configuring_ip_networking_with_nmcli
[4] https://www.geeksforgeeks.org/nmcli-command-in-linux-with-examples/
[5] https://opensource.com/article/20/7/nmcli
[6] https://infotechys.com/manage-network-connections-using-the-nmcli-utility/
[7] https://www.tecmint.com/configure-network-connections-using-nmcli-tool-in-linux/
[8] https://delightlylinux.wordpress.com/2024/02/04/monitor-network-connections-with-nmcli/