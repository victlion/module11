package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
    public void taskOne(List<String> listName){
        List<String> newList = listName.stream()
                .filter(x -> listName.indexOf(x) % 2 == 1)
                .map(y -> (listName.indexOf(y)) + ". " + y + " ")
                .collect(Collectors.toList());
        newList.forEach(System.out::print);
    }
    public List<String> taskTwo(List<String> stringList){
        return stringList.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
    public String taskThree(List<String> stringList){
        List<String> newList = stringList.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .sorted()
                .collect(Collectors.toList());
        return String.valueOf(newList);
    }
    public Stream<Long> taskFour(long a, long c, long m, long seed){
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Stream.Builder<T> builder = Stream.builder();
       Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            builder.accept(iterator1.next());
            builder.accept(iterator2.next());
        }
        return builder.build();
    }
}
