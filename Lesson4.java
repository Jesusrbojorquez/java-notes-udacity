//INHERITANCE
/*
Java allows us to write efficient code by creating a class (PARENT) that have a
basic set of atributes and exted this basic set with the creation of another set
(CHILD) that have additional attributes, this allows us to reuse code and avoid
repeting code. Example:
*/
//PARENT
class BankAccount {
  String acctNumber;
  double balance;
}
//CHILD
class Checking extends BankAccount {
  double limit;
}
//CHILD
class Savings extends BankAccount {
  int transfers;
}
//CHILD
class COD extends BankAccount {
  Date expiry;
}

//==============================================================================
/*
POLYMORPHISM
We can declare an objects as a PARENT class and initialize it as a CHILD class
so this object can behave either as a parent or as a child.

Imagine, you're working with a team of Java developers building a game that
involves a bag of items that they can carry with them. However, the bag can only
carry a total weight of 20 kilograms. You are the developer that is responsible
for implementing the logic, that checks if you can add another item to the bag
or not? While the other team members are still coming up with what these items
will be. So far they've created a bunch of different classes for each of the
items. A crossbow, a key, a rare item, and some coins. But because they're good
Java developers, instead of including the integer weight attributes in each of
those classes, they've decided to extend a single class called item, which
includes that attribute. And then, each of the children classes can have its own
extra attribute. But, how is that going to help you? Well, when you get to
implement the class bag which includes the method, can add item, you can define
the input parameter to be of type item.
*/
public class Bag {
  int currentWeight;
  boolean canAddItem( Item item);
}
/*
And this will magically work for any of the child classes that extend from the
class item. Which means you only need to implement this method once. And in that
implementation, all you have to do is access the item.weight attribute.
*/
boolean canAddItem(Item item){
  if(currentWeight + item.weight > 20){
    return false;
  } else {
    return true;
  }
}


/*
And because all the children classes that extend from item will include that
attribute by default, this method will just magically work for any of the
existing items. So, let's say in the main method you decide to declare a
variable of type cross-bow, and then you can pass that cross-bow variable into
the canAddItem method of the bag class just directly without even casting it
to the item class. And because, cross-bow extends the item class it would
definitely have the weight attribute inside it.
*/
public static void main(String [] args) {
  //...
  Crossbow crossbow = new Crossbow();
  if (bag.canAddItem(crossbow)) {
    bag.addItem(crossbow);
  }
  //...
}

/*
Not only that, but imagine sometime in the future they come up with this new
item class called Map, which also extends from the item class. You can in fact
pass in that variable directly as well without changing anything in the can add
item method.
*/
public static void main(String [] args) {
  //...
  Map treasureMap = new Map();
  if(bag.canAddItem(treasureMap)) {
    bag.addItem(treasureMap);
  }
  //...
}
/*
Amazing, isn't it? Well, that's just part of what polymorphism allows you to do
in Java.
*/

//==============================================================================
// THE CHESS EXAMPLE
/* We've seen how Inheritance allows you to extend classes and add more
functionality to them.

Sometimes you not only want to extend the functionality of a class, but also
modify it slightly in the child class.

For example, say you're building a Java chess game.

A good Java design will have a class for each piece type:

 King                   Queen

 Rock (Torre)           Bishop(Alfil)

 Knight (Caballo)       Pawn(Peon)

And they should all inherit from a common base class: Piece

Why?
Because according to the concept of polymorphism, you could represent the
chess-board as a 2D array of Piece objects, and then each cell in the 2D array
can contain any of the child classes that extend the Piece class.

Other classes
To store this 2D array we will need a class that represents the Game itself:
*/
class Game{
   Piece [][] board;
   // Constructor creates an empty board
   Game(){
      board = new Piece[8][8];
   }
}
/*
And finally, a simple class called Position that has nothing more than a row
value and a column value to represent a specific slot on the board. */

class Position{
   int row;
   int column;
   // Constructor using row and column values
   Position(int r, int c){
      this.row = r;
      this.column = c;
   }
}
/*
That way, the Piece class can include a field variable of type Position that
stores the current position of that piece on the board: */
class Piece{
   Position position;
}
/*
Now, since all piece types inherit from the same parent class Piece, they will
all share any methods declared in that class.

For example:

It will be useful to have a method that checks if a potential movement of a
piece is a valid one. Even though each piece type has a unique movement
capability, any piece (regardless of its type) has to - at the very least - stay
within the bounds of the chess board.

So, a good idea would be to include a method called isValidMove inside the Piece
class that takes a potential new position and decides if that position is within
the bounds of the chess board. */

class Piece{
   boolean isValidMove(Position newPosition){
      if(newPosition.row>0 && newPosition.column>0
         && newPosition.row<8 && newPosition.column<8){
         return true;
      }
      else{
         return false;
      }
   }
}
/*
Since each of the child classes inherits from that Piece class, each will
automatically include this method, which means you can call it from any of those
classes directly.

For example:
*/
Queen queen = new Queen();
Position testPosition = new Position(3,10);
if(queen.isValidMove(testPosition)){
   System.out.println("Yes, I can move there.");
}
else{
   System.out.println("Nope, can't do!");
}
/*
What we've done so far can be considered as a good start for checking the
validity of the movement of a piece on the board. However, each piece type has a
different pattern of allowed movements, which means that each of those child
classes needs to implement the isValidMove method differently!

Luckily, Java not only offers a way to inherit a method from a parent class but
also modify it to build your own custom version of it.

Let's see how.*/

//==============================================================================
// OVERRIDE
/*
When a class extends another class, all public methods declared in that parent
class are automatically included in the child class without you doing anything.

However, you are allowed to override any of those methods. Overriding basically
means re-declaring them in the child class and then re-defining what they should
do.

Going back to our chess example, assume you're implementing the isValidMove
method in the Rock class.

The Rock class extends the Piece class that already includes a definition of the
isValidMove method. */

class Piece{
   boolean isValidMove(Position newPosition){
      if(newPosition.row>0 && newPosition.column>0
         && newPosition.row<8 && newPosition.column<8){
         return true;
      }
      else{
         return false;
      }
   }
}
/*
Now let's implement a custom version of that method inside the Rock class: */

class Rock extends Piece{
   boolean isValidMove(Position newPosition){
      if(newPosition.column == this.column || newPosition.row == this.row){
         return true;
      }
      else{
         return false;
      }
   }
}
/*
Notice how both method declarations are identical, except that the
implementation in the child class has different code customizing the validity
check for the Rock piece. Basically it's checking that the new position of the
rock has the same column value as the current position (which means it's trying
to move up or down), or has the same row position which means it has moved
sideways, both valid movements for a Rock piece.

Remember that this.position.column and this.position.row are the local fields of
the Rock class holding the current position of that piece.

We can also do the same for all the other piece types, like for example the
Bishop class would have slightly different implementation:
*/

class Bishop extends Piece{
   boolean isValidMove(Position newPosition){
      if(Math.abs(newPosition.column - this.column) == Math.abs(newPosition.row - this.row)){
         return true;
      }
      else{
         return false;
      }
   }
}
/*
For the Bishop, since it can only move diagonally, we'd want to check that the
number of vertical steps is equal to the number of horizontal steps. That is,
the difference between the current and new column positions is the same as the
difference between the current and new row positions.

I've used Math.abs which takes the absolute value of that difference to always
be a positive value, allowing this check to work for all 4 diagonal directions.

Perfect, now try to override this method for the Queen class, remember, a Queen
can move diagonally or in straight lines.
*/

//PROGRAMMING QUIZ:
/*
Now it's your turn, override the isValidMove method in the Queen class.
1.In the Queen class, override the isValidMove method.
2.First Call the parent's isValidMove to check for the boundries.
3.Add more code to check for the queen's specific move validity.
*/

class Queen extends Piece{
  boolean isValidMove(Position newPosition){
    if(newPosition.row>0 && newPosition.column>0
       && newPosition.row<8 && newPosition.column<8){
       if(newPosition.column == this.column || newPosition.row == this.row){
         return true;
       } else if(Math.abs(newPosition.column - this.column) ==
          Math.abs(newPosition.row - this.row)) {
         return true;
       } else {
         return false;
       }
    }
    else{
       return false;
    }
  }
}

//==============================================================================
// SUPER

/*
SUPER! Not only because you managed to solve that exercise, but "super" is
actually another Java keyword that we will be using next!

It is important to note that once you override a method, you basically ignore
everything that was in the parent class and instead have your own custom
implementation in the child class (literally overwriting it)!

In our case, we don't want to throw away the parent implementation. We actually
want to continue to use the original method, and ADD the extra checks for each
child class individually.

This is where we get to use the "super" keyword!

You are allowed to re-use the parent method in the child class by using the
"super" keyword, followed by a dot and then the method name:
*/
super.isValidMove(position);
/*
Using the keyword super here means that we want to run the actual method in the
super (or parent) class from inside the implementation in "this" class.

Which means in each of the child classes, before you get to check the custom
movement, you can check if super.isValidMove(position) has returned false. If
so, then no need to do any more checks and immediately return false; otherwise,
continue checking.

The new implementation for the Rock class will look like this:
*/
class Rock extends Piece{
   boolean isValidMove(Position newPosition){
      // First call the parent's method to check for the board bounds
      if(!super.isValidMove(position)){
         return false;
      }
      // If we passed the first test then check for the specific rock movement
      if(newPosition.column == this.column || newPosition.row == this.row){
         return true;
      }
      else{
         return false;
      }
   }
}
/*
You can also use super() to call the parent's constructor. This is usually done
when implementing the child's constructor. Typically you would want to first run
everything in the parent's constructor then add more code in the child's
constructor:
*/
class Rock extends Piece{
   // default constructor
   public Rock(){
      super(); // this will call the parent's constructor
      this.name = "rock";
   }
}
/*
Note: If a child's constructor does not explicitly call the parent's constructor
using super, the Java compiler automatically inserts a call to the default
constructor of the parent class. If the parent class does not have a default
constructor, you will get a compile-time error.
*/

//==============================================================================
//INTERFACE
/*
An interface is like a facade or an outline of some imaginary class. Its sole
purpose is to be inherited by some other class. It only defines what needs to be
done, but not how to do it. In other words, the interface would list the methods
that need to be included in the class but no implementation code whatsoever. The
implementation of these methods are the responsibility of the classes
implementing that interface. Once you implement that interface in a class, you
can then start instantiating objects as usual.

INTERFACE  >>>implement>>>  CLASS  >>>instantiate>>> OBJECT

The reason Java introduced interfaces is because of the multiple inheritance
problem. A single class can be extended by multiple classes. But a child class
is not allowed to extend more than one parent class. Interfaces, however, don't
have that restriction, which means that a single class can implement multiple
interfaces allowing for a more flexible design but without the ambiguity
problem of the multiple inheritance. Let's have a look at an example. Imagine
you're responsible of implementing a class called Caravan. We know that a
caravan is half vehicle, half house. But if you had a class for a vehicle and a
class for a house, we know that you're not allowed to extend both classes at the
same time. A good solution would be to introduce interfaces. A good interface
would be the movable interface, for example, which would define the methods that
any class that moves should include, like the vehicle class, for example.
Another good interface would be called the habitable interface, which would also
define all the methods that are to be included for any habitable class.
                 Movable              Habitable
                (Interface)          (Interface)
                    ||                   ||
                    ||                   ||
                    \/                   \/
                  VEHICLE              HOUSE


Once we define those two interfaces, we could then implement both of them in the Caravan
class at the same time.
                   Movable        Habitable
                  (Interface)    (Interface)
                     ||              ||
                     ||              ||
                     \/              \/
                    [[[[[[[CARAVAN]]]]]]]
Let's have a look at the Java code for that. Creating an interface in Java is
very similar to creating a class. Simply swap the keyword class with interface.
Inside the interface, as you can see, we have listed the method signatures but
without any implementation code because that's the responsibility of the class
that will be implementing that interface. */
public interface Movable{
  void move(int distance);
  boolean canMove();
}
/*
The same for the habitable interface, which in our case here only includes the
canFit method. */
public interface Habitable{
  boolean canFit(int inhabitants);
}
/*
Once we create both of those interfaces, we can then start implementing our
Caravan class, which implements both the habitable and movable interfaces.
Notice that I've used the keyword, implements, here compared to the keyword,
extends when inheriting from classes. Implements is the keyword to use when
inheriting from interfaces. */
public class Caravan implements Habitable, Movable{

}

/*
Once we implement those interfaces, we have to implement the code for every
single method included in both those interfaces like the move method which was
included in the moveable interface and the canFit method which was included in
the habitable interface. If there's any method in any of those interfaces that
was not implemented in the Caravan class, that will show a compilation error. */
public class Caravan implements Habitable, Movable{
  void move(int distance){
    location = location + distance;
  }
  boolean canFit(int inhabitants){
    return max <= inhabitants;
  }
}
/*
Notice that inheriting interfaces hasn't
really saved us from rewriting any code like we've done before with extended
classes.That's because interfaces isn't there to help us reduce code as much as
enforce a good design. Creating interfaces forces any class that will implement
it to have to implement a certain number of methods. This means that later on,
if you have a look at any class that implements a certain interface without
looking at the code of that class, you can guarantee that it will include all
these methods that are in that interface. So, to summarize everything so far,
  * We know that interfaces define what a class should do, but not how to do it.
  * We've seen that creating an interface is very similar to creating a class.
  * We know that the interface's sole purpose is to be implemented by one or
    more classes.
  * That is, you're not allowed to create an instance or an object from an
    interface directly. You have to first implement it through a class, and then
    you can create objects from that.
  * And we've seen that it's not about reducing code or partition. It's more
    about enforcing a good design.
*/

//==============================================================================
// THE COMPARABLE INTERFACE
/*
A very popular interface in Java is the Comparable Interface.
see: https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
This interface includes a single method definition called compareTo which takes
an object as an input parameter of the same type and compares both objects
("this" object against the input argument object).

The main purpose of this interface is to give any class a chance to describe how
to compare 2 objects of that class against each other. This will be really handy
when we get to sorting or searching for such objects of that type.

For example:

Assume you have a class that represents a book:
*/
public class Book{
   int numberOfPages;
   String title;
   String author;
}
/*
And you are asked to implement the Comparable Interface so that you can sort the
books according to the following criteria:

1.If a book has more pages than the other, then the book with the more pages
  goes first.
2.If both books have the same number of pages, then sort by the title
  alphabetically.
3.If both books have the same number of pages and the same title, then sort by
the author alphabetically.

Before we start coding, let’s go through how the compareTo method should work:

The compareTo method takes a single input parameter (let's refer to it as the
"specified object") and since this method belongs to an object itself (let's
refer to it as "this object"), then the method simply compares the "specified"
object against "this" object.

According to the documentation, there are 3 possible outcomes when comparing any
2 objects:

1."This" object is considered less than the "specified" object
2."This" object is considered equal to the "specified" object
3."This" object is considered greater than the "specified" object

Respectively, for each of those cases, compareTo method should return:

1.A negative integer (any number less than 0)
2.zero (0)
3.A positive integer (any number greater than 0)

Ok, now that we've got everything well defined, let's start coding:
*/
public class Book implements Comparable<Book>{
   public int compareTo(Book specifiedBook) {
      // First check if they have different page counts
      if(this.numberOfPages != specifiedBook.numberOfPages){
         // this will return a negative value if this < specified but will
         // return a positive value if this > specified
         return this.numberOfPages - specifiedBook.numberOfPages;
      }
      // If page counts are identical then check if the titles are different
      if(!this.title.equals(specifiedBook.title){
         return this.title.compareTo(specifiedBook.title);
      }
      // If page titles are also identical then return the comparison of the
      // authors
      return this.author.compareTo(specifiedBook.author);
    }
}

//==============================================================================
/*
FINAL methods
OOP (Object Oriented Programming) is powerful - you can extend classes, add
features to them and even override their methods to behave differently.

But, remember ...
"With great power comes great responsibility....."
                                ...Spiderman

Being able to override any method could be dangerous. If someone creates a
class with a certain method, they assume this method behaves in a certain way.

That's why, if you want to protect your method from being overridden in a child
class you can prefix it with the keyword final.

A final method can still be accessed by the child class (if the permissions
allow so) but cannot be overridden, hence you can guarantee that any final
method will behave exactly like the parent's implementation.

Here's an example:
*/
public class Room{
   private double width;
   private double height;
   public Room(double width, double height){
      this.width = width;
      this.height =height;
   }
   public final double getArea(){//Protected with final
      return width*height;
   }
}
/*
Now if another class extends Room, no matter what type of room it is it
shouldn't be allowed to override the method getArea because the area should
always be calculated the same way: */

public class LivingRoom extends Room{
   // The constructor simply calls the parent's constructor using super()
   public LivingRoom(double width, double height){
        super(width,height);
    }
   // Not allowed to override getArea() here
}
/*
But since the method is public, it means that it's also available in the child
class: */

LivingRoom myLivingRoom = new LivingRoom(5,3);
double area = myLivingRoom.getArea();
System.out.println(area);
/*
The above code will work just fine, and the output will be 15.0 as expected! */

//==============================================================================
/*
FINAL fields
The final keyword can also be used to describe fields. However, unlike with
methods, a final field has nothing to do with inheritance!

A final field is simply a constant variable! In other words, a variable that is
only to be set once and is not allowed to change ever again!

A good example of a final field is defining math constants, like PI:
*/
public class MathLib{
   public final double PI = 3.14;
}
/*
This basically means that even though the field is public, you are not allowed
to change the value of PI anywhere (inside or outside of this class).
*/
public static void main(String [] args){
   MathLib mathlib = new MathLib();
   mathlib.PI = 0; // This is not allowed and will show a compiler error!
}


//==============================================================================
/*
Objects that are created from a class don't really last forever. Typically,
you'd create an object from a class, fill its fields with some values, and maybe
create another object and fill its fields with some different values, but then
eventually both those objects will get destroyed including every single value
stored in those fields Typically, that would happen whenever the scope of that
object ends For example here, inside this method I've created the variable
myItem which is an object of the type class Item. Once this method ends, this
myItem variable doesn't exist anymore, including all the values of all the field
inside it. */
public void method(){
  //...
  Item myItem = new Item();
  myItem.power = 10;
  //...
}
/*
This kind of makes sense because you don't really need the values of a field
inside an object that you can't even access anymore. However, in some rare
occasions, you might want to store the value of a certain field even if there
are no objects for that class. In that case, you need to add the keyword STATIC
when declaring this field. Declaring a field as static means that these values
are no longer stored within the object itself but within the class instead.
Meaning that all objects of the class will share that same exact value. And then
even if every single object of the class has been destroyed, the value is still
stored within the class. If you decide to create a new object of that same
class, then it will end up using the same value that was stored in the class.
Notice however, that static here doesn't mean that the value doesn't change. In
fact, if that value does change, it will update it in every single object of
that class again. Now because static fields belong to classes instead of object,
Java allows you to access a static field directly from the class instead of
having to create an object of that class. For example here, I can access the
power field from the class item directly and set it to a value. */
// We can do this
public void method(){
  //...
  Item.power = 10;
  //...
}
// Instead of this
public void method(){
  Item myItem = new Item();
  myItem.power = 10;
}
/*
Let's have a look at a coding example. In this example, I've created a class
called Person, and I'm trying to keep count of every single object that was
created from the class. So, I've added this public int field called count, and
inside the constructor, which is just the default constructor, I'm incrementing
that count by one, which means that every time I create a new object of Person,
it will add one to that count variable. */
public class Person{
  public int count;
  public Person(){
    count++;
  }
}

/*
Now if you go to the main method, you could see that I've created this loop that
starts from zero and counts all the way to 100, and inside that loop, I'm
creating a new instance of that class Person. And every time I create an object,
I print out the count value installed inside it. So when I run this code, I
would expect that every time I'm creating a new Person object, it's adding one
to the counter, and by the time we reach to the hundredth Person, the count
value would be 100. So I'm expecting to see the numbers between one and 100. */
public class Main(){
  public static void main(String [] args){
    for(int i = 0; 1 < 100; i++){
      Person person = new Person();
      System.out.println(person.count);
    }
  }
}
1
1
1
1
1
1
...
/*
However, if I do run this code, it seems like I'm just getting a bunch of ones,
which means that this count variable is not being updated at all. The
explanation for that is pretty simple. If we go back to the Person class, you'd
notice that I haven't declared this count variable as static, which means that
it belongs to the object not the class. And because I'm creating a new object
every time, it means I'm creating a new variable called count and I'm only
adding one to it. So every single object would have its own count variable that
has the value one. However, if I do add the static keyword to our count variable
here, this means that this variable now belongs to the class rather than the
object. And every time I'm calling the constructor, it's adding one to the same
variable count.So if I run this now, I should get all the numbers between one
and 100 like I expected earlier. */
public class Person{
  public static int count;
  public Person(){
    count++;
  }
}
public class Main(){
  public static void main(String [] args){
    for(int i = 0; 1 < 100; i++){
      Person person = new Person();
      System.out.println(person.count);
    }
  }
}
1
2
3
...
99
100
/*
Counting the instances that were created from a class is one of the very common
use cases for using the static keyword. So why don't you go ahead and try this
yourself as well.

STATIC Methods
The static keyword can also be used to describe methods, allowing you to simply
call the method from the class rather than having to create an object first and
then calling the method. Static methods, however, have limited capabilities
since it can't access non-static fields in the object anymore.

But before we get too much into static methods, go ahead and try out the static
fields yourself.

So when should we declare fields or methods to be static and when should we not?

The short answer is in most cases you would want the variables and methods to
belong to a certain object rather than the entire class, which means most of the
time you won't declare them as static. However, if you end up creating a class
that provides some sort of functionality rather than have a state of its own,
then that's a perfect case to use static for almost all of its methods and
fields.

For example, remember the Math class that we used to generate random numbers?
It turns out that Math is nothing more than a class with a bunch of static
methods like random() and others. Because it doesn't really make sense to create
an object called math1 and another called math2, all Maths are the same and
hence we can simply use the class itself to call its methods directly, and
that's why static was a good choice here.
*/

//==============================================================================
/*
STATIC METHODS
Just like static fields, static methods also belong to the class rather than the
object.

It's ideally used to create a method that doesn't need to access any fields in
the object, in other words, a method that is a standalone function.

A static method takes input arguments and returns a result based only on those
input values and nothing else.

Not needing any field values makes it easy for a method to be attached to the
class definition and not an individual object since it doesn't care about the
values of any of the fields.

However, a static method can still access static fields, that's because static
fields also belong to the class and are shared amongst all objects of that
class.

Here's an example of a calculator implementation with some static methods:
*/

public class Calculator {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

}
/*
Since both add and subtract don't need any object-specific values, they can be
declared static as seen above and hence you can call them directly using the
class name Calculator without the need to create an object variable at all:
*/
Calculator.add(5,10);

//Insignificant note.
