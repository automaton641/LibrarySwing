package automaton641.lib;

import automaton641.lib.LibMouseEvent;
import automaton641.lib.LibMouseEvent.LibMouseEventType;
import java.awt.event.MouseEvent;

public class LibEvent {
    public enum LibEventType {
        MouseEvent,
        KeyboardEvent
    }
    protected LibEventType eventType;
    public static LibMouseEvent fromMouseEvent(MouseEvent mouseEvent, LibMouseEventType mouseEventType) {
        LibMouseEvent event = new LibMouseEvent(mouseEventType,
            new LibPosition(mouseEvent.getX(), mouseEvent.getY()), mouseEvent.getButton());
        event.eventType = LibEventType.MouseEvent;
        return event;
    }
    public LibEventType getEventType() {
        return eventType;
    }
}
