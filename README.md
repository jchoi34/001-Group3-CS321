# Install Git
Refer the following site for instructions on how to setup Git on your system<br />
https://git-scm.com/book/en/v2/Getting-Started-Installing-Git 

# Instructions For GitHub

1. Clone the repository to your local hard drive<br />
    `git clone https://github.com/jchoi34/001-Group7-CS321.git`
2. Checkout the tag to be graded<br />
   `git checkout tags/Assignment5Submission`
3. Move into src folder located inside the repository<br />
   `cd 001-Group7-CS321/src/`
4. Compile the java files<br />
   `javac *.java`
5. Run the program<br />
   `java HRS [fileName]`
   Example:
   `java HRS sample1.txt`<br />
6. View Output<br />
   `cat HRS_fileName.txt`

# Instructions For ZIP File

1. Move into code folder located inside the zip file
   `cd code`
2. Compile the java files<br />
   `javac *.java`
3. Run the program<br />
   `java HRS [fileName]`
   Example:
   `java HRS sample1.txt`<br />
4. View Output<br />
   `cat HRS_fileName.txt`

# Instructions For Tests

1. Clone the repository to your local hard drive<br />
    `git clone https://github.com/jchoi34/001-Group7-CS321.git`
2. Move into tests folder<br />
   `cd tests`
3. Compile<br />
   `javac -cp .:junit-cs321.jar *.java`
4. Run ManagerReport Tests<br />
   `java -cp .:junit-cs321.jar ManagerReportTest`
5. Run Bad Location Test<br />
   `java -cp .:junit-cs321.jar BadLocation`
6. Run Banking System Test<br />
   `java -cp .:junit-cs321.jar BankingSystemTests`
7. Run Check-In Test<br />
   `cd  CheckInTest`<br />
   `javac *.java`<br />
   `java java HRS_CheckInTesting_Unit`
