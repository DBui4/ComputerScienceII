# Computer Science II - CSCE 156/156H
## Spring 2022
### Object Oriented Programming


## Objects

### Creating and Designing Classes: Demo

* Java is a "class"-based object oriented programming language
* Everything in Java is a class or belongs to a class
* A `class` in Java:
  * allows you to model a "real world" object or idea or "entity"
  * allows you to *group* multiple pieces of data together into one logical unit
  * also allows you to *encapsulate* methods within the class that *act on* or *operate on* that class's data (ie functionality)
  * IE: it allows you to group functionality together with the data that it operates on
  * Java classes also allow you to *protect* data from outside of the class
* First demonstration: design a class that models a radioactive isotope

## Objects

* Formally an object is a general entity characterized by:
1. Identity: an aspect of the object that distinguishes it from all other instances
2. State: a collection of properties (elements, attributes, data, fields, *member variables*)
3. Behavior: the functionality of the object or what it *does* or the services it provides

* Communication between objects is done via "message sending": you invoke a method on an object and that object executes the code inside that method
* Communication is facilitated by the object's *interface*: the `public` methods that are available
* Objects are *constructed* rather than just assigned
  * In Java, by default a no-argument constructor is provided
  * If you define your OWN constructor, it goes away
  * You can always restore it by explicitly defining it
  * You can define as many constructors as you wish to make your objects more usable
* Common patterns:
  * Copy constructors that take another instance of the object and make a deep copy
  * Partial copy constructors: copy constructors that take an object and other values to make a (partial) copy of the object
* Object design:
  * "Semantics dictate design"
  * Don't over-design: YAGNI = You Aint Gonna Need It
  * You break real-world objects or ideas into smaller and smaller parts until...
    * It is direclty representable OR
    * An object already exists for it
* Generally your objects are *composed* of other objects or data
  * When an object "owns" an instance of another object it is called "composition"
* Avoid the "god-antipattern": a class should only know about its own stuff, it should not *know everything, do everything, be everything*

## Four Pillars:

* Abstraction
* Encapsulation
* Inheritance
* Polymorphism

## Abstraction

* Implementation or "information hiding"
* You shouldn't have to worry about how an object is represented, just how to use it (its interface: its publicly facing methods)
* Ex: how does `LocalDate` represent an actual date?
  * 3 integers: year/month/day
  * String: ISO 8601 standard
  * A single number: number of milliseconds since an epoch (unix epoch: Jan 1, 1970)
  * Answer: who cares?
* How does Java represent a `String`?

## Encapsulation

Usually is comprised of three things:
1. The grouping of data into one logical unit
2. The protection of data from the outside world
3. The grouping of methods (behavior) that act on that data

* Don't break encapsulation by locating data or methods that act on that data outside the class
* Bank stuff belongs in the `Bank` class, not the `main` or `Demo` class
* Student "stuff" belongs in the `Student` class
* Good abstraction and encapsulation work together to make code:
  * Isolated
  * More easily testable
  * Control/limit "side effects"
  * Reusable

## Inheritance

Scenario: a retail store sells products and subscription
services.  Products are items that have a price and a
customer may purchase any number of them (ex: USB memory stick).
Subscriptions have an annual rate and are purchased based
on the start date and end date.

* Inheritance allows you to reuse a class by `extends`ing it and creating a *subclass*
  * Common functionality and state/behavior is located in the `super` class
  * Specific behavior/specialization is provided or *overridden* in the subclass
* If a class $A$ `extends` a class $B$:
  * $A$ is the subclass, $B$ is the superclass
  * $A$ is the child class, $B$ is the parent class
* Inheritance defines an "is-a" relationship
* A subclass *is-a* (an) instance of its superclass:
  * Robin is a Bird (covariance)
  * Bird is not necessarily an Ostrich (contravariant)
  * Never safe: invariance you cannot make a Robin into an Ostrich
* One thing you *can* use is `instanceof` (but should probably not unless absoutely necessary)
  * Generally you only use this with constructors (copy constructors)
* Motivation:
  * Provides a way to *reuse* code, avoid repeating code (by placing in the super class)
  * Provides a way to *organize* code
* If you have a class that is not well-defined, make it `abstract`
  * `abstract` classes may have state and methods
  * `abstract` classes may have `abstract` methods: methods that do not have a body but force subclases to specify behavior
  * With `abstract` classes you can prevent someone from creating instances of them
* Sometimes you want to *prevent* subclassing
  * You make your class `final`
  * You can also make a method `final`: it prevents any subclass from overriding that method
  * By default in Java, all methods are "virtual": they *can* be overridden in the subclass
  * By placing `final` in front, they are no longer virtual, they are non-virtual
* A *pure* abstract class is one in which NO functions are defined, ie all functions are `abstract`
   * in Java, you would use an `interface`
   * This allows you in Java to `implements` an interface and more so...
   * In Java you can only `extends` on class (single inheritance hierarchy) but
   * you can `implements` multiple interfaces

### Pitfalls

* Some languages support *multiple inheritance*: you can inherit or "extend" from multiple classes (not interfaces)
  * Java is not one of them
  * C++ does allow this
  * Diamond Problem:
  * Cat, Dog are both Animals
  * Create a class `CatDog` that inherits from *both* a `Cat` and a `Dog`
  * The inheritance is ambiguous, not well-defined
  * Java avoids this by forcing a single-inheritance hierarchy: you can only `extends` one class!
* Antipattern: yo-yo problem
  * Inheritance hierarchies should generally be shallow
  * Deep heirarchies mean you are always looking up and down the chain to identify state/behavior
* Antipattern: Rectangle Problem


## Polymorphism

* Polymorph: poly = many, morph = form => many forms
* Code: a variable, method, or class may be generically programmed so that it can apply or be used with/on many different types
  * C: you have a single `qsort()` function: it is generic and can be applied to any type
  * In Java: polymorphism appears in many different forms

### Subtype polymorphism

* When you use inheritance, you can treat a *subclass* as an instance of its superclass
* examples
```java
Bird b = new Robin();
List<Integers> numbers = new ArrayList<>();
Collection<Integer> otherNumbers = numbers;

```

### Function Overloading

* When you use inheritance and change the behavior of a method in a subclass it is called *overriding*
* Overloading does not involve inheritance
* In C: how do you compute the absolute value of a variable?  `abs(), fabs(), llabs(), labs()`
* Overloading of functions means that you can define multiple functions with the same name but with different types (and which may have different code)
* Java: `Math.abs()`
* At compile time the compiler is smart enough to deduce which function you actually meant to call
* This mechanism is known as "static dispatch"
* as long as the number of type of parameters is different, the function is different and the compiler is able to determine which one you mean by looking at the input parameters

### Operator Overloading

* In Java: `String + String`: means concatenation
* In Java: `int + int`: means addition
* In Java: `String + int`: means concatenation
* An operator can have multiple meanings depending on the types you apply it to
* In C: no operator overloading; everything has one and only one meaning
* In PHP: no operator overloading
  * `string + string`: convert both strings to numbers (if you can) and add them
  * `int + int`: addition
  * `string + int`: convert the second to a string and add
  * concatenation: `string . string`
* Python:
  * `string + string` concatenation
  * `int + string`: throws an error
  * `int + int`: addition
* C++:
  * wild wild west, YOU can redefine any operator that you want!
  * `Date + Date = ?` (who knows)
  * `Duration + Duration = Duration`
  * `List + List = ?` append the second to the end of the first; OR: vector addition; OR minkowski sum (??); throw an error
  * `Set + Set` = union, multiset conversion, etc.
* Ultimately, using operator overloading is not very good practice
  * Depending on the language/context it could be confusing or ill-defined
  * In any case, to define what an operator does, you need to write a function anyway!
* Java does not allow user-defined operator overloading (good thing); but does have some limited operator overloading

## Parameterized Polymorphism

* Java allows you to use a parameterized class, method or variable

```java
List<Integers> numbers; //only holds integers
List<Product> products; //only holds products

int x; //x is an integer, but its value is *variable*

//the following type of declaration means that
// both the variable and its type can vary:
T a;

```

* PECS: Producer Extends, Consumer Super
  * A collection (list, set) is a *producer* of elements; if you wish to pull them out and do something with them, then you need a "named" parameter: `<T extends Item>` (`T` is the name
    of type type being used)
  * A collection is a *consumer* of elements if you wish to put stuff in: `<? super Item>`: if you don't care about what is in the collection alrady, you can simply use `Item`


```text









```