package by.day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/main/resources/shoes.csv");
        Scanner scanner = new Scanner(file);
        List<String> line = new ArrayList<>();
        File file1 = new File("src/main/resources/missing_shoes.txt");
        PrintWriter pw = new PrintWriter(file1);

        while (scanner.hasNext()) {

            String str = scanner.nextLine();
            line.add(str);
            String[] words = str.split(";");
        }
        scanner.close();

        for (String box : line) {

            String[] numbers = new String[3];
            numbers = box.split(";");
            if (Integer.parseInt(numbers[2]) == 0) {

                pw.println(box);

            }


        }
        pw.close();
    }

}
