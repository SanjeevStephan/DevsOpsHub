## Java Execution in Jupyter Lab

Jupyter Lab can be configured to execute Java code using a specialized kernel. This setup allows you to leverage Jupyter's interactive environment for Java programming. Below are the steps to enable Java execution in Jupyter Lab.

### Step 1: Install Java

Ensure that the Java Development Kit (JDK) (version 9 or higher) is installed on your system. Verify the installation by running:

```
    java -version
```

```java
java version "24.0.1" 2025-04-15
Java(TM) SE Runtime Environment (build 24.0.1+9-30)
Java HotSpot(TM) 64-Bit Server VM (build 24.0.1+9-30, mixed mode, sharing)
```

Ensure the output shows the correct version and includes `jdk.jshell`.


### Step 2:  Install Python

```python
winget search python3
```

```python
winget install --id Python.Python.3.9 --source winget
```

### Step 2: Install Python Virtual Environment

```python
python -m venv venv           ## install the virtual environment
./venv/Scripts/activate.ps1   ## activate the virtual envirionment
```

### Step 3: Install Jupyter Lab

If Jupyter Lab is not already installed, use Python's package manager to install it:

```python
    pip install jupyterlab
```
### Step 3: Install the IJava Kernel

The IJava kernel enables Java execution in Jupyter. Follow these steps:

- Download the latest release of IJava from its [GitHub repository](https://github.com/SpencerPark/IJava).

- Extract the downloaded .zip file, which contains `install.py` and a java folder.

- Run the installer using Python:

```python
python3 install.py --sys-prefix
```

OR 


```python
(venv) ┌──(SUPERUSER㉿192.168.56.1)-[Z:\jupyterNotebooks\java-for-jupyter-lab\ijava-1.3.0]
└─$ PS>python .\install.py --sys-prefix
Z:\jupyterNotebooks\java-for-jupyter-lab\ijava-1.3.0\install.py:164: DeprecationWarning: replace is ignored. Installing a kernelspec always replaces an existing installation
  install_dest = KernelSpecManager().install_kernel_spec(
Installed java-kernel into"Z:\jupyterNotebooks\venv\share\jupyter\kernels\java"
```

- Verify installation by listing available kernels:

```python
jupyter kernelspec list
```

You should be able to see the below output

```python
Execute this Command > jupyter kernelspec list
Available kernels:
  java       Z:\jupyterNotebooks\venv\share\jupyter\kernels\java
  python3    Z:\jupyterNotebooks\venv\share\jupyter\kernels\python3
```

### Step 4: Start Jupyter Lab

Launch Jupyter Lab with:

```python
    jupyter lab
```
In the interface, create a new notebook and select Java as the kernel.

Step 5: Write and Execute Java Code

You can now write Java code in cells and execute it interactively. For example:

```
    System.out.println("Hello, Jupyter Lab!");
```
Press Shift + Enter to run the cell.

Tips for Enhanced Usage

Use %classpath magic commands to add Maven dependencies dynamically:

%classpath add mvn org.apache.commons commons-math3 3.6.1
Visualize data using libraries like XChart or JavaFX.

Export notebooks as HTML, PDF, or Markdown for sharing.

By following these steps, you can seamlessly integrate Java programming into Jupyter Lab's interactive environmen