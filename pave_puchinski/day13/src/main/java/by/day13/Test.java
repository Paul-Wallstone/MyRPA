package by.day13;

public class Test {
    public static void main(String[] args) {

        User ana = new User("Ana");
        User pavel = new User("Pavel");
        User tolya = new User("Tolya");
        ana.sendMessage(pavel, "Hello!");
        ana.sendMessage(pavel, "What are you doing mtfk?!");
        pavel.sendMessage(ana, "Hi!");
        pavel.sendMessage(ana, "Eating your food!");
        pavel.sendMessage(ana, "How are you?");
        tolya.sendMessage(ana, "Hello!");
        tolya.sendMessage(ana, "You look nice!");
        tolya.sendMessage(ana, "Come with me on coffee!");

//        MessageDatabase.showDialog(ana, pavel);
//        MessageDatabase.showDialog(ana, tolya);
        for (Message box : MessageDatabase.getMessages()) {
            System.out.println( box.toString());

        }
    }
}
