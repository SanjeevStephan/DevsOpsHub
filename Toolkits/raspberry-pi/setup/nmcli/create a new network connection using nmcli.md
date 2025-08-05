To create a new network connection using `nmcli`, follow these steps, which outline both dynamic (DHCP) and static IP configurations.

## Creating a New Ethernet Connection

### 1. Dynamic IP Configuration (DHCP)
If you want to create a new Ethernet connection that automatically obtains an IP address via DHCP, you can use the following command:

```bash
sudo nmcli connection add type ethernet ifname <interface-name> con-name <connection-name> ipv4.method auto
```

- **`<interface-name>`**: Replace this with the actual name of your network interface (e.g., `enp0s3`).
- **`<connection-name>`**: Choose a name for your connection (e.g., `MyOfficeConnection`).

**Example:**
```bash
sudo nmcli connection add type ethernet ifname enp0s3 con-name MyOfficeConnection ipv4.method auto
```

### 2. Static IP Configuration
To create a new Ethernet connection with a static IP address, use the following command:

```bash
sudo nmcli connection add type ethernet ifname <interface-name> con-name <connection-name> ipv4.method manual ipv4.address <IP-address>/<prefix> ipv4.gateway <gateway-address>
```

- **`<IP-address>`**: The desired static IP address (e.g., `192.168.1.50`).
- **`<prefix>`**: The subnet mask in CIDR notation (e.g., `24` for `255.255.255.0`).
- **`<gateway-address>`**: The gateway IP address (e.g., `192.168.1.1`).

**Example:**
```bash
sudo nmcli connection add type ethernet ifname enp0s3 con-name MyStaticConnection ipv4.method manual ipv4.address 192.168.1.50/24 ipv4.gateway 192.168.1.1
```

### 3. Verify the Connection
After creating the connection, you can verify it by listing all connections:

```bash
nmcli connection show
```

### 4. Activate the Connection
To activate the newly created connection, use:

```bash
nmcli connection up <connection-name>
```

**Example:**
```bash
nmcli connection up MyOfficeConnection
```

### Additional Configuration Options
You can modify DNS settings or other parameters after creating the connection:

```bash
sudo nmcli connection modify <connection-name> ipv4.dns "8.8.8.8 8.8.4.4"
```

This command sets Google DNS servers for the specified connection.

### Summary
Using `nmcli`, you can easily manage network connections from the command line, making it ideal for server environments or systems without a graphical interface[1][2][3][4].

Citations:
[1] https://opensource.com/article/20/7/nmcli
[2] https://access.redhat.com/solutions/647383
[3] https://www.geeksforgeeks.org/nmcli-command-in-linux-with-examples/
[4] https://www.tecmint.com/configure-network-connections-using-nmcli-tool-in-linux/
[5] https://docs.redhat.com/en/documentation/red_hat_enterprise_linux/7/html/networking_guide/sec-configuring_ip_networking_with_nmcli
[6] https://www.tecmint.com/nmcli-configure-network-connection/
[7] https://jfearn.fedorapeople.org/fdocs/en-US/Fedora/20/html/Networking_Guide/sec-Connecting_to_a_Network_Using_nmcli.html
[8] https://people.freedesktop.org/~lkundrak/nm-docs/nmcli.html