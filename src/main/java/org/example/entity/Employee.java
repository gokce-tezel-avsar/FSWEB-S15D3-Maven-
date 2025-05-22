package org.example.entity;

import java.util.Objects;

public class Employee {
    private String firstname;
    private String lastname;
    private int id;

    public Employee( int id,String firstname,String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }


    public String getFirstname() {
        return firstname;
    }
    public int getId() {
        return id;
    }
    public String getLastname() {
        return lastname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(firstname, employee.firstname) &&
                Objects.equals(lastname, employee.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", id=" + id +
                '}';
    }
}
