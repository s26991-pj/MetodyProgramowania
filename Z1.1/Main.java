import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Person person = null;
        try {
            person = new Person("Jan", 20);
        } catch (InvalidAgeExceptation e) {
            System.out.println("Złapano wyjątek: " +e.getMessage());
        }

//        try {
//            Person person2 = new Person("Adam", -5);
//        } catch (InvalidAgeExceptation e) {
//            System.out.println("Złapano wyjątek: " +e.getMessage());
//        }

        try{
            person.setAge(-10);
        } catch (InvalidAgeExceptation e) {
            System.out.println("Złapano wyjątek: " +e.getMessage());
        }

        System.out.println("Imię: " + person.getName() + " wiek: " + person.getAge());

        System.out.println("Osoba: " + person);

        Person person2 = new Person("Magda", 35);
        Person person3 = new Person("Andrzej", 28);


        List<Person> immutablePersonList = List.of(person, person2, person3);

//            immutablePersonList.add(Person) -- Rzuca wyjątek ponieważ do listy niemutowalnej nie można dodawać obiektów

        System.out.println("Lista niemutowalna: " + immutablePersonList);


        List<Person> mutablePersonList = new ArrayList<>();
        mutablePersonList.add(person);
        mutablePersonList.add(person2);
        mutablePersonList.add(person3);


        System.out.println("Lista mutowalna: " + mutablePersonList);


        Set<Person> immutablePersonSet = Set.of(person, person2, person3);
        System.out.println("Zbiór niemutowalny: " + immutablePersonSet);

        Set<Person> mutablePersonSet = new HashSet<>();
        mutablePersonSet.add(person);
        mutablePersonSet.add(person2);
        mutablePersonSet.add(person3);
        System.out.println("Zbiór mutowalny: " + mutablePersonSet);

        Map<Integer, Person> immutablePersonMap = Map.of(1, person, 2, person2, 3, person3);
        System.out.println("Mapa niemutowalna: " + immutablePersonMap);

        Map<String, Person> mutablePersonMap = new HashMap<>();
        mutablePersonMap.put("A", person);
        mutablePersonMap.put("B", person2);
        mutablePersonMap.put("C", person3);
        mutablePersonMap.put("A", person2);
        System.out.println("Mapa mutowalna: " + mutablePersonMap);

    ///Streamy
        List<Integer> ageList = immutablePersonList.stream()
                .map(Person::getAge)
                .collect(Collectors.toList());

        Integer ageSum = ageList.stream()
                .reduce(0,(sum, value) -> sum + value);

        System.out.println("Lista wieków: " + ageSum);

        double averageAge = ageSum/ageList.size();
        System.out.println("Średnia wieku: " + averageAge);

        Integer ageSum1 = immutablePersonList.stream()
                .map(p -> p.getAge())
                .reduce(0, (sum, value) -> sum + value);
        System.out.println("suma stream chain " + ageSum1);


        List<String> nameList = immutablePersonList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("Lista imion: " + nameList);


        List<Person> personListAbove25 = immutablePersonList.stream()
                .filter(p -> p.getAge() > 25)
                .collect(Collectors.toList());
        System.out.println("Lista osób powyżej 25 lat: " + personListAbove25);


        List<Person> sortedPersonList = immutablePersonList.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());


        immutablePersonList.stream()
                .forEach(p -> System.out.println("Imię: " + p.getName() + " wiek: " + p.getAge()));


        Person youngestPerson = immutablePersonList.stream()
                .min(Comparator.comparing(Person::getAge))
                .get();
        System.out.println("Najmłodsza osoba: " + youngestPerson.getName());
        System.out.println("Najsstarsza osoba: " + immutablePersonList.stream()
                .max(Comparator.comparing(Person::getAge))
                .get()
                .getName());



    }
}
 