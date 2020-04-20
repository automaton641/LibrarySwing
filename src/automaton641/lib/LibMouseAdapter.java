package automaton641.lib;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LibMouseAdapter extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent event) {
        LibTerminal.printLine("event: " + event.getPoint());
    }
    public void mouseReleased(MouseEvent event) {
        LibTerminal.printLine("event: " + event.getPoint());
    }

}
