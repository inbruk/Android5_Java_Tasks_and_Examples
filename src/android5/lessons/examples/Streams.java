package JavaLessons.Task521;

import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(1, integer -> integer + 1);

        System.out.println();

        Stream<String> stringStream =
            stream.map(String::valueOf)
            .distinct()
            .limit(5);
        stringStream.forEach(System.out::println);

//-------------------------------------------------------------
//        System.out.println();
//
//        IntStream stream2 = IntStream.generate(() -> 15);
//        OptionalDouble average = stream2.mapToLong(integer -> integer)
//                .average();
//        System.out.println(average.orElseThrow(() -> new RuntimeException()));

//-------------------------------------------------------------
        System.out.println();

        LongStream ls = LongStream.of(1, 2, 3);
        OptionalLong opt = ls.map(n -> n * 10).filter(n -> n < 5).findFirst();

        opt.ifPresent(System.out::println);
    }
}
