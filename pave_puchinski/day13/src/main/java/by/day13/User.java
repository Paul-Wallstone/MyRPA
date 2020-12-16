package by.day13;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private List<User> subscriptions;

    public User(String username) {
        this.username = username;
        this.subscriptions = new ArrayList<>(); //В этом списке должны храниться те пользователи, на
        //   которых подписан пользователь.
    }

    public String getUsername() {
        return username;
    }

    public List<User> getSubscriptions() {
        return subscriptions;
    }

    //    подписывает пользователя на
//    пользователя user
    public void subscribe(User user) {
        subscriptions.add(user);
    }

    //    возвращает True , если
//    пользователь подписан на пользователя user и False , если не подписан.
    public boolean isSubscribed(User user) {
        boolean checklist = false;

        for (User box : subscriptions) {
            if (box.username == user.username) {
                checklist = true;
                continue;
            }

        }
        return checklist;
    }

    //    Возвращает True , если
//    пользователь  user является другом и False , если пользователь  user не
//    является другом. Подумайте, что такое дружба в контексте соц. сетей.
    public boolean isFriend(User user) {
        boolean checklist = false;
        boolean checklist2 = false;
        // я на него подписан
        for (User box : subscriptions) {
            if (box.username == user.username) {
                checklist = true;
                continue;
            }
        }
        for (User box : user.subscriptions) {
            if (box.username == this.username) {
                checklist2 = true;
                continue;
            }
        }
        if (checklist == checklist2) {
            return true;
        } else return false;


    }

    //отправляет
//сообщение с текстом text пользователю  user . Здесь должен использоваться
//статический метод из  MessageDatabase .
    public void sendMessage(User user, String text) {
        MessageDatabase.sendMessage(this, user, text);

    }
//возвращает строковое представление
//пользователя (имя пользователя).
    public String toString() {
        return this.username;

    }

}
