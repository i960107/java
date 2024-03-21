package this_is_java.game;

public abstract class PlayerLevel {
    public final void go(int count) {
        run();
        for (int i = 0; i < count; i++) {
            jump();
        }
        turn();
    }


    protected abstract void run();

    protected abstract void jump();

    protected abstract void turn();

    protected abstract void showLevelMessage();
}
