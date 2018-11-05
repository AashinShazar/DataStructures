# ProcessScheduler Assignment
## Project: Using PriorityQueues

## Project Overview
In this assignment you will learn more about PriorityQueues in Java. PriorityQueue class was introduced in Java 1.5 and it’s part of Java Collections Framework. PriorityQueue is an unbounded queue based on a priority heap and the elements of the priority queue are ordered by default in natural order. We can provide a Comparator for ordering at the time of instantiation of priority queue. The head of the priority queue is the least element based on the natural ordering or comparator based ordering, if there are multiple objects with same ordering, then it can poll any one of them randomly. When we poll the queue, it returns the head object from the queue.

## Description
Use the class PriorityQueue to build a processor scheduler that receives multiple processes with variant priorities. The processor will ask the processor scheduler about the next process to serve. The scheduler should remove the process that has the highest priority. Once the processor is done, the processor asks the scheduler again about the next process to serve and so on. The program ends when all processes are served. For the sake of this assignment we will work on serving 10 processes.

You project should contain only 2 classes:
Class: Process
This class contains 2 data members:
• ID - sequential number (first object id=1, second object id=2,..etc)
• Priority - random number from 1 to 100 (higher number = higher priority)

Hint 1: You can implement an object counter using a static data member

Class: ProcessSchedulerTest
This class has the main method that will call two functions:

1. GenerateProcesses: This function will create 10 processes. Each process will be assigned a priority number that is a random number from 1 to 100. Each process object is added to the PriorityQueue.

Hint 2: To generate a random number in Java you can use the Math.Random class.
Code example: https://www.geeksforgeeks.org/generating-random-numbers-in-java/

2. ServerProcesses: This function represents the processor that serves the processes in the Priority Queue. The queue will serve the process that has the highest priority.

