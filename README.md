# Based on Book Spring Start Here by Laurentiu Spilca
![](https://learning.oreilly.com/library/view/spring-start-here/9781617298691/)
![](/Users/adungao/Downloads/400w.jpeg)

The modules are based on the book Spring Start Here written by Laurentiu Spilca. It is an amazing book for Spring 
beginners.
This is a compilation of the exercises in the book while preparing for Spring certification. 
Maven is used for build dependency.

<!-- TOC -->
* [Book: Spring Start Here by Laurentiu Spilca](#book-spring-start-here-by-laurentiu-spilca)
  * [Chapter 1: Spring in Real World](#chapter-1-spring-in-real-world)
  * [Chapter 2: The Spring Context: Defining Beans](#chapter-2-the-spring-context-defining-beans)
  * [Chapter 3: The Spring Context: Wiring Beans](#chapter-3-the-spring-context-wiring-beans)
  * [Chapter 4: The Spring Context: Using Abstractions](#chapter-4-the-spring-context-using-abstractions)
<!-- TOC -->

## Chapter 1: Spring in Real World
## Chapter 2: The Spring Context: Defining Beans
Using @Bean annotation we are able to add an object to the context. Adding a bean in the context 
can be done programmatically as well using the registerBean method of the context object.

@Repository, @Component, and @Service are the stereotypes annotation available to define the responsibilty 
of the bean. The stereotypes is used to reduce code and improve readability.

## Chapter 3: The Spring Context: Wiring Beans
Spring context is a place where the framework manages objects. There are three approaches to establish bean relationship.
1. Directly referring bean method in the configuration
2. Referring to the bean name or bean id in the method parameter.
3. Using @AutoWire. You may annotate the field, the constructor, and setter methods.

@Primary and @Qualifier annotations are used if there are more than one bean of the same type.

## Chapter 4: The Spring Context: Using Abstractions
Decoupling is good for class design as it makes changes easy and without affecting too many parts of the application -
easy maintenance and extendable.

Decoupling can be achieved by the use of interface. When using abstraction on dependency injection, Spring knows to search
for bean created with an implementation of the requested abstraction.

@Primary and @Qualifier can be used if multiple implementation is available for the same abstraction.
Stereotype @Service, @Component, and @Repository separates the responsibility. @Component is used as default.