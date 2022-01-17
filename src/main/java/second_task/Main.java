package second_task;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]));
        }
        //несовершеннолетние
        long count = persons.stream().filter(s -> s.getAge() < 18).count();
        System.out.println(count);
        //Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
        List<String> collect = persons.stream().filter(s -> s.getAge() >= 18 && s.getAge() <= 27).map(Person::getFamily).collect(Collectors.toList());
        collect.forEach(System.out::print);
        //Получить отсортированный по фамилии список потенциально работоспособных людей с высшим образованием в выборке (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).

        List<Person> collect1 = persons.stream().filter(person -> (person.getSex().equals(Sex.MAN)) &&
                        (person.getAge() >= 18 && person.getAge() <= 60) || (person.getSex().equals(Sex.WOMAN)) &&
                        (person.getAge() >= 18 && person.getAge() <= 65)).sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());

        System.out.println(collect1);


    }
}
