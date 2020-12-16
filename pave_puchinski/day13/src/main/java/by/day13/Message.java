package by.day13;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Message {

    private User sender;
    private User receiver;
    private String text;
    private Date date;

    public Message(User sender, User receiver, String text) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.date = new Date();
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }
//возвращает строковое представление сообщения
//в таком формате:
//FROM: 'Имя отправителя'
//TO: 'Имя получателя'
//ON: Sun Aug 30 19:07:34 MSK 2020
//'Текст сообщения'
    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat(" E MMM HH:mm:ss yyyy ");
       // Calendar calendar = new GregorianCalendar();
      return  "FROM: " + sender+
              "\nTO: " + receiver +
              "\nON: " + date+"\n"+
              text;

    }
}
