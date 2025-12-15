import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CheckOut extends JFrame implements ActionListener {

    JComboBox comboId;
    JTextField tfroom, tfname;
    JButton checkBtn, backBtn;
    JTable table;

    Connection con;
    Statement st;

    public CheckOut() {
        setTitle("Customer Check-Out");
        setBounds(450, 200, 900, 450);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(450, 80, 400, 300);
        add(l1);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_db", "root",
								"Deep@123");
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel title = new JLabel("Check-Out");
        title.setFont(new Font("Tahoma", Font.BOLD, 25));
        title.setBounds(350, 20, 200, 30);
        add(title);

        // ---- Customer ID ----
        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30, 80, 150, 25);
        add(lblid);

        comboId = new JComboBox();
        comboId.setBounds(180, 80, 200, 25);
        add(comboId);

        loadCustomerIDs();

        // ---- Room Number ----
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 150, 25);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(180, 130, 200, 25);
        tfroom.setEditable(false);
        add(tfroom);

        // ---- Customer Name ----
        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(30, 180, 150, 25);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(180, 180, 200, 25);
        tfname.setEditable(false);
        add(tfname);

        // ---- Buttons ----
        checkBtn = new JButton("Check-Out");
        checkBtn.setBounds(70, 250, 120, 30);
        checkBtn.setBackground(Color.black);
        checkBtn.setForeground(Color.white);
        checkBtn.addActionListener(this);
        add(checkBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(220, 250, 120, 30);
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.white);
        backBtn.addActionListener(this);
        add(backBtn);

        comboId.addActionListener(e -> fetchCustomerDetails());

        setVisible(true);
    }

    // Load customer IDs into combo box
    private void loadCustomerIDs() {
        try {
            ResultSet rs = st.executeQuery("SELECT id FROM newcustomer");
            while (rs.next()) {
                comboId.addItem(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Auto-fill customer details when ID is selected
    private void fetchCustomerDetails() {
        try {
            String id = (String) comboId.getSelectedItem();
            ResultSet rs = st.executeQuery("SELECT * FROM newcustomer WHERE id='" + id + "'");
            if (rs.next()) {
                tfroom.setText(rs.getString("room_number"));
                tfname.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Check-Out Button Logic
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == checkBtn) {
            try {
                String id = (String) comboId.getSelectedItem();
                String room = tfroom.getText();

                // Delete customer from DB
                st.executeUpdate("DELETE FROM newcustomer WHERE id='" + id + "'");

                // Mark room as available
                st.executeUpdate("UPDATE addRoom SET availability='Available' WHERE room_no='" + room + "'");

                JOptionPane.showMessageDialog(null, "Check-Out Successful");

                // loadCustomerTable();
                comboId.removeItem(id);
                tfroom.setText("");
                tfname.setText("");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == backBtn) {
            new Reception().setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
