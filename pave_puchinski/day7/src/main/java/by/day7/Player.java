package by.day7;

public class Player {

    private int stamina;
    private static final int MAX_STAMINA = 100;
    private static final int MIN_STAMINA = 0;
    private static int countPlayers;

    public int getStamina() {
        return stamina;
    }

    public Player(int stamina) {
        if(stamina<=MAX_STAMINA&&stamina>=MIN_STAMINA)
        this.stamina = stamina;
        else System.out.println("ERROR");
        if(countPlayers<6){
        countPlayers++;}
    }

    public void run() {
        if (this.stamina == MIN_STAMINA)
            return;
            this.stamina--;
        if(this.stamina==MIN_STAMINA&& countPlayers>0) {
            countPlayers--;

        }

    }
    public static void info(){
if (countPlayers<6){
    System.out.println("Команды неполные. На поле еще есть "+(countPlayers)+" свободных мест");
} else {
    System.out.println("На поле нет свободных мест " + countPlayers);
}

    }

}
