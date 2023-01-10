# Computer Science II
## Assignment 2 - Project Phase I
## Data Representation & EDI
### Spring 2023
---

# Introduction

Objects represent and model real-world entities. The *state* of an
object consists of the pieces of data that conceptually/semantically
define what that object is. It is often necessary to be able to transmit
objects between different systems which may use completely different
technology stacks. This is usually referred to as Electronic Data
Interchange (EDI) and is achieved by translating objects into a
platform-independent data format such as XML (Extensible Markup
Language) or JSON (JavaScript Object Notation) representations. Once
transferred, the data on the other end can then be translated into an
object in the second system. Different languages and frameworks have
their own terminology for this process (marshaling/unmarshaling,
serialization/deserialization, etc.).

The first phase of the project will focus on the design and
implementation of several Java classes to model the various entities in
the system. For the first phase, your classes may be simple data
containers. Full behavior, methods, and inheritance will be required in
Phase II and you are encouraged to plan ahead for any modifications that
you may need. Your classes will define, conceptually, what each of the
entities are (their data and types and accessor/mutator methods) as well
as provide means for creating and building instances of those entities.

You will also write a parser to process a collection of "flat" data
files containing data on entities in the old system and build instances
of each object. These "flat" files are all in a comma separated value
(CSV) format.  Finally, you will also implement functionality to serialize
your objects into either XML and/or JSON formats (so that data can be
transmitted to the subsystems other teams are building).  

# Data Files

Full examples of each of the following files have been
provided in a separate directory in this repository. However, you will
also be required to develop your own non-trivial test case. In general,
you may assume that all data is valid and properly formatted and all
data files are named as specified. You should assume that all data files
are located in a directory called `data` and output files should be
saved to the same directory.

## Persons Data File

Data pertaining to individual people on the system is stored in a CSV
file in `data/Persons.csv`. The format is as follows: the first
line will contain a single integer indicating the total number of
records. Each subsequent line contains comma delimited data fields:

-   Person Code -- a unique alphanumeric id

-   Name -- the person's name in a `lastName,firstName` format

-   Address -- the mailing address of the person with the format:
    `street,city,state,zip,county`

-   Email Address(es) -- an (optional) list of email addresses. If there
    are multiple email addresses, they will be delimited by a comma

An example:

```text
3
fdc267,Quarry,Staci,601 Lotheville Road,Savannah,GA,31405,US,squarry0@reverbnation.com,squarry0@salon.com
0375b6,Michelotti,Nonnah,0 Havey Avenue,Cleveland,OH,44177,US,nmichelotti1@sbwire.com,nmichelotti1@vistaprint.com,nmichelotti1@gravatar.com,nmichelotti1@patch.com
aa887a,Leavold,Wit,65337 Straubel Place,Muncie,IN,47306,US
```

## Stores Data File

Data pertaining to each store on the system is stored in a CSV file in
`data/Stores.csv`. The format is as follows: the first line will
contain a single integer indicating the total number of records. Each
subsequent line contains a comma delimited data fields:

-   Store Code -- a unique alphanumeric identifier

-   Manager Code -- an alphanumeric code representing the individual
    person that manages the store (as specified in the Persons data
    file)

-   Address -- the physical address of the store in the same format:
    `street,city,state,zip,country`

An example:

```text
5
3c0234,fdc267,123 Cornhusker Way,Lincoln,NE,68508,US
9f352c,aa887a,4242 A Street,Omaha,NE,68117,US
73668b,fdc267,RR9901,Mead,NE,61234,US
96f2cf,fdc267,452 13th Street,Hastings,NE,68901,US
25d901,aa887a,180 Magdeline Plaza,Wichita,KS,67230,US
```

## Invoice Items Data File

Data pertaining to each available item (equipment, products, services)
is stored in a CSV file in `data/Items.csv`. The format is as follows:
the first line will contain the total number of records (an integer).
Each subsequent line contains comma delimited data fields depending
on the type of item.  The first three tokens for all itmes are the
same: a unique alphanumeric code, a single character representing
the type of item, and the name of the item.

-   Equipment will have the following format:
    `code,E,name,model`
    (the `E` designates that this record is a piece of equipment)

-   Products have the following format:
    `code,P,name,unit,unitPrice`
    where `unit` is a descriptor for the unit that the product is
    sold in and the `unitPrice` is the price per unit.  In the
    example below, top soil is sold by the `ton` and the cost is $850
    per ton.

-   Services have the following format: `code,S,name,hourlyRate`

An example:

```text
14
1d4d89,E,Tractor,MegaTract 150HP
0ec6e9,E,Harvester,Husker 2000
740515,E,Baler,Haymaker 400
3506f6,E,Backhoe,BidDoug X25
649f88,E,Truck,F105
342foa3,P,Haybale,bale,500
3n3k4l2,P,Corn seed,bag,50
n3453js,P,Fertilizer,liter,10.25
l4k32j4,P,Wire fencing,lft,8
23n4kl2,P,Top soil,ton,850
2334b23,S,Delivery,100
n43k2l3,S,Plowing,1000
432kn2l,S,Tractor Driving Lessons,25
8432941,S,Cattle Vaccination,225.50
```

# Requirements

You are required to design Java classes to model the problem above and
hold the appropriate data. The classes you design and implement, their
names, and how they relate to each other are design decisions that you
must make. However, you should follow good object oriented programming
principles. In particular, you should make sure that your classes are
designed following best practices.

In addition, your program will load data from the CSV files, construct
(and relate) instances of your objects, and serialize the data into
output files. It is your choice as to which format you produce, XML or
JSON (or both for extra credit).

For XML, your output file names should be `Persons.xml`,
`Stores.xml` and `Items.xml`; for JSON, your output files
should be `Persons.json`, `Stores.json` and
`Items.json` respectively. Your output files should be placed in
the same `data` directory as the input files.

There is no need to define a rigorous schema in either case. However,
your XML/JSON should be well-formatted and valid. You should follow the general
structures in the examples provided, though some flexibility is allowed
for tag and element names. However, the output should *conceptually*
match the expected output. It must also pass any and all validation
tests (using the validators listed below). In addition, you may (in fact
are *encouraged* to) use a library to serialize your Java classes to XML
or JSON. Some common libraries and more information on each
of the formats can be found with the following resources:

-   XStream, a light-weight XML binding framework (recommended for XML):
    <http://x-stream.github.io/>

-   Google-gson (recommended for JSON) library to convert between Java
    objects and JSON: <http://code.google.com/p/google-gson/>

-   An XML Validator: <http://www.w3schools.com/xml/xml_validator.asp>

-   A JSON Validator: <http://jsonformatter.curiousconcept.com/>

# Process

For this initial phase, your objects may be simple data containers since
the only thing you are doing with them is parsing data files, creating
object instances, and exporting them in a different format. However,
much of the code you write in this phase will be useful in subsequent
phases, so ensure that you have well-designed, robust, bug-free and
reusable code.

## Testing

You are expected to thoroughly test and debug your implementation using
your own test case(s). To ensure that you do, you are required to design
and include at least one non-trivial test case to demonstrate your
program was tested locally to some degree. Ultimately your application
will be tested on multiple test cases through webgrader including those
handed in by your peers.

Understand that the webgrader is *not* a sufficient testing tool.
Webgrader is a *black-box* tester: you don't have access to its
internals, nor to the test cases, nor can you debug with respect to it.

Also understand what a test case is: it is an input-output that is known
to be good using a method independent of your program (calculated or
verified by hand). We will use your test case when grading other
assignments, so you are encouraged to be adversarial: design test cases
to probe and break "bad" code, but stay within the requirements
specified above.

There are many tools available that will help you generate test data.
Some examples:

-   Mockaroo: <http://www.mockaroo.com>

-   Generate Data: <http://www.generatedata.com>

-   Online Converter: <https://www.convertcsv.com>

# Artifacts -- What you need to hand in

-   Your program *must* be runnable from a class named
    `DataConverter.java` which *must* be in the package
    `com.fmt`

-   Your input/output test case files *must* be in a `data`
    directory in your project when you hand it in.

-   You must follow the instructions for how to build your project as a
    single JAR file in Appendix B of the Project Description document.
    Name your JAR file `Project.jar`

-   In addition, you will be writing a design document. The first draft
    of this document is due 1 week prior to this assignment.

## Common Errors

Some common errors that students have made on this and similar
assignments in the past that you should avoid:

-   Design should come first--be sure to have thought out a design for
    your objects and how they relate and interact with each other before
    coding.

-   OOP requires more of a bottom-up approach: your objects are your
    building blocks that you combine to create a program. This is in
    contrast with a procedural style which is top-down.

-   Worry about the design of objects before you worry about how they
    are created.

-   A good litmus test: if you delete your driver class, are your other
    objects still usable? Is it possible to port them over to some other
    uses or another application and have them still work without
    knowledge of your driver program? If yes, then it is probably a good
    design; if no, then you may need to reconsider what you're doing.

-   Objects should be created via a constructor (or some other pattern);
    an object should not be responsible for parsing data files or
    connecting to a database to build itself (a Factory pattern is much
    more appropriate for this kind of functionality).

-   Encapsulation should be respected. Appropriate data fields and
    appropriate types should be defined for each class. Visibility
    should be restricted with access done through accessor/mutator
    methods. Any methods or functionality that acts on a class's data
    should be encapsulated in the class (unless usage of an external
    library makes it inappropriate). If a value is based on an object's
    state and that state is mutable, then the value should be recomputed
    based on the state it was in at the time that the value was asked
    for.

-   Classes should be designed as stand-alone, reusable objects. Design
    them so that they could be used if the application was changed to
    read from a database (rather than a file) or used in a larger
    Graphical User Interface program, or some other completely different
    framework.

# Rubric (100 points total)

Grading will be based on the following items

Style (5)
 *  Clean, well-organized and readable code
 *  Meaningful identifier names
 *  Proper use of whitespace
 *  Consistent style
 *  No debugging or dead code remains

Documentation (5)
 *  Class and method-level documentation for all non-trivial methods
 *  Complex blocks of code are commented
 *  No unnecessary or development-style comments remain
 *  Code is otherwise self-documenting

Design (25)

 *  Classes are implemented and utilized properly
 *  Classes are well-designed
    *  State and interface make sense
    *  Encapsulation is respected
    *  Each member field has an appropriate type
    *  Each class properly models the entity it represents
    *  Constructors are appropriately defined and used
    *  Accessor (and maybe mutator) methods are properly implemented
 * Good SOLID principles
    * -5 to -10 if your `DataConverter` class violates the single-responsibility principle and is a "god class"
    * -5 for bad modeling (not defining a class when appropriate)
    * -5 for bad modeling (not using a class when appropriate)
    * -5 to -15 for breaking encapsulation depending on the severity
 * Points will not be deducted for the following, but:
    * Inheritance is not necessary for this phase, but it will be for the next; don't design yourself into a corner
    * You should prefer dynamic data structures, `List`s or `Map`s instead of arrays
    * You should prefer immutable objects *in general*; avoid setters

Correctness (50)

 *  Submitted JAR must contain code and artifacts and properly run on the webgrader
 *  All test cases properly execute and display correct output
 *  Output is valid and well-formatted

Test Case(s) (15)

 *  A valid, non-trivial test case has been submitted with the correct file names, is well-formatted, and correctly executes

Bonus/Honors Items (10 each)

 *  Both XML and JSON formats are used
 *  Test Case submitted 1 week prior to due date
