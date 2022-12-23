# Algorithms 4th edition
This repo is the solution of some exercises of the book [Algorithms](https://github.com/jonathanperezdev/Knowledge-Base/blob/main/Books/Algorithms/Algorithhms%20-%20Robert%20Sedgewick%2C%20Kevin%20Wayne-%204th%20Edition%20-%202011.pdf)

## Section 1 Fundamentals
### Chapter 1.3
#### Exercise 1.3.10 Infix to Postfix
In this exercise you receive an infix expression, and you have to return a postfix expression

**You need**
* A String variable, it will be the output postfix expression
* Stack (Last In First Out) to store operators and left parenthesis (

**The steps are**
1. You have to read the infix expression from left to right (for)
2. If you find a number, you put that number in the output variable
3. If you find a (, push it to stack
4. if you find a ), pop the operators stack until you find a (
5. If you find any operator, validate if this operator has <= precedence of the stack operator, add the spack operator to the postfix output expression

#### Exercise 1.3.11 Evaluate Postfix Expression

**You need**
* Stack (Last In First Out) to store numbers

**The steps are**
1. You have to read the postfix expression from left to right (for)
2. If you find a number, you put that number in the Stack
3. If you find an operator, pop two numbers from the Stack and push the result to the same Stack
