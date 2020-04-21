package automaton641.lib;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LibMouseAdapter extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent event) {
        LibCanvas canvas = (LibCanvas)event.getSource();
        canvas.mousePressed(event);

    }
    @Override
    public void mouseReleased(MouseEvent event) {
        LibCanvas canvas = (LibCanvas)event.getSource();
        canvas.mouseReleased(event);
    }

}
