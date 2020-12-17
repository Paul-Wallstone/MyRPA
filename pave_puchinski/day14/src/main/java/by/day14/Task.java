package by.day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {

        File file = new File("test");
        File file2 = new File("people");
        printSumDigits(file);
        System.out.println(parseFileToStringList(file2));
        System.out.println(Person.parseFileToObjList(file2));

    }

    static void printSumDigits(File file) {
        try {
            Scanner sc = new Scanner(file);
            String line = sc.nextLine();
            String[] numbers = line.split(" ");
            if (numbers.length != 10)
                throw new IllegalArgumentException();

            int sum = 0;
            for (String box : numbers) {

                sum += Integer.parseInt(box);
            }
            System.out.println(sum);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла нет");

        } catch (IllegalArgumentException e) {
            System.out.println("В файле не 10 занчений");
        }
    }

    public static List<String> parseFileToStringList(File file) {

        List<String> list = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String str = sc.nextLine();
                int num = Integer.parseInt(str.substring(str.indexOf(" ") + 1));
                if (0 > num)
                    throw new IllegalArgumentException();
                list.add(str);

            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла нет");
        } catch (IllegalArgumentException e) {

            System.out.println("Возраст отрицательный");
        }

        return list;
    }

}