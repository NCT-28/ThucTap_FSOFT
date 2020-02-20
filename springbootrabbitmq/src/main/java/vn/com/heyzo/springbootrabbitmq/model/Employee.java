package vn.com.heyzo.springbootrabbitmq.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Employee.class)
public class Employee {
    private String empName;
    private String empId;

    public Employee() {
    }

    public Employee(String empName, String empId) {
        this.empName = empName;
        this.empId = empId;
    }

    public String getEmpName() {
        return this.empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpId() {
        return this.empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Employee empName(String empName) {
        this.empName = empName;
        return this;
    }

    public Employee empId(String empId) {
        this.empId = empId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(empName, employee.empName) && Objects.equals(empId, employee.empId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empName, empId);
    }

    @Override
    public String toString() {
        return "{" + " empName='" + getEmpName() + "'" + ", empId='" + getEmpId() + "'" + "}";
    }
}
