/*
LISTS
A List in Java is an interface that behaves very similarly to an array

  * It's an ordered collection (also known as a sequence).
  * The user of this interface has precise control over where each item is
    inserted in the list.
  * The user can access items by their integer index (position in the list).
  * The user can search for items in the list by looping over the items in it.

In fact, the most common class that implements the List interface uses an array
internally and is even called ArrayList

ArrayList
An ArrayList is a class that implements the interface List. It's simply a
wrapper around an array, but provides really powerful methods that make dealing
with the array much simpler.

Note: An item in an ArrayList is known as an element

Let's have a look at some of the ArrayList's methods:

  * add(E element): Appends the specified element to the end of this list.
  * add(int index, E element): Appends the specified element to the specified
    index of this list.
  * get(int index): Returns the element at the specified position in this list.
  * contains(Object o): Returns true if this list contains the specified
    element.
  * remove(int index): Removes the element at the specified position in this
    list.
  * size(): Returns the number of elements in the list.

For the full list of methods check out the documentation here:
https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html

To create and initialize an ArrayList:
*/
ArrayList grades = new ArrayList();
/*
Then you can add elements by calling the add() method:
*/
grades.add(100);
grades.add(97);
grades.add(85);
/*
To access the first item in the list:
*/
grades.get(0)
/*
This will return the value stored at index 0 (in this case: "100")

At any point, you can check the size of an array using the size() method:
*/
System.out.println(grades.size().toString());
/*
This will print the number of elements in the list (in this case: "3")

You can also remove items by index:
*/
grades.remove(0);
/*
Which will remove the first item in the list with index=0 ("100"), and then
shift the other 2 items ("97" and "85") to have the indices (0 and 1)
respectively.

You can even clear the entire list by calling the clear() method:
*/
grades.clear();
/*
Some of these methods save us from writing extra code (loop and if checks) that
we used to do with arrays. That's because the ArrayList already has such code
implemented internally.

For example, when adding an element to the end of an array you will need to keep
track of the index pointing to that last slot, and continue to increment that
index every time you add a new item. But with ArrayLists, all you have to do is
call the method add() with the item and it will take care of finding the correct
index and inserting it in the right place.

Also, notice that we don't need to specify the initial size of an ArrayList:
*/
ArrayList myArrayList = new ArrayList();
/*
Unlike what we used to do with arrays:
*/
int[] myArray = new int[100];
/*
This is because the ArrayList class takes care of resizing the internal array
every time it runs out of space, which is all done behind the scenes so you
don’t have to worry about implementing any of that.
*/
//==============================================================================
/*
Loops & Collections
Just like with arrays, the best way to access each and every element in an
ArrayList is to create a loop and use the loop counter as an index: */

// First get the size of the array list
int size = list.size();
// Start the loop
for(int i = 0; i < size; i++){
   System.out.println(list.get(i));
}
/*
The above will get each element at index "i" and print it.

There's another type of loop that's basically a shorthand for loops that doesn't
require you to specify a loop counter variable nor an index variable.

It consists of 2 parts, declaring the item variable followed by a colon : then
the ArrayList variable (or any collection type):
*/
// iterate via "New way to loop"
for (String item : list) {
   System.out.println(item);
}
/*
This basically reads: For each item in the list, print that item! Pretty simple!

Advanced topic:
There's another way to loop over collections, however, it's a more advanced
technique that should only be used in certain collections where the 2 loops
above are too slow, like a LinkedList. For more information check out this link:
https://www.tutorialspoint.com/java/java_using_iterator.htm
*/
//==============================================================================
//STACKS
/*
Stacks
The Stack collection represents a last-in-first-out (LIFO) stack of objects.

It means that the last item added (pushed) to a stack is the first item removed
(popped) from that stack.

Just like a stack of plates: The last plate I add on will always be the first
plate I take off.


The Stack class includes these five methods:

  * push(E item): Adds an item onto the top of this stack
  * pop(): Removes the object at the top of this stack and returns that object
  * peek(): Returns the object at the top without removing it from the stack.
  * empty(): Checks if this stack is empty.
  * search(Object o): Searches for an object in this stack and returns its position.
Just like the ArrayList, the Stack also internally uses an array that stores
everything in order.

An example of when a stack is useful would be when developing something like an
email system: Once the email server receives a new email it should add this
email to the top of the stack of emails so that the user will read the latest
email first!

Here's a simple example of how to use a Stack:
*/
Stack newsFeed = new Stack();
newsFeed.push("Morning news");
newsFeed.push("Afternoon news");
newsFeed.push("Evening news");
String breakingNews = (String) newsFeed.pop();
System.out.println(breakingNews); // Will print "Evening news"
}
/* Ok, great, now what happens if we call these 2 lines again right after the
code above?
*/
String moreNews =  (String) newsFeed.pop();
System.out.println(moreNews); // It will print "Afternoon news"
/*
If you want to access the top of the stack without removing it, then call peek
instead of pop.
*/
String peekNews = (String) newsFeed.peek();
/*
Note
You might be wondering why the need to cast the return type of pop() and peek()
using (String)?

That's because these methods actually return the type Object and not String,
simply because it has no idea what you've inserted and what type it is!

We will learn more about this when we get to the Generics section of this
lesson.
*/
//==============================================================================
//  QUEUE
/*
Queue
Another very common collection type used in Java is the Queue. As the name
suggests it resembles the queue or line of people one after the other.

Unlike the stack, it's a First-In-First-Out (FIFO) data type where the first
element added to the queue is the first element to be accessed or removed.


The Queue is only an Interface and not a Class by itself, however, it defines 2
important methods for all classes that do implement the Queue interface.

  * add(E element): Inserts the specified element into this queue
  * poll(): Retrieves and removes the head of this queue

A special type of Queues is known as Deque which is a double-ended queue.
Meaning that you can add or remove elements from either end of a Deque (Front or
End).

Along with the 2 Queue methods, a Deque also offers these methods:

  * addFirst(E element): Inserts the specified element at the front of this
    deque
  * addLast(E element): Inserts the specified element at the end of this deque
  * pollFirst(): Retrieves and removes the first element of this deque
  * pollLast(): Retrieves and removes the last element of this deque

Java also provides a few classes that implement the Queue Interface, perhaps the
most popular of all is the LinkedList

Here's an example on how to create and use a LinkedList object:
*/
Queue orders = new LinkedList();
orders.add("Order1");
orders.add("Order2");
orders.add("Order3");
System.out.print(orders.poll()); // Prints "Order1"
System.out.print(orders.poll()); // Prints "Order2"
System.out.print(orders.poll()); // Prints "Order3"

//==============================================================================
/*
GENERICS
In a nutshell, Generics enable classes to accept parameters when defining them,
much like the more familiar parameters used in method declarations.

Defining a type parameter for a class provides a way for you to re-use the same
code with different inputs. The difference is that the inputs to formal
parameters are values, while the inputs to type parameters are types.

Generics in Collections
For example: ArrayLists use Generics to allow you to specify the data type of
the elements you're intending to add into that ArrayList.

The way to do so is by defining that data type between <> when declaring the
ArrayList variable:
*/
ArrayList<String> listOfStrings = new ArrayList();
/*
This is explicitly saying that you want to create an ArrayList of Strings, and
hence the compiler will only allow Strings to be inserted into this ArrayList
and will show you an error if you try to insert something else.

Generics eliminate the need for casting
Remember how we had to cast the return value of a pop() method when we were
using a collection like the Stack earlier?

Well, because of generics you can now specify the datatype of the stack or queue
or any collection when declaring it, thus eliminating the need to cast any
return types:

The following code snippet without generics requires casting:
*/
List list = new ArrayList();
list.add("hello");
String s = (String) list.get(0);
/*
When re-written to use generics, the code does not require casting:
*/
List<String> list = new ArrayList<String>();
list.add("hello");
String s = list.get(0);   // no cast
/*
Define your own Generic Types
And finally, you can create your own generic type by declaring a generic
parameter when defining your class. This will not be covered in this lesson, but
if you want to know more about how to do so check out the documentation here:
https://docs.oracle.com/javase/tutorial/java/generics/types.html
*/
//==============================================================================
/*
By now, you should know how to define a data type when creating a collection
using generics. */
ArrayList<Country> listOfCountries = new ArrayList();
/*
You should also know that with polymorphism, a class can be treated as if it was
its parent as well as its own type.
      Place===============
        ||                ||
        ||                ||
        ||                ||
        \/                \/
      Country==========> Egipt
Putting those two concepts together, we could achieve the flexibility that we
want when coding while still keeping a good design that will help us avoid
unintentional bugs. Let's see how. If you don't specify the data type when
creating a collection, you are allowed to add pretty much any data type to that
same collection. However, when you're retrieving an item back you'll need to
know what type that was and casted to that type before you can use i If you try
to cast something that doesn't match that dat it will throw in an error at
runtime and might even cause your program to crash.
*/
ArrayList countries = new ArrayList();
countries.add(1);
countries.add("Australia");
countries.add(countryobject);

String countryName = (String) countries.get(1); // Australia coincide con String
String countryName = (String) countries.get(2); // data does not coincide, will
                                                //throw an error
/*
But with polymorphism, you can define the data type of a collection to some
basic parent class and then add a remove any item of a child class into that
same collection. Let's have a look at an example Assume you have an audio class
and a video class, and you want to create a playlist that will include both
object types in the same list. Using polymorphism, you could set the audio class
and video classes to extend from its common class called Media. That way, you
can define your ArrayList to be of type, Media, instead of a specific audio or
video type. Once you do that, you could start creating objects of type videos
and audios as normal, and then add those objects into that playlist. This will
work because the media type is the parent of both video and audio types. Now,
when retrieving an item from that playlist, you could simply retrieve it as if
it was a media object, and then you could call a common method like play that
should exist in both video and audio objects. This way, as you could see, you
don't have to cast that item that you've returned into a specific type and
hence, avoid any unintentional run time errors.*/
ArrayList<Media> playlist = new ArrayList();
Video someVideo = new Video();
Audio someAudio = new Audio();
playlist.add(someVideo);
playlist.add(someAudio);
Media media = playlist.get(0);
media.play();
/*
Having said that, you are still about to retrieve the item using its own type by
casting it, which will allow you to access more specific methods that exist only
in that child class. */
ArrayList<Media> playlist = new ArrayList();
Video someVideo = new Video();
Audio someAudio = new Audio();
playlist.add(someVideo);
playlist.add(someAudio);
Video movie = (Video) playlist.get(0);
movie.playFullScreen();
/*
But the whole point of using polymorphism with collections is to allow to
retrieve items as if they were the parent type and then simply use common method
that would exist in any of its children.
*/

//==============================================================================
/*
ARRAYLIST METHODS
You can search for an item in an ArrayList the same way we've done with arrays
before, all you have to do is create a loop that checks every item in the
ArrayList and compares it to the one you are looking for.

For example, looking for the String "Sydney" in the ArrayList cities will look
like this:
*/
for(int i=0; i<cities.size(); i++){
   if(cities.get(i).equals("Sydney")){
      return true;
   }
}
/*
Or even use the shorthand loop that we mentioned earlier:
*/
for(String city : cities){
   if(city.equals("Sydney")){
      return true;
   }
}
/*
Moreover, ArrayList comes with the power of being a class that contains a bunch
of useful methods, including:
*/
int indexOf(Object o)
/*
This method returns the index of the first occurrence of the specified element
in this list, or -1 if this list does not contain the element.

So instead of having to create a loop and search "Sydney" one by one you can
replace all that with this 1 line of code:
*/
cities.indexOf("Sydney");
/*
If the above returned -1 then Sydney is not in the list, if it returned any
positive value than that will be the index of the String "Sydney".

Another really cool method is the remove() method.

The remove() method not only handles searching for and removing the item from
the list but also shifts all the following items to fill up the gap created by
removing that item.

Check out this documentation page for more information about all the methods in
the ArrayList class.
https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
*/
//==============================================================================
/*
OPTIMIZATION
Understanding how different data structures work in Java will help you become a
great software developer. The reason it is important to use the correct data
structure for a variable or a collection is: performance.

A single program can be implemented in so many different ways, but only some
will run smoothly and fast enough that users will want to continue using it.

For example:

We've seen how to search an ArrayList of Strings for a particular String inside,
we know that we need to use a loop to compare that String with every other
String in the list (even when using the indexOf method, internally it will still
use a loop to search for your item).

It may not seem to take that long when you try it on your computer, but if that
ArrayList contained millions of items (a very common list size in Java btw), it
will take a noticeable time to find the item you are looking for.

Users usually consider a program "non-responding" if it takes more than 10
seconds to complete an operation! Which means if the search itself took that
long, no-one will ever use your program again!

HASHMAPS
A HashMap is another type of collection that was introduced in Java to speed up
the search process in an ArrayList.

In some sense, it's just another collection of items (Strings or Integers or any
other Object), but the way it stores those items is unique.

HashMaps allow you to store a key for every item you want to add. This key has
to be unique for the entire list, very much like the index of a typical array,
except that this key can be any Object of any Type!

The point is to be able to find an item in this collection instantly (without
having to loop through all the items inside) and hence save that precious
run-time.

Let's have a look at an example:

Consider you have a class called Book that contains every detail about such
book:
*/
public class Book{
   String title;
   String author;
   int numOfPages;
   int publishedYear;
   int edition;
   String ISBN;
}
/*
If you were to create a Library class that will simulate a virtual library of
all the books that exist in the world (~130 Million) you can easily create an
ArrayList of Books, and fill it up with all the book details that you may have.
*/
public class Library{
   ArrayList<Book> allBooks;
}
/*
Now, to search for a book by its ISBN (String) you will need to create a loop to
compare the ISBN of each book with the one you are looking for:
*/
Book findBookByISBN(String isbn){
   for(Book book : library.allBooks){
      if(book.ISBN.equals(isbn)){
         return book;
      }
   }
}
/*
A way more optimal solution is to use a HashMap instead of ArrayLists. To use
HashMaps, you will need to import it at the very top of your Java file:
*/
import java.util.HashMap;
/*
This is how you declare a HashMap:
*/
public class Library{
   HashMap<String, Book> allBooks;
}
/*
The above declaration means that we are creating a collection of Books with a
key of type String.

To initialize this hash map, use the default constructor like so:
*/
allBooks = new HashMap<String, Book>();
/*
Then, to add items to the HashMap:
*/
Book taleOfTwoCities = new Book();
allBooks.put("9781539687399", taleOfTwoCities);
/*
To search for a book using its ISBN:
*/
Book findBookByISBN(String isbn){
   Book book = allBooks.get(isbn);
   return book;
}
/*
The above code will use the String key (ISBN) to find the book instantly in the
entire collection of ~130 Million books leading to a much better performing Java
program.
*/
