package demo02.bx_cha.MethodReference;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author bx_cha
 * @version 1.0
 * 方法接口的使用
 */

/**
 * 类::实例方法 (类::非静态方法)
 */
public class demo03_MethodReference3 {

    @Test
    // labda表达式
    public void test1() {
        /**
         * 类型相似，不是特别匹配
         * Comparator int compare(T t1,T t2)
         * String int t1.compareTo(t2)
         */
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        System.out.println(comparator.compare("abc", "abd"));

    }

    @Test
    // 方法引用
    public void test2() {
        /**
         * 类型相似，不是特别匹配
         * Comparator int compare(T t1,T t2)
         * String int t1.compareTo(t2)
         */
        Comparator<String> comparator = String::compareTo;
        System.out.println(comparator.compare("abc", "abd"));
    }

    @Test
    // labda表达式
    public void test3() {
        /**
         * 类型相似
         * BiPredicate boolean test(T t1,T t2)
         * String boolean t1.equals(t2)
         */
        BiPredicate<String, String> biPredicate = (s1, s2) -> s1.equals(s2);
        System.out.println(biPredicate.test("nihao", "nihaooo"));
    }

    @Test
    // 方法引用
    public void test4() {
        /**
         * 类型相似
         * BiPredicate boolean test(T t1,T t2)
         * String boolean t1.equals(t2)
         */
        BiPredicate<String, String> biPredicate = String::equals;
        System.out.println(biPredicate.test("nihao", "nihao"));
    }

    @Test
    // labda表达式
    public void test5() {
        /**
         * 类型相似
         * Function R apply(T t)
         * Employee String getName();
         */
        Employee employee = new Employee(1001, "zbx", 20, 2000);

        Function<Employee, String> function = e -> e.getName();
        System.out.println(function.apply(employee));

    }

    @Test
    // 方法引用
    public void test6() {
        /**
         * 类型相似
         * Function R apply(T t)
         * Employee String getName();
         */
        Employee employee = new Employee(1001, "zbx", 20, 2000);

        Function<Employee, String> function = Employee::getName;
        System.out.println(function.apply(employee));
    }
}
