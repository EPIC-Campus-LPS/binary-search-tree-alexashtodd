# Binary Search Trees

## Objective
In this lab, you are to implement several methods for a binary search tree. You will also implement a console program 
that will allow you to test your methods for your search tree efficiently. 

## Creating a BST
Your final BST class should have the following methods:
- `void add(E value)`
- `boolean contains(E value)`
- `int countNodes()` //returns the number of nodes in the tree
- `int countLeafNodes()` //returns the number of leaf nodes in tree
- `int getHeight()` //returns the longest path from the root to a leaf node
- `void printInorder()`
- `void printPreorder()`
- `void printPostorder()`
- `E delete(E value)` //returns the deleted node

## Console Program
The console program should allow the following options:
1. Fill the tree from a file
2. Add a value to tree
3. Delete a value from the tree
4. See if tree contains a value
5. Test traversals (pre, in, post)
6. Print stats (nodes, leaf nodes, height)
7. Clear the tree
8. Exit Program

## Testing
You may assume the file to be read will contain only integers. (You may ask the user which it is before you build the tree.) The file will have all the data listed one at a time, each on a new line. If the user enters an invalid entry for the menu, the program will prompt the user for a valid menu entry.

Please create JUnit tests with 85% coverage for your program.

## Javadoc
Add Javadoc comments and generate a Javadoc HTML reference for your program.

## Rubric

**Rubric**

*Course Content*

- 6 points - All required items are present.
- 5 points - Task was completed, but supplementary materials are weak or missing.
    - Code was uncommented.
    - Solution is correct but is significantly difficult to read, highly inefficient, very clumsy, very difficult to extend etc. From the original Jargon File, we would refer to solutions like this as *kluge*.
    - Reflection questions related to content were incorrect.
- 4 points - Task was attempted, but is missing major components.
    - Coding prompt was only partially completed
    - Some deliverables are missing
- 3 points - Did not attempt or student should reattempt.

*Workforce Readiness*

- 4 points - Exemplified  WFR standards
    - Language is professional.
    - Work is clear and easy to read.
    - Used deductive reasoning guide solution.
    - Reflection on own work was thoughtful and honest.
- 3 points - Practiced WFR standards
    - Language is readable but not professional.
    - Work is understandable but not completely clear.
    - Reflection on own work was weak.
    - Citations were not complete.
- 2 points - Developing WFR standards
    - Work is unprofessional. Significant spelling or grammar errors.
    - Did not attempt or student should reattempt.


---
# Style Guidelines
## Lab 6: Style Guide

### Comments

The expectations for Javadoc comments are the same as the previous lab.  [Here is the IntelliJ  documentation](https://www.jetbrains.com/help/idea/javadocs.html) again if you need more information. In addition to Javadoc comments, your code should include regular comments to explain anything that is not immediately obvious.

# Data Structures Style Guide

In this course, we will not only practice writing code but how to write good code. Learning how to write good code  includes a number of stylistic conventions. As we move further into the course, the expectations for appropriate  style and documentation will become more extensive as we continue to practice. It is expected that you keep the style  guidelines introduced in previous assignments in mind during the current assignment. This document will include a generic introduction to aspects of style relevant to this class in addition to specifics regarding this assignment.

## Types of Style Guidelines

There are six main categories of guidelines to look out for during this course.

### Formatting


Formatting refers to the way code is structured. This includes indentations, brackets, and whitespace. Using clear and  consistent formatting throughout makes writing and reading code easier. It is even more important when multiple people  are working on the same program. In IntelliJ, there are built-in formatting rules which you can apply by:

- Going in the _Code_ menu and selecting _Reformat Code_.
- Using the keyboard shortcut, which by default is Ctrl+Alt+L on Windows and Opt+Cmd+L on Mac.

### Comments

Comments are statements of code that are not executed by the compiler or interpreter. We use them to explain what  different pieces of do. Regardless of the complexity of the program, commenting all of your work appropriately is a good  habit to get into.

In general, your comments should:

- Be concise: only write as much as is necessary to convey relevant information
- Help the reader: write them with the intention of a third party using them to understand your code, especially if it  is not immediately obvious
- Break the code into smaller units: Comments help separate code at logical breaks like the beginning of a loop, a new  step in a larger calculation, or at the beginning of a function

Commenting can be used as part of an effective code writing strategy as well. Instead of commenting after the code is  written, try commenting before writing the code. By breaking down your program logically into smaller chunks and then  working on those small chunks individually, you can avoid some bugs and logical errors

#### Javadoc

Javadoc is a tool that generates Java code documentation in the HTML format from Java source code. The documentation is  formed from Javadoc comments that are usually placed above classes, methods, or fields.
### Naming

Naming variables, constants, functions, and classes is key to writing good code. Names should help the reader understand  what is going on in your program.

In general, names should be:

- Accurate and informative: Names should reflect the contents or purpose of the entity as much as possible
- Concise: Names should be as concise as possible without sacrificing the above bullet point too much. It's a balance.
- Consistent: Use consistent names and naming conventions throughout your programs. See the section below for more  information about Java-specific conventions.

#### Java Conventions

In Java there are a few different conventions programmers use.

- For variables and functions, we will typically use camelCase
- For constants, we use CAPS_SNAKE_CASES
- For files, we use UpperCamelCase

### Maintainability

Maintainable code is easy to work on, update, and change without the original author needing to be present.  Maintainability is a broad catch-all category for other aspects of good code that make it easy for you and others on  your team to work on and debug code.

### Efficiency

It is important to not only write code that is correct, but efficiently uses resources (primarily memory and time). We  will talk about this more extensively later in the course, but is something to keep in mind. Efficient code is  increasing important as we write code to handle larger and larger inputs.

### Concision

Your code should be as concise as possible without sacrificing readability. Just like with commenting, this is a  balance.  
