package app.example_1;

import java.util.Arrays;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Yusif", "Memmedov", 21),
                new Person("Kenan", "Sultanov",20),
                new Person("Elmeddin","Pasayev",21),
                new Person("Yasemen", "Sultanova", 23),
                new Person("Elmir", "Memmedov",20),
                new Person("Kamran","Piriyev",22)
        );


        people.stream()
                .filter(p -> p.getSurname().startsWith("Memmed") )
                .forEach(p -> System.out.println(p.getName()));

        long count = people.stream()
                .filter(p -> p.getAge() > 21)
                .count();

        System.out.println(count);


        people.stream()
                .filter(p -> p.getSurname().startsWith("Memmed"))
                .forEach(p -> System.out.println(p.getName()));

    }
}
