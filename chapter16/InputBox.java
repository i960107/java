package chapter16;

public class InputBox {
    KeyEventListener keyEventListener;
    public void setKeyEventListener(KeyEventListener keyEventListener){
        this.keyEventListener = keyEventListener;
    }
    public static final int KEY_DOWN = 2;
    public static final int KEY_UP = 4;
    public void listenerCalled(int eventType){
        if(eventType == KEY_DOWN){
            keyEventListener.onKeyDown();
        }else if(eventType == KEY_UP){
            keyEventListener.onKeyUp();
        }
    }

}
