/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author KHANH VY
 */
public class Employee {
    
    int empId;
    String empName, userName, password, address, position;
    Date birthday, startDate;
    double salary;
    
    public Employee(){
    };

    public Employee(int empId, String empName, String userName, String password, String address, String position, Date birthday, Date startDate, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.position = position;
        this.birthday = birthday;
        this.startDate = startDate;
        this.salary = salary;
    }

    public Employee(String empName, String userName, String password, String address, String position, Date birthday, Date startDate, double salary) {
        this.empName = empName;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.position = position;
        this.birthday = birthday;
        this.startDate = startDate;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
    
}
