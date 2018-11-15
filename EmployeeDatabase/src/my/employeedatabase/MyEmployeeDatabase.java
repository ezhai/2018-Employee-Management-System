/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.employeedatabase;

import java.awt.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author shawnzhang12
 */

public class MyEmployeeDatabase {

    // ATTRIBUTES
    // buckets is an array of ArrayList. Each item in an ArrayList is an
    // StudentInfo object.
    private ArrayList<EmployeeInfo>[] buckets;

    // CONSTRUCTOR
    public MyEmployeeDatabase(int howManyBuckets) {
        // Construct the hash table (open hashing/closed addressing) as an array
        // of howManyBuckets ArrayLists.

        // Instantiate an array to have an ArrayList as each element of the
        // array.
        buckets = new ArrayList[howManyBuckets];

        // For each element in the array, instantiate its ArrayList.
        for (int i = 0; i < howManyBuckets; i++) {
            buckets[i] = new ArrayList(); // Instantiate the ArrayList for
            // bucket i.
        }
    }
    
    // GET 
    public ArrayList<EmployeeInfo>[] getBuckets(){
        return buckets;
    }
    
    // OTHER METHODS
    public int calcBucket(int keyValue) {
        // Returns the bucket number as the integer keyValue modulo the number
        // of buckets for the hash table.
        return (keyValue % buckets.length);
    }

    public void addToTable(EmployeeInfo itemToAdd) {
        buckets[calcBucket(itemToAdd.getEmployeeNumber())].add(0, itemToAdd);
    }

    public EmployeeInfo searchTable(int eN) {
        for (int i = 0; i < buckets[calcBucket(eN)].size(); i++) {
            if (buckets[calcBucket(eN)].get(i).getEmployeeNumber() == eN) {
                return buckets[calcBucket(eN)].get(i);
            }
        }
        return null;
    }

    public EmployeeInfo removeFromTable(int eN) {
        if (buckets[calcBucket(eN)].isEmpty()) {
            //System.out.println("The employee does not exist in our database");
            return null;
        } else {

            for (int i = 0; i < buckets[calcBucket(eN)].size(); i++) {
                EmployeeInfo toBeRemovedEmployee = buckets[calcBucket(eN)].get(i);
                if (buckets[calcBucket(eN)].get(i).getEmployeeNumber() == eN) {
                    buckets[calcBucket(eN)].remove(i);
                    //System.out.println("The employee with employee number " + eN + " was removed from our database");
                    return toBeRemovedEmployee;
                }
            }
            return null;
        }
    }

    public void displayTable() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i].isEmpty()) {
            } else {
                for (int j = 0; j < buckets[i].size(); j++) {
                    System.out.println(buckets[i].get(j).getFirstName() + " " + buckets[i].get(j).getLastName() + ", " + buckets[i].get(j).getEmployeeNumber());
                }
            }
        }
    }

    public ArrayList<EmployeeInfo> retrieveTable() {
        ArrayList<EmployeeInfo> eList = new ArrayList<>();
        //StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i].isEmpty()) {
            } else {
                for (int j = 0; j < buckets[i].size(); j++) {
                    //System.out.println(buckets[i].get(j).getFirstName() + ", " + buckets[i].get(j).getEmployeeNumber());
                    eList.add(buckets[i].get(j));
                }
            }
        }

        return eList;
    }
    
    public ArrayList<String> readFile(File file) throws IOException{
        BufferedReader inp = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        ArrayList<String> empList = new ArrayList<>();
      
        String text = inp.readLine();
            while (text != null) {
                    empList.add(text);
                    text = inp.readLine();
            }
        inp.close();
        
        for (int i=0;i<empList.size();i++){
            System.out.println(empList.get(i));
        }
        return empList;
    }
     
    public void writeFile(File file) throws IOException{
        PrintWriter printer = new PrintWriter(file);
        String toWrite = "";
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i].isEmpty()) {
                System.out.println("BUCKET " + i + " is empty!");
            } else {
                for (int j = 0; j < buckets[i].size(); j++) {
                    if (buckets[i].get(j) instanceof FullTimeEmployee){
                        FullTimeEmployee e = (FullTimeEmployee) buckets[i].get(j);
                        toWrite = ("1"+e.getEmployeeNumber()+"%"+e.getFirstName()+"%"+e.getLastName()+"%"+e.getSex()+"%"+e.getWorkLocation()+"%"+e.getYearlySalary()+"%"+e.getDeductionsRate()+"\n");
                    } else if(buckets[i].get(j) instanceof PartTimeEmployee){
                        PartTimeEmployee e = (PartTimeEmployee) buckets[i].get(j);
                        toWrite = ("0"+e.getEmployeeNumber()+"%"+e.getFirstName()+"%"+e.getLastName()+"%"+e.getSex()+"%"+e.getWorkLocation()+"%"+e.getHourlyWage()+"%"+e.getHoursPerWeek()+"%"+e.getWeeksPerYear()+"%"+e.getDeductionsRate()+"\n");
                        
                    }
                        printer.println(toWrite);
                }
            }
        }
        printer.close();
    }

} // end class MyHashTable
