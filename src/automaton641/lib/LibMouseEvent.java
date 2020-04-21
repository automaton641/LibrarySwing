package automaton641.lib;

public class LibMouseEvent extends LibEvent {
    public enum LibMouseEventType {
        Pressed,
        Released
    }
    public static final int LeftButton = 1;
    public static final int MiddleButton = 2;
    public static final int RightButton = 3;
    private LibPosition position;
    private int button;
    private LibMouseEventType mouseEventType;
    public LibMouseEvent (LibMouseEventType mouseEventType, LibPosition position, int button) {
        this.mouseEventType = mouseEventType;
        this.position = position;
        this.button = button;
    }
    public int getButton() {
        return button;
    }
    public LibMouseEventType getMouseEventType() {
        return mouseEventType;
    }
}
