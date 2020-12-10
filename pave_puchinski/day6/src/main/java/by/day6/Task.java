package by.day6;

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
        motorbike.info();
        System.out.println(motorbike.yearDifference(1900));
        car.info();
        System.out.println(car.yearDifference(2011));


        Airplane airplane = new Airplane("JVC", 2001, 150, 10000);
        airplane.setYear(2002);
        airplane.setLength(155);
        airplane.fillUp(500);
        airplane.fillUp(55);
        airplane.info();
        Teacher teacher= new Teacher("Steve", "Math");
        Student student = new Student("Paul");
        teacher.evaluate(student.getName());
    }
}
