package by.day12.task5;

import java.util.List;

public class MusicBand {
    private String name;
    private int year;
    private List<MusicArtist> members;

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public MusicBand(String name, int year, List<MusicArtist> members) {
        this.name = name;
        this.year = year;
        this.members = members;
    }

    public MusicBand() {
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

    public List<MusicArtist> getMembers() {
        return members;
    }

    public void setMembers(List<MusicArtist> members) {
        this.members = members;
    }


    public void printMembers() {
        for (MusicArtist box : members)
            System.out.println(box.getName() + " " + box.getYear());

    }

    public static void transferMembers(MusicBand band1, MusicBand band2) {

        for (MusicArtist box : band2.getMembers()) {

            band1.getMembers().add(box);
        }

        band2.getMembers().clear();
    }
}
