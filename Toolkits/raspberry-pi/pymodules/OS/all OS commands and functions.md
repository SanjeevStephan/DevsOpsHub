The **`os`** module in Python provides a way of using operating system-dependent functionality like reading or writing to the file system, managing directories, and interacting with the environment. Below are some important commands and functions provided by the `os` module.

### Key Functions in the `os` Module

1. **Getting Current Working Directory**
   - **`os.getcwd()`**: Returns the current working directory (CWD).
     ```python
     import os
     cwd = os.getcwd()
     print("Current working directory:", cwd)
     ```

2. **Changing the Current Working Directory**
   - **`os.chdir(path)`**: Changes the current working directory to the specified path.
     ```python
     os.chdir('/path/to/directory')
     ```

3. **Listing Files and Directories**
   - **`os.listdir(path)`**: Returns a list of the names of the entries in the directory given by `path`.
     ```python
     files = os.listdir('.')
     print("Files and directories:", files)
     ```

4. **Creating Directories**
   - **`os.mkdir(path)`**: Creates a new directory at the specified path.
   - **`os.makedirs(path)`**: Creates a directory recursively (creates intermediate directories if they don’t exist).
     ```python
     os.mkdir('new_directory')
     os.makedirs('parent_directory/child_directory')
     ```

5. **Removing Files and Directories**
   - **`os.remove(path)`**: Removes (deletes) the file at the specified path.
   - **`os.rmdir(path)`**: Removes (deletes) an empty directory.
   - **`os.removedirs(path)`**: Removes directories recursively.
     ```python
     os.remove('file.txt')
     os.rmdir('empty_directory')
     ```

6. **Renaming Files and Directories**
   - **`os.rename(src, dst)`**: Renames a file or directory from `src` to `dst`.
     ```python
     os.rename('old_name.txt', 'new_name.txt')
     ```

7. **Checking File or Directory Existence**
   - **`os.path.exists(path)`**: Returns `True` if the path exists, otherwise `False`.
   - **`os.path.isfile(path)`**: Returns `True` if the path is a file.
   - **`os.path.isdir(path)`**: Returns `True` if the path is a directory.
     ```python
     if os.path.exists('file.txt'):
         print("File exists.")
     ```

8. **Getting Environment Variables**
   - **`os.environ`**: A mapping object representing the string environment.
   - **`os.getenv(key)`**: Returns the value of the environment variable `key`.
     ```python
     home_dir = os.getenv('HOME')
     print("Home Directory:", home_dir)
     ```

9. **Executing Shell Commands**
   - **`os.system(command)`**: Executes the command (a string) in a subshell.
   - **`os.popen(command)`**: Opens a pipe to or from the command.
     ```python
     os.system('ls')  # List files in Linux/Unix
     ```

10. **Path Manipulation**
    - **`os.path.join(*paths)`**: Joins one or more path components intelligently.
    - **`os.path.abspath(path)`**: Returns an absolute path for a given path.
      ```python
      full_path = os.path.join('folder', 'file.txt')
      print("Full Path:", full_path)
      ```

### Example Usage

Here’s an example script demonstrating some of these functions:

```python
import os

# Get current working directory
print("Current Working Directory:", os.getcwd())

# Create a new directory
new_dir = 'test_directory'
if not os.path.exists(new_dir):
    os.mkdir(new_dir)
    print(f"Directory '{new_dir}' created.")

# List files in current directory
print("Files in current directory:", os.listdir('.'))

# Change working directory to new directory
os.chdir(new_dir)
print("Changed Working Directory to:", os.getcwd())

# Create a new file in the new directory
with open('example.txt', 'w') as f:
    f.write("Hello, World!")

# List files in new directory
print("Files in new directory:", os.listdir('.'))

# Clean up by removing created files and directories
os.remove('example.txt')
os.chdir('..')  # Go back to previous directory
os.rmdir(new_dir)  # Remove test_directory
print(f"Directory '{new_dir}' removed.")
```

### Conclusion

The `os` module is essential for performing various operating system-related tasks in Python, such as managing files and directories, manipulating paths, and interacting with environment variables. It provides a portable way to handle these functionalities across different operating systems. For more information, you can refer to the official [Python documentation for the `os` module](https://docs.python.org/3/library/os.html).

Citations:
[1] https://www.w3schools.com/python/module_os.asp
[2] https://www.javatpoint.com/python-os-module
[3] https://www.geeksforgeeks.org/working-zip-files-python/
[4] https://www.geeksforgeeks.org/os-module-python-examples/
[5] https://www.studytonight.com/python-howtos/how-to-unzip-file-in-python
[6] https://www.youtube.com/watch?v=kS0telASUxU
[7] https://docs.python.org/zh-cn/dev/library/os.html
[8] https://note.nkmk.me/en/python-zipfile/