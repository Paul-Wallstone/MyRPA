package by.project;

public class User {

    private String name;
    private int battles;
    private int losses;
    private int wins;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public int getBattles() {
        return battles;
    }

    public void setBattles(int battles) {
        this.battles = battles;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public String getName() {
        return name;
    }
}
