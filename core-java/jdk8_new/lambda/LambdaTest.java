package lambda;

import java.util.Arrays;

public class LambdaTest {

    public static void main(String[] args) {

        // 集合类（包括List）现在都有一个forEach方法，对元素进行内部迭代（遍历）
        Arrays.asList("p", "k", "u").forEach(e -> System.out.print(e + '-'));
        // 参数e的类型是由编译器推理得出的，也可以显式指定该参数的类型
        Arrays.asList("a", "b", "d").forEach((String e) -> System.out.print(e + '-'));

        // 如果Lambda表达式需要更复杂的语句块，则可以使用花括号将该语句块括起来
        // Lambda表达式可以引用类成员和局部变量（会将这些变量隐式得转换成final的）
        String separator = "/";
        Arrays.asList("p", "k", "u").forEach(e -> {
            e += separator;
            System.out.print(e);
        });

        // Lambda表达式有返回值，返回值的类型也由编译器推理得出
        // 如果表达式中的语句块只有一行，则可以不用使用return语句
        String[] li = { "a", "b", "d" };
        // 相当于{int result = e1.compareTo( e2 ); return result;}
        Arrays.sort(li, (e1, e2) -> e2.compareTo(e1));
        System.out.println(Arrays.toString(li));
    }

}
