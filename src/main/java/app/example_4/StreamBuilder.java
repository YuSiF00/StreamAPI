package app.example_4;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBuilder {
    public static void main(String[] args) {

        List<String> studentNames = new ArrayList<>();

        studentNames.add("Yusif");
        studentNames.add("Kenan");
        studentNames.add("Elmeddin");
        studentNames.add("Eldar");
        studentNames.add("Eli");
        studentNames.add("Vuqar");
        studentNames.add("Kamran");
        studentNames.add("Nermin");
        studentNames.add("Ziver");
        studentNames.add("Aysel");
        studentNames.add("Sebine");
        studentNames.add("Tamilla");
        studentNames.add("Nigar");
        studentNames.add("Aygul");


        // filter()
        studentNames.stream().filter(s -> s.startsWith("E")).forEach(System.out::println);
        System.out.println("\n***************************************************\n");

        // map()
        studentNames.stream().filter(s -> s.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);
        System.out.println("\n***************************************************\n");


        // sorted()
        studentNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("\n***************************************************\n");


        // collect()
        List<String> studentNamesInUpperCase = studentNames.stream().sorted().collect(Collectors.toList());
        System.out.println(studentNamesInUpperCase);
        System.out.println("\n***************************************************\n");

        // match()
        boolean matchResult = studentNames.stream()
                .anyMatch(s -> s.startsWith("Y"));
        System.out.println(matchResult);

        matchResult = studentNames.stream()
                .allMatch(s -> s.startsWith("Y"));
        System.out.println(matchResult);

        matchResult = studentNames.stream()
                .noneMatch(s -> s.startsWith("Y"));
        System.out.println(matchResult);

        System.out.println("\n***************************************************\n");

        // count()
        long totalStudent = studentNames.stream()
                .count();
        System.out.println(totalStudent);

        long countStudent = studentNames.stream()
                .filter(s -> s.length()==5)
                .count();
        System.out.println(countStudent);

        System.out.println("\n***************************************************\n");

        // reduced()
        Optional<String> reduce = studentNames.stream().reduce((s1, s2) -> s1 + "#" + s2);

        reduce.ifPresent(System.out::println);
        System.out.println("\n***************************************************\n");


        // findFirst()
        Optional<String> FirstStudentName = Optional.of(studentNames.stream().filter(s -> s.startsWith("E"))
                .findFirst().get());
        System.out.println(FirstStudentName);
        System.out.println("\n***************************************************\n");


        // distinct()
        Collection<String> list = Arrays.asList("A","B","C","C","D","A","D","B","E","A");

        List<String> distinct_elements = list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct_elements);
        System.out.println("\n***************************************************\n");


        // peek()
        list.stream().distinct().peek(System.out::println).collect(Collectors.toSet());
        System.out.println("\n***************************************************\n");


        // iterate() && limit()
        Stream<Integer> evenNumInfiniteStream = Stream.iterate(0, n->n+2);
        evenNumInfiniteStream.limit(10).forEach( i -> System.out.print(i+" "));
        System.out.println("\n***************************************************\n");

        // skip()
        Stream<Integer> evenNumInfiniteStream2 = Stream.iterate(0, n->n+2);
        evenNumInfiniteStream2.skip(5).limit(5).forEach(System.out::println);
        System.out.println("\n***************************************************\n");


        // forEachOrdered()
        List<Integer> newList = Arrays.asList(6,10,2,8,4);
        newList.stream().parallel().forEachOrdered(System.out::println);
        System.out.println("\n***************************************************\n");


        // min() && max()
        List<Integer> newList2 = Arrays.asList(9,43,51,67,34,79,12,6,95,33,58);

        Optional<Integer> min_number = newList2.stream()
                .min(Integer::compareTo);

        Optional<Integer> max_number = newList2.stream()
                .max(Integer::compareTo);

        System.out.println("Min : "+ min_number);
        System.out.println("Max : "+ max_number);
        System.out.println("\n***************************************************\n");

        // flatMap()

        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        List<List<Integer>> listOfLists = Arrays.asList(list1,list2,list3);

        List<Integer> integerList = listOfLists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(integerList);
        System.out.println("\n***************************************************\n");

        // if-else logic
        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9);

        Consumer<Integer> action = i -> {
          if(i%2==0){
              System.out.println("Even Number : " + i);
          }else{
              System.out.println("Odd number : " + i);
          }
        };

        numberList.forEach(action);


    }
}
