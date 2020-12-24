package by.Project;


import java.util.Scanner;


public class Game {


    public static void main(String[] args) {
        boolean exit = true;
        boolean next = true;
        Scanner sc = new Scanner(System.in);
        Command command = null;
        String userfield1[][] = new String[11][11];
        String userfield2[][] = new String[11][11];
        String userfield1B[][] = new String[11][11];
        String userfield2B[][] = new String[11][11];
        SeaField seaField = null;
        SeaField seaField2 = null;
        User user1 = null;
        User user2 = null;
        int statusGameReady = 0;

        while (exit) {

            do {
                System.out.printf("_______MENU_______\n" +
                        "New_Game --- press 1\n" +
                        "Start --- press 2\n" +
                        "Exit --- press 3\n");


                String str = sc.next();
                String[] ch = str.split("");
                for (String h : ch) {
                    if (!Character.isDigit(h.charAt(0))) {
                        System.out.println("Неверная команда!");
                        next = true;
                        break;
                    }
                    command = Command.getcommand(Integer.parseInt(h));
                    if (command.getNum() < 0 && command.getNum() > 3) {
                        next = true;
                        System.out.println("Неверная команда!");
                    } else next = false;
                }


            } while (next);


            switch (command) {
                case NEW_GAME:

                    System.out.print("Введите имя 1 игрока:");
                    sc.nextLine();
                    user1 = new User(sc.nextLine());

                    System.out.print("Введите имя 2 игрока:");
                    user2 = new User(sc.nextLine());
                    System.out.println();

                    seaField = new SeaField(userfield1, user1);
                    seaField2 = new SeaField(userfield2, user2);

                    seaField.defaultField();
                    seaField.print();

                    seaField2.defaultField();
                    seaField2.print();


                    newGame(user1, seaField);
                    newGame(user2, seaField2);
                    statusGameReady = 1;
                    break;
                case EXIT:
                    exit = false;
                    System.out.println("Exit");
                    break;
                case START:
                    if (statusGameReady == 1) {
                        exit = true;
                        SeaField seaField1B = new SeaField(userfield1B, user1);
                        SeaField seaField2B = new SeaField(userfield2B, user2);
                        seaField1B.defaultField();
                        seaField2B.defaultField();
                        int countsForWin = 0;
                        int countsForWin2 = 0;
                        while (exit) {
                            //ход игрока 1

                            turns(seaField, seaField2, user1, seaField2B, countsForWin);
                            if (countsForWin == 20) {
                                System.out.println("Игрок: " + user1.getName() + " победил!");
                                sc.nextLine();
                                exit = false;
                                continue;
                            }

                            //ход игрока 2
                            turns(seaField2, seaField, user2, seaField1B, countsForWin2);
                            if (countsForWin2 == 20) {
                                System.out.println("Игрок: " + user2.getName() + " победил!");
                                sc.nextLine();
                                exit = false;
                                continue;
                            }
                        }
                    }

                    break;
                default:
                    break;


            }
        }
    }


    //проверка вводимых символов
    public static String check(String h) {
        boolean checkLetter = false;
        if (Character.isDigit(h.charAt(0)))
            if (Integer.parseInt(h) > 10 || Integer.parseInt(h) <= 0) {
                System.out.println("НЕВЕРНО ВВЕДЕНЫ КООРДИНАТЫ ПО ГОРИЗОНТАЛИ");
                return "error";
            }
        if (!Character.isDigit(h.charAt(0))) {
            String[] lineABC = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

            for (int j = 0; j < 11; j++) {

                if (lineABC[j].charAt(0) == h.charAt(0))
                    checkLetter = true;
            }

            if (!checkLetter) {
                System.out.println("НЕВЕРНО ВВЕДЕНЫ КООРДИНАТЫ ПО ВЕРТИКАЛИ");
                return "error";
            }
        }
        return h;
    }

    public static void newGame(User user1, SeaField seaField) {

        boolean ready = true;
        seaField.setCountShips(0);
        int ship1 = 0;
        int ship2 = 0;
        int ship3 = 0;
        int ship4 = 0;
        Scanner sc = new Scanner(System.in);
        while (ready) {
            System.out.println(user1.getName() + " введите координаты корабля в формате \"A1A4\"");
            String coordinates = sc.nextLine();
            String pos0 = "";
            String pos1 = "";
            String pos2 = "";
            String pos3 = "";
            if (coordinates.length() == 5) {
                if (Character.isDigit(coordinates.charAt(2))) {
                    pos0 += Character.toString(coordinates.charAt(0));
                    pos1 += Character.toString(coordinates.charAt(1));
                    pos1 += Character.toString(coordinates.charAt(2));
                    pos2 = Character.toString(coordinates.charAt(3));
                    pos3 = Character.toString(coordinates.charAt(4));
                } else if (Character.isDigit(coordinates.charAt(4))) {
                    pos0 += Character.toString(coordinates.charAt(0));
                    pos1 = Character.toString(coordinates.charAt(1));
                    pos2 = Character.toString(coordinates.charAt(2));
                    pos3 += Character.toString(coordinates.charAt(3));
                    pos3 += Character.toString(coordinates.charAt(4));
                }

            } else if (coordinates.length() == 6) {
                pos0 += Character.toString(coordinates.charAt(0));
                pos1 += Character.toString(coordinates.charAt(1));
                pos1 += Character.toString(coordinates.charAt(2));
                pos2 = Character.toString(coordinates.charAt(3));
                pos3 += Character.toString(coordinates.charAt(4));
                pos3 += Character.toString(coordinates.charAt(5));

            } else if (coordinates.length() == 4) {
                pos0 += Character.toString(coordinates.charAt(0));
                pos1 = Character.toString(coordinates.charAt(1));
                pos2 = Character.toString(coordinates.charAt(2));
                pos3 = Character.toString(coordinates.charAt(3));
            }
            if (pos0 != pos1 && pos2 != pos3 && !Character.isDigit(pos0.charAt(0)) && !Character.isDigit(pos2.charAt(0)) &&
                    Character.isDigit(pos1.charAt(0)) && Character.isDigit(pos3.charAt(0))) {
                switch (seaField.addUserShip(check(pos0),
                        check(pos1), check(pos2), check(pos3))) {

                    case 10: {

                        System.out.println("Выход");
                        ready = false;
                        break;
                    }
                    case 1:
                        if (ship1 == 1) {
                            System.out.println("Однопалубные корабли расставлены!");
                            break;
                        }
                        seaField.countShips += 1;
                        seaField.print();

                        System.out.println(seaField.getCountShips());
                        ship1++;
                        break;
                    case 2:
                        if (ship2 == 0) {
                            System.out.println("Двухпалубные корабли расставлены!");
                            break;
                        }
                        seaField.countShips += 1;
                        seaField.print();

                        ship2++;
                        break;
                    case 3:
                        if (ship3 == 0) {
                            System.out.println("Трехпалубные корабли расставлены!");
                            break;
                        }
                        seaField.countShips += 1;
                        seaField.print();
                        ship3++;
                        break;
                    case 4:
                        if (ship4 == 0) {
                            System.out.println("Четырехпалубные корабли расставлены!");
                            break;
                        }
                        seaField.countShips += 1;
                        seaField.print();
                        ship4++;
                        break;
                    default:
                        System.out.println("Корабль не создан!");
                        seaField.print();
                        break;

                }
                if (ship1 == 1 && ship2 == 0 && ship3 == 0 && ship4 == 0 /*&& seaField.getCountShips() == 10*/) {
                    ready = false;

                }

            }
        }

    }

    public static void turns(SeaField seaField, SeaField seaField2, User user1, SeaField seaField2Back, int countsForWin) {
        String coordinates;
        int ex = 0;
        int tern = 1;
        while (ex == 0) {
            System.out.println();
            System.out.println("Ход игрока:" + user1.getName());
            seaField.print();
            seaField2Back.print();
            System.out.println(user1.getName() + " Огонь! Введите координаты (A1):");
            Scanner sc = new Scanner(System.in);
            coordinates = sc.nextLine();
            String pos1 = "";
            String pos2 = "";

            if (coordinates.length() <= 3 && coordinates.length() >= 2 && !Character.isDigit(coordinates.charAt(0)) &&
                    Character.isDigit(coordinates.charAt(1))) {

                if (coordinates.length() == 3 && Character.isDigit(coordinates.charAt(2))) {
                    if (Character.isDigit(coordinates.charAt(1)) && Character.isDigit(coordinates.charAt(2))) {
                        pos1 = Character.toString(coordinates.charAt(0));
                        pos2 = Character.toString(coordinates.charAt(1));
                        pos2 += Character.toString(coordinates.charAt(2));
                        tern = SeaField.fire(seaField2, check(pos1), check(pos2), seaField2Back);
                    }

                } else if (coordinates.length() == 2) {
                    pos1 = Character.toString(coordinates.charAt(0));
                    pos2 = Character.toString(coordinates.charAt(1));
                    tern = SeaField.fire(seaField2, check(pos1), check(pos2), seaField2Back);
                }


                if (tern == 0) {
                    ex = 1;
                    continue;
                } else if (tern == 2) {
                    countsForWin++;

                }
            } else System.out.println("Ошибка ввода координат!");

        }
    }
}