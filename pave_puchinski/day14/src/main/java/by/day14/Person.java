package by.day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
    private String name;
    private int year;

    public Person(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static List<Person> parseFileToObjList(File file) {
        List<Person> people = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {

                String str = scanner.nextLine();

                String name = str.substring(0, str.indexOf(" "));
                int year = Integer.parseInt(str.substring(str.indexOf(" ") + 1));
                if (0 > year)
                    throw new IllegalArgumentException();
                people.add(new Person(name, year));

            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Такого файла нет");
        } catch (IllegalArgumentException e) {
            System.out.println("Возраст отрицательный");
        }
        return people;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
