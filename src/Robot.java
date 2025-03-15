public enum Robot {
    UP(1) , DOWN(-1), LEFT(-1), RIGHT(1);

    private final int direction;

    Robot(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}
