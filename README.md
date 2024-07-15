
### Instructions to Run the Program

This guide will walk you through the steps to compile and run the Java program with the required command-line arguments.

#### Prerequisites

- Ensure you have Java Development Kit (JDK) installed on your system.
- Ensure your CLASSPATH is set up correctly if your program depends on external libraries.

#### Compiling the Program

1. Save your Java source file (e.g., `Main2.java`).

2. Open your terminal or command prompt.

3. Navigate to the directory where your Java file is saved.

4. Compile the Java source file using the following command:
   ```sh
   javac Main2.java
   ```

#### Running the Program

To run the program, use the `java` command followed by the class name and the required command-line arguments. Below is the format for running the program:

```sh
java Main2 --input=<inputType> --inputSource=<inputSource> --operation=<operation> --output=<outputType> [--outputSource=<outputSource>] [--replaceFrom=<replaceFrom>] [--replaceTo=<replaceTo>]
```

#### Required Parameters

- `--input`: Specifies the input type.
- `--inputSource`: Specifies the source of the input.
- `--operation`: Specifies the operation to be performed.
- `--output`: Specifies the output type.

#### Optional Parameters

- `--outputSource`: Required if the `--output` type is `file`.
- `--replaceFrom` and `--replaceTo`: Required if the `--operation` is `replace`.

#### Example Commands

1. **Basic Command**:
   ```sh
   java Main2 --input=rss --inputSource=https://tech.uzabase.com/rss --operation=trim --output=print
   ```

2. **Command with Output to File**:
   ```sh
   java Main2 --input=rss --inputSource=https://tech.uzabase.com/rss --operation=trim --output=file --outputSource=/path/to/output/file.txt
   ```

3. **Command with Replace Operation**:
   ```sh
   java Main2 --input=text --inputSource=/path/to/input/file.txt --operation=replace --replaceFrom=oldText --replaceTo=newText --output=file --outputSource=/path/to/output/file.txt
   ```

#### Error Messages and Troubleshooting

- If any required parameters are missing, the program will display:
  ```
  Required parameters missing. --input, --inputSource, --output and --operation is mandatory
  ```

- If `--output=file` is specified without `--outputSource`, the program will display:
  ```
  outputSource is required with the output=file
  ```

- If `--operation=replace` is specified without `--replaceFrom` or `--replaceTo`, the program will display:
  ```
  replace is used with replaceTo and replaceFrom
  ```

- For any unknown arguments, the program will display:
  ```
  Unknown argument: <argument>
  ```

#### Running the Program with Full Example

Here is a full example of running the program with all arguments:

```sh
java Main2 --input=text --inputSource=https://example.com/input.txt --operation=replace --replaceFrom=oldText --replaceTo=newText --output=file --outputSource=/path/to/output/file.txt
```

This command specifies the input type as text from a URL, performs a replace operation, and outputs the result to a specified file.

By following these instructions, you should be able to compile and run your Java program with the appropriate command-line arguments.
