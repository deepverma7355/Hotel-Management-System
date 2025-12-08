import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame {

    private JPanel contentPane;

    public Reception() {

        setBounds(530, 200, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 440, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(290, 40, 500, 400);
        add(l1);

        JButton btnNewCustomerForm = new JButton("New Customer Form");
        btnNewCustomerForm.setBounds(20, 40, 220, 35);
        btnNewCustomerForm.setBackground(Color.BLACK);
        btnNewCustomerForm.setForeground(Color.WHITE);
        contentPane.add(btnNewCustomerForm);

        btnNewCustomerForm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new NewCustomer().setVisible(true);
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        JButton btnNewButton = new JButton("Room");
        btnNewButton.setBounds(20, 100, 220, 35);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Room().setVisible(true);
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        JButton btnNewButton_1 = new JButton("Employee Info");
        btnNewButton_1.setBounds(20, 160, 220, 35);
        btnNewButton_1.setBackground(Color.BLACK);
        btnNewButton_1.setForeground(Color.WHITE);
        contentPane.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new EmpInfo().setVisible(true);
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        JButton btnNewButton_3 = new JButton("Customer Info");
        btnNewButton_3.setBounds(20, 220, 220, 35);
        btnNewButton_3.setBackground(Color.BLACK);
        btnNewButton_3.setForeground(Color.WHITE);
        contentPane.add(btnNewButton_3);

        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new CustomerInfo().setVisible(true);
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        JButton btnNewButton_4 = new JButton("Check Out");
        btnNewButton_4.setBounds(20, 280, 220, 35);
        btnNewButton_4.setBackground(Color.BLACK);
        btnNewButton_4.setForeground(Color.WHITE);
        contentPane.add(btnNewButton_4);

        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new CheckOut().setVisible(true);
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        JButton btnSearchRoom = new JButton("Search Room");
        btnSearchRoom.setBounds(20, 340, 220, 35);
        btnSearchRoom.setBackground(Color.BLACK);
        btnSearchRoom.setForeground(Color.WHITE);
        contentPane.add(btnSearchRoom);

        btnSearchRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new SearchRoom().setVisible(true);
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        JButton btnNewButton_7 = new JButton("Log Out");
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Login().setVisible(true);
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        btnNewButton_7.setBounds(20, 400, 220, 35);
        btnNewButton_7.setBackground(Color.BLACK);
        btnNewButton_7.setForeground(Color.WHITE);
        contentPane.add(btnNewButton_7);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}