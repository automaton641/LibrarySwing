package automaton641.lib;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LibWindowComponentAdapter extends ComponentAdapter {
    private LibWindow window;
    public LibWindowComponentAdapter(LibWindow window) {
        this.window= window;
    }
}
