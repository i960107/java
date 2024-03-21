package this_is_java.game;

public class AdvancedLevel extends PlayerLevel {
    @Override
    protected void run() {
        System.out.println("느리게 뜁니다.");
    }

    @Override
    protected void jump() {
        System.out.println("점프 합니다.");
    }

    @Override
    protected void turn() {
        System.out.println("turn 못하지롱.");
    }
    protected  void showLevelMessage(){
        System.out.println("*******Advanced Level*********");
    }
}
