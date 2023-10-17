package demo03.bx_cha.StreamAPI;

import demo02.bx_cha.MethodReference.Employee;
import demo02.bx_cha.MethodReference.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author bx_cha
 * @version 1.0
 * 创建Stream流
 */
public class demo01_StreamAPI {
    // 提供集合创建
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployee();

        // stream()返回一个顺序流
        Stream<Employee> stream = employees.stream();

        // parallelStream() 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    // 通过数组创建
    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 4, 4, 3, 1};
        // Arrays.stream()方法来从数组中创建Stream流
        IntStream stream1 = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "zbx", 20, 2000);
        Employee e2 = new Employee(1002, "abc", 30, 3000);
        Employee[] arr2 = new Employee[]{e1, e2};

        Stream<Employee> stream2 = Arrays.stream(arr2);
    }

    // 通过Stream的静态工厂方法
    @Test
    public void test3() {
        // Stream.of()创建一个流
        Stream<Integer> stream = Stream.of(1, 2, 3, 2, 1, 10);

    }

    // 通过生成器创建
    @Test
    public void test4() {
        // 使用Stream.generate()或Stream.iterate()方法创建包含无限元素的Stream流
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}












