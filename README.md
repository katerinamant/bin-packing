# Bin Packing Problem

*A take on the popular optimization problem using custom heap and abstract data implementations.*

## Screenshots

![Screenshot_20230205_121842](https://user-images.githubusercontent.com/97695022/216791866-9e510307-ca0f-4f6a-9a20-06673a63cf28.png)

![Screenshot_20230205_121953](https://user-images.githubusercontent.com/97695022/216791872-84daacb7-f471-49a0-ab5d-9e917af70c2e.png)

## Description

First, we created our own interface of a Linked List using generics, which is implemented in the `MyLinkedList` class.
Using this, we created our own Max Heap and Max Priority Queue.

The input .txt file contains N lines, each with a folder sized 0-1000000 MB.
The program `Greedy` processes these folders and displays the amount of 1TB disks used to store them.

Additionally, in the `Sort.java` file, using a merge sort algorithm, the folders are sorted in decreasing order.
In the `experiment` package, we generate files with randomly sized folders to compare the Greedy and the Greedy-Decreasing algorithms.

More information on how to run the project can be found in the instructions.txt file.

## Lessons learned from this project

- Generated randomized files and compared results.
- Implemented generics for our custom data structures.
- Efficiently handled multiple input files with various requirements.
- Used a merge sort algorithm for our custom linked list.

## Creators

- Katerina Mantaraki [@katerinamant](https://github.com/katerinamant)
- Alex Papadopoulos [@alexisthedev](https://github.com/alexisthedev)
