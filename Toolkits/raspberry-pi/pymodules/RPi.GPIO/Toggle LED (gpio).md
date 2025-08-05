---
module:
  - RPi.GPIO
Script-ID:
  - gpioscript-02
---
To turn on an LED connected to GPIO pin 17 on a Raspberry Pi, you can use the following Python script. This script will set up the GPIO pin and turn on the LED.

### Required Components

1. **LED**: A standard LED.
2. **Resistor**: A 220-ohm resistor (to limit current).
3. **Wiring**: Connect the LED and resistor as follows:
   - Connect the longer leg (anode) of the LED to GPIO pin 17.
   - Connect the shorter leg (cathode) of the LED to one end of the resistor.
   - Connect the other end of the resistor to a ground pin on the Raspberry Pi.

### Python Script

Here’s a simple Python script to turn on the LED:

```python
#!/usr/bin/env python

import RPi.GPIO as GPIO
import time

# Set up GPIO mode
GPIO.setmode(GPIO.BCM)

# Set up GPIO pin 17 as an output
led_pin = 17
GPIO.setup(led_pin, GPIO.OUT)

# Turn on the LED
GPIO.output(led_pin, True)
print("LED is ON")

# Keep the LED on for 5 seconds
time.sleep(5)

# Turn off the LED
GPIO.output(led_pin, False)
print("LED is OFF")

# Clean up GPIO settings
GPIO.cleanup()
```

### Explanation of the Script

- **Imports**: The script imports the necessary libraries for controlling GPIO pins and handling time delays.
- **GPIO Setup**: The `setmode(GPIO.BCM)` function sets up the GPIO pin numbering system to use BCM (Broadcom) numbers.
- **Pin Configuration**: `GPIO.setup(led_pin, GPIO.OUT)` configures pin 17 as an output pin.
- **LED Control**:
  - `GPIO.output(led_pin, True)` turns on the LED.
  - The script waits for 5 seconds (`time.sleep(5)`) while keeping the LED on.
  - After that, it turns off the LED with `GPIO.output(led_pin, False)`.
- **Cleanup**: Finally, `GPIO.cleanup()` resets all GPIO pins used in this script.

### Running the Script

1. Save this code in a file named `led_control.py`.
2. Make it executable:

   ```bash
   chmod +x led_control.py
   ```

3. Run the script:

   ```bash
   python3 led_control.py
   ```

When you run this script, you should see the LED turn on for 5 seconds and then turn off. You can modify the duration by changing the value in `time.sleep(5)` to your desired number of seconds.

This simple setup demonstrates how to control an LED using a Raspberry Pi's GPIO pins effectively.

Citations:
[1] https://www.instructables.com/Using-Your-Raspberry-Pis-GPIO-Pins-to-Control-an-L/
[2] https://raspberrydiy.com/gpio-pins-tutorial-raspberry-pi/
[3] https://forums.raspberrypi.com/viewtopic.php?t=154824
[4] https://circuitdigest.com/microcontroller-projects/basic-gpio-control-on-raspberry-pi-zero-w-blinking-an-led
[5] https://www.youtube.com/watch?v=6gRRPQtvb2w
[6] https://www.youtube.com/watch?v=HzZdrzQXp-k
[7] https://pimylifeup.com/raspberry-pi-rfid-rc522/
[8] https://github.com/ondryaso/pi-rc522