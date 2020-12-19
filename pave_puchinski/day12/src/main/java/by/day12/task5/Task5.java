package by.day12.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {

        List<MusicBand> bands = new ArrayList<>();
        MusicArtist musicArtist = new MusicArtist("Paul", 1988);
        MusicArtist musicArtist1 = new MusicArtist("Stive", 1999);
        MusicArtist musicArtist2 = new MusicArtist("Ana", 1994);
        MusicArtist musicArtist3 = new MusicArtist("Ben", 1990);
        List<MusicArtist> artists = new ArrayList<>(Arrays.asList(musicArtist, musicArtist1));
        List<MusicArtist> artists1 = new ArrayList<>(Arrays.asList(musicArtist2, musicArtist3));


        bands.addAll(Arrays.asList(
                new MusicBand("ABBA", 1967, artists),
                new MusicBand("Radiohead", 1990, artists1),
                new MusicBand("Cage", 2002), new MusicBand("The Aliphant", 2005),
                new MusicBand("White Stripes", 2007), new MusicBand("Placebo", 1991),
                new MusicBand("The Killers", 2003), new MusicBand("Coldplay", 1999),
                new MusicBand("3 Doors Down", 2002), new MusicBand("Sum 41", 2002)
        ));
//        bands.get(1).printMembers();
//        bands.get(0).printMembers();

//        for (MusicArtist box : bands.get(0).getMembers()) {
//             System.out.println(box.getName()+box.getYear());
//
//        }
        MusicBand.transferMembers(bands.get(0), bands.get(1));
        bands.get(0).printMembers();


    }




}

