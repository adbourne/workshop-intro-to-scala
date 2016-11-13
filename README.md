# Intro to Scala Workshop 
This project is intended to give you, dear reader, a hands-on introduction 
to the Scala programming language. We'll cover some basic functional 
programming concepts and some need-to-know language features, all over the 
span of about an hour. If after that you still want more then you'll find 
a list of additional resources way down at the bottom of this page. 


## Prior to the Workshop
You're going to need to do a few things prior to the workshop.

#### Install JDK 7+
If you're currently programming in Java you'll already have this. 
Otherwise [grab it](http://www.oracle.com/technetwork/java/javase) and 
install it

#### Install SBT
You're going to need to install [SBT](http://www.scala-sbt.org/). This 
is the Scala Build Tool and will take care of building your project, 
dependency management etc. In fact, think of it to Scala as Maven is to 
Java. (For die-hard gradle users -- sorry for using the "M" word).

#### Installing an IDE / Text Editor
I recommend [IntelliJ IDEA](docs/setup-intellij.md) and will be using
this IDE during the workshop. If IntelliJ isn't your cup of tea then 
[Eclipse](docs/setup-eclipse.md) would do the trick. If you prefer the 
text editor approach then you can get some nice Scala syntax highlighting 
in [Atom](docs/setup-atom.md).

#### The First Run 
Once you have SBT installed and your IDE configured you're going to want 
to build the project and download all those lovely dependencies. Open up 
your terminal/command prompt and navigate to the root of the project. 
Run this:
```
    sbt clean compile run
```
This will do a few things:
* Download the correct version of SBT for the project as specified in 
project/build.properties -- clever right?
* Compile the necessary Scala bits for the version specified in build.sbt
* Download the necessary dependencies for this project
* Start up a server on port 9000

__This will take a few minutes__! But it's all worth it, trust me! Once 
it's done try hitting http://localhost:9000 in a browser. For the extra 
curios take a look at A_Scala101Test.scala. This and the other stuff 
will be covered in the workshop.  


## Additional Resources
Looking for more? Try these:

#### Online
* [The official Scala site](http://www.scala-lang.org)
* [The Morning Paper - Why Functional Programming Matters] (https://blog.acolyer.org/2016/09/14/why-functional-programming-matters/)
* [Daniel Westheide's "The Neophyte's Guide to Scala"](http://danielwestheide.com/scala/neophytes.html)
* [Martin Odersky's Scala Coursera course] (https://www.coursera.org/learn/progfun1)
* [Lightbend's eBook collection] (http://www.lightbend.com/resources/e-books)

#### Books
* [Scala for the Impatient - This book is fantastic!](https://www.amazon.co.uk/Scala-Impatient-Cay-Horstmann/dp/0321774094)
* [Functional Programming in Scala](https://www.amazon.co.uk/Functional-Programming-Scala-Paul-Chiusano/dp/1617290653)
* [Programming in Scala](https://www.amazon.co.uk/Programming-Scala-Comprehensive-Step-Step-ebook/dp/B01EX49FOU)
 
