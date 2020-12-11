package by.day8;

public class Airplane {
    private String producer;
    private int year;
    private int length;
    private int weight;
    private int fuel;

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public int getFuel() {
        return fuel;
    }

    public Airplane(String producer, int year, int length, int weight) {
        this.producer = producer;
        this.year = year;
        this.length = length;
        this.weight = weight;
        this.fuel = 0;
    }

    public void info() {
        System.out.println("Изготовитель: " + producer + ", год выпуска: " + year + ", длина: " + length +
                ", вес:" + weight + ", количество топлива в баке: " + getFuel());

    }

    public void fillUp(int fuel) {
        this.fuel += fuel;

    }

    public static void compareAirplanes (Airplane airplane1,Airplane airplane2){
if(airplane1.length>airplane2.length){
    airplane1.info();
}
else airplane2.info();

    }


    @Override
    public String toString() {
        return "Изготовитель: " + producer + ", год выпуска: " + year + ", длина: " + length +
        ", вес:" + weight + ", количество топлива в баке: " + getFuel();
    }
}
