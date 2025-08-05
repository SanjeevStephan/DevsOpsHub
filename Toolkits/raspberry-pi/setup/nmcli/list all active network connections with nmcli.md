To list all active network connections using `nmcli`, you can use the following command:

```bash
nmcli connection show --active
```

This command displays only the connections that are currently active, providing details such as the connection name, UUID, type, and associated device. 

### Additional Commands

- To list **all** network connections (both active and inactive), you can use:
  ```bash
  nmcli connection show
  ```

- If you prefer a more concise output, you can also use:
  ```bash
  nmcli con show --active
  ```

These commands are useful for quickly checking the status of your network connections in a Linux environment managed by NetworkManager.

Citations:
[1] https://www.oreilly.com/library/view/centos-quick-start/9781789344875/0a39b4e2-8adb-409f-972d-04b9d15fed41.xhtml
[2] https://www.geeksforgeeks.org/nmcli-command-in-linux-with-examples/
[3] https://www.tecmint.com/configure-network-connections-using-nmcli-tool-in-linux/
[4] https://people.freedesktop.org/~lkundrak/nm-docs/nmcli.html
[5] https://docs.redhat.com/en/documentation/red_hat_enterprise_linux/7/html/networking_guide/sec-configuring_ip_networking_with_nmcli
[6] https://delightlylinux.wordpress.com/2024/02/04/monitor-network-connections-with-nmcli/
[7] https://opensource.com/article/20/7/nmcli
[8] https://www.tecmint.com/nmcli-configure-network-connection/