package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSignIn extends JFrame implements ActionListener {

    private JLabel uname, upass, title, pic;
    private JTextField tname;
    private JPasswordField tpass;
    private JButton signin, back;
    private User u1, u2;
    private User users[];
    private JPanel panel;

    public AdminSignIn() {

        u1 = new User("Admin", "admin");
        u2 = new User("Tanjid", "owl");
        users = new User[4];
        users[0] = u1;
        users[1] = u2;

        ImageIcon framelogo = new ImageIcon("Image/logo.png");
        setIconImage(framelogo.getImage());

        ImageIcon icon = new ImageIcon("Image/admin.png");
        pic = new JLabel(icon);
        pic.setBounds(50, 50, 400, 400);
        this.add(pic);

        setTitle("Admin Panel");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 600);
        add(panel);

        title = new JLabel("Admin");
        title.setFont(new Font("Forte", Font.PLAIN, 30));
        title.setBounds(630, 70, 300, 30);
        title.setForeground(Color.decode("#E4002B"));
        title.setOpaque(true);
        panel.add(title);

        uname = new JLabel("Admin Username");
        uname.setFont(new Font("Arial", Font.PLAIN, 20));
        uname.setSize(200, 20);
        uname.setLocation(600, 120);
        panel.add(uname);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 20));
        tname.setSize(200, 40);
        tname.setLocation(600, 150);
        panel.add(tname);

        upass = new JLabel("Admin Password");
        upass.setFont(new Font("Arial", Font.PLAIN, 20));
        upass.setSize(200, 20);
        upass.setLocation(600, 210);
        panel.add(upass);

        tpass = new JPasswordField();
        tpass.setFont(new Font("Arial", Font.PLAIN, 20));
        tpass.setSize(200, 40);
        tpass.setLocation(600, 240);
        panel.add(tpass);

        signin = new JButton("Admin In");
        signin.setBackground(Color.decode("#E4002B"));
        signin.setForeground(Color.decode("#FFFFFF"));
        signin.setOpaque(true);
        signin.setFont(new Font("Arial", Font.PLAIN, 25));
        signin.setSize(150, 50);
        signin.setLocation(625, 290);
        signin.addActionListener(this);
        panel.add(signin);

        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(100, 40);
        back.setLocation(760, 450);
        back.setBackground(Color.decode("#E4002B"));
        back.setForeground(Color.decode("#FFFFFF"));
        back.setOpaque(true);
        back.addActionListener(this);
        panel.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signin) {
            String user = tname.getText();
            String pass = tpass.getText();

            int flag = 0;

            if (user.isEmpty() == false && pass.isEmpty() == false) {
                for (int i = 0; i < users.length; i++) {
                    if (users[i] != null) {
                        if (user.equals(users[i].getname()) && pass.equals(users[i].getPassword())) {
                            flag = 1;
                            break;
                        }
                    }
                }
                if (flag == 1) {
                    User x = this.searchUser(user);
                    new Home(x);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or password!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fill up each field.");
            }
        } else if (e.getSource() == back) {
            new HomePage();
            setVisible(false);
        }
    }

    public User searchUser(String user) {
        User a = null;

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (users[i].getname().equals(user)) {
                    a = users[i];
                    break;
                }
            }
        }
        return a;
    }
}
