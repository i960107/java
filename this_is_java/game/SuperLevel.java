package this_is_java.game;

public class SuperLevel extends PlayerLevel {
    @Override
    protected void run() {
        System.out.println("아주 빠르게 뜁니다.");
    }

    @Override
    protected void jump() {
        System.out.println("아주 높이 jump 합니다.");
    }

    @Override
    protected void turn() {
        System.out.println("한바퀴 turn합니다.");
    }

    protected  void showLevelMessage(){
        System.out.println("*******Super Level*********");
    }
}
