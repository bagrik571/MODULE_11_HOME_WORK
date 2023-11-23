package task2;

import task1.Names;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ListName {
    public static void main(String[] args) {
        List<Names> namesList1 = List.of(new Names("Vitalii"), new Names("Viktor"), new Names("Svitlana"));
        List<Names> namesList2 = List.of(new Names("Marina"), new Names("Tania"), new Names("Oleksiy"));
        List<List<Names>> lists = List.of(namesList1, namesList2);

        String collect = lists.stream()
                .flatMap(Collection::stream)
                .map(u -> u.getName().toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining("\n"));

        System.out.println(collect.toString());
    }

}
