package by.project;

public class SeaField {
    String[][] board;
    User user;
    int countShips;
    private static final String ERROR = "error";
    Ship[][] board1 = new Ship[10][10];

     public SeaField(String[][] board, User user) {
        this.board = board;
        this.user = user;

    }

    public int getCountShips() {
        return countShips;
    }

    public void setCountShips(int countShips) {
        this.countShips = countShips;
    }

    // Формирует поле по умолчанию
    public void defaultField() {
        int n = 1;
        //Строка
        board[0][0] = " ";
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < 11; j++) {

                board[i][j] = String.valueOf(n) + " ";
                n++;
            }
        }

        //Колонка
        String[] lineABC = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 1; j++) {

                board[i][j] = lineABC[i];

            }
        }
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {

                board1[i - 1][j - 1] = Ship.EMPTY_SPACE;
                board[i][j] = Ship.EMPTY_SPACE.getBoats();
            }
            System.out.println();
        }


    }

    // Добовляет корабль игрока
    public int addUserShip(String verticalBegin, String horizontalBegin, String verticalEnd, String horizontalEnd) {
        if (verticalBegin == ERROR || horizontalBegin == ERROR ||
                verticalEnd == ERROR || horizontalEnd == ERROR ||
                !(verticalEnd.hashCode() == verticalBegin.hashCode() ||
                        horizontalBegin.hashCode() == horizontalEnd.hashCode())) {
            return 0;

        }


        String[] lineABC = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        int verBgn = 0;
        int verEnd = 0;
        for (int j = 0; j < 11; j++) {
            if (lineABC[j].hashCode() == verticalBegin.hashCode())
                verBgn = j;
            if (lineABC[j].hashCode() == verticalEnd.hashCode())
                verEnd = j;
        }
        int horBgn = Integer.parseInt(horizontalBegin);
        int horEnd = Integer.parseInt(horizontalEnd);

        if (checkNearby(board1, verBgn, horBgn) == 1)
            return 0;

        if (verBgn == verEnd && horBgn == horEnd) {//однопалубные
            board[verBgn][horBgn] = Ship.TORPEDO_BOATS.getBoats();
            board1[verBgn - 1][horBgn - 1] = Ship.TORPEDO_BOATS;
            changeStatusOfFields();
            return 1;
        } else if ((verEnd - verBgn) == 1 || (horEnd - horBgn) == 1) {//двухпалубные
            board[verBgn][horBgn] = Ship.DESTROYERS.getBoats();
            board[verEnd][horEnd] = Ship.DESTROYERS.getBoats();
            board1[verBgn - 1][horBgn - 1] = Ship.DESTROYERS;
            board1[verEnd - 1][horEnd - 1] = Ship.DESTROYERS;
            changeStatusOfFields();
            return 2;
        } else if ((verEnd - verBgn) == 2 || (horEnd - horBgn) == 2) {//трехпалубные
            board[verBgn][horBgn] = Ship.CRUISERS.getBoats();
            board[verEnd][horEnd] = Ship.CRUISERS.getBoats();
            board1[verBgn - 1][horBgn - 1] = Ship.CRUISERS;
            board1[verEnd - 1][horEnd - 1] = Ship.CRUISERS;
            if (verBgn == verEnd) {
                board[verBgn][horBgn + 1] = Ship.CRUISERS.getBoats();
                board1[verBgn - 1][horBgn] = Ship.CRUISERS;
            } else {
                board[verBgn + 1][horBgn] = Ship.CRUISERS.getBoats();
                board1[verBgn][horBgn - 1] = Ship.CRUISERS;
                changeStatusOfFields();
                return 3;
            }
        } else if ((verEnd - verBgn) == 3 || (horEnd - horBgn) == 3) {//четырехпалубный
            board[verBgn][horBgn] = Ship.BATTLESHIP.getBoats();
            board[verEnd][horEnd] = Ship.BATTLESHIP.getBoats();
            board1[verBgn - 1][horBgn - 1] = Ship.BATTLESHIP;
            board1[verEnd - 1][horEnd - 1] = Ship.BATTLESHIP;
            if (verBgn == verEnd) {
                board[verBgn][horBgn + 1] = Ship.BATTLESHIP.getBoats();
                board[verBgn][horBgn + 2] = Ship.BATTLESHIP.getBoats();
                board1[verBgn - 1][horBgn] = Ship.BATTLESHIP;
                board1[verBgn - 1][horBgn + 1] = Ship.BATTLESHIP;
            } else {
                board[verBgn + 1][horBgn] = Ship.CRUISERS.getBoats();
                board[verBgn + 2][horBgn] = Ship.CRUISERS.getBoats();
                board1[verBgn][horBgn - 1] = Ship.CRUISERS;
                board1[verBgn + 1][horBgn - 1] = Ship.CRUISERS;

            }
            changeStatusOfFields();

            return 4;
        }
        return 0;
    }

    //выводит поле String
    public void print() {
        System.out.println(user.getName());
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {


                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    //выводит поле User
    public void print1() {
        System.out.println(user.getName());
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {


                System.out.print(board1[i][j].getBoats());
            }
            System.out.println();
        }
    }

    //выводит поле Status
    public void printStatus() {
        System.out.println(user.getName());
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {


                System.out.print(board1[i][j].getSpaceStatus());
            }
            System.out.println();
        }
    }

    // проверяет наличие рядом кораблей или наслоение на корабль
    public int checkNearby(Ship[][] board1, int x, int y) {


        if (board1[x - 1][y - 1].getSpaceStatus() == 1 || board1[x - 1][y - 1].getSpaceStatus() == 2) {
            return 1;
        }

        return 0;
    }

    //устанвливает статус клетки
    public void changeStatusOfFields() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board1[i][j].getSpaceStatus() == 2) {
                    for (int r = -1; r < 2; r++) {
                        for (int t = -1; t < 2; t++) {
                            int c = i + r;
                            int b = j + t;
                            if (c >= 0 && c <= 9 && b >= 0 && b <= 9) {
                                int st = board1[i + r][j + t].getSpaceStatus();
                                if (st == 0) {

                                    board1[i + r][j + t] = Ship.FULL_SPACE;
                                }
                            }
                        }

                    }
                }

            }
        }
    }

    public static int fire(SeaField seaField, String verticalBegin, String horizontalBegin, SeaField seaFieldBack) {
        if (verticalBegin == ERROR || horizontalBegin == ERROR) {
            return 1;

        }

        String[] lineABC = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        int verBgn = 0;

        for (int j = 0; j < 11; j++) {
            if (lineABC[j].hashCode() == verticalBegin.hashCode())
                verBgn = j;

        }

        int horBgn = Integer.parseInt(horizontalBegin);
        if (seaField.board[verBgn][horBgn] == Ship.FULL_SPACE.getFired() ||
                seaField.board[verBgn][horBgn] == Ship.CRUISERS.getFired()) {
            return 1;

        }
        if (seaField.board1[verBgn - 1][horBgn - 1].getBoats() != Ship.EMPTY_SPACE.getBoats() ||
                seaField.board1[verBgn - 1][horBgn - 1].getBoats() != Ship.FULL_SPACE.getBoats()) {

            seaField.board[verBgn][horBgn] = Ship.CRUISERS.getFired();
            seaFieldBack.board[verBgn][horBgn] = Ship.CRUISERS.getFired();
            return 2;
        } else {
            seaField.board[verBgn][horBgn] = Ship.FULL_SPACE.getFired();
            seaFieldBack.board[verBgn][horBgn] = Ship.FULL_SPACE.getFired();
        }
        return 0;
    }

}
