package demo01.bx_cha.Lambda;

/**
 * @author bx_cha
 * @version 1.0
 */
public class demo03FunctionalInterfaceExample {
    public static void main(String[] args) {
        // 使用Lambda表达式实现函数式接口
        demo03MyInterface myFunction = () -> System.out.println("Doing something");
        myFunction.method1();
    }
}
