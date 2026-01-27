import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame {
    JPanel p;
    JLabel l, l2;
    JTextField tf;
    JPasswordField tf2;
    JButton b, b2;
    Connection con;
    Statement st;

    public Login() {

        p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.white);
        l = new JLabel("Username");
        l2 = new JLabel("Password");
        tf = new JTextField();
        tf2 = new JPasswordField();
        b = new JButton("Login");
        b2 = new JButton("Cancel");

        // set login button color
        b.setBackground(Color.BLACK);
        b.setForeground(Color.white);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);

        // setting bounds
        l.setBounds(20, 40, 100, 30);
        tf.setBounds(140, 40, 180, 30);

        l2.setBounds(20, 90, 100, 30);
        tf2.setBounds(140, 90, 180, 30);

        b.setBounds(40, 150, 100, 35);
        b2.setBounds(150, 150, 100, 35);

        // inserting image

        ImageIcon i1 = new ImageIcon("icons/second.jpg");
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350, 10, 200, 200);
        add(img);
        // adding
        add(p);
        p.add(l);
        p.add(l2);
        p.add(tf);
        p.add(tf2);
        p.add(b);
        p.add(b2);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String user = tf.getText();
                String pass = new String(tf2.getPassword());
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_db", "root", "Deep@123");

                    st = con.createStatement();

                    String query = "SELECT * FROM login WHERE username='" + user +
                            "' AND password='" + pass + "'";
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        new Dashboard().setVisible(true);
                        setVisible(false);
                    } else
                        JOptionPane.showMessageDialog(null, "Wrong Username or Password");

                    con.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });

        setVisible(true);
        setTitle("Login Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        new Login();

    }
}
