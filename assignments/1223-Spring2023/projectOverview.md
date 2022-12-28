# Computer Science II
## Project Overview
### Spring 2023
---

> If you don't have the time to do it right, then you'll have to find
> the time to do it over.

# Introduction

Over the course of this semester, you will incrementally build a
substantial database-backed application in Java. In each phase of the
project you will focus on a particular component, which will have
*deliverables* that you must hand in by a certain date. These
deliverables may include a Java Archive (JAR) file, source code,
non-trivial test cases, database schemas and a well-written technical
design document.

Each phase builds upon prior phases and may also require updates and
modifications to prior phases. It is important that you understand the
entire scope of the project. You should read all of the assignments to
get a better understanding of where the project will be going.

The iterative nature of this project means that it is *vital* that you
do not fall behind. In each phase it is also important that you have a
good, well-thought design to make subsequent phases easier to design,
extend and implement. Poor designs, bad implementations, bugs and broken
code will mean subsequent phases of this project will suffer. Investing
your time and resources upfront will minimize your *technical debt* and
mitigate the need to update or refactor your design later on. Remember
one of the Golden Rules of coding: only code that which you would not
mind having to maintain.

# Problem Statement

Pablo Myers has recently taken over the family business--FarMarT (or
FMT for short), a regional chain of B2B (business-to-business) stores
that sell farm equipment and supplies to farmers large and small.  The
business was built up by his father and unfortunately he never focused
on supporting the technology-side of the business.  Pablo has decided
that the first thing he wants to do is update all business operations
with newly developed systems for inventory, marketing, delivery and
sales.  Each system will be independently developed; it is your team's
responsibility to develop the sales subsystem that will be responsible
for keeping track of all sales in a database-backed system.  The system
will also be responsible for producing several different sales reports.

It will be your responsibility to design a new system from scratch that
is Object-Oriented, written in Java, and supports FMT's business model
by implementing their business rules and providing the functionality as
stated below.

FMT stores sell various items including farming equipment (which can be
purchased or leased), products (such as fertilizer, seed, etc.), and
contracts for services (plowing, harvesting, training).  Each type of
item will be identified by a unique alphanumeric code and a human-readaable
name.  There will be additional data associated with each specific type.

-   **Equipment** includes things such as tractors, balers, or trucks.  
    Each piece of equipment includes an alphanumeric model number.  
    Customers have the option of purchasing or leasing a piece of equipment.

    When purchased, there is a single purchase price that the customer
    pays.  In addition, no taxes are assessed on purchased farm equipment.

    However, when leased the customer signs a contract and agrees to pay
    a fee for every 30 day period.  The lease begins and ends on specific
    dates and the total charge is based on the number of days between the
    start/end date (inclusive on both days), prorated to the 30 day fee.

-   **Products** include things such as fertilizer and seed.  Each product
    is sold in quantities by a particular unit.  For example, fertilizer
    may be solid in liters while seed is sold in bags.  Each unit has
    a particular price (fertilizer at $10.25 per liter or seed at $50
    per bag).  

    When a customer purchases a product, they buy a certain quantity
    (always sold in whole number, so a customer is not able to buy 1.5
    liters of fertilizer for example).  The total cost is simply the
    quantity multiplied by the price per unit.

-   **Services** are services that a customer contracts with FMT
    (which may then subcontract with other companies; though that is
    a feature of a different subsystem).  Services are billed on a
    per-hour basis.  When purchased, a customer pays for a certain
    number of hours (which can be fractional) and so the total cost
    is the cost per-hour times the number of hours contracted.

The sales system will keep track of *invoices* which are a collection of
items purchased by a particular customer.  Each invoice
includes:

-   A unique identifying alphanumeric code

-   The date that the invoice was created

-   The customer (and their info) that the invoice is for

-   The store (and its info) that the sale was made at

-   The items that were part of the invoice (which may include equipment,
    products, and services).

Depending on the customer and items on the sale, various taxes
are also applied.

-   Equipment has no taxes when purchased.  However, when leased a flat
    tax is assessed based on the total cost of the lease.  For leases
    costing less than $10,000, zero tax is applied; for leases costing
    $10,000 but less than $100,000 a tax of $500 is applied; for all
    leases $100,000 or more, a tax of $1,500 is applied.

-   All products have a 7.15% sales tax

-   All services have a 3.45% service sales tax

**Note**: for all dollar values, the system will need to round to the
nearest cent.

# Project Outline

Over the course of this semester you will iteratively design an
application to support this business model. Development has been broken
down into 6 phases:

-   Phase I: Data Representation & Electronic Data Interchange (EDI) --
    in the first phase you will design and implement the objects that
    will form a basis for the system and create parsers to read data
    from flat files, generate instances of your objects and export them
    to an interchange format (XML and/or JSON).

-   Phase II: Summary Report -- In this phase you will further refine
    your objects and define relationships between them to generate a
    summary report that aggregates the data together.

-   Phase III: Database Design -- This phase focuses on designing a
    relational database to model your objects and support your
    application

-   Phase IV: Database Connectivity -- You will refactor your code to
    load your objects to your database rather than from flat files

-   Phase V: Database Persistence -- You will implement and use an API
    to persist (save) data to your database.

-   Phase VI: Sorted List ADT -- In this phase you design and implement
    a sorted list ADT and integrate it into your application

# Project Setup Requirements

To ensure that your projects will run on the webgrader you *must* adhere
to the following requirements and procedures. Failure to do so may make
it impossible to grade your project and you will not receive credit.

A full video walkthrough of the project setup and export process has been
provided here:

https://www.youtube.com/watch?v=lfGVthy2A14&list=PL4IH6CVPpTZXOMCZRaFy_WRc-GvANOZfk&index=4

## Setup Requirements (Eclipse)

-   You *must* include a `readme.md` (a markdown file) file at
    the root of your project with your name(s), cse login username(s), NUIDs and
    preferred email. If you choose to work in pairs, **both** names/contact
    info should be included.

-   All data files *must* be included in a directory named `data`
    at the root of your project.

-   Any external JAR libraries should be placed in a directory named
    `lib` at the root of your project. Your project should look
    something like the following.

    ![Your project setup should look something like this
    figure.](images/organization.png)

    To add external JAR files to your project do the following.

    1.  Drag and drop your JAR file to this folder, be sure to select
        "copy files"

    2.  Right click the new JAR file in your `lib` folder and
        select `Build Path` then `Add to Build Path`

-   Your `main` method *must* be in the package and class name
    specified by **each** assignment.

## Exporting Your Project (Eclipse)

To export your project for submission to webgrader, do the following:

1.  Run your program at least once, this creates a "Launch
    Configuration" in Eclipse

2.  Right click your project and select `Export...`

3.  Under the Java folder, select `JAR file`, click `Next`

4.  Be sure to check `Export Java source files and resources` and
    select the location where you want the JAR file saved. It should
    look something like the following.

    ::: center
    ![image](export.png)
    :::

5.  You can now click `Finish` and it should save the project as
    a JAR file which you will then turn in. The JAR file should contain
    all libraries, classes, source files and other data files necessary,
    but you should be sure it works by running the webgrader and
    addressing any issues.

# Partner Policy & Procedure

You may choose to work alone or with a single partner (i.e. *pairs*) for
each phase of the project. You may change partners between each phase if
you choose. If you do choose to work in pairs, **you must adhere** to the
following guidelines.

-   All work must be the result of an equal collaborative effort by each
    partner. You may not simply partition the work between you.

-   In order to work in pairs, you *must* join a group together in
    Canvas under "People" and then "Project Partners" group set. **Do not** create
    your own group set, use an existing one.

-   Turn in only one copy of the design document with both of your names
    on it.

-   Both of you *should* turn in an electronic copy of all artifacts using
    the webhandin, but ***we will grade based on the submission of the
    partner whose last name comes first alphabetically.***

-   You are *highly encouraged* to use some sort of revision control
    system such as git. However, you must ensure that your team's
    codebase and artifacts are not publicly accessible. Failure to do so
    will be considered a violation of the department's academic
    integrity policy.
