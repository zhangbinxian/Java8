package demo02.bx_cha.MethodReference;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author bx_cha
 * @version 1.0
 * 方法接口的使用
 * <p>
 * 直接引用已存在的方法（或者构造方法），而不需要像Lambda表达式那样再次实现相同的方法
 */

/**
 * 对象::实例方法 (对象::非静态方法)
 */
public class demo01_MethodReference1 {

    @Test
    // labda表达式
    public void test1() {
        /**
         * 类型相似，一个参数，无返回值
         * Consumer void accept(T t)
         * PrintStream void println(T t)
         */
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("nihao");
    }

    @Test
    // 方法引用
    public void test2() {
        /**
         * 类型相似，一个参数，无返回值
         * Consumer void accept(T t)
         * PrintStream void println(T t)
         */
        PrintStream ps = System.out;
        Consumer<String> consumer = ps::println;
        consumer.accept("hello");
    }

    @Test
    // labda表达式
    public void test3() {
        /**
         * 类型相似 无参数，泛型返回值
         * Supplier T get()
         * Employee String getName()
         */
        Employee employee = new Employee(1001, "zbx", 21, 3000);
        Supplier<String> supplier = () -> employee.getName();
        System.out.println(supplier.get());
    }

    @Test
    // 方法引用
    public void test4() {
        /**
         * 类型相似 无参数，泛型返回值
         * Supplier T get()
         * Employee String getName()
         */
        Employee employee = new Employee(1001, "zbx", 21, 3000);
        Supplier<String> supplier = employee::getName;
        System.out.println(supplier.get());
    }

}
