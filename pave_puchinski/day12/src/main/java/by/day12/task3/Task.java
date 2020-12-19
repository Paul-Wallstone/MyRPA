package by.day12.task3;

import java.util.*;

public class Task {
    public static void main(String[] args) {
        List<String> car = new ArrayList<>();

        car.add("BMW");
        car.add("Saab");
        car.add("Ford");
        car.add("Mazda");
        car.add("Reno");
        car.add(3, "Seat");
        car.remove(0);
        for (String box : car) {

            System.out.println(box);
        }

        List<Integer> num = new ArrayList<>();


        for (int i = 0; i < 31; i++) {
            num.add(i);
        }
        for (int i = 300; i < 351; i++) {
            num.add(i);
        }

        for (Integer box : num) {
            System.out.println(box);
        }

        List<MusicBand> bands = new ArrayList<>();

        bands.addAll(Arrays.asList(
                new MusicBand("ABBA", 1967), new MusicBand("Radiohead", 1990),
                new MusicBand("Cage", 2002), new MusicBand("The Aliphant", 2005),
                new MusicBand("White Stripes", 2007), new MusicBand("Placebo", 1991),
                new MusicBand("The Killers", 2003), new MusicBand("Coldplay", 1999),
                new MusicBand("3 Doors Down", 2002), new MusicBand("Sum 41", 2002)
        ));
        Collections.shuffle(bands);
for (MusicBand box: bands){
    System.out.println(box.getName()+box.getYear());
}
        System.out.println();
        Collections.shuffle(bands);
        for (MusicBand box : groupsAfter2000(bands)) {
            System.out.println(box.getName()+box.getYear());


        }

    }

    public static List<MusicBand> groupsAfter2000(List<MusicBand> bands) {
        List<MusicBand> listbands = new ArrayList<>();
        for (MusicBand box : bands) {
            if (box.getYear() >= 2000)
                listbands.add(box);
        }

        return listbands;
    }


}
