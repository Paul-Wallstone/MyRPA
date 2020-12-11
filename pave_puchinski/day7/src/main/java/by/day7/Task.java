package by.day7;

public class Task {
    public static void main(String[] args) {

        Airplane airplane1 = new Airplane("SSR", 2019, 200, 70000);
        Airplane airplane2 = new Airplane("DDW", 2015, 250, 100000);
        Airplane.compareAirplanes(airplane1, airplane2);

        Player player1 = new Player(91);
        Player player2 = new Player(90);
        Player player3 = new Player(95);
        Player player4 = new Player(91);
        Player player5 = new Player(99);
        Player player6 = new Player(94);
        Player.info();
        Player player7 = new Player(94);
        Player.info();
        int x = 0;
        while (x < 100) {
            player1.run();
            player2.run();
            x++;
        }
        Player player8 = new Player(94);
        Player.info();
    }
}
