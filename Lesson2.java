//USER INTERACTION
//==============================================================================
/*
INPUT SCANNER
The most flexible and common way to read an input from a user is by asking them
to type in something and wait till they respond.

Just like we've seen how this command will print "Hello World" to the command
line as an output:
*/
System.out.println("Hello World!");
/*
You can also ask the user to type in a message and then your Java program can
read it into a variable and use it.

This is done using a Java class called Scanner.

First, to be able to access this class, you have to point your program to the
java.util library that includes the Scanner class. You do that by typing this at
the very top of the file
*/
import java.util.Scanner;
/*
We will talk more about including packages and libraries later on in this
course.

A Scanner allows the program to read any data type from a particular input, if
we create the scanner object like this:
*/
Scanner scanner = new Scanner(System.in);
/*
Then the scanner will be reading from the System's input (hence System.in) which
is basically the command line.

It will continue to read whatever the user is typing until they hit "enter" then
the program continues to execute.

Once the scanner object has been created, you can use it to read a String, an
integer or an entire line.

Calling the method nextLine() in that scanner object will return a String that
contains everything the user has typed in before they hit "enter".
*/
scanner.nextLine();

//For example:

System.out.println("Enter your address: ");
Scanner scanner = new Scanner(System.in);
String address = scanner.nextLine();
System.out.println("You live at: " + address);
/*
The above code will wait until the user types in their address, then stores it
into the variable address and then prints it back to the user.

Go ahead and try it out yourself! You should get an output that looks like this:
*/
/Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/bin/java ...
Enter your address:
2465 Latham St, Mountain View
You live at: 2465 Latham St, Mountain View

Process finished with exit code 0
/*
If you want to read a number into an integer variable instead of the entire
line:
*/
System.out.println("Enter your grade: ");
Scanner scanner = new Scanner(System.in);
int grade = scanner.nextInt();
if(grade > 90){
   System.out.println("Wow! you did well!");
}else{
   System.out.println("Not bad, but you can do better next time!");
}

//==============================================================================
// FILE SCANNER
/*
Another way of accepting runtime input is through files, these files can be
plain text files that the user creates with a very basic text editor (e.g.
notepad on windows or TextEdit on macs).

A good example would be a Java program that loads a list of expenses from a text
file (or excel sheet) and after some calculations prints a report of the total
amount, average spendings, largest purchase etc.

To read a text file in Java you can also use the same Scanner class we used to
read command line inputs, but instead of passing System.in as the argument you
pass a File object which you can create by typing in the file name:
*/
File file = new File("expenses.txt");
Scanner fileScanner = new Scanner(file);
/*
Once the file scanner has been created, you read lines the same way we did
earlier.

But since you would most likely want to load the entire file at once, you can
check if the file still has more lines using hasNextLine method and then use
this loop to read everything:
*/
while (input.hasNextLine()) {
   String line = input.nextLine();
   // Use that line to do any calculations, processing, etc ..
}

//==============================================================================
// Exercise: File Scanner
/*
Start a project that does the following things:
  * Use the File Scanner to read the contents of any large file
  * Create a loop that reads every line into a string
  * Split the string using the space character as a delimiter
  * Count the number of words in that line using the length of the split array
  * Add up all the words in every line read from the file
  * Display the total word count
*/
import java.io.File; // So you can use the class File
import java.util.Scanner; // So you can read the file

public class WordCount{
  public static void main(String [] args){
    File bookFile = new File("MobyDick.txt"); // Create an object bookfile
    Scanner newScanner = new Scanner(bookFile);// Create an object newScanner

    int words = 0;
    while(newScanner.hasNextLine()){ // If there is a next line you keep reading
      String line = newScanner.nextLine(); // Capture the new line in a string
      words += line.split(" ").length; // Split the line and count the words on
                                       // it
    }// End while
    // Print the results
    System.out.println("There are: " + words + " words in this book.");
  }
}

//==============================================================================
/*
RUNNING A PROGRAM IN INTELLIJ
Running a program via the command line (Windows)
It's pretty much the same steps as above, however you might need to make sure
that Windows can find the Java compiler and interpreter:

Select Start -> Computer -> System Properties -> Advanced system settings ->
Environment Variables -> System variables -> PATH.
Find out which jdk version you have installed by navigating to C:\Program Files\
Java and check which folders are there.
Add C:\Program Files\Java\jdk???\bin; to the beginning of the PATH variable.
Replace the ??? with the folder name from step 2
*/

//==============================================================================
/*
COMMAND LINE ARGUMENTS
There's one more way a Java program can accept input from the user, and that is
before they actually run the program!

Remember the declaration of the main method:
*/
public static void main(String args[]){
}
/*
Notice that the method accepts a String array called args[] as an input
parameter, but we never explicitly call the main method ourselves! So what is
this String array and where does its value ever come from?

If you end up running the program from the command line, anything you type
after the program name is considered an input argument.

For example, if we had a Java program called weather that prints today's
weather, running it from the command line is as simple as typing in the program
name:
*/
>> Java Weather
Please specify a location
/*
If we wanted the program to be more customizable, we could set it up to accept
a city input and print the weather there. So to get the weather in Sydney you
can type:
*/
>>Java Weather
Please specify a location
>> Java Weather Sydney
The weather in Sydney is 68 degrees.
>>
/*
The way this works is through the String [] args that's passed to the main
method, which means inside the main method, the first String in that String
array args contains the value "Sydney". */

public static void main(String [] args){
   if(args.length==0) {
      System.out.println("Please specify a location");
   }
   else {
      String location = args[0];
      int temperature = 60 + (int)(Math.random()*10);
      System.out.println("The weather in "+location+" is "+ temperature);
   }
}
/*
You can loop through the args array and collect as many arguments as you want.

Feel free to read more information on how to read and use the command line
arguments, se more on;
https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html

Now it's time to try all of these input types in our project
*/

/*
RUNTIME ERRORS
Only happens occasionally, and while the program is running and is caused by the
user entering an invalid input or trying to open a file that doesn't exist.
A good Java program should check that any operation is valid before it tries to
do it, like check that the file actually exist before opening it.
*/
File file = new File("test.txt");
if(file.exists()){
  Scanner fileScanner = new Scanner(file);
}
/*
EXCEPTIONS
In java the most common runtime errors are formalized into something called
EXCEPTIONS. An exception is almost like a formal definition of a potential
problem.For example FileNotFoundException (appears everytime you try to open a
file that doesn't exist).
When a method tries to do perform an operation that is invalid it creates an
exception object.
Methods communicate exceptions with each other by throwing exeptions, this is
done by adding the throws methods, example:
*/
public void openFile(String fileName) throws FileNotFoundException{

}
/*
Once you have declared that a method throws an exception, java forces you to
surround that method with a try clause everytime you try to call it. This simply
means that you are aware that this method might trow an exception at any time.
To handle that exception, you will also need to follow it with a catch block.
Whenever that exception is thrown, the code would jump right into that catch
block and run whatever's inside it. Most exceptions are already built in Java
libraries like the file class that were used earlier. So, usually, all you have
to do is just surround those methods with a try catch block, and handle the
exception anyway you want. The most common way to handle an exception is to
print a message to the user, explaining what went wrong and ask them to maybe
try again or check their setup.
*/
try{
 File file = new File("somefile.txt");
} catch (FileNotFoundException e) {
  System.out.println("File missing!");
}

/*
You may also chose to re-trow that exception or even not surround it with a try
catch at all, and instead declare that this method itself throws an exception.
*/
// Re-trow that exception
try {
  File file = new File("somefile.txt");
} catch(FileNotFoundException e){
  throw e;
}
// Not surround it with a try catch at all
void openFile() throws Exception {
  File file = new File("somefile.txt");
}
/*
You can actually continue to do so all the way up to the main method and declare
the main method to declare an exception itself.
*/
void main(String [] args) throws Exception {
  operFile();
}
void openFile() throws Exception {
  File file = new File("somefile.txt");
}
/*
However, that will mean that if such exception does get thrown, it will end up
all the way back to the user causing the program to end with an unhandled
exception method, not the most user friendly experience I bet. So it is always
a good idea to handle any possible exception somewhere inside your code.
*/
try {
  File file = new File("somefile.txt");
} catch(FileNotFoundException e){
  throw e;
}

//==============================================================================
/*
CATCHING EXCEPTIONS
Inside the catch block you have the choice of either handling the situation
quietly (like printing an error message or showing a warning popup)
*/
try{
   openFile("somefile.txt");
} catch(FileNotFoundException exception) {
   // Handle the situation by letting the user know what happened
   System.out.println("Cannot find that file");
}
OR you can elude the situation and just re-throw the exception:

try{
   openFile("somefile.txt");
} catch(FileNotFoundException exception) {
   // Running away from the responsibility
   throw exception;
}
/*
However, re-throwing the exceptions means that whoever is calling "this" method
will now have to surround it with another try-catch block and do the same!

MULTIPLE CATCH STATEMENTS
Since a try block can include more than one statement, and methods can actually
throw more than one type of exceptions, you sometimes end up having to cater for
different types of exceptions at the same time:
*/
try{
   openFile("somefile.txt");
   array[index]++;
} catch(FileNotFoundException exception) {
   // Handle all the possible file-not-found-related issues here
} catch(IndexOutOfBoundsException exception) {
   // Handle all the possible index-out-of-bounds-related issues here
}
/*
You can have as many catch statements as you need until you cover all possible
Exception types that could be thrown inside the try statement.

Catching all exceptions
Another option is to simply catch ALL exception types by catching the general
type Exception, this means that whatever exception is thrown within this
try-catch block, it will be caught and handled in this catch statement
*/
try{
   openFile("somefile.txt");
   array[index]++;
} catch(Exception exception) {
   // Handle all the possible exceptions here
}

//==============================================================================
/*
QUIZ: Exceptions
This code was meant to ask the user for a month number and print out the month's
short name that corresponds to that number!

Read the code carefully and then try to answer the questions below.
*/

public static void main(String[] args) {
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                       "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    Scanner scanner = new Scanner(System.in);
    try {
        int month = scanner.nextInt();
        System.out.print(months[month]);
    } catch (IndexOutOfBoundsException exception) {
        System.out.print("Index is out of bounds");
    } catch (InputMismatchException exception) {
        System.out.print("Input mismatch");
    }
}

/*
  Q1: What will be  the output if the user enters 3:
  Ans: "Apr"
  Q2: What will be the output if the user enters 99:
  Ans: Index is out of bonds, because the index is bigger than the matrix
  Q3: What will be the output if the user enters aaa:
  Ans: "Input mismatch"
*/
