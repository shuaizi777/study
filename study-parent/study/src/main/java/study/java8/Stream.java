package study.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/5/31 22:36
 */
public class Stream {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = stringList.stream().filter((String s) ->
                !s.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);
        /* Random random = new Random();
        random.ints().limit(10).forEach(System.out::println); */
        List<String> list = Arrays.asList("1", "2", "6", "3");
        list.stream().distinct()
                .sorted().forEach(System.out::println);
        System.out.println(list.stream().distinct()
                .sorted().collect(Collectors.toList()).toString());

    }
}
