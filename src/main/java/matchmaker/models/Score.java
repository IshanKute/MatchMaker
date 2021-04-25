package matchmaker.models;

public class Score {
    private final User user;
    private final int score;

    public Score(User user, int score) {
        this.user = user;
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public int getScore() {
        return score;
    }
}
