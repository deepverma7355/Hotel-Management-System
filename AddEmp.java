import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddEmp extends JFrame {
    JPanel p;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField tf1, tf2, tf4, tf5, tf6, tf7, tf8;
    JRadioButton male, female;
    ButtonGroup genderGroup;
    JButton b, b2;

    public AddEmp() {
        p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.white);
        l1 = new JLabel("NAME");
        l2 = new JLabel("AGE");
        l3 = new JLabel("GENDER");
        l4 = new JLabel("JOB");
        l5 = new JLabel("SALARY");
        l6 = new JLabel("PHONE");
        l7 = new JLabel("AADHAR");
        l8 = new JLabel("EMAIL");

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        // Group the radio buttons
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();

        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        l1.setBounds(50, 30, 100, 25);
        tf1.setBounds(160, 30, 200, 25);

        l2.setBounds(50, 70, 100, 25);
        tf2.setBounds(160, 70, 200, 25);

        l3.setBounds(50, 110, 100, 25);
        male.setBounds(160, 110, 80, 25);
        female.setBounds(250, 110, 80, 25);

        l4.setBounds(50, 150, 100, 25);
        tf4.setBounds(160, 150, 200, 25);

        l5.setBounds(50, 190, 100, 25);
        tf5.setBounds(160, 190, 200, 25);

        l6.setBounds(50, 230, 100, 25);
        tf6.setBounds(160, 230, 200, 25);

        l7.setBounds(50, 270, 100, 25);
        tf7.setBounds(160, 270, 200, 25);

        l8.setBounds(50, 310, 100, 25);
        tf8.setBounds(160, 310, 200, 25);

        b.setBounds(64, 360, 130, 30);
        b2.setBounds(210, 360, 130, 30);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410, 27, 480, 410);
        add(image);

        add(p);
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);
        p.add(l5);
        p.add(l6);
        p.add(l7);
        p.add(l8);

        p.add(tf1);
        p.add(tf2);
        p.add(male);
        p.add(female);
        p.add(tf4);
        p.add(tf5);
        p.add(tf6);
        p.add(tf7);
        p.add(tf8);

        p.add(b);
        p.add(b2);

        setSize(930, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = tf1.getText();
                String age = tf2.getText();
                String gender = male.isSelected() ? "Male" : "Female";
                String job = tf4.getText();
                String salary = tf5.getText();
                String phone = tf6.getText();
                String aadhar = tf7.getText();
                String email = tf8.getText();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Hotel_db", "root", "Deep@123");

                    Statement st = con.createStatement();

                    String query = "INSERT INTO addEmpl(name, age, gender, job, salary, phone, aadhar, email) VALUES ('"
                            + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','"
                            + phone + "','" + aadhar + "','" + email + "')";

                    st.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Employee Added Successfully!");

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dashboard().setVisible(true);
                setVisible(false);
            }
        });

    }

    public static void main(String[] args) {
        new AddEmp();
    }
}