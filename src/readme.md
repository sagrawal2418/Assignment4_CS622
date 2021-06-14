# Homework 4 - Concurrency 
Developed by Sandeep Agrawal

This project is demonstrate the difference in execution time between Multithreading program and single thread program. 

## Technical Details

Technology used - Java

Classes - MyExecutor.java

Methods
* main() - This method is the starting point of program execution, this method will call the handleSingleThread method and also handle the multithreading program.
* handleSingleThread() - This method will add 100 entries and calculate the total time taken to complete this program.
* handleMultiThread() - This method is to execute each thread tu add 20 entries into the list. 
* generateRandomGenome() - This method is used to create random genome sequence of 10 characters. 


## Assumptions
1. For the purpose of the assignment no UI was implemented.
2. Used assignment 4 MyExecutor.java as the base project.
3. Calling the handleSingleThread method inside main method to start the program.
4. Created array of 5 threads and created 5 instances of thread and executed the handleMultiThread program inside each thread. 
5. Handled each thread to start using a loop as well as join all the thread using the loop so that actual end time can be measured. 
6. Print the total time taken for both type of program.    
4. Program execution flow:
*  Program start with main method
*  handleSingleThread() method is executed.
*  System print the start of single thread program and the start time
*  System print all the sequence in each line. 
*  System print the end of single thread progran and the end time. 
*  System print how long it took to execute the single thread program.
*  System print the start of multi thread program and the start time
*  System print all the sequence in each line. 
*  System print the end of multi thread progran and the end time. 
*  System print how long it took to execute the multi thread program.
*  System print compares the difference in total time between both type of program and print the output.





