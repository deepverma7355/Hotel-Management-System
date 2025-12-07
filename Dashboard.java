import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    public Dashboard() {
        // inserting image
        ImageIcon i1 = new ImageIcon("icons/third.jpg");
        Image i2 = i1.getImage().getScaledInstance(1500, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 10, 1550, 1000);
        add(img);

        // text on the image
        JLabel txt = new JLabel("OUR HOTEL WELCOMES YOU");
        txt.setBounds(400, 80, 1000, 50);
        txt.setFont(new Font("serif", Font.PLAIN, 46));
        img.add(txt);

        // creating menubar
        JMenuBar jmb = new JMenuBar();
        jmb.setBounds(0, 0, 1550, 30);
        img.add(jmb);

        // adding menu
        JMenu jm = new JMenu("HOTEL MANGEMENT");
        jm.setForeground(Color.red);
        jmb.add(jm);

        // adding items
        JMenuItem rec = new JMenuItem("RECEPTION");
        jm.add(rec);
        rec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Reception().
                    setVisible(true);
                } catch (Exception e) {
                }
            }
        });

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.blue);
        jmb.add(admin);
        // admin.addActionListener(this);

        JMenuItem addEmp = new JMenuItem("ADD EMPLOYEE");
        admin.add(addEmp);
        addEmp.addActionListener(this);

        JMenuItem addRooms = new JMenuItem("ADD ROOMS");
        admin.add(addRooms);
        addRooms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddRoom().setVisible(true);
                } catch (Exception e) {
                }
            }
        });

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1550, 1000);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            new AddEmp().setVisible(true);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
