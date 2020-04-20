package automaton641.lib;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LibCanvasComponentAdapter extends ComponentAdapter {
    public void componentResized(ComponentEvent componentEvent) {
        LibCanvas canvas = (LibCanvas)componentEvent.getComponent();
        canvas.resized();
    }
}
