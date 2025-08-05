To set up a Wi-Fi hotspot using `raspi-config` on your Raspberry Pi, follow these steps. This method leverages the built-in configuration tool to simplify the process of creating a hotspot.

### Step 1: Access `raspi-config`

1. **Open Terminal**: If you're using a monitor and keyboard connected to your Raspberry Pi, open a terminal window. If you're accessing it remotely, use SSH.

2. **Launch `raspi-config`**:
   ```bash
   sudo raspi-config
   ```

### Step 2: Configure the Hotspot

1. **Navigate to Network Options**:
   - Use the arrow keys to select **Network Options** and press Enter.

2. **Select Wi-Fi**:
   - Choose **Wi-Fi** and enter your SSID (network name) and password for the Wi-Fi network you want to connect to (this is your existing network that the Raspberry Pi will use to provide internet access).

3. **Set Up Hotspot**:
   - Look for an option that mentions setting up a hotspot or access point (the exact wording may vary based on your Raspberry Pi OS version). Follow the prompts to configure it.
   - You may need to specify whether you want to set up a new hotspot or use an existing connection.

### Step 3: Install Required Packages

If `raspi-config` does not handle all configurations automatically, you may need to install additional packages:

```bash
sudo apt-get update
sudo apt-get install hostapd dnsmasq
```

- **Hostapd**: This program allows your Raspberry Pi to act as an access point.
- **Dnsmasq**: This lightweight DHCP and DNS server provides IP addresses to connected devices.

### Step 4: Configure Static IP Address

1. **Edit `dhcpcd.conf`**:
   ```bash
   sudo nano /etc/dhcpcd.conf
   ```
   
2. **Add Static IP Configuration**:
   At the end of the file, add:
   ```plaintext
   interface wlan0
   static ip_address=192.168.4.1/24
   nohook wpa_supplicant
   ```

3. **Save and Exit**: Press `Ctrl + X`, then `Y`, and hit Enter.

### Step 5: Configure Hostapd

1. **Create/Edit Hostapd Configuration**:
   ```bash
   sudo nano /etc/hostapd/hostapd.conf
   ```

2. **Add Configuration Settings**:
   Enter the following details, modifying as needed:
   ```plaintext
   country_code=US  # Change as necessary
   interface=wlan0
   ssid=YourHotspotName  # Change this to your desired SSID
   hw_mode=g
   channel=7  # Choose a channel (1-11)
   wmm_enabled=0
   macaddr_acl=0
   auth_algs=1
   wpa=2
   wpa_passphrase=YourPassword  # Change this to your desired password
   rsn_pairwise=CCMP
   ```

3. **Save and Exit**: Press `Ctrl + X`, then `Y`, and hit Enter.

### Step 6: Enable Hostapd

1. **Edit Default Hostapd File**:
   ```bash
   sudo nano /etc/default/hostapd
   ```

2. **Uncomment and Set Configuration File Path**:
   Find the line that starts with `#DAEMON_CONF` and modify it as follows:
   ```plaintext
   DAEMON_CONF="/etc/hostapd/hostapd.conf"
   ```

3. **Save and Exit**: Press `Ctrl + X`, then `Y`, and hit Enter.

### Step 7: Start Hostapd and Dnsmasq

1. **Restart Services**:
   ```bash
   sudo systemctl restart hostapd dnsmasq
   ```

2. **Enable Services on Boot**:
   ```bash
   sudo systemctl enable hostapd dnsmasq
   ```

### Step 8: Verify Hotspot Functionality

- Reboot your Raspberry Pi:
  ```bash
  sudo reboot
  ```
- After rebooting, check for your hotspot SSID on other devices and attempt to connect using the password you set.

### Conclusion

Following these steps will help you successfully set up a Wi-Fi hotspot on your Raspberry Pi using `raspi-config` and additional configurations as needed. This setup allows other devices to connect to the Raspberry Pi's network while potentially accessing the internet through its connection to another Wi-Fi network.

Citations:
[1] https://www.raspberrypi.com/tutorials/host-a-hotel-wifi-hotspot/
[2] https://learn.sparkfun.com/tutorials/setting-up-a-raspberry-pi-3-as-an-access-point/all
[3] https://www.raspberrypi.com/documentation/computers/remote-access.html
[4] https://raspberrypi-guide.github.io/networking/create-wireless-access-point
[5] https://www.youtube.com/watch?v=I3ePABpY9nY
[6] https://www.tomshardware.com/how-to/raspberry-pi-access-point
[7] https://trainedmonkey.com/2024/05/20/using_a_raspberry_pi_as_a_wifi_hotspot
[8] https://www.g7smy.co.uk/2022/04/setting-up-ssh-in-vs-code-to-connect-to-a-raspberry-pi/