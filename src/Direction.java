public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction turnRight() {
        return values()[(this.ordinal() + 1) % values().length];
    }

    public Direction turnLeft() {
        return values()[(this.ordinal() - 1 + values().length) % values().length];
    }
}
