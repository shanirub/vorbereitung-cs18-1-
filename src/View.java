import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
        JLabel background_image;
        JPanel clocks;
        JSpinner counter;
        Controller controller;

    public void initialise(Controller c) {
        controller = c;

        JPanel p;

        this.setTitle("Weltzeituhr");
        background_image = new JLabel(new ImageIcon("urania-weltzeituhr_alexanderplatz_berlin.jpeg"));
        this.setLayout(new BorderLayout());

        p = new JPanel();
        p.setLayout(new BorderLayout());
        clocks = new JPanel();
        BoxLayout boxLayout = new BoxLayout(clocks, BoxLayout.Y_AXIS);
        clocks.setLayout(boxLayout);

        counter = new JSpinner();
        counter.setModel(new SpinnerNumberModel(0, 0, 5, 1));
        counter.setPreferredSize(new Dimension(400, 100));
        counter.setFont(new Font(Font.SANS_SERIF, 64, Font.BOLD));
        counter.setToolTipText("Erzeugt oder löscht eine Uhr");
        counter.addChangeListener(controller);

        p.add(counter, BorderLayout.SOUTH);

        p.add(clocks, BorderLayout.PAGE_START);

        this.add(background_image, BorderLayout.WEST);
        this.add(p, BorderLayout.CENTER);



        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
