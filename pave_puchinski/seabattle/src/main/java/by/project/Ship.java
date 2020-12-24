package by.project;

public enum Ship {
    TORPEDO_BOATS("торпедный катер", 1, true, "🛥️", "🔥", 2),
    DESTROYERS(" эсминец", 2, true, "🚢", "🔥", 2),
    CRUISERS("крейсер", 3, true, "🛳", "🔥", 2),
    BATTLESHIP("линкор", 4, true, "⛴", "🔥", 2),
    EMPTY_SPACE("пустая клетка", 1, true, "🌊", "🚬", 0),
    FULL_SPACE (" непустая клетка",1,true,"🌊","🚬",1);

    private String rusTitle;
    private int lengthShip;
    private boolean alive;
    private String boats;
    private String fired;
    private int spaceStus;

    Ship(String rusTitle, int lengthShip, boolean alive, String ship, String fired, int spaceStatus) {
        this.rusTitle = rusTitle;
        this.lengthShip = lengthShip;
        this.alive = alive;
        this.boats = ship;
        this.fired = fired;
        this.spaceStus = spaceStatus;
    }

    public String getRusTitle() {
        return rusTitle;
    }

    public int getLengthShip() {
        return lengthShip;
    }

    public boolean isAlive() {
        return alive;
    }

    public String getBoats() {
        return boats;
    }

    public String getFired() {
        return fired;
    }

    public int getSpaceStatus() {
        return spaceStus;
    }


}
