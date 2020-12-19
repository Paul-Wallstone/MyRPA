package by.day12.task4;

import java.util.ArrayList;
import java.util.List;

public class MusicBand {
    private String  name;
    private int year;
    private List<String> members;

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public MusicBand(String name, int year, List<String> members) {
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

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }




    public void printMembers (){
        for (String box : members)
        System.out.println(box);

    }
}
