package snake_and_ladder;

public class Player {

    public String getId() {
        return id;
    }

    String id;

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    int currentPosition;

    public Player(String id, int position) {
        this.id = id;
        this.currentPosition = position;
    }
    public int getCurrentPosition() {
        return currentPosition;
    }
}
