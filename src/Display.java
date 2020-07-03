import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Display extends JPanel implements Serializable, ActionListener {
    transient SimpleDateFormat formatter;
    JLabel label;
    transient javax.swing.Timer timer;

    String timeZone;
    Date date;

    public String getTimeZone() {
        timeZone = formatter.getTimeZone().getDisplayName();
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        timeZone = TimeZone.getTimeZone(timeZone);
        this.timeZone = timeZone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public Display() {
        formatter = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        label = new JLabel();
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 48));
        label.setForeground(Color.RED);

        String[] time_zones = {"Asia/Bangkok", "Asia/Beirut", "Asia/Damascus", "Asia/Istanbul", "Asia/Jakarta",
                "Asia/Shanghai", "Asia/Tokyo", "Europe/Berlin", "Europe/Lisbon", "Europe/Moscow"};
        JComboBox<String> time_zone = new JComboBox<String>(time_zones);
        time_zone.setSelectedItem("Europe/Berlin");

        this.setPreferredSize(new Dimension(600, 120));
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());
        this.setBorder(new MatteBorder(5, 5, 5, 5, Color.GREEN));

        this.add(time_zone, BorderLayout.SOUTH);
        this.add(label, BorderLayout.CENTER);

        timer = new Timer(1, this);
        time_zone.addActionListener(this::actionPerformed);

        timer.start();


    }
}
