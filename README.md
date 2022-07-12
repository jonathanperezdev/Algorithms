# Algorithms
Repository with solution of algorithms practice to interviews

## Problem 1 - Count words in a sentence (NumberOfWords.java)
### Defining the problem
In this exercise you have a sentence, and you have to count how many times a word is present

```
Example

El papa de mi papa no es mi papa

El 1 papa 3 mi 2 ...
```

### Solution
To solve this problem, I use the new feature of maps implemented with the merge method, you can find the solution in NumberOfWordsImp class

## Problem 2 - Get Statistics of Job Executions (JobStatistics.java)
### Company: Hulu 
### Defining the problem
A job has a name and one or more instances. Each instance has a globally unique ID number. Given this list of input lines:

```
Started name=dump_logs jobid=f863
Started name=dump_logs jobid=g301gas

Ended jobid=f863 time=1021
Started name=grep_logs jobid=ac3de
Ended jobid=g301gas time=1343
Started name=read_logs jobid=r0eas

Started name=write_logs jobid=dg2dz
Ended jobid=r0eas time=103
Ended jobid=ac3de time=52

Print out the names of the ALL distinct jobs (not job instance IDs) with the longest running individual job instances (no totaling). Note they can be out of order.
So the output for the above would be:

Name Time
dump_logs 1343
read_logs 103
```

### Solution
To solve this problem, I use the merge method included in Java 8 to maps, see the JobStatisticsImp class

## Problem 3 Anagram (AnagramFinder.java)
### Defining the problem
Two words are anagrams of each other if they contain the same combination of characters, including counts, but regardless of order.  
"BEAR" and "BARE" are anagrams of each other, but "ARREAR" and "RARE" are not.

Write a function that takes in an array of strings as its argument and then prints the anagrams found in the array

```
Input: {"eat", "tea", "funeral", "frog", "elvis", "real fun", "lives", "dog", "ate"}
Output: ["eat", "tea", "funeral", "elvis", "real fun", "lives", "ate"]
```
   
### Solution
The main idea to solve this problem is use a Map that allow you to identify duplicated items, but in this problem two Strings are equals if contains the same letters and length,
so, I created a class named Anagram with an override equals and hashcode methods, implemented the logic to know if two words are Anagrams, 
the idea is summarize the individual hash of each letter in the override hash function and using Map I can find duplicates
please see the AnagramFinderImp class to understand this logic.

## Problem 4 Spiral Matrix (SpiralMatrixCreator.java)
### Company: Hulu
### Defining the problem
They are matrix filled as an spiral see next examples

```
3x3
1 2 3
8 9 4
7 6 5

4x4
 1  2  3  4
12 13 14  5
11 16 15  6
10  9  8  7
```
### Solution
The idea to solve this problem was found a pattern of how the matrix is filled by columns and rows, 
and use as approach the idea of someone walking across the matrix, so, the program move to the next cell
and fill the value of that cell, please see SpiralMatrixCreatorImp class to validate the solution 

## Problem 5 Longest sub string (LongestSubStringFinder.java)
### Defining the problem
Given a string, find the length of the longest substring without repeating characters.

```
Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
```
### Solution
The solution for this problem is use a collection with FIFO pattern implementation, the letters will be processed one by one starting on head towards the tail 
to find duplicated letters. 
Exist two collections with FIFO pattern implementation in Java PriorityQueue and LinkedList, the fist one was discarded due to is a sorted
collection, so, the LinkedList is the best option because this collection is just ordered not sorted.

Please see the LongestSubStringFinder class to understand the complete solution

To see the ordered and sorted concepts in collections, please read the Java Concepts - Collections part of this document

[Interviews Concepts](https://docs.google.com/document/d/1Nl-01uY2qwOkfeiMySlihSKqqlsS3DFwrofJ-WgGyGY/edit#heading=h.4qmnhbuiwjjw)

 
## Problem 6 - Get first not repeating letter in a word (FirstNonRepeating.java)
### Defining the problem
Given a word, find the first non repeating letter and its index

```
Examples
polca - Letter p index 0
cocolocal - Letter a index 7
```

### Solution
To solve this problem, I use the merge method included in Java 8 to maps, see the JobStatisticsImp class

## Problem 7 - Celebrity problem (CelebrityMatrix.java)
### Company: Vivid Seats
### Defining the problem
In a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “. Find the stranger (celebrity) in the minimum number of questions.
We can describe the problem input as an array of numbers/characters representing persons in the party. We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, false otherwise. How can we solve the problem.

```
Examples
MATRIX = { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 0, 0, 0},
           {0, 0, 1, 0} }
Output:id = 2
Explanation: The person with ID 2 does not 
know anyone but everyone knows him

MATRIX = { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 1, 0, 0},
           {0, 0, 1, 0} }
Output: No celebrity
```

### Solution
I found two solutions for this problem, the first option is using matrix(CelebrityMatrix.java) and other with collections (CelebrityCollection.java)

#### Solution1 Matrix - CelebrityMatrix.java
With this solution, we use a queue in which we start adding the possible celebrities that are the rows or columns in the matrix, because matrix is N x N
```
Queue<Integer> possibleCelebrities = new PriorityQueue<>();        
for(int row = 0; row < rows; row ++){
    possibleCelebrities.add(row);
}
```

We start evaluating with next logic elements in the queue

* If personA knows personB, means personB could be a celebrity, personA is discarded, 
cause everybody knows to a celebrity
* If personA does not know personB, means personA could be a celebrity, personB is discarded, 
cause celebrity does not know anybody

At the end we have just one possible celebrity, and the only pending validations are
* Everybody should know to the celebrity
* Anybody should not know the celebrity

#### Solution2 Collections - CelebrityCollection.java
With collections the solution is easiest compared to matrix version, here, we create a Class named TeamMember with name as attribute,
override equals and hashcode methods, and using a Map<TeamMember, Set<TeamMember>>, we define a TeamMember, and the persons who He knows
and use the next logic

* Find the team member who knows anybody, that team member is a possible celebrity
* Validate if everybody knows the possible celebrity

## Problem 8 - [Minimum Swap problem (MinimumSwap.java)](https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays)
You are given an unordered array consisting of consecutive integers, [1, 2, 3, ..., n] without any duplicates. 
You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.

```
Exmaple 1
4 3 1 2
output: 3

Explanation 0
Given array [4,3,1,2]

After swapping we get [1,3,4,2]
After swapping we get [1,4,3,2]
After swapping we get [1,2,3,4]
So, we need a minimum of 3 swaps to sort the array in ascending order.

Example 2
array [7,1,3,2,4,5,6]

i   arr                     swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]

It took 5 swaps to sort the array.
```

## Problem 9 - [New Year Chaos (NewYearChaos.java)](https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays)
### Solution
To solve this problem, you have iterate starting of the maximum to the minimum element over the array in reverse index order, and validate next things

* Iterate the original order in reverse way [8,7,6,5,...]
* Find the actual position of the element 
* It is the right position of the element swaps = originalPosition - actualPosition
    * If swaps > 2, Too chaotic, 
    * if swaps > 0, swap original position element swaps times
    * if swaps == 0, do nothing, element is right position

## Problem 10 - [Subarray with given sum (SubArraySum.java)](https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1)
### Defining the problem
Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array which adds to a given number S.

```
Example 1
Input:
N = 5, S = 12
A[] = {1,2,3,7,5}
Output: 2 4
Explanation: The sum of elements 
from 2nd position to 4th position 
is 12.

Example 2
Input:
N = 10, S = 15
A[] = {1,2,3,4,5,6,7,8,9,10}
Output: 1 5
Explanation: The sum of elements 
from 1st position to 5th position
is 15.
```

### Solution
To solve this problem, I use the merge method included in Java 8 to maps, see the JobStatisticsImp class

## Problem 11 - Ransom Note
### Company: Epam
### Defining the problem
Giving a note you should validate if you can build that note using as source a magazine, both note and magazine are strings formed by several words

```
Example 1
Input:
note "dog dog can run" magazine "dog can dog run like dog"
Return true, cause magazine contains all the words of note

Example 2
Input:
note "cat miau can cat" magazine "cat miau can"
Return false, cause in magazine is missing one cat word
```

### Solution
To solve this problem, I use two maps, one for a magazine and another for note 
with key = word and value= occurrences of the word, and, I iterate note's map 
validating if magazine contains the word, and the times needed for that word

## Problem 12 - Drawing Book
### Company: Hacker Rank
### Defining the problem
https://www.hackerrank.com/challenges/drawing-book/problem?isFullScreen=true
### Solution
See /hackerrank/DrawingBook.java

## Problem 13 - Sherlock Valid String
### Company: Hacker Rank
### Defining the problem
https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?isFullScreen=true
### Solution
See /hackerrank/SherlockValidString.java

## Problem 14 - Sum an Expression
### Company: Kin + Carta
### Defining the problem
In Postfix notation  
### Solution
See /hackerrank/SherlockValidString.java

## Problem 15 - The friend circle problem
### Company: Hourly
### Defining the problem
https://www.educative.io/edpresso/the-friend-circle-problem
### Solution
See /hackerrank/GroupsOfKnown.java

The logic to solve this problem is think in sets cause sets does not allow duplicates, so, means, sets without common elements

## Problem 16 - Save the prisoner
### Company: Hourly
### Defining the problem
https://www.hackerrank.com/challenges/save-the-prisoner/problem?h_r=profile
### Solution
See /hackerrank/SaveThePrisoner.java