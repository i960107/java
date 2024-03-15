package chapter16;

public class MyPage {
    static InputBox input;

    public static void main(String[] args) {
        MyPage myPage = new MyPage();
        myPage.setUI();
        myPage.pressKey();
    }

    public void setUI() {
        input = new InputBox();
        input.setKeyEventListener(new KeyEventListener() {
            @Override
            public void onKeyDown() {
                System.out.println("key down");
            }

            @Override
            public void onKeyUp() {
                System.out.println("key up");
            }
        });
    }

    public void pressKey() {
        input.listenerCalled(InputBox.KEY_DOWN);
        input.listenerCalled(InputBox.KEY_UP);
    }
}
