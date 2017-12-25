CodingChallenge02-RoundTable Version 2.0 24/12/2017

--------------------
Describe the problem
--------------------
N children stand around a circle.
Starting with a given child and working clockwise, each child gets a sequential number,
    which we will refer to as it’s ID.
Then starting with the first child, they count out from 1 until k.
The k’th child is now out and leaves the circle.
The count starts again with the child immediately next to the eliminated one.
Children are so removed from the circle one by one. The winner is the child left standing last.
Write a static method on a new class, which,
    when given n and k,
    returns the sequence of children as they go out,
    and the id of the winning child.
Create any additional classes, tests, etc, you need to support the design of your solution.

-----------------
Analysing problem
-----------------
Create a table with given number of children (N) and skip number (k)
Identify the k'th child and then remove the child
Keep continuing playing until there is only one child
Store the sequence of children ah they go out
Store the id of the winning child

-------------
Prerequisites
--------------
What things I need to install the software and how to install them



----------
Installing
----------
A step by step series of examples that tell you have to get a development
 environment running


-----------------
Running the Tests
-----------------
Explain how to run the automated tests for this system
The TDD approach is used to build the solution


----------
Deployment
----------
Add additional notes about how to deploy this on a live system



-----------------------
Build With
-----------------------
- Web framework used
- Dependency Management



----------
Versioning
----------
Current version is 2.0
Repository in GitHub: https://github.com/NgoMing/CodingChallenge02_version_02.git