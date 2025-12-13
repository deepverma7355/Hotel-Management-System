import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
 
public class EmpInfo extends JFrame {

    JPanel p;
    JTable table;
    JScrollPane scrollPane;
    JLabel lblAvailability, lblCleanStatus, lblNewLabel, lblNewLabel_1, lblRoomNumber, lblId;
    Connection con;
    Statement st;

    public EmpInfo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 600);
        setLocationRelativeTo(null);

        p = new JPanel();
        setContentPane(p);
        p.setBackground(Color.WHITE);
        p.setLayout(null);

        JLabel l1 = new JLabel("Employees Information");
        l1.setFont(new Font("serif", Font.BOLD, 20));
        l1.setBounds(400,5,200,30);
        p.add(l1);

      //  Column Headers
        // lblId = new JLabel("Room Number");
        // lblId.setBounds(50, 130, 100, 20);
        // p.add(lblId);

        // lblAvailability = new JLabel("Availability");
        // lblAvailability.setBounds(270, 130, 100, 20);
        // p.add(lblAvailability);

        // lblCleanStatus = new JLabel("Clean Status");
        // lblCleanStatus.setBounds(450, 130, 100, 20);
        // p.add(lblCleanStatus);

        // lblNewLabel = new JLabel("Price");
        // lblNewLabel.setBounds(670, 130, 100, 20);
        // p.add(lblNewLabel);

        // lblNewLabel_1 = new JLabel("Bed Type");
        // lblNewLabel_1.setBounds(870, 130, 100, 20);
        // p.add(lblNewLabel_1);

        // TABLE (inside scrollpane)
        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 70, 1100, 400);
        p.add(scrollPane);

        // Back Button
        JButton btnNewButton = new JButton("Back");
        btnNewButton.setBounds(600, 490, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        p.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });

        // Load Data Button
        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.setBounds(370, 490, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        p.add(btnLoadData);

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
            ResultSet rs = st.executeQuery("SELECT * FROM addEmpl");
            // Create Table Model Manually
            DefaultTableModel model = new DefaultTableModel();

            // Add Column Names
            model.addColumn("Name");
            model.addColumn("Age.");
            model.addColumn("Gender");
            model.addColumn("Job");
            model.addColumn("Salary");
            model.addColumn("Phone No.");
            model.addColumn("Aadhar");
            model.addColumn("Email");

            // Add Rows from ResultSet
            while (rs.next()) {
                Object[] row = {
                        rs.getString("name"),
                        rs.getString("age"),
                        rs.getString("gender"),
                        rs.getString("job"),
                        rs.getString("salary"),
                        rs.getString("phone"),
                        rs.getString("aadhar"),
                        rs.getString("email")
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
        new EmpInfo().setVisible(true);
    }
}