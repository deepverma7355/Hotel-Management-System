import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener{

    JLabel txt;
    JButton btn;

    public HomePage() {
        setLayout(null);
        setBounds(100, 100, 1336, 565);

        ImageIcon icon = new ImageIcon("icons/first.jpg");
        JLabel img = new JLabel(icon);
        img.setBounds(0, 0, 1336, 565);
        add(img);

        txt = new JLabel("Welcome To Our Hotel");
        txt.setBounds(20, 450, 500, 40);
        
        txt.setForeground(Color.white);
        txt.setFont(new Font("serif", Font.PLAIN, 50));
        img.add(txt);

         btn = new JButton("Next");
        btn.setBounds(1150, 450, 150, 40);
        btn.setBackground(Color.black);
        btn.setForeground(Color.white);
        btn.setFont(new Font("serif", Font.PLAIN, 25));
        img.add(btn);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        btn.addActionListener(this);
        while (true) {
            txt.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
            txt.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }
            
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            // Open Login Page
            new Login();
            // Close current window
            dispose();
        }
    }

    public static void main(String[] args) {
        new HomePage();

    }

}