package by.Project;

public enum Ship {
    TORPEDO_BOATS("торпедный катер", 1, true, "🛥️", "🔥", 2),
    DESTROYERS(" эсминец", 2, true, "🚢", "🔥", 2),
    CRUISERS("крейсер", 3, true, "🛳", "🔥", 2),
    BATTLESHIP("линкор", 4, true, "⛴", "🔥", 2),
    EMPTY_SPACE("пустая клетка", 1, true, "🌊", "🚬", 0),
    FULL_SPACE (" непустая клетка",1,true,"🌊","🚬",1);

    private String RusTitle;
    private int lengthShip;
    private boolean alive;
    private String ship;
    private String fired;
    private int spaceStus;

    Ship(String rusTitle, int lengthShip, boolean alive, String ship, String fired, int spaceStatus) {
        RusTitle = rusTitle;
        this.lengthShip = lengthShip;
        this.alive = alive;
        this.ship = ship;
        this.fired = fired;
        this.spaceStus = spaceStatus;
    }

    public String getRusTitle() {
        return RusTitle;
    }

    public int getLengthShip() {
        return lengthShip;
    }

    public boolean isAlive() {
        return alive;
    }

    public String getShip() {
        return ship;
    }

    public String getFired() {
        return fired;
    }

    public int getSpaceStatus() {
        return spaceStus;
    }

    public void setSpaceStatus(int space) {
        this.spaceStus = space;
    }
}
