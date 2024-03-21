package this_is_java.game;

public class BeginnerLevel extends PlayerLevel {
    @Override
    protected void run() {
        System.out.println("천천히 뜁니다.");
    }

    @Override
    protected void jump() {
        System.out.println("점프 못하지롱");
    }

    @Override
    protected void turn() {
        System.out.println("턴 못하지롱");
    }
    protected  void showLevelMessage(){
        System.out.println("*******Beginner Level*********");
    }
}
