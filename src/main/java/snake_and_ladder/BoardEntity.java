package snake_and_ladder;

public abstract class BoardEntity {
    private int start;
    private int end;

    public BoardEntity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public abstract String getId();

    public int getStartPosition()
    {
        return this.start;
    }

    public int getEndPosition()
    {
        return this.end;
    }
}
