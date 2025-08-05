To read RFID cards and tags using the MFRC522 module with a Raspberry Pi, you can use the following Python script. This script utilizes the `SimpleMFRC522` library, which simplifies interaction with the RFID reader.

### Prerequisites

1. **Install Required Libraries**:
   First, ensure you have the necessary libraries installed. You can install the `mfrc522` library using pip:

   ```bash
   python3 -m pip install mfrc522
   ```

2. **Wiring the MFRC522 to Raspberry Pi**:
   Connect the MFRC522 to your Raspberry Pi as follows:
   - SDA (SS) -> GPIO 24
   - SCK -> GPIO 23
   - MOSI -> GPIO 19
   - MISO -> GPIO 21
   - IRQ -> Not used
   - GND -> Ground (Pin 6)
   - RST -> GPIO 22
   - VCC -> 3.3V (Pin 1)

3. **Enable SPI Interface**:
   Use `raspi-config` to enable the SPI interface and reboot your Raspberry Pi.

### Python Script to Read RFID Tags

Here’s a simple Python script to continuously read RFID tags:

```python
#!/usr/bin/env python

import RPi.GPIO as GPIO
from mfrc522 import SimpleMFRC522
import time

reader = SimpleMFRC522()

try:
    print("Hold a tag near the reader...")
    while True:
        id, text = reader.read()
        print("ID: %s\nText: %s" % (id, text))
        time.sleep(1)  # Wait for a second before reading again

except KeyboardInterrupt:
    print("Program terminated.")
finally:
    GPIO.cleanup()
```

### Explanation of the Script

- **Imports**: The script imports necessary libraries for GPIO control and RFID reading.
- **Reader Initialization**: An instance of `SimpleMFRC522` is created to handle RFID operations.
- **Infinite Loop**: The script enters a loop where it waits for an RFID tag to be placed near the reader. When a tag is detected, it reads the ID and any associated text.
- **Error Handling**: The `try` block allows graceful handling of keyboard interrupts (Ctrl+C), ensuring that GPIO pins are cleaned up properly on exit.

### Running the Script

1. Save the script in a file named `Read.py`.
2. Make it executable:

   ```bash
   chmod +x Read.py
   ```

3. Run the script:

   ```bash
   python3 Read.py
   ```

Place an RFID tag near the reader, and you should see its ID and any stored text printed in the terminal.

This setup allows for continuous reading of RFID tags without needing to restart the script each time, making it suitable for applications that require real-time RFID detection.

Citations:
[1] https://pimylifeup.com/raspberry-pi-rfid-rc522/
[2] https://github.com/pimylifeup/MFRC522-python
[3] https://github.com/ondryaso/pi-rc522
[4] https://forums.raspberrypi.com/viewtopic.php?t=341724
[5] https://www.instructables.com/RFID-RC522-Raspberry-Pi/
[6] https://stackoverflow.com/questions/50912880/rfid-rc522-tag-is-not-read
[7] https://www.youtube.com/watch?v=HzZdrzQXp-k
[8] https://pypi.org/project/mfrc522-python/