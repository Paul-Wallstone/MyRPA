package by.day5;

public class Task {
    public static void main(String[] args) {

        Car car = new Car();

        car.setColor("Blue");
        car.setModel("321");
        car.setYear(2020);

        System.out.println("Color:" + car.getColor() + "\nYear:" + car.getYear() + "\nModel:" + car.getModel());

        Motorbike motorbike = new Motorbike("221", "red", 1967);
        System.out.println("Color:" + motorbike.getColor() + "\nYear:" +
                motorbike.getYear() + "\nModel:" + motorbike.getModel());
    }
}
