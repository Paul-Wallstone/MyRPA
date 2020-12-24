package by.day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/text");
        double x = printResult(file);
        System.out.printf("%.15f,%.3f ", x,x );
    }

    public static Double printResult(File file) throws FileNotFoundException {
        double avSum = 0.0;
        String line = new String();
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            line = sc.nextLine();

        }
        sc.close();
        String[] numbers = line.split(" ");
        for (String box : numbers) {
            avSum += Double.parseDouble(box);
        }
        return avSum = avSum / numbers.length;

    }
}
