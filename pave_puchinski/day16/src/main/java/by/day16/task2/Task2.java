package by.day16.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws IOException {

        Charset utf8 = StandardCharsets.UTF_8;
        List<String> list = new ArrayList<>();
        PrintWriter pw = new PrintWriter("file1.txt");
        PrintWriter pw2 = new PrintWriter("file2.txt");

        Random random = new Random();
        String listnum = new String();
        for (int i = 0; i < 101; i++)
            listnum += random.nextInt(100) + " ";

        list.add(listnum);
        Files.write(Paths.get("file1.txt"), list, utf8);
        File file = new File("file1.txt");
        File file2 = new File("file2.txt");
        Scanner scanner = new Scanner(file);
        String str = scanner.nextLine();

        String[] numbers = str.split(" ");
        int x = 0;
        double avgSum = 0.0;
        listnum = "";
        list.clear();
        for (String box : numbers) {
            avgSum += Double.parseDouble(box);
            x++;
            if (x == 20) {
                listnum += Double.toString(avgSum / 20) + " ";

                x = 0;
            }

        }
        list.add(listnum);
        Files.write(Paths.get("file2.txt"), list, utf8);

        printResult(file2);
    }

    public static void printResult(File file) throws FileNotFoundException {
        double sum = 0.0;
        Scanner scanner = new Scanner(file);
        String str = scanner.nextLine();
        String[] numbers = str.split(" ");
        for (String box : numbers) {

            sum += Double.parseDouble(box);
        }
        int a = (int) sum;
        System.out.printf("%d",a);
    }
}
