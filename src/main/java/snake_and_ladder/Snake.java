package snake_and_ladder;

public class Snake extends BoardEntity {

    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public String getId() {
        return "S_" + this.getEndPosition();
    }
}
