###intro
Hi, My name is Conor Redmond and this presentation
is a high level introduction to the MyBatis Persistence Framework.

### Is this for you  ?
This presentation will be of interest to you :- 
- if you are a Java Developer  
- writing applications that  access a relational database
- and think that the current approaches using JPA and JDBC are too complicated.


### Contents 
In this presentation we will :-
- provide a brief introduction to MyBatis 
- demonstrate how to build and use a simple MyBatis based Data Access Object (DAO)
-  examine some other features of Mybatis like Dynamic SQL  



###  What is MyBatis
The Purpose of Mybatis is to reduce the complexity of storing and retrieving data from a relational database .

 MyBatis  is a persistence framework that is built  on top of the JDBC API 
 but   hides away the the majority of the low level compexity you would encounter if working with JDBC directly
 
 
MyBatis is similar to Hibernate/JPA in that they both help simplify the interaction with the database
But where JPA takes an Object Centric approach and generates the SQL behind the scene ,
  MyBatis works by dealing with SQL directly and using some of the features of the SQL language specifically aliases to simplif.
W


###MyBatis Demo
This is all best illustrated by showing you some code. 
the code for the example shown next is available for download from github 
The link is here

###TODO  DEMO


If you'd like to try out some of the MyBatis code samples shown later in this presentation
I've created a sample project on github
that helps set up some of the prerequisites you'll need, such as
A Database
(we use a H2 in-memory embedded database for easier setup)
It comes with some the Database Table definitions, INSERT statements  
And everything else needed to be up and running quickly

### MyBatis Integration Options
When adding in MyBatiis to your own Application there are three main options.
Use the library directly,
use a mybatis-spring library, if you use the spring framework
or use a spring-boot starter package
the spring-boot option requires the least amount of configuration to get started
thats the option we use in the sample project for this presentation
More help on building with Mybatis can be found on the www.mybatis.org site.
along with the latest version numbers


### MyBatis Mapping Choices 
MyBatis provides two main approaches for mapping between Java objects and Database tables
For mapping relatively simple tables and queries, I typically use the @ Annotation option.
like the @Select annotation shown here.
For dealing with more complex tables
or if we want to use advanced features like Dynamic SQL
then I'd suggest the XML based mapping
We'll take a more in-depth look at both of these options next.
 
### @Select Annotation 
 
SQL comes with a built-in "alias" feature
that can map a column name to any label you want
Mybatis piggy-backs off this feature to provide the Object-Relational (OR) Mapping
For example in the SQL shown the database column "UNAME" has an alias "userName"
MyBatis reuses this same native SQL alias feature
to perform the mapping
from database columns
to fields in  Java objects
so when mapping the results of a SQL query into a Java Object, ...
the "ID" Column maps to the "id" field
the "UNAME" column maps the the "userName" field
and the "LNAME" column maps to the "lastName" field

### Groovy 
If you enable Groovy compilation in your project,
you can use the triple-quote feature
to paste in large SQL queries right into your code.
The sample project has an example of this.

### XML Mapping
XML based mapping is a little trickier
since the SQL statements are no longer co-located with our interface
but placed in a separate XML file.
There are three main parts to this
firstly a Book class is used to store the results of the findAllBooks() query
we had an interface , just like before used to define the DAO (Data Access Object) operations
whats differerent,  is that we have a new XML file which defines the mapping from database query  results to Java fields.

### Dynamic SQL
One reason for choosing the XML based mapping
is if you need to dynamically change the SQL at runtime.
An example of a situation where Dynamic SQL could be used
is for a Web Search form with a number of optional fields.
We can use the MyBatis <if> tags
to optionally include SQL predicates
when certain optional fields in the Java search form object are populated
In this case, depending on what fields were populated, we could have
three different SQL SELECT statements generated.
when a "first name" was included
or a last name
or both names

### Annotations vs XML
Given a choice between XML and Annotation based implementations, which should you choose?
My advice would be to use annotation based mapping where possible
as these are generally easy to write and understand.
If the queries you want to use are more complicated,
in that they require dynamic SQL or collections or nested-selects
then you'll need to use XML based mappers
which are more verbose but also more powerful.
The SQL centric approach adopted by MyBatis
has a number of advantages for the developer
which we'll take a look at in the next slides.

### Advantages

### Learning Curve
If comparing Mybatis to alternatives like JPA
one advantage over JPA is that
most developers already have some basic SQL skills
so it's very easy to jump into.
The 'alias' based mapping used by MyBatis is already built-in to SQL
Dynamic SQL is strightforward
mapping complex relationships between tables can be built on top of SQL's existing 'JOIN' feature.

### Complex Reports
MyBatis is especially handy to use if you have a lot of predefined SQL reports that you need to get into your Java application
Its' very easy to just paste your SQL in to an XML or annotation based mapper

### Debugging
When using JPA, the generated SQL it builds for you
can be hard to find
127	<UNT>
and even harder to understand.
But With mybatis you always have full visibility to the SQL used.
This can help avoid issues like the dreaded "N+1 selects" issue

###Performance
Sometimes there are specific features of your underlying database
that you need to access in order to maximize performance
For example you may need to use database specifc optimizer hints
or database specifc features for performance reasons

### Review 
- Intro 
- Demo
- 

### Conclusion 

We hope you've enjoyed this brief introduction to MyBatis


   
 ### ORM Mapping issue
The problems with moving data between Applications and a relational database
typically the field names, types and structures don't quite line up
and a developer often need to map from one domain to the other
some examples of simple mapping issues could be
differences between the database column names and the names of the fields in the java objects you're storing data in.
We also need to account for differences in the TYPE of the fields on the java and Database sides .


### Association issues 
More complex mapping issues can be seen
when comparing the structural differences between Tables and Java Object Graphs
In the java example above, the association between a parent Blog object and a child Comment Object
is a one way reference.
But when representing the same relationship in a Database Table using a foreign key
the association is a bidirectional relationship.

### Granularity 
Another  mapping issue occurs when there is a big difference in the granularity of structures between the Java and database sides
For example
a single "Address" class on the Java side
might be represented as multiple ADDRESS, STATE and COUNTRY tables on the Database side.
The main takeaway here is that mapping between these very different structures is hard
and any framework that helps simplify this  mapping, like MyBatis,  is a very good thing.
So, that's the problem...
Now lets take a look at the solution..




### MyBatis Design pattern
Before we delve into the code, lets take a quick look at the design pattern behind MyBatis.
MyBatis is an implementation of the "Data Mapper" design pattern.
as described by Martin Fowler in his book
"Enterprise Application Architecture"
A DataMapper, or more simply a Mapper
is a class that sits between
your domain objects and the database
and helps transfer data between them
Thats the theory, lets look at some examples next.
###
JPA tries to be database agnostic
which can make it harder to embed database specific features that you need to improve performance
MyBatis has no such barriers.
During this presentation we looked at some of the underlying reasons why Object-Relation mapping is hard.
Anything that makes that mapping easier is a good thing.
And MyBatis's trick of reusing the SQL 'alias'
allows you do do a lot of the mapping for free
while still having perfectly valid SQL
We saw that building Dynamic SQL and delivering pre-existing complex SQL reports
is something the MyBatis Excels at
and significantly easier than the JPA equivalents
we showed how the SQL centric approach used by MyBatis
makes it easier to get started
and can actually help with debugging and performance
We hope you've enjoyed this brief introduction to MyBatis
Thank You!
Pool 1