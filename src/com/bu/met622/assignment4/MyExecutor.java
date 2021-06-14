package com.bu.met622.assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Sandeep Agrawal
 * This project is to compare the difference between a single thread program and multi thread program using the time elapsed in completing each.
 */

public class MyExecutor {

    /**
     * @param args this contains the java command line arguments
     * @return Does not return anything
     * @description This method is the main method and is used to execute other
     * methods in this class.
     */
    public static void main(String[] args) {

        double singleThreadEndTime = handleSingleThread(); //execute the single thread program

        Thread[] myThreads = new Thread[5]; //create thread array

        //iterate through the array
        for (int i = 0; i < 5; i++) {
            myThreads[i] = new Thread(MyExecutor::handleMultiThread); //create object of thread and execute the handleMultiThread method in the run method of thread
        }

        long startTime = System.currentTimeMillis(); //store the start time of the multi threading program
        System.out.println("Multithreading start time: " + startTime); //print the start of multi thread application with the start time

        for (Thread thread : myThreads) { //loop through all the threads
            thread.start(); //start each thread inside the loop
        }

        for (Thread thread : myThreads) { //iterate through the threads
            //add a try/catch block to handle exceptions
            try {
                thread.join(); //join the thread here so that we can calculate the endtime of the thread for comparison with the single thread program
            } catch (InterruptedException e) {
                System.out.println("Something went wrong, please try again or see the exception" + e.getLocalizedMessage()); //handle exception here
            }
        }

        long endTime = System.currentTimeMillis(); //get the end time of the multi thread program after all thread are completed
        long totalTimeTakenForMultiThread = endTime - startTime; //save the total time for multi threading
        System.out.println("Multi-threading end time: " + endTime); //print the end time of the multi thread
        System.out.println("Total time taken for Multi-threading: " + totalTimeTakenForMultiThread + "ms"); //print the total time taken in miliseconds for multi thread to complete

        //print the final statement based on the how long each type of threading took or if equal
        if (singleThreadEndTime > totalTimeTakenForMultiThread) {
            System.out.println("Single thread took longer time to finish");
        } else if (singleThreadEndTime < totalTimeTakenForMultiThread) {
            System.out.println("Multi thread took longer time to finish");
        } else {
            System.out.println("No significant difference was found between single and multi thread");
        }
    }

    /**
     * @return This method will return the total time taken for the single thread to complete
     * @description This method is executed to handle the single thread to add 100 random entries to the list and print the values with the duration how long it took
     * to execute the program in miliseconds
     */
    private static double handleSingleThread() {

        List<String> sequence = new ArrayList<>(); //declare the list of string type
        long startTime = System.currentTimeMillis(); //calculate the start time of the program
        System.out.println("Single thread start time: " + startTime); //print the start of this method

        //iterate through the number of entries and generate random genome string of length 10
        for (int i = 0; i < 100; i++) {
            sequence.add(generateRandomGenome());
        }

        //print each string in the list
        for (String str : sequence) {
            System.out.println(str);
        }

        //calculate the end time
        long endTime = System.currentTimeMillis();
        System.out.println("Single thread end time: " + endTime); //pring the end of program with end time
        System.out.println("Total time taken for Single threading: " + (endTime - startTime) + "ms"); //calculate the total time taken for single thread to complete
        return endTime - startTime; //return the total time taken for single thread so that it can be compared in the main method
    }

    /**
     * @return This method will return the total time taken for the single thread to complete
     * @description This method is executed to handle the multi thread to add 20 random entries to the list and print the values.
     */
    private static void handleMultiThread() {
        List<String> sequence = new ArrayList<>();//create list of string type

        for (int i = 0; i < 20; i++) { //iterate through the list and add the entries to the list
            sequence.add(generateRandomGenome()); //generate random genome sequence
        }
        //print the content of the list
        for (String str : sequence) {
            System.out.println(str);
        }
    }

    /**
     *
     * @return This method return String of random genome
     * This method is used to create a  random generated genome sequence
     */
    public static String generateRandomGenome() {
        Random rand = new Random(); //create Random object
        StringBuilder dna = new StringBuilder(10); //use StringBuilder with 10 capacity

        for (int i = 0; i < 10; i++) { //iterate through the capacity and add the random string among the 4 characters
            dna.append("ACGT".charAt(rand.nextInt(4)));
        }

        return dna.toString(); //return the string
    }
}