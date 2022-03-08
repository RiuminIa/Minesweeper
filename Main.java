import uloha1.Student;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.parallelSort;

public class Main {
    public static void main(String[] args) {
        Student[] one={new Student(1,"pizda","huinya",16),new Student(2,"hui","hernya",25),new Student(0,"huinya","uebok",2),new Student(36,"debil","eblo",56)};
        Arrays.sort(one, Collections.reverseOrder(Student::compareByName));
        Arrays.sort(one, Collections.reverseOrder(Student::compareByAge));
        parallelSort(one, Collections.reverseOrder(Student::compareByAge));
       // Arrays.stream(one).sorted();
        for(Student on:one){
            System.out.println(on.getId()+" "+on.getMeno()+" "+on.getPreizvisko());
        }
    }
}
