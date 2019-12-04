//The Wold of Objects
//==============================================================================
// What is OOP (Object Oriented Programming)

/*
An object in OOP is a concept that help us organize better the way we interact
with variables,it is a complex datatype that can also perform actions, an object
have FIELDS and METHODS. For example, a pokemon object could have:
FIELDS:
  Name: Pikachu
  Type: Electric
  Health: 70
METHODS:
  attack()
  dodge()
  evolve()
*/
//==============================================================================
/*
FIELDS

The fields of an object are all the data variables that make up that object.
They are also sometimes referred to as ATTRIBUTES or MEMBER VARIABLES.
These fields are usually made up of primitive types like integers or characters,
but they can also be objects themselves. For example a book object may contain
fields like title, author and numberOfPages. Then a library object may contain a
field named books that will store all book objects in an array.

Accessing fields:

Accessing a field in an object is done using the dot modifier ‘.’
For example, if we had an object called book that contains these fields:
*/
String title;
String author;
int numberOfPages;
/*
To access the title field you would use
*/
book.title
/*
This expression is just like any other string, which means you can either store
it in a string variable:
*/
String myBookTitle = book.title;
/*
Or use it directly as a string itself and perform operations like printing it:
*/
System.out.println(book.title);
/*
Setting Fields

You can also change a field’s value. Say you want to set the number of pages
in a book to 234 pages:
*/
book.numOfPages = 234;


//==============================================================================
/*
METHODS
You might have also noticed that running actions in objects look very much like
calling a function. That’s because that’s exactly what it is. Methods in Java
are functions that belong to a particular object. When we get to creating our
own object types later in this lesson we will be creating methods the same way
we used to created functions.

Calling a method
To use a method you call it (just like calling a function). This is also done
using the dot modifier "."
Methods, just like any function can also take in arguments. For Example: Assume
that our book object has a method called setBookmark that takes the page number
as a parameter:
*/
void setBookmark(int pageNum);
/*
If you wanted to set a bookmark at page 12, you can call the method and pass in
the page number as an argument:
*/
book.setBookmark(12);
/*
Summary

Fields and Methods together are what make an object useful, fields store the
object's data while methods perform actions to use or modify those data.

However some objects might have no fields and are just made up of a bunch of
methods that perform various actions.

Other objects might only have fields that act as a way to organize storing data
but not include any methods!
*/

//==============================================================================
/*
A CLASS is the blueprint that defines what the object should look like, an
object on the other hand is the actual entity that is created from that class.
In other words a CLASS is where you would list all the FIELDS and implement all
the METHODS when defining what that object type should look like. Example:
*/
class Pokemon {
  String name;
  String type;
  int health;

  boolean dodge {
    return Math.random() > 0.5;
  }
  void attack(Pokemon enemy){
    if(!enemy.dodge(){
      enemy.health--;
    }
  }
}
/*
Classes and Objects are two different terms and should not be used
interchangeably, they can sometimes seem like they both refer to the same
thing but each has a different meaning.

Here's a comparison that illustrates when to use which:

_____________________Class__________________________Object____________
What:		             A Data Type	                  A Variable
Where:		           Has its own file	              Scattered around the project
Why:		             Defines the structure	        Used to implement to logic
Naming convention:	 CamelCase                      camelCase
                     (starts with an upper case)	  (starts with a lower case)
Examples:		         Country	                      australia
                     Book	                          lordOfTheRings
                     Pokemon	                      pikachu

In summary, "objects" are to "Classes" what "variables" are to "Data types".

Strings
You've probably already noticed that (unlike all primitive types) Strings start
with an upper case 'S'! That's because a String is in fact a class and not a
primitive type

A String variable is made up of an array of characters (char []) as its field,
but being an object means that it also offers some powerful methods like
length() that counts and returns the number of characters in that array, and
equals(String s) that compares the characters in this string with another
string.

Everything is an object in Java
Because Java is an OOP language, it includes classes that simply wrap around
all the primitive types themselves to offer some extra functionality through
their methods:

Class	           Primitive type
Integer	         int
Long	           long
Double	         double
Character	       char
String	         char[]
Each of those classes is made up of the corresponding primitive type as its
field, but usually also comes with some powerful methods.

It also allows you to forget about primitive types and treat everything in Java
as an object. However, it is still recommended to use primitive types when
writing a simple piece of code.
*/
//==============================================================================
/*
THE MAIN METHOD
A Java program can be as small as a single class, but usually a single program
will be made up of tens or even hundreds of classes!

A good Java program is one that divides the logic appropriately so that each
class ends up containing everything related to that class, and nothing more!

Classes would be calling each other's methods and updating their fields to make
up the logic of the entire program all together!

BUT, where should the program start from exactly? In other words, if a method
can call another method and that method can call another, which method will
start this sequence the very first time?

The answer is the main method! It looks like this:
*/

public static void main(String [] args){
   // Start my program here
}
/*
Let's break it down:

public: Means you can run this method from anywhere in your Java program (we
        will talk more about public and private methods later)
static: Means it doesn't need an object to run, which is why the computer
        starts with this method before even creating any objects (we will also
        talk more about static methods later on)
void:   Means the main method doesn't return anything, it just runs when the
        program starts, and once it's done the program terminates
main:   Is the name of the method
String [] args : Is the input parameter (array of strings) which we will cover
                  how to use it later in this lesson as well!

This main method is the starting point for any Java program, when a computer
runs a Java program, it looks for that main method and runs it.

Inside it you can create objects and call methods to run other parts of your
code. And then when the main method ends the program terminates.

If this main method doesn't exist, or if there's more than one, the Java program
won't be able to run at all!

The main method can belong to any class, or you can create a specific class just
for that main method which is what most people do.

Let's have a look at an example next.
*/
public static void main(String [] args){
}

//==============================================================================
/*
CONSTRUCTORS
Constructors are special types of methods that are responsible for creating and
initializing an object of that class.

Creating a constructor
Creating a constructor is very much like creating a method, except that:

1.Constructors don't have any return types
2.Constructors have the same name as the class itself

They can however take input parameters like a normal method, and you are allowed
to create multiple constructors with different input parameters.

Here's an example of a simple constructor for a class called Game */

class Game{
   ...
   // Constructor
   Game(){
      // Initialization code goes here
   }
   ...
}
/*
Default constructor
A Default constructor is one that doesn't take any input parameters at all!

It's optional, which means if you don't create a default constructor, Java will
automatically assume there's one by default that doesn't really do anything.

However, if the class has fields that need to be initialized before the object
can be used, then you should create one that does so.

For example, assume we have a class Game that has an integer member field score,
we'd like to make sure that any object of type Game will start with the score
value set to 0. To do so, we need to create a default constructor that will
initialize the mScore field */

class Game{
   int mScore;
   // Default constructor
   Game(){
      // Initialize the score here
      mScore = 0;
   }
}
/*
Parameterized constructor
As we've mentioned earlier, a constructor can also take input parameters.

Let's assume that some games start with a positive score value and not just 0,
that means we need another constructor that takes an integer parameter as an
input, and uses that to initialize the score variable. */

class Game{
   int score;
   // Default constructor
   Game(){
      score = 0;
   }
   // Constructor by starting score value
   Game(int startingScore){
      score = startingScore;
   }
}
/*
ACCESSING A CONSTRUCTOR (NEW & NULL)
Unlike normal methods, constructors cannot be called using the dot . modifier,
instead, every time you create an object variable of a class type the
appropriate constructor is called. Let's see how:

The (NEW) keyword
To create an object of a certain class, you will need to use the new keyword
followed by the constructor you want to use, for example:
*/
Game tetris = new Game();
/*
This will create an object called tetris using the default constructor (i.e.
tetris will have an initial score value of 0)

To create a game that is initialized with a different starting score you can use
the second constructor:
*/
Game darts = new Game(501);
/*
The (NULL) keyword
If you do not initialize an object using the new keyword then its value will be
set to something called null. null simply refers to an empty (uninitialized)
object. null objects have no fields or methods, and if you try to access a null
object's field or call its method you will get a runtime error.

In some cases, you might want to explicitly set an object to null to indicate
that such object is invalid or yet to be set. You can do so using the assignment
operation:
*/
Game darts = null;
/*
Why multiple constructors?
You might be wondering why do we still need to keep the default constructor
now that we have another constructor that can create a game object with any
starting score value (including 0)?

Good point, however, it's considered a good practice to always include a
default constructor that initializes all the fields with values that correspond
to typical scenarios. Then you can add extra parameterized constructors that
allow for more customization when dealing with less common cases.

But you said the default constructor is optional!
As we've mentioned earlier, you have the option to not create any constructors
at all! The class will still be valid and you will be able to create objects
using the same syntax of a default constructor. Exactly as if you had created
an empty default constructor.

However, this privilege goes away once you create any constructor of your own!
Which means if you create a parameterized constructor and want to also have a
default constructor, you will have to create that default constructor yourself
as well.

doubt: how to create a default constructor for an String type attribute?
*/
//==============================================================================
/*
Self Reference (THIS)
Sometimes you'll need to refer to an object within one of its methods or
constructors, to do so you can use the keyword "this".

"this" is a reference to the current object — the object whose method or
constructor is being called. You can refer to any field of the current object
from within a method or a constructor by using "this".

Using this with a Field
The most common reason for using the this keyword is because a field has the
same name as a parameter in the method or constructor

For example, if a Position class was written like this */

class Position {
   int row = 0;
   int column = 0;

    //constructor
   Position(int r, int c) {
      row = r;
      column = c;
   }
}
/*
A more readable way would be to use the same names (row & column) for the
constructor parameters which means you will have to use the this keyword to
seperate between the fields and the parameters: */

class Position {
   int row = 0;
   int column = 0;

    //constructor
   Position(int row, int column) {
      this.row = row; //this.row is the same as row (from the Field)
      this.column = column;
   }
}
/*
In the second snippet, the constructor Position accepts the parameters row and
column, but the class Position also includes two fields with the exact same
name.

Using this.row compared to row means that we are referring to the field named
row rather than the input parameter.

There are plenty more uses for the keyword this that you can check out here,
but they are slightly outside the scope of this course.
see more on: https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html
*/

//==============================================================================
/*
EXAMPLE: THE CONTACTS MANAGER
Assume you're writing a Java program that's responsible for storing and managing
all your friends' contact information.

We'll start by creating a class that's responsible for storing all contact
information of a single person, it will look something like this:
*/
class Contact{
   String name;
   String email;
   String phoneNumber;
}
/*
All fields, no methods, since a contact object itself won't be "doing" much
actions itself in the scope of this program, it's merely a slightly more
advanced data type that can store a few strings in 1 variable.

Note: Noticed how we used a String to store the phone number instead of using
int! Can you think of a reason why?

ANSWER:
  1.Because phone numbers start with 0's and integers can't store leading 0's
  2.Because the largest integer is smaller than a typical phone number
*/

/*
Next, let's create the class that will be in charge of adding and searching for
contacts. Since it will be managing all the contacts, I'll call it
ContactsManager:
*/
class ContactsManager {
}
/*
This class will be storing the contacts in an array, which means one of its
fields will be an array of Contacts, another field will be an int representing
the number of friends added to the array, this int will help us know where in
the array was the last contact added so we can continue to add more contacts
into the array later as we will see.

This is what the class will look like after adding the fields
*/
class ContactsManager {
   // Fields:
   Contact [] myFriends;
   int friendsCount;
}
/*
Okay, now let's create a default constructor that will initialize those fields.
*/
class ContactsManager {
   // Fields:
   Contact [] myFriends;
   int friendsCount;
   // Constructor:
   ContactsManager(){
      this.friendsCount = 0;
      this.myFriends = new Contact[500];
   }
}
/*
The friendsCount starts from 0 and will increment every time we add a new
contact later.

The Contact array myFriends (just like any array) needs to be initialized using
the new keyword and we chose to reserve enough space in the array to store up to
500 contacts.

Next, let's start adding methods to the ContactsManager class that allows adding
and searching for contacts in the array
*/


/*
ADDING METHODS
The ContactsManager class methods
The first method we will create in the ContactsManager class is the addContact
method which will add a Contact object to the Contact array myFriends:
*/
   void addContact(Contact contact){
      myFriends[friendsCount] = contact;
      friendsCount++;
   }
/*
The method addContact takes a Contact object as an input parameter, and uses the
friendsCount value to fill that slot in the array with the contact that was
passed into the method.

Then, since we need to move that counter to point to the following slot in the
array, we increment friendsCount using the increment operation ++

Now, let's add another method called searchContact that will search through the
array using a name String and return a Contact object once a match is found:
*/
Contact searchContact(String searchName){
   for(int i=0; i<friendsCount; i++){
      if(myFriends[i].name.equals(searchName)){
         return myFriends[i];
      }
   }
   return null;
}
/*
This method loops over the array, and for each element myFriends[i] it compares
the name field to the searchName value using this if statment:
*/
if(myFriends[i].name.equals(searchName))
/*
This if statement will evaluate to true if the searchName is equal to the name
field in the Contact stored in myFriends[i]

If it was a match, the loop will return the matching Contact object
myFriends[i]. Otherwise. it will return null indicating that it could not find
that contact.

Putting all this together, our ContactsManager class will look like this:
*/
class ContactsManager {
   // Fields:
   Contact [] myFriends;
   int friendsCount;

   // Constructor:
   ContactsManager(){
      friendsCount = 0;
      myFriends = new Contact[500];
   }

   // Methods:
   void addContact(Contact contact){
      myFriends[friendsCount] = contact;
      friendsCount++;
   }

   Contact searchContact(String searchName){
      for(int i=0; i<friendsCount; i++){
         if(myFriends[i].name.equals(searchName)){
            return myFriends[i];
         }
      }
      return null;
   }
}
/*
To be able to run this program, we need the main method, so let's create another
class called Main that will hold this method:
*/
class Main {
   public static void main(String [] args){
      ContactManager myContactManager = new ContactManager();
   }
}
/*
This means that once this program runs, the main method will start which will
create the ContactManager object myContactManager and thus ready to be used.

However, if you go ahead and run this program nothing will appear because we we
haven't created the logic to ask the user for adding or searching contacts yet.

Later on in this course, we will see how to read input from the user to make
this program more powerful.
*/
//==============================================================================
/*
Programming Quiz
Now it's your turn, go ahead and create the ContactsManager program on your
computer, then in the main method write the following:

1.Create a ContactsManager object called myContactsManager using the default
  constructor (we've already done so in the previous page)
2.Create a new Contact variable
  * Set the name to a friend's name
  * Set the phoneNumber field to their phone number
3.Call the addContact method in myContactsManager to add that contact
4.Repeat steps 2 and 3 for 4 more contacts
5.Search for a contact using the method searchContact and print out their phone
  number
*/

// My Solution:
ContactsManager myContactsManager = new ContactsManager()
Contact person = new Contact();/* May be wrong to create just one Contact
because the variable String would be imposible to change later*/
person.name = "Vale";
person.phoneNumber = "23412341234";
addContact(person);
person.name = "Vale2";
person.phoneNumber = "23412353532";
addContact(person);
person.name = "Vale3";
person.phoneNumber = "436234523452";
addContact(person);
person.name = "Vale4";
person.phoneNumber = "3456574568334";
addContact(person);

// Other solution
public static void main(String [] args){
   // Create the ContactsManager object
   ContactsManager myContactsManager = new ContactsManager();
   // Create a new Contact object for James
   Contact friendJames = new Contact();
   // Set the fields
   friendJames.name = "James";
   friendJames.phoneNumber = "0012223333";
   // Add James Contact to the ContactsManager
   myContactsManager.addContact(friendJames);
   // Create a new Contact object for Cezanne
   Contact friendCezanne = new Contact();
   // Set the fields
   friendCezanne.name = "Cezanne";
   friendCezanne.phoneNumber = "987654321";
   // Add Cezanne Contact to the ContactsManager
   myContactsManager.addContact(friendCezanne);
   // Create a new Contact object for Jessica
   Contact friendJessica = new Contact();
   // Set the fields
   friendJessica.name = "Jessica";
   friendJessica.phoneNumber = "5554440001";
   // Add Jessica Contact to the ContactsManager
   myContactsManager.addContact(friendJessica);

   // Now let's try to search of a contact and display their phone number
   Contact result = myContactsManager.searchContact("Jessica");
   System.out.println(result.phoneNumber);

}

//==============================================================================
/*FIELDS (public vs private)

To label a field as private or public simply add the modifier just before the
field type when declaring it:
*/
public int score;
private String password;
/*
You always have the final call on which fields you'd want to make public vs
private, and it always depends on the purpose of the field as well as the
overall design of your code.

However, it's strongly recommended in Java to label ALL fields as private:

For example , when defining a Book class, instead of saying:
*/
class Book{
   String title;
   String author;
}
/*
A proper way would be to define everything private, and only initialize them in
the construtor.
*/
class Book{
   private String title;
   private String author;
   public Book(String title, String author){
      this.title = title;
      this.author = author;
   }
}
/*
This way you can guarantee that once a book object has been created, the title
and author will never change!

But sometimes you need to have fields that can be modified by other classes.

For example, if we wanted to keep track of whether a Book is being borrowed or
not, you can add a public boolean field to do so:
*/
public class Book{
   private String title;
   private String author;
   public boolean isBorrowed;
   public Book(String title, String author){
      this.title = title;
      this.author = author;
   }
}
/*
This will work, since you will be able to do something like this from anywhere
in your project:
*/
book.isBorrowed = true;
/*
However, it's still slightly risky, and you could end up mistakingly setting
the boolean to true when you only meant to check if it was true or false!

A better design would be to declare that field as private and then create
public methods that return the value of such hidden field (known as getters)
as well as public methods that provide a way to set or change its value (known
as setters)
*/
public class Book{
   private String title;
   private String author;
   private boolean isBorrowed;
   public Book(String title, String author){
      this.title = title;
      this.author = author;
   }
   public void borrowBook(){
      isBorrowed = true;
   }
   public void returnBook(){
      isBorrowed = false;
   }
   public boolean isBookBorrowed(){
      return isBorrowed;
   }
}
/*
Setting the isBorrowed field as private will prevent you from mistakenly
changing its value somewhere in the code, because the only way to change it now
is to call either borrowBook() or returnBook() which is much more explicit.

And to be able to read the value of isBorrowed, we've created a getter method
called isBookBorrowed() that is public and simply returns the value of
isBorrowed

Summary
  *Always try to declare all fields as private
  *Create a constructor that accepts those private fields as inputs
  *Create a public method that sets each private field, this way you will know
   when you are changing a field. These methods are called setters
  *Create a public method that returns each private field, so you can read the
   value without mistakingly changing it. These methods are called getters
*/

//==============================================================================
/*
METHODS (public vs private)

With methods, it's common to have a mix of private and public methods.

The private methods are usually known as helper methods, since they can only be
seen and called by the same class, they are usually there to organize your code
and keep it simple and more readable.

The public methods are the actual actions that the class can perform and are
pretty much what the rest of the program can see and call.

Here's an example of when you'd want to use public methods vs private methods
*/

class Person{
   private String userName;
   private String SSN;
   private String getId(){
      return SSN + "-" + userName;
   }
   public String getUserName(){
      return userName;
   }
   public boolean isSamePerson(Person p){
      if(p.getId().equals(this.getId()){
         return true;
      }
      else{
         return false;
      }
   }
}
/*
The class Person has both its fields set to private because if they were public
then any other class will be able to change such sensitive information. Setting
them to private means that only methods and constructors inside this class can
do so!

The method getId() was also set to private so that no other class can know the
social security number of any person.

However, we were still able to use that method internally when comparing this
person with another person object in the isSamePerson(Person p) method.

This means that any other class can only call getUserName or isSamePerson and
will seem as if these are the only 2 methods provided by the class Person

Public classes
Even classes can be labeled as public or private! And even though you are
allowed to label a class as private, it requires you to know about nested
classes which is not covered in this course.
  *see more of "nested classes":
*/
   https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
/*
So for now, make sure you label all your classes public.

What if I don't use any label at all?
We've been doing that so far anyway! What does that mean?

It's not recommended to do so, but if you do, it will default to something
called "package public" which means it's as if you've labeled them public but
only to the classes that are in the same package/folder. We will learn more
about packages later. But again, it's always a good idea to label everything
explicitly.

But but but
... wait a second! Since I have access to all the code, can't I just go back and
change all the private methods and fields and make everything public and control
the universe!

Yes, but remember that this is for your own good. You're trying to design your
code in a way that will prevent you from doing things you don't want to happen!
You're also most likely going to be working with a team of other developers, and
setting the correct access modifiers helps communicate with everyone the
intended use of each part of your project.

Summary
To summarize, it's recommended to:

  *Set all your classes to public
  *Set all your fields to private
  *Set any of your methods to public that are considered actions
  *Set any of your methods to private that are considered helper methods

  Quiz:
  Select the scenarios where you should define the methods to be private


  Sol:
  1. A helper method in the Shape class that calculates the distance between 2
     points
  2. A method that should only be used by another method in this class
*/
