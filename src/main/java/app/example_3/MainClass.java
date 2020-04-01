package app.example_3;

import java.util.Date;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {

        Stream<Date> stream1 = Stream.generate(Date::new);
        //stream.forEach(p -> System.out.println(p));

        IntStream stream2 = "12345_abcde".chars();
        stream2.forEach(p -> System.out.print(p+" "));

        










    }
}
