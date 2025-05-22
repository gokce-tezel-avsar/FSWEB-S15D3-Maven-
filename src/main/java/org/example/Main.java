package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    private static Map<Integer, Employee> employeeMap;
    private static List<Employee> duplicatedEmployees;

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Gökçe", "Tezel"));
        employees.add(new Employee(1,"Gökçe", "Tezel" ));
        employees.add(new Employee(1,"Gökçe", "Tezel"));
        employees.add(new Employee(2,"Alpcan", "Avşar"));
        employees.add(new Employee(3,"Sanem", "Avşar"));
        employees.add(new Employee(4,"Gülçe", "Tezel"));

    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        employeeMap = new HashMap<>();
        duplicatedEmployees = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("null record");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())) {
                duplicatedEmployees.add(employee);       //employeeMap boş olarak geldi.oluşturduğumuz listeden gelen id ile
                //employeemap karşılaştırılır. ilkince else düşüp emplooMape ekler çünkü boştu.
                //sonrakileri karşılaştırıken tekrar eden varsa duplicatedEmployeese düşer
            } else {
                employeeMap.put(employee.getId(), employee);
            }

        }
        return duplicatedEmployees;

    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        employeeMap = new HashMap<>();
        duplicatedEmployees = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("null record");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);

            }
        }
        return employeeMap;

    }


    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> duplicates = findDuplicates(employees);
        Map< Integer,Employee> uniques = findUniques(employees);
        List<Employee> tekOlanlar = new LinkedList<>(uniques.values());
        tekOlanlar.removeAll(duplicates);
        return tekOlanlar;
    }


}
