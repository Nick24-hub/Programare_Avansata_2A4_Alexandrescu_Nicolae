import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        //creez studentii
        Faker faker = new Faker();
        Student[] students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student(faker.leagueOfLegends().champion()))
                .toArray(Student[]::new);


        //pun note random
        Random rand = new Random();

        for (Student student : students) {
            student.setGrade((rand.nextInt(901) + 100) / 100f);
        }

        for (Student student : students) System.out.println(student.toString());
        System.out.println();

        //creez scolile
        School[] schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i))
                .toArray(School[]::new);

        //setez capacitatile
        schools[0].setCapacity(1);
        schools[1].setCapacity(2);
        schools[2].setCapacity(2);

        for (School school : schools) System.out.println(school.toString());
        System.out.println();

        //sortez studentii
        List<Student> studentList = new LinkedList<>(Arrays.asList(students));
        Collections.sort(studentList);

        System.out.println("Lista studentilor ordonati crescator dupa note: " + studentList);
        System.out.println();


        //creez un set pentru scoli
        Set<School> schoolSet = new TreeSet<>();
        schoolSet.addAll(Arrays.asList(schools));

        //setez preferintele pentru studenti
        students[0].setPreferences(Arrays.asList(schools[0], schools[1], schools[2]));
        students[1].setPreferences(Arrays.asList(schools[0], schools[1], schools[2]));
        students[2].setPreferences(Arrays.asList(schools[0], schools[1]));
        students[3].setPreferences(Arrays.asList(schools[0], schools[2]));

        //setez preferintele pentru scoli
        schools[0].setPreferences(Arrays.asList(students[3], students[0], students[1], students[2]));
        schools[1].setPreferences(Arrays.asList(students[0], students[2], students[1]));
        schools[2].setPreferences(Arrays.asList(students[0], students[1], students[3]));

        //creez un map pentru preferintele studentilor
        Map<Student, List<School>> stdPrefMap = new HashMap<>();
        stdPrefMap.put(students[0], students[0].getPreferences());
        stdPrefMap.put(students[1], students[1].getPreferences());
        stdPrefMap.put(students[2], students[2].getPreferences());
        stdPrefMap.put(students[3], students[3].getPreferences());

        System.out.println("Preferintele studentilor:" + stdPrefMap);
        System.out.println();

        //creez un map pentru preferintele scolilor
        Map<School, List<Student>> schPrefMap = new TreeMap<>();
        schPrefMap.put(schools[0], schools[0].getPreferences());
        schPrefMap.put(schools[1], schools[1].getPreferences());
        schPrefMap.put(schools[2], schools[2].getPreferences());

        System.out.println("Preferintele scolilor: " + schPrefMap);
        System.out.println();


        Problem p = new Problem();
        p.setStdNumber(4);
        p.setSchNumber(3);
        p.setStudentList(Arrays.asList(students));
        p.setSchoolList(Arrays.asList(schools));

        //afisez studentii care au pe primul loc la preferinte scoala H0
        studentList.stream()
                .filter(student -> student.getPreferences().indexOf(schools[0])==0 )
                .forEach(System.out::println);
    }
}
