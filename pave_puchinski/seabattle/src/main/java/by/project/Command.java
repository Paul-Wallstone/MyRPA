package by.project;

public enum Command {
    START(2),
    EXIT(3),
    NEW_GAME(1),
    DEFAULT_COMMAND(0);
    private int num;


    Command(int num) {
        this.num = num;

    }

    public int getNum() {
        return num;
    }

    public static Command getcommand(int n) {
        Command[] com = Command.values();
        Command comDef = Command.DEFAULT_COMMAND;
        for (Command box : com) {
            if (box.getNum() == n) {
                return box;
            }
        }
        return comDef;
    }

}
