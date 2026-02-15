RULE --
Easy - 5
Medium - 10
Hard - 5

Chaman's advice --
Be consistent, most people don't stay consistent
when applying for a specific company, a week before go through the questions asked previously.

QUESTIONS & TIPS --

Sum of N Natural numbers -- (N * (N + 1)) / 2
When you see a sorted array problem, always think whether BS or two pointer technique can be used.


Arrays.fill(arr, Integer.MAX_VALUE);
Sub-array (Continuous part of array), Subsequence (Ordered but non-continuous) & Subset (Ordered, non-continuous with empty set).
Binary search: mid = (start + end) / 2  --> mid = start + (end - start) / 2
Hashset contains(obj) is O(1) in Time complexity
list.sort(Comparator.comparingInt(a -> a.end));
List<Integer> list = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

Recursion very important (heavily used in Trees, Graphs & DP)
String with dynamic programming
String with recursive backtracking
Amazon asks at least 2 Tree questions

distributed transaction (2PC - two phase commit)
Internal working of Hash map (something called collision)
Hashing

Linked List -- Concepts like finding the middle and reversing the linked list will be used in medium to hard level problems (Chaman)
find middle in linked list -- runner technique aka slow and fast pointer
linked list cycle -- mathematics behind is Flocyd cycle detection
LRU cache problem (includes Hashmap and doubly linkedlist) - very popular interview question

For Tree problems, first think which traversal suits (Pre, In, Post, Level or Level by level order).
Remember a queue with forloop for Tree level by level order traversal.
Chaman once had a Bar raiser interview round in Amazon.
Witch - Microsoft asked only medium level questions (Chaman denied, they can ask medium to hard levels too).

Bit Manipulation -- << is multiplication of 2, >> is division by 2

Top view of Binary Tree -- level order with Horizontal distance
Chaman -- all questions discussed in Session 11 & 12 (Tree and BST) are very important problems

Learn internal working of Heap / Priority Queue -- (Complete binary tree that follows Heap order property)
Types - Min Heap & Max Heap
Insert - O(logN), Delete - O(logN), top element - O(1)

Complete Binary Tree -- all levels are fully filled except last level. Last level should fill from left to right.

Greedy vs DP -
Greedy makes the choice that looks best at that moment.
DP sees all possibilities and then makes the decides.
Coin change problems best explains the problem with Greedy (why wrong answer) and why DP is better.

Longest Increasing Subsequence -
1. Brute Force -
    i) Generate All subsequence -- O(2 pow N)
    ii) Using 2 for loops (dp - bottom down approach) -- O(N pow 2)
    iii) Using binary search -- O(NlogN)

Java Memory Management:
 • JVM Architecture
 • Garbage Collection
 • Heap & Stack Memory