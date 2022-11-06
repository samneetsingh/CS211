/*
Samneet Singh
01/06/2020
Computer Science 211
To calculate the salary of a Marketer and advertise
 */
public class Marketer extends Employee {
    public Marketer () {
        super();
    }
    // getter method for salary of a marketer
    public double getSalary() {
        return super.getSalary() + 10000;
    }
    // return string for 'Act now, while supplies last!'
    public String toString() {
        return "Act now, while supplies last!";
    }
}