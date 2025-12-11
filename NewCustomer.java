
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class NewCustomer extends JFrame {

    JPanel p;
    JTextField t1, t2, t3, t4, t5, t6;
    JComboBox comboBox;
    JRadioButton r1, r2;

    public NewCustomer() {

        p = new JPanel();
        add(p);
        p.setLayout(null);

        ImageIcon i1 = new ImageIcon("icons/fifth.png");
        Image i3 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(480, 10, 300, 500);
        p.add(l1);

        JLabel lblName = new JLabel("NEW CUSTOMER FORM");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 260, 53);
        p.add(lblName);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(35, 76, 200, 14);
        p.add(lblId);

        comboBox = new JComboBox(new String[] { "Passport", "Aadhar Card", "Voter Id", "Driving license" });
        comboBox.setBounds(271, 73, 150, 20);
        p.add(comboBox);

        JLabel l2 = new JLabel("Number :");
        l2.setBounds(35, 111, 200, 14);
        p.add(l2);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(35, 151, 200, 14);
        p.add(lblName_1);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 191, 200, 14);
        p.add(lblGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(271, 191, 80, 12);
        p.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 191, 100, 12);
        p.add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 231, 200, 14);
        p.add(lblCountry);

        JLabel lblReserveRoomNumber = new JLabel("Allocated Room Number :");
        lblReserveRoomNumber.setBounds(35, 274, 200, 14);
        p.add(lblReserveRoomNumber);

        JLabel lblCheckInStatus = new JLabel("Checked-In :");
        lblCheckInStatus.setBounds(35, 316, 200, 14);
        p.add(lblCheckInStatus);

        JLabel lblDeposite = new JLabel("Deposit :");
        lblDeposite.setBounds(35, 359, 200, 14);
        p.add(lblDeposite);

        t1 = new JTextField();
        t1.setBounds(271, 111, 150, 20);
        p.add(t1);

        t2 = new JTextField();
        t2.setBounds(271, 151, 150, 20);
        p.add(t2);

        t3 = new JTextField();
        t3.setBounds(271, 231, 150, 20);
        p.add(t3);

        t4 = new JTextField();
        t4.setBounds(271, 273, 150, 20);
        p.add(t4);

        t5 = new JTextField();
        t5.setBounds(271, 316, 150, 20);
        p.add(t5);

        t6 = new JTextField();
        t6.setBounds(271, 359, 150, 20);
        p.add(t6);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.setBounds(100, 430, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        p.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Read all input values
                String idType = (String) comboBox.getSelectedItem();
                String idNumber = t1.getText();
                String name = t2.getText();
                String gender = r1.isSelected() ? "Male" : "Female";
                String country = t3.getText();
                String roomNumber = t4.getText();
                String checkIn = t5.getText();
                String deposit = t6.getText();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Hotel_db",
                            "root",
                            "Deep@123");

                    Statement st = con.createStatement();

                    String query = "INSERT INTO newcustomer(id_type, id_number, name, gender, country, room_number, checkin_status, deposit) "
                            + "VALUES ('" + idType + "','" + idNumber + "','" + name + "','" + gender + "','" + country
                            + "','"
                            + roomNumber + "','" + checkIn + "','" + deposit + "')";

                    st.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Customer Added Successfully!");

                    con.close();

                    new Reception().setVisible(true);
                    setVisible(false);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        JButton btnExit = new JButton("Back");
        btnExit.setBounds(260, 430, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        p.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });

        p.setBackground(Color.WHITE);

        setSize(850, 550);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new NewCustomer();

    }
}