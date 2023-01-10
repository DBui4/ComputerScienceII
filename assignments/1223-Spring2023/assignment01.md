# Computer Science II
## Assignment 1.0
### Spring 2023

# Overview

In the first assignment, we'll focus on getting used to your new language
(Java or python) by doing some simple standalone programs.  Follow
instructions **carefully**, failure to do so may result in
points being deducted.  

* For this first assignment, all work must be your own, no partners or
  collaboration with other student(s) is allowed.  However, you may
  discuss problems *at a high level*.  The School of Computing's
  Academic Integrity Policy is in effect: <https://computing.unl.edu/academic-integrity-policy>

* Hand in all your source files and other artifacts through the webhandin
  and verify your programs are correct by running the webgrader.  

* **For those in the main section(s)**: your programs must be
  written in Java, should accept command line arguments as specified,
  and execute successfully on the webgrader.  All your classes should
  be in the *default package* and your source files should have the
  following names: `Corn.java, Cheer.java, WeatherData.java`

* **For those in the honors section**: your programs must be written
  in python (unless you have no prior Java experience, in which case,
  you should do the Java version), should accept command line arguments
  as specified, and execute successfully on the webgrader.  Your source
  files should have the following file names: `corn.py, cheer.py, weather_data.py`

## Exercise 1: Corn Silo Estimator (25 points)

Write a program to help farmers estimate the weight of corn stored
in cylindrical silos.  Each silo's dimensions are measured in radius $r$ and
height $h$ in meters.  For the purposes of this exercise, you can assume silos
are perfect cylinders whose volume (cubic meters, $$m^3$ ) is computed as

$$h \times \pi \times r^2$$

The amount of corn stored in a silo is reported as a *percentage* $p$ of the
silo's capacity (0% to 100% on the scale of [0, 1]).  The total weight of corn
can be computed using the estimate of 720.83 $kg/m^3$

For example, a silo that has a measure of radius $r = 5$ meters, height
$h = 20$ meters and is 35% (.35) full would have

$$\pi (5)^2 \cdot 20 \cdot .35 = 549.778714378$$

cubic meters ($m^3$) of corn which would have a total weight of
$396296.990685$ kg.

Write a program that reads in the above measures ( $r$, $h$, and $p$; radius
height and percentage respectively) as **command line arguments** and outputs
both the total number of cubic meters of corn as well as the total weight
estimate.  For example, if we ran your program with `5 20 0.35` as arguments,
it would produce output that looks something like:

```text
Radius: 5m
Height: 20m
Percentage: 35.00%

Total Volume: 549.778714 m^3
Total Weight: 396296.990685 kg
```

## Exericse 2: Husker/Maverick Cheer (25 points)

Write a program to solve the following variation on the classic "fizz buzz"
problem.  Your program will implement a series of functions/methods that
take a list of integers and process each integer as if it were a "score".
It will award it to either the huskers team or the mavericks team
according to the following rules:
  - if it is divisible by 3 it should be awarded to the huskers
  - if it is divisible by 5 it should be awarded to the mavericks
  - if it is divisible by both 3 *and* 5 it should be awarded to *both* "teams"
  - otherwise ignore it (it is not given to either team)

For the Java version, we have provided a starter file with specific instructions
written in the documentation.  We have also provided a junit starter file that
has several test cases already written.  In addition to implementing all methods
as specified, you will be required to *add* additional test cases to the junit
testing suite.  Specifically, you need to add at least 3 valid test cases *for
each method* you need to implement.  

For the Python version, we have provided a starter file with specific instructions
written in the documentation.  We have also provided a `unittest` starter file that
has several test cases already written.  In addition to implementing all methods
as specified, you will be required to *add* additional test cases to the `unittest`
testing suite.  Specifically, you need to add at least 5 valid test cases *for
each method* you need to implement.  

## Exercise 3: Weather Data (50 points)

Two weather stations periodically take temperature data samples.  Each
data point consists of a date-time stamp as an ISO 8601 formatted string
(example: `2016-11-03T12:01`) and a temperature (example: `76.2`).  Data from
the two weather stations is stored in two data files with the
following format: the first line is an integer indicating the total
number of data samples in the file.  Each subsequent line is
the date-time stamp and a temperature value separated by a space.  
An example:

```text
5
2017-01-01T02:00 -24.92
2017-01-01T04:00 -26.70
2017-01-01T00:00 32.78
2017-01-01T03:00 -25.40
2017-01-01T01:00 18.97
```

The data is ***not necessarily in any order*** in the data files.

Your program will read in data from two files (we'll refer to them
as data set A and data set B) whose path/names are provided as
*command line arguments* and generates the following reports:

1. For the data in data set A, report the minimum, maximum and mean
temperatures.

```text
Temperature Reports (dataset A)
-==-==-==-==-==-==-==-==-==-==-==-
Minimum: -43.170000
Mean:    -1.686596
Maximum: 46.520000
```

2. For the data in data set A, report the earliest available (by date)
data point and the most recent data point.  Your
report should look *something* like the following.

```text
Date Reports (dataset A)
-==-==-==-==-==-==-==-==-==-==-==-
Earliest:    32.780000 (2017-01-01T00:00)
Most recent  -4.450000 (2017-01-02T23:00)
```

3. Inconsistent/Missing Data Reports.  The final report will compare
the two data sets and report any *inconsistencies* or *missing data*.  
In particular:

- Report any data point in data set A that is *missing* in data
  set B (a data point is missing if the date/time stamp record is
  in A but is not in B).
- Report any data point in data set A whose corresponding data
  point (by date) in set B has a temperature that is off by more
  than 0.001 degrees.

Your output should look something like the following.

```text
Inconsistent/Missing Data Reports
-==-==-==-==-==-==-==-==-==-==-==-
Inconsistent Data:  32.78 vs 32.90 (2017-01-01T00:00)
Missing Data:       14.43 (2017-01-01T08:00)
```

An test case example has been provided in this repository.
The actual data may consist of **millions of data points**.  You will
***NOT*** be able to solve this problem with a brute-force approach
(comparing all possible pairs of data).  You will need to use
efficient searching and sorting techniques.  

# Installing and Using JUnit 5 in Eclipse

## Installing

First, we need to add the JUnit library to your project.

1. Right-click your project in the Project Explorer
2. Select "Build Path" and then "Add Libraries..."
3. Select JUnit then "Next"; make sure to select JUnit 5 and click "Finish"

You should be able to copy any provided JUnit source code
into your project now.  

## Using JUnit

To run a JUnit test suite, simply open the testing file and hit the
"play" button as you would a normal program.  Eclipse will
automatically compile a report of the number of tests passed or
failed along with any messages provided for failed test cases.

Note that there is no `main` method in a JUnit test suite.  Instead,
JUnit uses "reflection" to automatically find unit tests (methods
identified by the `@Test` annotation) and run them.  

## Optional Items

### Manually Installing

If for some reason JUnit 5 is not available as an option, you can download
and install it manually in your project.  

* On the JUnit website, https://junit.org/junit5/ click the "Platform" tag
  under the "Latest Release" section
* Click the download icon for "junit-platform-console-standalone" and select
"jar" (this should download a file named `junit-platform-console-standalone-1.7.0.jar`)
* Create a `lib` folder in your Eclipse project and drag/drop/copy the downloaded
jar file to this directory.
* Right click the copied jar file and select "Build Path" and then "Add to Build Path"

### Project Setup

In larger Java projects it is typical to keep source code and
testing code in separate locations.  With JUnit this is usually
done by putting source code in a `src/main/java` folder and JUnit
test code in a `src/test/java` folder.  In addition, JUnit tests are
usually located in the same package structure as the classes
they are testing.

To setup your Eclipse project this way:
1. Right-click your project and select "Build Path" and select "New Source Folder"
2. Create the source folder `src/main/java` (repeat this for `src/test/java`)
3. Move any code you might have had in the original `src` folder to the appropriate new folder

# Rubric

Each exercise will be graded based on the following items.  However, exercise
three will have a total of 41 correctness points.

## Style (2 pts)

-   Appropriate variable and function/method identifiers

-   Style and naming conventions are consistent

-   Good use of whitespace; proper indentation

-   Clean, readable code

-   Code is well-organized

## Documentation (2 pts)

-   Well written comments that clearly explain the purpose of each
    non-trivial piece of code

-   Comments explain the "what" and "why"

-   Comments are not overly verbose or overly terse

-   Code itself is "self-documenting"; it explains the "how"

## Program Design (5 pts)

-   Code is well-organized and efficient

-   Code is modular; substantial pieces of it could be reused; few
    redundancies

-   Code is easily understood and maintainable

-   It is clear that sufficient testing has been performed

-   Corner cases and bad input have been anticipated and appropriate
    error handling has been implemented

## Program Correctness (16 pts)

-   Source code compiles and executes as expected

-   Program runs as specified: correctly reads any input; correctly
    formatted output

-   Test cases successfully execute
