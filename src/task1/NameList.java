package task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class NameList {

    public static void main(String[] args) {
        List<Names> names1 = new ArrayList<>();
        names1.add(new Names("Vitalii"));
        names1.add(new Names("Viktor"));
        names1.add(new Names("Svitlana"));

        List<Names> names2 = new ArrayList<>();
        names2.add(new Names("Marina"));
        names2.add(new Names("Tania"));
        names2.add(new Names("Oleksiy"));
        List<List<Names>> lists = List.of(names1, names2);

        AtomicInteger i = new AtomicInteger(1);

        String collect = lists.stream()
                .flatMap(Collection::stream)
                .map(u -> i.get() + ". " + u.getName())
                .filter(s -> {
                    return i.getAndIncrement() % 2 != 0;
                })
                .collect(Collectors.joining(", "));

        System.out.println(collect);
    }
}
