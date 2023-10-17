package demo02.bx_cha.MethodReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author bx_cha
 * @version 1.0
 * <p>
 * 员工类
 */
@Data

public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee() {
        // System.out.println("Employee()被调用");
    }

    public Employee(int id) {
        this.id = id;
        // System.out.println("Employee(int id)被调用");
    }

    public Employee(int id, int age) {
        this.id = id;
        this.age = age;
        // System.out.println("Employee(int id, int age)被调用");
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        // System.out.println("Employee(int id, String name, int age, double salary)被调用");
    }
}
