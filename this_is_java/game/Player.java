package this_is_java.game;

public class Player {
    private PlayerLevel playerLevel;

    public Player() {
        this.playerLevel = new BeginnerLevel();
    }

    public void play(int count) {
        playerLevel.go(count);
    }

    public void upgradeLevel(PlayerLevel level) {
        this.playerLevel = level;
        playerLevel.showLevelMessage();
    }

    public static void main(String[] args) {
        Player player = new Player();
        player.play(1);

        player.upgradeLevel(new AdvancedLevel());
        player.play(2);

        player.upgradeLevel(new SuperLevel());
        player.play(3);
    }

}
