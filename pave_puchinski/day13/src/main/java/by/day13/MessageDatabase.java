package by.day13;

import java.util.ArrayList;
import java.util.List;

public class MessageDatabase {
    private static List<Message> messages = new ArrayList<>();

    //этот метод “отправляет” новое сообщение от пользователя  u1 пользователю
    //u2 с текстом  text . Отправка в нашем контексте означает добавление
    //сообщения в нашу “базу данных”.
    public static void sendMessage(User u1, User u2, String text) {
        messages.add(new Message(u1, u2, text));
    }

    public static List<Message> getMessages() {
        return messages;
    }

    //этот метод
//должен вывести цепочку сообщений (диалог) пользователей u1 и  u2 .
    public static void showDialog(User u1, User u2) {
        for (Message box : messages) {
            if (box.getSender().getUsername() == u1.getUsername() &&
                    box.getReceiver().getUsername() == u2.getUsername()) {
                System.out.printf("%s: %s", u1.getUsername(), box.getText());
                System.out.println();
            } else if (box.getSender().getUsername() == u2.getUsername() &&
                    box.getReceiver().getUsername() == u1.getUsername()) {
                System.out.printf("%s: %s", u2.getUsername(), box.getText());
                System.out.println();
            }

        }
    }

}
