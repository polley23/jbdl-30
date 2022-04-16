package com.gfg;
import com.gfg.Thread.PrintOddNumber;
import com.gfg.Thread.Task;
import com.gfg.Thread.ThreadExample;
import com.gfg.Thread.Worker;

import java.io.*;
import java.rmi.AccessException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Random random = new Random();// no arg consturctor
//        Calculator  calculator = new Calculator(5,0);
//        try {
//            calculator.getDivision();
//       } catch (DivideByZeroException | AccessException e) {
//            e.printStackTrace();
//        }
//        finally {
//            System.out.println("in finally block");
//        }
//        //calculator class 5,5 , calculator class 5,0
        //write in the console
        System.out.println("hello world");
        // take input from the console;
//        Scanner scanner = new Scanner(System.in);
//        int[] a = new int[2];
//        int i= 0;
//        while(i<2 && scanner.hasNext() ){
//            a[i]=scanner.nextInt();
//            i++;
//        }
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        int[] a = new int[2];
//        int i= 0;
//        String input = null;
//        try {
//            input = bufferedReader.readLine();
//            while(i<2 && input!=null){
//                a[i]=Integer.parseInt(input);
//                i++;
//                input=bufferedReader.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        File file = new File("test.txt");
//        FileWriter fileWriter = null;
//
//        try {
//            fileWriter = new FileWriter(file,true);
//            fileWriter.write("Hello World");
//            fileWriter.write("Bye World");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                fileWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
//            System.out.println(bufferedReader.readLine());
//        } catch ( FileNotFoundException  e) {
//            e.printStackTrace();
//        }catch (IOException e){
//
//        }
        Task task = new PrintOddNumber() ;
        Worker  worker = new Worker(task);
        ThreadExample threadExample = new ThreadExample(worker);
        threadExample.execute();
        System.out.println(Thread.currentThread().getName());


    }

    static void print(Collection<Review> collection){
        for(Review i : collection){
            System.out.println(i.criticReview + " "+ i.userReview + " ");
            //collection.remove(i);
        }

    }
}

