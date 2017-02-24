package streaming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamingBasis {
    
    /**
     * 集合是关于数据的，而Java流是关于计算的
     * 粗看之，集合与流的区别就是与何时处理数据有关。
     * 集合是内存中的数据结构，它包含有当前数据结构中的全部值--将所有元素加入到集合之前，必须先对所有元素进行处理。
     * 相反地，Java流只是逻辑上固定的数据结构，它里面的元素只会根据需要进行处理。
     * 能够被连接在一起的Java流操作被称为中间操作。这些操作之所以能被连接在一起，是因为它们都会返回Stream对象。
     * Java流管道的最终操作被调用之前，中间操作并不会执行任何处理；它们是"惰性"方法。
     * 在调用collect()操作之前，没有实际工作会被执行。
     * 这是因为中间方法经常会被"合并"，在最终操作中它们会被合成为单一的执行路径。
     */
    
    /**
     * 总结：
     * 一个数据源(例如一个集合)，对它执行查询
     * 一个中间操作的链，它组成一个流的管道
     * 一个最终操作，它执行流的管道并产生结果
     */

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> twoEvenSquares = numbers.stream().filter(n -> {
            System.out.println("filtering " + n + ", result = " + (n % 2 == 0));
            return n % 2 == 0;
        }).map(n -> {
            System.out.println("mapping " + n);
            return n * n;
        }).limit(2).collect(Collectors.toList());
        
        /*
         * limit(2)使用了短路；我们只需要处理流的一部分，而不是全部，去得到一个结果。
         * 这就类似于测评一个由and操作符关联起来的大型布尔表达式链：
         * 一旦某个表达式返回了false，那么就可以认为整个表达式链就是false，而不必测评所有的表达式了。
         * 在这个例子中，limit()方法将返回的Java流的长度限定为2。
         * 另外，filter与map被合并在了同一条执行路径中了。
         */
        
        System.out.print(twoEvenSquares);
    }

}
