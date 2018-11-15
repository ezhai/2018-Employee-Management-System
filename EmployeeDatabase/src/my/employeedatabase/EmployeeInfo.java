/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.employeedatabase;

/**
 *
 * @author shawnzhang12
 */
public class EmployeeInfo {
    // Attributes

    private int employeeNumber;
    private int sex;
    private int workLocation;
    private String firstName;
    private String lastName;
    private EmployeeInfo left;
    private EmployeeInfo right;

    // Constructors
    public EmployeeInfo() // These are the initial values of an added student
    {
        employeeNumber = 0;
        firstName = "Place";
        lastName = "Holder";
    }

    public EmployeeInfo(int eN, String fN, String lN, int s, int wL) {
        employeeNumber = eN;
        firstName = fN;
        lastName = lN;
        sex = s;
        workLocation = wL;
        left = null;
        right = null;
    }

    // Sets the inputed information of the student as the attributes of the student
        
    public void setLeft(EmployeeInfo cE){
        left = cE;
    }
    
    public EmployeeInfo getLeft(){
        return left;
    }
    
    public void setRight(EmployeeInfo cE){
        right = cE;
    }
    
    public EmployeeInfo getRight(){
        return right;
    }
    
    public void setFirstName(String fN) {
        firstName = fN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lN) {
        lastName = lN;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmployeeNumber(int eN) {
        if (eN < 0) {
            employeeNumber = 0;
        } else {
            employeeNumber = eN;
        }
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setSex(int s) {
        if (s < 0 || s > 2) {
            sex = -1;
        } else {
            sex = s;
        }
    }

    public int getSex() {
        return sex;
    }

    public void setWorkLocation(int wL) {
        if (wL < 0 || wL > 2) {
            workLocation = -1;
        } else {
            workLocation = wL;
        }
    }

    public int getWorkLocation() {
        return workLocation;
    }

} // StudentInfo class
