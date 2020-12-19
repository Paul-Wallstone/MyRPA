package by.day12.task4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task4 {
    public static void main(String[] args) {
        List<MusicBand> bands = new ArrayList<>();


        bands.addAll(Arrays.asList(
                new MusicBand("ABBA", 1967, Arrays.asList("Pall Wallstone", "Ray Charles")),
                new MusicBand("Radiohead", 1990, Arrays.asList("Fred Gal")),
                new MusicBand("Cage", 2002), new MusicBand("The Aliphant", 2005),
                new MusicBand("White Stripes", 2007), new MusicBand("Placebo", 1991),
                new MusicBand("The Killers", 2003), new MusicBand("Coldplay", 1999),
                new MusicBand("3 Doors Down", 2002), new MusicBand("Sum 41", 2002)
        ));
//        bands.get(1).printMembers();
//        bands.get(0).printMembers();
        for (String box : bands.get(0).getMembers()) {
           // System.out.println(box);

        }
        transferMembers(bands.get(0), bands.get(1));
        bands.get(0).printMembers();
    }

    public static void transferMembers(MusicBand band1, MusicBand band2) {
        List<String> newlist = new ArrayList<>();
        for (String box : band1.getMembers()) {
            newlist.add(box);

        }
        for (String box : band2.getMembers()) {
            newlist.add(box);

        }
        band1.setMembers(newlist);
    }

}
