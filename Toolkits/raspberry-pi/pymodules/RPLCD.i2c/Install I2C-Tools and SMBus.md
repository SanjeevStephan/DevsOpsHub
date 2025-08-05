To install **I2C-tools** and **SMBus** on a Raspberry Pi, follow these steps:

### Step 1: Update Package Lists

Open a terminal on your Raspberry Pi and ensure your package lists are up to date:

```bash
sudo apt-get update
```

### Step 2: Install I2C-tools

Install the I2C-tools package, which provides utilities to interact with I2C devices:

```bash
sudo apt-get install i2c-tools
```

### Step 3: Install SMBus

Next, install the SMBus library, which allows Python to access the I2C bus:

```bash
sudo apt-get install python-smbus
```

### Step 4: Enable I2C Interface

You need to enable the I2C interface on your Raspberry Pi. You can do this using the `raspi-config` tool:

1. Run the configuration tool:
   ```bash
   sudo raspi-config
   ```

2. Navigate to **Interfacing Options**.

3. Select **I2C** and choose **Yes** to enable it.

4. Exit the configuration tool and reboot your Raspberry Pi for the changes to take effect:
   ```bash
   sudo reboot
   ```

### Step 5: Verify Installation

After rebooting, you can verify that the I2C interface is working by checking for connected devices. Run the following command:

```bash
i2cdetect -y 1
```

This command will display a grid showing the addresses of any connected I2C devices. If your device is connected properly, its address will be displayed in the grid.

By following these steps, you will have successfully installed **I2C-tools** and **SMBus** on your Raspberry Pi, enabling you to communicate with I2C devices such as LCD screens or sensors.

Citations:
[1] https://www.circuitbasics.com/raspberry-pi-i2c-lcd-set-up-and-programming/
[2] https://www.instructables.com/Raspberry-Pi-I2C-Python/
[3] https://raspi.tv/how-to-set-up-i2c-in-raspbian-on-the-raspberry-pi
[4] https://docs.sunfounder.com/projects/superkit-v2-pi/en/latest/appendix/i2c_configuration.html
[5] https://www.electronicwings.com/raspberry-pi/python-based-i2c-functions-for-raspberry-pi
[6] https://www.engineersgarage.com/articles-raspberry-pi-i2c-bus-pins-smbus-smbus2-python/
[7] https://mike632t.wordpress.com/2021/07/17/setting-up-i2c-on-a-raspberry-pi/
[8] https://forums.raspberrypi.com/viewtopic.php?t=270043