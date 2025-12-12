import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class Room extends JFrame {

    JPanel p;
    JTable table;
    JScrollPane scrollPane;
    JLabel lblAvailability, lblCleanStatus, lblNewLabel, lblNewLabel_1, lblRoomNumber, lblId;
    Connection con;
    Statement st;

    public Room() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 600);
        setLocationRelativeTo(null);

        p = new JPanel();
        setContentPane(p);
        p.setBackground(Color.WHITE);
        p.setLayout(null);

        // IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500, 15, 600, 500);
        add(l1);

        // TABLE (inside scrollpane)
        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 40, 480, 400);
        p.add(scrollPane);

        // Load Data Button
        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.setBounds(90, 470, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        p.add(btnLoadData);

        // Back Button
        JButton btnNewButton = new JButton("Back");
        btnNewButton.setBounds(260, 470, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        p.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });

        // // Column Headers
        lblId = new JLabel("Room Number");
        lblId.setBounds(20, 15, 90, 14);
        p.add(lblId);

        lblAvailability = new JLabel("Availability");
        lblAvailability.setBounds(120, 15, 90, 14);
        p.add(lblAvailability);

        lblCleanStatus = new JLabel("Clean Status");
        lblCleanStatus.setBounds(220, 15, 90, 14);
        p.add(lblCleanStatus);

        lblNewLabel = new JLabel("Price");
        lblNewLabel.setBounds(330, 15, 90, 14);
        p.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Bed Type");
        lblNewLabel_1.setBounds(410, 15, 90, 14);
        p.add(lblNewLabel_1);

        // Load Data Button Action
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadRoomData();
            }
        });
    }
                                
    private void loadRoomData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel_db", "root", "Deep@123");

            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM addRoom");

            // Create Table Model Manually
            DefaultTableModel model = new DefaultTableModel();

            // Add Column Names
            model.addColumn("Room Number");
            model.addColumn("Availability");
            model.addColumn("Clean Status");
            model.addColumn("Price");
            model.addColumn("Bed Type");

            // Add Rows from ResultSet
            while (rs.next()) {
                Object[] row = {
                    rs.getString("room_no"),
                    rs.getString("Availability"),
                    rs.getString("Cleaning_Status"),
                    rs.getString("Price"),
                    rs.getString("Bed_Type")
                };
                model.addRow(row);
            }

            table.setModel(model);

            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Room().setVisible(true);
    }
}
