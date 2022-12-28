# Computer Science II
## Assignment 3 - Project Phase II
## Summary & Detail Report
### Spring 2023
---

# Introduction

In the previous phase you began initial work to support a sales
management system for FarMarT. In this iteration, you will
continue to design classes to support the application as well as modify
and extend your previous design to add functionality. In this phase
we will add functionality to our classes from Phase I and design new
classes to complete the core functionality of the system. You will
integrate all of your classes to produce several reports:

1. The first report will give a summary of *all* sales along with
   a few totals.

2. The second report will give a similar summary but for *each* store.

3. The final report will give details for each individual invoice.

# Data Files

The data files for persons, stores, and sale items are the same as in
Phase I. Two new CSV data files are used in this phase to model invoices
and items on each invoice.  As before, you may assume that all data is valid and
properly formatted and all data files are named as specified.

## Invoice Data File

Data for all invoices is contained in the file `data/Invoices.csv`. The
first line contains a single integer indicating the number of records in
the file. Each subsequent line contains the following data, separated by
commas.

-   Invoice code -- An alphanumeric code used to uniquely identify
    the invoice.

-   Store code -- an alphanumeric code corresponding to the store that
    the sale took place at

-   Customer code -- an alphanumeric code corresponding to the person
    who made the purchase

-   Salesperson code -- an alphanumeric code corresponding to the person
    who made the sale

-   Invoice date - the date of the invoice (in the format `YYYY-MM-DD`)

An example (also provided in the same directory as the previous phase's data
files):

```text
4
INV001,3c0234,fdc267,8197d3,2022-12-01
INV002,73668b,aa887a,8197d3,2022-11-03
INV003,9f352c,aa887a,f22d0b,2022-11-15
INV004,3c0234,529dbe,d78da4,2022-12-21
```

## Invoice Item Data File

Data for all items on invoices is contained in the file `data/InvoiceItems.csv`. The
first line contains a single integer indicating the number of records in
the file. Each subsequent line contains the following data, separated by
commas.

-   Invoice code -- the alphanumeric code corresponding to the invoice the item
    is on.

-   Item code -- the alphanumeric code corresponding to the item (equipment, product,
    service).  Depending on the type of item, the remaining tokens will vary.

    -   For equipment, the next token will either be a `P` (for purchase) or
        `L` for lease.  If it is a purchase, the next token will be the purchase
        price of the item.  If it is a lease, there will be three tokens:
        the 30-day fee, the start date and the end date of the lease.  The date
        formats will be `YYYY-MM-DD`.

    -   For products, the next token will be the quantity purchased.  

    -   For services, the next token will be the number of hours billed

An example; note that this is for a single invoice (id: `INV001`), but the
CSV file will contain data for *all* invoices and will not necessarily be in
any order.

```
4
INV001,1d4d89,P,85000
INV001,3506f6,L,3500,2022-01-01,2022-12-31
INV001,n3453js,158
INV001,n43k2l3,3.5
```

## Full Example

Using the example above, invoice `INV001` contains 3 items.  The item
codes can be found in the previous assignment's example.

* Item `1d4d89` is equipment: Tractor (model MegaTract 150HP) that is purchased.  
  The purchase price is $85,000 and there is no tax associated with it.

* Item `3506f6` is equipment: Backhoe (model BidDoug X25) that is leased.
  The dates from `2022-01-01` to `2022-12-31` correspond to 365 days.  
  At $3,500/30 days, that's $$3,500 \cdot (365/30) = 42583.3333333$$ but
  rounded to the nearest cent costs $$42,583.33$$.  As a lease, this falls
  in the second tier and so a $500 tax is also applied.  

* Item `n3453js` is a product: fertilizer sold by the liter.  The invoice
  purchases 158 liters and so the total cost is $$158 \cdot 10.25$$ which
  is $1,619.50.  A 7.15% tax is applied for a total tax of
  $$0.0715 \cdot 1619.50 = 115.79425$$ and rounded to the nearest cent is
  $115.79.

* Item `n43k2l3` is a service: plowing, billed for 3.5 hours for a total of
  $$1000.00 * 3.5 = 3500$$ and a tax of $$3500 \cdot 0.0345 = 120.75$$.

* The subtotal of all items is $132,702.83

* The total tax is $736.54

* The grand total is $133,439.37

# Requirements

You will be required to design Java classes to model the system and
functionality as specified and hold the appropriate data. The classes
you design and implement, what you name them, and how you relate them to
each other are design decisions that you must make. However, you should
follow good object oriented programming principles. You should make sure
that your classes are designed following best practices.

Your program will load the data from all the data files, construct (and
relate) instances of your objects, and produce the 3 reports and output
them to the standard output.

Formatting details are left up to you but your reports should be
readable and communicate enough information to verify that your code is
correct and that you've followed all requirements and specifications.
Your report ***needs to output at least as much information*** as the
webgrader's expected output. An
example has been provided but you are free to make it prettier, use
alternate formatting, and are encouraged to communicate even more details
if you wish.

# Design Process

You have some flexibility in how you design and implement this phase of
the project. However, you must use good OOP practices. You should
non-trivially demonstrate the proper use of the four major principles:
inheritance, abstraction, encapsulation, and polymorphism. When thinking
of your design, keep the following in mind.

-   What should the public and private interface of each of the classes
    be? Don't make them simple data containers--what methods (behavior
    or services) should each class provide?

-   Think about the state and methods that are common and/or dissimilar
    in each of your objects. What would be an appropriate use of
    inheritance and which methods/state are specific to subclasses?
    What, if anything should the subclasses define or override?

-   What classes should own (via composition or some other method)
    instances of other classes? How are complex relationships made
    between objects?

-   Think about how to utilize polymorphic behavior to simplify your
    code. You should not have to handle similar objects in a dissimilar
    manner if you have properly defined a common public interface.

Object-oriented design is fundamentally different from a top-down
procedural style approach that you may be used to. Rather than breaking
a problem down into sub-parts, we instead do a bottom-up design. We
*first* identify the entities and design classes that can be used as the
building blocks to implement a larger application. You are highly
encouraged to completely understand the problem statement and have a
good prototype design on paper before you write a single line of code.

## Testing

You are expected to thoroughly test and debug your implementation using
your own test case(s). To ensure that you do, you are required to design
and turn in at least one non-trivial test case to demonstrate your
program was tested locally to some degree. Ultimately your application
will be tested on multiple test cases through webgrader. However,
webgrader is not a sufficient testing tool for you to use; you don't
have access to the test cases, nor can you debug with respect to it.

Understand what a test case is: it is an independent input-output that
is known to be correct using a method independent of your program (say,
calculated by hand). You must provide your test case one week prior to
the due date along with your design document draft. We will use these
test cases when grading other assignments, so be adversarial: design
test cases to probe and break "bad" code, but stay within the
requirements specified above.

# Artifacts -- What you need to hand in

-   Your program *must* be runnable from a class named
    `InvoiceReport.java` which *must* be in the package
    `com.fmt`

-   Your input/output test case files *must* be in a `data`
    directory in your project when you hand it in.

-   You must follow the instructions for how to build your project as a
    single JAR file in Appendix B of the Project Overview document.
    Name your JAR file `Project.jar`

-   In addition, you will be writing a design document. The first draft
    of this document is due 1 week prior to this assignment.

# Common Errors

Some common errors that students have made on this and similar
assignments in the past that you should avoid:

-   Design should come *first*--be sure to have a well-thought out
    design of your objects and how they relate and interact with each
    other *before* coding.

    -   OOP requires more of a bottom-up design: your objects are your
        building blocks that you combine to create a program (this is in
        contrast with a procedural style which is top-down)

    -   Worry about the design of objects before you worry about how
        they are created.

    -   A good litmus test: if you were to delete your driver class, are
        your other objects still usable? Is it possible to port them
        over for some other use or another application and have them
        still work without knowledge of your driver program? If yes,
        then it is probably a good design; if no, then you may need to
        reconsider what you're doing.

-   Objects should be created via a constructor (or some other pattern);
    an object should not be responsible for parsing data files or
    connecting to a database to build itself (a Factory pattern is much
    more appropriate for this kind of functionality).

-   Classes (at least not all of them) should not be mere data
    containers: if there is some value of a class that depends on
    aggregating data based on its state, this should be done in some
    method, not done outside the class and a field set (violation of
    encapsulation--grouping of data with the methods that act on it). If
    a value is based on an object's state and that state is mutable,
    then the value should be recomputed based on the state it was in at
    the time that the value was asked for.

-   Classes should be designed as stand-alone, reusable objects. Design
    them so that they could be used if the application was changed to
    read from a database (rather than a file) or used in a larger
    Graphical User Interface program, or some other completely different
    framework.

# Rubric (150 points total)

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

Design (75)

  *  Classes are implemented and utilized properly
  *  Classes are well-designed
  *  Proper use of Encapsulation
    *  Related functionality and data are properly grouped in associated classes
    *  Each member field has an appropriate type
    *  Each class properly models the entity it represents
    *  Constructors are appropriately defined and used
    *  Accessor (and maybe mutator) methods are properly implemented
  *  Proper use of Abstraction
    *  Classes have non-trivial methods and are not just data containers
    *  Use of a class does not require knowledge of its internal state
  *  Proper use of Inheritance
    *  Hierarchy of inheritance makes sense, not over-engineered
  *  Proper use of Polymorphism
    *  At least 1 instance of polymorphic behavior

Correctness (50)

  *  Submitted JAR must contain code and artifacts and properly run on the webgrader
  *  All test cases properly execute and display correct output
  *  Output is valid and well-formatted

Test Case(s) (15)

  *  A valid, non-trivial test case has been submitted with the correct file names, is well-formatted and correctly executed

Bonus/Honors Items (10 each)

  *  Summary report prints in order of invoice total (highest to lowest) *and*
     store summary report prints in order of manager's last name/first name, *then*
     by invoice total (highest to lowest)
  *  Test Case submitted 1 week prior to due date
