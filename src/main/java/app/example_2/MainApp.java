package app.example_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) throws IOException {

        // 1. Integer Stream
        IntStream
                .range(1,10)
                .forEach(System.out::print);

        System.out.println("\n******************************************************");

        // 2. Integer Stream with skip
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(System.out::print);

        System.out.println("\n******************************************************");

        // 3. Integer Stream with sum
        System.out.println(IntStream
                .range(1,10)
                .sum());
        System.out.println("\n******************************************************");

        // 4. Integer Stream with average
        System.out.println(IntStream
                .range(1,10)
                .average());

        System.out.println("\n******************************************************");

        // 5. Integer Stream with generate
        IntStream.generate(() -> {
            return (int) (Math.random()*100);
        }).limit(5).forEach(System.out::println);

        System.out.println("\n******************************************************");

        //6. Integer Stream with Builder
        IntStream build = IntStream.builder().add(5).add(7).add(14).build();
        build.forEach(x -> System.out.print(x+" "));

        System.out.println("\n******************************************************");


        // 7. Stream.of, sorted and findFirst
        Stream.of("car","phone","table")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("\n******************************************************");

        // 8. Stream from Array sort,filter and print
        String[] cars = {"Hyundai","Toyota","Chevrolet","Kia"};

        Stream.of(cars)
                .filter(x -> x.length()>5)
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n******************************************************");

        // 9. Average of square of an int array

        int[] numbers = {1,7,9,13,56,22,4};

        Arrays.stream(numbers)
                .map(x -> x *x)
                .average()
                .ifPresent(System.out::println);

        System.out.println("\n******************************************************");

        // 10. Stream from List , filter and print
        List<String> people = Arrays.asList("Jack","John","Helen","Mark","Kevin","Tom");

        people.stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("j"))
                .forEach(System.out::println);

        System.out.println("\n******************************************************");

        Stream<String> players = Files.lines(Paths.get("src\\main\\java\\app\\example_2\\players.txt"));

        players
                .sorted()
                .filter(x -> x.length()>6)
                .forEach(System.out::println);
        players.close();

        System.out.println("\n******************************************************");

        





    }
}
