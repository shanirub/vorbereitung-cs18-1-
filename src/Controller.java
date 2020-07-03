import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller implements ChangeListener {
    View view;

    public void initialise(View v) {
        view = v;
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        int current_count = (int) view.counter.getModel().getValue();
        int current_clocks_number = view.clocks.getComponentCount();
        int diff = current_count - current_clocks_number;

        if (diff > 0) {
            // add clocks
            for (int i = 0; i < diff; i++) {
                Display new_clock = new Display();
                view.clocks.add(new_clock);
            }

        } else if (diff < 0) {
            // remove clock
            for (int i = Math.abs(diff); i > 0; i--) {
                view.clocks.remove(i);
            }
        }

        view.pack();
        view.repaint();
    }
}
