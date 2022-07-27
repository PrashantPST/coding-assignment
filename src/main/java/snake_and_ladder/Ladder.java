package snake_and_ladder;

public class Ladder extends BoardEntity {

    public Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    public String getId() {
        return "L_" + this.getEndPosition();
    }
}
