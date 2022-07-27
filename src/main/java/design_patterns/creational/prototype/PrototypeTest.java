package design_patterns.creational.prototype;

import java.util.List;

public class PrototypeTest {
    public static void main(String[] args) {
        Employees employees = new Employees();
        employees.loadData();

        //Use the clone method to get the Employee object
        Employees empsNew = (Employees) employees.clone();
        Employees empsNew1 = (Employees) employees.clone();
        List<String> list = empsNew.getEmpList();
        list.add("John");
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("Pankaj");

        System.out.println("employees List: " + employees.getEmpList());
        System.out.println("empsNew List: " + list);
        System.out.println("empsNew1 List: " + list1);
    }
}

