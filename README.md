# Java8
学习java8特性

# java8 接口
在jdk7之前，接口里的所有方法都没有方法体，即都是抽象方法<br>
在jdk8之后，可以有静态方法，默认方法，即在接口当中可以有方法的具体实现，需要家default关键字修饰
```java
interface AInterface {

    public void hi();

    // 在jdk7之前，接口里的所有方法都没有方法体，即都是抽象方法<br>
    // 在jdk8之后，可以有静态方法，默认方法，即在接口当中可以有方法的具体实现，需要家default关键字修饰
    public default void hello(){
        System.out.println("hello");
    }
    public static void hello2(){
        System.out.println("hello2");
    }
}

class A implements AInterface {
    @Override
    public void hi() {
        System.out.println("A类实现了Ainterface的hi方法");
    }
}
```
# java8 Data日期类
## Date,Calender,LocalDate...
### 第一代日期类
- Date:精确到毫秒，代表特定的瞬间
- SimpleDateFormat：格式和解析日期的类
允许经行格式化(日期->文本)，
解析(文本->日期)和规范化

### 第二代日期类
- Calendar:日历类
- Calendar是一个抽象类，它为特定瞬间与一组日历字段提供相互转换方法

### 第三代日期类
前两代日期类的不足分析

JDK 1.0当中包含了一个java.util.Date类，但是大多数方法已经在JDK 1.1引入calendar类
之后弃用了，而且calendar类也存在问题
1. 可变性：日期和时间类应该是不可变的
2. 偏移性：Date中的年份从1900开始，而月份都从0开始
3. 格式化：格式化只对Date有用，calendar则不行
4. 此外，它们也不是线程安全，不能处理闰秒(每隔2天，多出1s)


jdk8加入了

- LocalDate(日期)，获取日期字段
- LocakTime(时间), 获取时间字段
- LocalDateTime(时间日期)，获取日期和时间字段
- Instant(时间戳)，提供一系列与Date类转换的方法
```text
Instant--->Date
Date date = Date.from(instant)

Date--->Instant
Instant innstant = date.toInstant()
```
# Lambda表达式
Lambda表达式是Java 8引入的一种新语法特性，它允许您以更简洁的方式编写匿名函数。Lambda表达式主要用于函数式编程，可以作为方法参数传递、作为返回值返回，或者用于简化集合操作
```txt
(parameters) -> expression
(参数) -> 表达式

// 参数：可以是零个或多个参数，用于传递给 Lambda 表达式的函数。
// ->：箭头符号，用于将参数和表达式主体分隔开。
// 表达式：包含在 Lambda 表达式中的功能代码。
```
```txt
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// 使用Lambda表达式遍历列表并打印每个元素
numbers.forEach(number -> System.out.println(number));
```
写功能代码，省略了函数名
## Lambda表达式的一种简化写法
只包含一个语句,Lambda表达式不需要显式使用大括号 {} 来包裹操作
```text
Consumer<String> consumer1 = (String s) -> {
    System.out.println(s);
};
consumer1.accept("java");

Consumer<String> consumer1 = (String s) ->System.out.println(s);
consumer1.accept("java");
```
## 示例
- 代码中演示了Lambda表达式的不同用法，包括无参数、带参数、省略数据类型、省略小括号等情况。
- 使用Lambda表达式可以使代码更加简洁，特别是在只包含一个语句时，可以省略大括号 {} 和 return 语句

```java
public class Main {
    @Test
    // 无参 无返回值
    public void test1() {
        Runnable runnable = () -> System.out.println("test1");
        runnable.run();
    }
    
    @Test
    // 需要一个参数，但是没有返回值
    public void test2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("hello");
    }
    
    @Test
    public void test3() {
        Consumer<String> consumer1 = (String s) -> System.out.println(s);
        consumer1.accept("java");
    }
    
    @Test
    // 数据类型新可以省略，因为编译器可推断出，称为“类型推断“
    public void test4() {
        // 前面泛型是String,编译器可以推断出参数s也是String
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept("hello world");
    }
    
    @Test
    // 只需要一个参数时，参数的小括号可以省略
    public void test5() {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("hello world");
    }
    
    @Test
    // 需要2个或以上参数时,多条执行语句，并且可以有返回值时，以下写法
    public void test6() {
        Comparator<Integer> comparator = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1, o2);
        };
        int i = comparator.compare(10, 20);
        System.out.println(i);
    }
    
    @Test
    // 只包含一个语句,Lambda表达式不需要显式使用大括号 {} 来包裹操作,return 也省略
    public void test7() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
    
        int i = comparator.compare(10, 20);
        System.out.println(i);
    }
}
```
# 函数式接口
函数式接口（Functional Interface）是 Java 中的一种特殊类型的接口，
它仅包含一个抽象方法（有时也包含默认方法或静态方法），用于表示函数或操作

Lambda表达式的本质，作为函数式接口的实例，如果一个接口当中，
只声明了一个抽象方法，则此接口就称为函数式接口
## 函数式接口的主要特点和示例：
- 单一抽象方法：函数式接口只能包含一个抽象方法。这个方法定义了接口的主要功能。其他非抽象方法通常是默认方法或静态方法。

- @FunctionalInterface 注解：Java 8 引入了 @FunctionalInterface 注解，用于显式声明一个接口为函数式接口。这个注解有助于确保接口只包含一个抽象方法。

- Lambda 表达式：函数式接口通常与 Lambda 表达式一起使用。Lambda 表达式提供了一种便捷的方式来实现函数式接口的抽象方法。
```java
// 定义一个函数式接口
@FunctionalInterface
interface MyFunction {
    void doSomething();
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // 使用Lambda表达式实现函数式接口
        MyFunction myFunction = () -> System.out.println("Doing something");
        myFunction.doSomething();
    }
}

``` 
## 内置的函数式接口 Consumer、Supplier、Function、Predicate
| 名称       | 参数类型              | 返回类型    | 用途                                                         |
|------------|-----------------------|-------------|-------------------------------------------------------------|
| `Consumer` 消费性接口 | 一个参数（T）          | `void`      | 执行操作并接受一个输入，通常无返回值，用于消费数据。 void accept(T t)      |
| `Supplier` 供给型接口| 无参数                | 泛型（T）   | 生成数据并无需参数，通常用于提供数据。<br> T get()            |
| `Function` 函数式接口| 一个参数（T）          | 泛型（R）   | 将输入数据转换为输出数据，用于数据转换和映射。  R apply(T t)    |
| `Predicate` 断定型接口| 一个参数（T）          | `boolean`  | 对输入数据进行条件测试，通常用于过滤和筛选数据。     boolean test(T t) |

## 实例
```java
class Main{
        @Test
        public void test3() {
    
            List<String> list = Arrays.asList(null, "abc", "12", "hello", "world", "我爱学java");
            // 使用匿名内部类
            List<String> fliterList = fliterString(list, new Predicate<String>() {
                @Override
                public boolean test(String s) {
                    return s != null && s.length() > 4;
                }
            });
            System.out.println(fliterList);
        }
    
        @Test
        public void test4() {
            List<String> list = Arrays.asList(null, "abc", "12", "hello", "world", "我爱学java");
            // 使用lambda
            List<String> fliterString = fliterString(list, s -> s != null && s.length() > 4);
            System.out.println(fliterString);
        }
    
    
        // 过滤字符串 使用Predicate断定型接口，
        public List<String> fliterString(List<String> list, Predicate<String> predicate) {
            // 过滤字符串list
            ArrayList<String> fliterList = new ArrayList<String>();
    
            for (String s : list) {
                // 对原先list遍历，使用predicate.test()方法，判断，如果成立，fliterList.add(s)
                if (predicate.test(s)) {// test()具体规则，看接口实现类是如何写的
                    fliterList.add(s);
                }
            }
            // 返回fliterList
            return fliterList;
        }
}
```
# 方法引用 
方法引用（Method Reference）是 Java 8 引入的一个功能，它允许您直接引用已存在的方法（或者构造方法），
而不需要像Lambda表达式那样再次实现相同的方法。方法引用使代码更加简洁，提高可读性。

方法引用的语法是使用双冒号 :: 运算符，后跟方法的名称。方法引用可以用于函数式接口的实现，也可以用于静态方法、实例方法以及构造方法。
```text
类(或对象)::方法名
```
## 何时使用
接口当中的抽象方法的形参列表和返回值类型 
```text
/**
* 类型相识，一个参数，无返回值
* Consumer void accept(T t)
* PrintStream void println(T t)
*/

/**
* 类型相似 无参数，泛型返回值
* Supplier T get()
* Employee String getName()
*/
```
与方法引用的方法的形参和返回值类型相同
## 一些常见的方法引用类型：
- 静态方法引用：引用静态方法。
```text
ClassName::staticMethodName
```

- 实例方法引用：引用特定对象的实例方法。
```text
objectReference::instanceMethodName
```

- 特定类型的实例方法引用：引用特定类型的任意对象的实例方法。
```text
ClassName::instanceMethodName
```

- 构造方法引用：引用构造方法。
```text
ClassName::new
```
## 下面是一些示例，演示如何使用方法引用：
```text
// 静态方法引用
Function<Integer, Integer> square = Math::square;

// 实例方法引用
List<String> strings = Arrays.asList("apple", "banana", "cherry");
strings.forEach(System.out::println);

// 特定类型的实例方法引用
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.sort(Integer::compare);

// 构造方法引用
Supplier<LocalDate> todaySupplier = LocalDate::new;
LocalDate today = todaySupplier.get();

```
# 构造器引用
构造器引用是 Java 中的一种方法引用，用于创建对象的实例。它允许你引用一个类的构造器（构造方法），并将其用作函数式接口的实现
```text
ClassName::new
```
# StreamAPI
Java Stream API（流式编程API）是从Java 8开始引入的，用于处理集合数据的强大工具。它提供了一种函数式的方式来操作集合，使数据处理更具表达性和清晰度。
Stream API支持一系列丰富的操作，包括筛选、映射、聚合、排序等，使数据处理更加方便和高效。

StreamAPI 对集合数据进行操作，类似于SQL执行的数据库查询
## 如何使用
### 创建一个数据源：
创建一个数据源：首先，你需要有一个数据源，它可以是集合、数组、I/O通道等。你可以使用集合类的 stream() 方法来创建一个流
- 通过集合创建
- 通过数组创建
- 通过Stream的静态工厂方法
- 通过生成器创建
- 通过文件创建
```text
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
```

### 中间操作：
中间操作：然后，你可以在流上执行中间操作，以筛选、映射、排序、去重等方式转换数据。
#### 筛选与切片
- filter(Predicate)：筛选出符合给定条件的元素，返回一个包含这些元素的新流
- distinct()：去除流中的重复元素，返回包含不同元素的新流。
- limit(long)：截取流的前几个元素，返回包含限定数量元素的新流。
- skip(long)：跳过流的前几个元素，返回包含剩余元素的新流。
#### 映射
- map(Function)：将流中的每个元素映射到另一个值，返回包含映射结果的新流
- flatMap(Function)：用于扁平化映射，将每个元素映射到一个流，然后将这些流合并为一个新的流。

#### 排序
- sorted()：对流中的元素进行排序，默认是自然顺序，也可以提供自定义的比较器
- peek(Consumer)：用于在流的每个元素上执行操作，通常用于调试和记录元素。


### 终端操作：终止操作
终端操作：最后，你需要执行一个终端操作，触发流的处理并生成结果。终端操作可以是迭代、收集到集合、计数、聚合等。

流的操作通常是惰性的，直到执行终端操作时，操作才会实际执行。一旦流被终端操作处理，它不能再被重复使用。

#### 匹配与查询
- allMatch(Predicate p) 检测是否匹配所有元素
- anyMatch(Predicate p) 检测是否至少匹配一个元素
- noneMatch(Predicate p) 检测是否没有匹配所有元素
- findFirst() 返回第一个元素
- findAny() 返回当前流中任意元素
- count() 返回流中元素总数
- max(Comparator c) 返回流中元素最大值
- min(Comparator c) 返回流中元素最小值
- forEach(Consumer c) 返回流中元素
#### 规约
- reduce(T iden,BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回T
- reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回Optional<T>
#### 收集
- collect(Collector c) 将流转化为其他形式，接收一个Collcetor接口的实现，用于给Stream中元素做汇总的方法
# Optional类
Optional 是 Java 中的一个类，用于处理可能为null的值，以避免空指针异常。
Optional 提供了一种更安全的方式来表示可能为null的值，
同时鼓励程序员明确处理这些情况，而不是简单地进行空值检查

## 方法
### 创建Optional对象
- Optional.of(T t) 创建一个Optional实例 t必须非空
- Optional.empty() 创建一个空的Optional实例
- Optional.ofNullable(T t)t可以为null
### 判断Optional容器中是否包含对象
- boolean isPresent() 判断是否包含对象
- void ifPresent(Consumer<? super T> consumer) 如果有值，
就执行Consumer接口的实现代码，并且将该值作为参数传给它
### 获取Optional容器的对象
- T get() 如果调用对象包含值，就返回该值，否则抛异常
- T orElse(T other) 如果有值就将其返回，否则返回指定的other对象
- T orElseGet(Supplier<? extends T> other) 如果有值，就将其返回，
否则返回由Supplier接口实现提供的对象
- T orElseThrow(Supplier<? extends X> exceptionSupplier)  如果有值，就将其返回，
否则抛出由Supplier接口实现提供的异常


