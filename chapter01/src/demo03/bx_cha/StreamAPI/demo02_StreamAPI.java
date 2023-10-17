package demo03.bx_cha.StreamAPI;

import demo02.bx_cha.MethodReference.Employee;
import demo02.bx_cha.MethodReference.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author bx_cha
 * @version 1.0
 * 中间操作
 */
public class demo02_StreamAPI {
    // 筛选
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployee();

        // stream()返回一个顺序流
        Stream<Employee> stream = employees.stream();

        // filter 查询工资大于3000
        stream.filter(e -> e.getSalary() > 3000).forEach(System.out::println);
        System.out.println();

        // limit 查询前三条
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println();

        // skip 跳过元素
        employees.stream().skip(3).forEach(System.out::println);
        System.out.println();

        // distince 筛选 去重
        List<Integer> list = Arrays.asList(1, 2, 3, 3, 3, 3, 4, 5, 6, 7);
        list.stream().distinct().forEach(System.out::println);
    }

    // 映射
    @Test
    public void test2() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        // map 映射 转大写
        // map(Function)：将流中的每个元素映射到另一个值，返回包含映射结果的新流。
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println();

        // 获取员工姓名.length>3的姓名

        List<Employee> employees = EmployeeData.getEmployee();
        employees.stream().map(Employee::getName)
                .filter(name -> name.length() > 3)
                .forEach(System.out::println);
        System.out.println();


        // flatMap(Function)
        // 使用flatMap中间操作将流中的每个元素映射为一个流，然后将这些流合并为一个新的流。通常用于扁平化嵌套集合的情况。

        // list "aa", "bb", "cc", "dd", "ee"
        Stream<Stream<Character>> streamStream = list.stream().map(demo02_StreamAPI::fromStringtoStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::print);
        });
        System.out.println();

        // 使用flatMap 扁平化
        Stream<Character> characterStream = list.stream().flatMap(demo02_StreamAPI::fromStringtoStream);
        characterStream.forEach(System.out::print);


    }


    // 将字符串的多个字符构成的集合转换为Stream流的实例
    public static Stream<Character> fromStringtoStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }

    // 排序
    @Test
    public void test3() {
        // sorted()：对流中的元素进行排序，默认是自然顺序，也可以提供自定义的比较器。
        List<Integer> list = Arrays.asList(12, 3, -1, 4, 5, 1);

        list.stream().sorted().forEach(System.out::println);
        System.out.println();

        list.stream().sorted((i1, i2) -> Integer.compare(i2, i1))
                .forEach(System.out::println);
    }
}












