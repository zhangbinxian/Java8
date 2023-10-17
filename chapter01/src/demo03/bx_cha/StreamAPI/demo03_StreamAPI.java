package demo03.bx_cha.StreamAPI;

import demo02.bx_cha.MethodReference.Employee;
import demo02.bx_cha.MethodReference.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author bx_cha
 * @version 1.0
 * 终止操作
 * <p>
 * - allMatch(Predicate p) 检测是否匹配所有元素
 * - anyMatch(Predicate p) 检测是否至少匹配一个元素
 * - noneMatch(Predicate p) 检测是否没有匹配所有元素
 * - findFirst() 返回第一个元素
 * - findAny() 返回当前流中任意元素
 * - count() 返回流中元素总数
 * - max(Comparator c) 返回流中元素最大值
 * - min(Comparator c) 返回流中元素最小值
 * - forEach(Consumer c) 返回流中元素
 * <p>
 * - allMatch(Predicate p) 检测是否匹配所有元素
 * - anyMatch(Predicate p) 检测是否至少匹配一个元素
 * - noneMatch(Predicate p) 检测是否没有匹配所有元素
 * - findFirst() 返回第一个元素
 * - findAny() 返回当前流中任意元素
 * - count() 返回流中元素总数
 * - max(Comparator c) 返回流中元素最大值
 * - min(Comparator c) 返回流中元素最小值
 * - forEach(Consumer c) 返回流中元素
 * <p>
 * - allMatch(Predicate p) 检测是否匹配所有元素
 * - anyMatch(Predicate p) 检测是否至少匹配一个元素
 * - noneMatch(Predicate p) 检测是否没有匹配所有元素
 * - findFirst() 返回第一个元素
 * - findAny() 返回当前流中任意元素
 * - count() 返回流中元素总数
 * - max(Comparator c) 返回流中元素最大值
 * - min(Comparator c) 返回流中元素最小值
 * - forEach(Consumer c) 返回流中元素
 * <p>
 * - allMatch(Predicate p) 检测是否匹配所有元素
 * - anyMatch(Predicate p) 检测是否至少匹配一个元素
 * - noneMatch(Predicate p) 检测是否没有匹配所有元素
 * - findFirst() 返回第一个元素
 * - findAny() 返回当前流中任意元素
 * - count() 返回流中元素总数
 * - max(Comparator c) 返回流中元素最大值
 * - min(Comparator c) 返回流中元素最小值
 * - forEach(Consumer c) 返回流中元素
 * <p>
 * - allMatch(Predicate p) 检测是否匹配所有元素
 * - anyMatch(Predicate p) 检测是否至少匹配一个元素
 * - noneMatch(Predicate p) 检测是否没有匹配所有元素
 * - findFirst() 返回第一个元素
 * - findAny() 返回当前流中任意元素
 * - count() 返回流中元素总数
 * - max(Comparator c) 返回流中元素最大值
 * - min(Comparator c) 返回流中元素最小值
 * - forEach(Consumer c) 返回流中元素
 * <p>
 * - allMatch(Predicate p) 检测是否匹配所有元素
 * - anyMatch(Predicate p) 检测是否至少匹配一个元素
 * - noneMatch(Predicate p) 检测是否没有匹配所有元素
 * - findFirst() 返回第一个元素
 * - findAny() 返回当前流中任意元素
 * - count() 返回流中元素总数
 * - max(Comparator c) 返回流中元素最大值
 * - min(Comparator c) 返回流中元素最小值
 * - forEach(Consumer c) 返回流中元素
 * <p>
 * - reduce(T iden,BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回T
 * - reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回Optional<T>
 * <p>
 * - allMatch(Predicate p) 检测是否匹配所有元素
 * - anyMatch(Predicate p) 检测是否至少匹配一个元素
 * - noneMatch(Predicate p) 检测是否没有匹配所有元素
 * - findFirst() 返回第一个元素
 * - findAny() 返回当前流中任意元素
 * - count() 返回流中元素总数
 * - max(Comparator c) 返回流中元素最大值
 * - min(Comparator c) 返回流中元素最小值
 * - forEach(Consumer c) 返回流中元素
 * <p>
 * - reduce(T iden,BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回T
 * - reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回Optional<T>
 * <p>
 * - allMatch(Predicate p) 检测是否匹配所有元素
 * - anyMatch(Predicate p) 检测是否至少匹配一个元素
 * - noneMatch(Predicate p) 检测是否没有匹配所有元素
 * - findFirst() 返回第一个元素
 * - findAny() 返回当前流中任意元素
 * - count() 返回流中元素总数
 * - max(Comparator c) 返回流中元素最大值
 * - min(Comparator c) 返回流中元素最小值
 * - forEach(Consumer c) 返回流中元素
 * <p>
 * - reduce(T iden,BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回T
 * - reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回Optional<T>
 */

/**
 * - allMatch(Predicate p) 检测是否匹配所有元素
 * - anyMatch(Predicate p) 检测是否至少匹配一个元素
 * - noneMatch(Predicate p) 检测是否没有匹配所有元素
 * - findFirst() 返回第一个元素
 * - findAny() 返回当前流中任意元素
 * - count() 返回流中元素总数
 * - max(Comparator c) 返回流中元素最大值
 * - min(Comparator c) 返回流中元素最小值
 * - forEach(Consumer c) 返回流中元素
 */

/**
 * - reduce(T iden,BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回T
 * - reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回Optional<T>
 */

/**
 * - collect(Collector c) 将流转化为其他形式，接收一个Collcetor接口的实现，用于给Stream中元素做汇总的方法
 */
public class demo03_StreamAPI {
    // 匹配与查询
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployee();

        // allMatch(Predicate p) 检测是否匹配所有元素 检测员工年龄是否全部大于20
        boolean b = employees.stream().allMatch(e -> e.getAge() > 20);
        System.out.println("检测员工年龄是否全部大于20 " + b);

        // anyMatch(Predicate p) 检测是否至少匹配一个元素 检测员工薪资 至少一个大于5000
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 5000);
        System.out.println("检测员工薪资 至少一个大于5000 " + b1);

        //  noneMatch(Predicate p) 检测是否没有匹配所有元素 检测员工薪资 没有小于1000
        boolean b2 = employees.stream().noneMatch(e -> e.getSalary() < 1000);
        System.out.println("检测员工薪资 没有小于1000 " + b2);

        // findFirst() 返回第一个元素
        Optional<Employee> firstEmployee = employees.stream().findFirst();
        System.out.println("第一个员工 " + firstEmployee);

        // findAny() 返回当前流中任意元素
        // Optional<Employee> anyEmployee = employees.stream().findAny();
        Optional<Employee> anyEmployee = employees.parallelStream().findAny();
        System.out.println("任意一个员工 " + anyEmployee);

        //count() 返回流中元素总数 员工工资大于5000总数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println("员工工资大于5000总人数 " + count);

        // max(Comparator c) 返回流中元素最大值 返回最大工资
        // 先map映射取出工资，再比较工资max
        Optional<Double> max = employees.stream()
                .map(e -> e.getSalary())
                .max(Double::compare);

        System.out.println("最大工资" + max);

        // min(Comparator c) 返回流中元素最大值 返回最小年龄
        Optional<Integer> min = employees.stream()
                .map(e -> e.getAge())
                .min(Integer::compareTo);

        System.out.println("最小年龄" + min);

        // forEach(Consumer c) 返回流中元素
        employees.forEach(System.out::println);
    }


    // 规约
    @Test
    public void test2() {
        // reduce(T iden,BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回T
        // 计算1-10的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Integer sum = list.stream().reduce(0, Integer::sum);
        Integer sum = list.stream().reduce(0, (i1, i2) -> (i1 + i2));
        System.out.println("计算1-10的和" + sum);


        // reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回Optional<T>
        // 计算所有员工工资总和
        List<Employee> employees = EmployeeData.getEmployee();

        // Double salarySum = employees.stream().map(e -> e.getSalary()).reduce((double) 0, (s1, s2) -> s1 + s2);
        Double salarySum = employees.stream().map(e -> e.getSalary()).reduce((double) 0, Double::sum);
        System.out.println("所有员工工资总和 " + salarySum);

    }


    // 收集
    @Test
    public void test3() {
        // collect(Collector c) 将流转化为其他形式，接收一个Collcetor接口的实现，用于给Stream中元素做汇总的方法
        // 查找工资大于3000的员工，结果返回为一个List或者Set

        List<Employee> employees = EmployeeData.getEmployee();

        // 调用Collectors toList()方法
        List<Employee> list = employees.stream().filter(e -> e.getSalary() > 3000).collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println();

        // 调用Collectors toSet()方法
        Set<Employee> set = employees.stream().filter(e -> e.getSalary() > 3000).collect(Collectors.toSet());
        set.forEach(System.out::println);

        System.out.println();

    }
}












