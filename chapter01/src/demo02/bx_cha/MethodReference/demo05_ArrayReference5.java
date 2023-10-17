package demo02.bx_cha.MethodReference;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author bx_cha
 * @version 1.0
 * 方法接口的使用
 */

/**
 * 构造器引用
 */
public class demo05_ArrayReference5 {

    // 构造器引用
    // Supplier T get()
    // Employee 空参构造器 Employee()
    @Test
    public void test1() {
        Supplier<Employee> supplier = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        Employee employee = supplier.get();
        System.out.println(employee);
    }

    // Supplier T get()
    // Employee Employee()
    @Test
    public void test2() {
        Supplier<Employee> supplier = () -> new Employee();
        Employee employee = supplier.get();
        System.out.println(employee);
    }

    @Test
    // Supplier T get()
    // Employee Employee()
    public void test3() {
        Supplier<Employee> supplier = Employee::new;
        Employee employee = supplier.get();
        System.out.println(employee);
    }


    @Test
    // Function R apply(T t)
    // Employee Employee(int id)
    public void test4() {
        Function<Integer, Employee> function = id -> new Employee(id);
        Employee employee = function.apply(1);

        System.out.println(employee);
    }

    @Test
    // Function R apply(T t)
    // Employee Employee(int id)
    public void test5() {
        Function<Integer, Employee> function = Employee::new;//调用 Employee(int id)构造器
        Employee employee = function.apply(2);

        System.out.println(employee);
    }

    @Test
    // BiFunction R apply(T t,U u)
    // Employee Employee(int id)
    public void test6() {
        BiFunction<Integer, Integer, Employee> biFunction = (id, age) -> new Employee(id, age);
        Employee e = biFunction.apply(1001, 20);
        System.out.println(e);
    }

    @Test
    // BiFunction R apply(T t,U u)
    // Employee Employee(int id)
    public void test7() {
        BiFunction<Integer, Integer, Employee> biFunction = Employee::new;
        Employee e = biFunction.apply(1002, 20);
        System.out.println(e);
    }
}