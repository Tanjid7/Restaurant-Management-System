package classes;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Category2 extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton cripsybtn, popcornbtn, boxbtn, back, order;
    private JLabel prcripsy, prpopcorn, prbox, banner;
    private JCheckBox rcripsy, rpopcorn, rbox;
    private JComboBox<String> bcripsy;
    private JComboBox<String> bpopcorn;
    private JComboBox<String> bbox;
    private String a[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String b[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String d[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String f;

    public Category2(String user) {

        ImageIcon framelogo = new ImageIcon("Image/logo.png");
        setIconImage(framelogo.getImage());

        f = user;

        Icon bicon = new ImageIcon("Image/rice bowl menu.png");
        Icon cripsyicon = new ImageIcon("Image/cripsyricebowl.png");
        Icon popcornicon = new ImageIcon("Image/popcornricebowl.png");
        Icon boxicon = new ImageIcon("Image/boxricebowl.png");

        setTitle("Rice Bowls");
        setBounds(0, 0, 900, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 600);
        add(panel);

        back = new JButton("Back");
        back.setBounds(145, 500, 150, 50);
        back.setBackground(Color.RED);
        back.setForeground(Color.BLACK);
        back.setOpaque(true);
        back.addActionListener(this);
        panel.add(back);

        order = new JButton("Place Order");
        order.setBounds(625, 500, 150, 50);
        order.setBackground(Color.BLACK);
        order.setForeground(Color.WHITE);
        order.setOpaque(true);
        order.addActionListener(this);
        panel.add(order);

        banner = new JLabel(bicon);
        banner.setBounds(0, 0, 900, 150);
        panel.add(banner);

        cripsybtn = new JButton(cripsyicon);
        cripsybtn.setBounds(120, 175, 200, 200);
        cripsybtn.addActionListener(this);
        panel.add(cripsybtn);

        rcripsy = new JCheckBox("Hot & Crispy Rice Bowl");
        rcripsy.setBounds(120, 385, 200, 30);
        rcripsy.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(rcripsy);

        prcripsy = new JLabel("249 Tk");
        prcripsy.setBounds(150, 415, 150, 20);
        prcripsy.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(prcripsy);

        bcripsy = new JComboBox<String>(a);
        bcripsy.setBounds(120, 445, 70, 20);
        panel.add(bcripsy);

        popcornbtn = new JButton(popcornicon);
        popcornbtn.setBounds(350, 175, 200, 200);
        popcornbtn.addActionListener(this);
        panel.add(popcornbtn);

        rpopcorn = new JCheckBox("Popcorn Rice Bowl");
        rpopcorn.setBounds(350, 385, 200, 30);
        rpopcorn.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(rpopcorn);

        prpopcorn = new JLabel("249 Tk");
        prpopcorn.setBounds(380, 415, 150, 20);
        prpopcorn.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(prpopcorn);

        bpopcorn = new JComboBox<String>(b);
        bpopcorn.setBounds(350, 445, 70, 20);
        panel.add(bpopcorn);

        boxbtn = new JButton(boxicon);
        boxbtn.setBounds(600, 175, 200, 200);
        boxbtn.addActionListener(this);
        panel.add(boxbtn);

        rbox = new JCheckBox("Rice Box");
        rbox.setBounds(600, 385, 200, 30);
        rbox.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(rbox);

        prbox = new JLabel("299 Tk");
        prbox.setBounds(630, 415, 150, 20);
        prbox.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(prbox);

        bbox = new JComboBox<String>(b);
        bbox.setBounds(600, 445, 70, 20);
        panel.add(bbox);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Restaurant(f);
            setVisible(false);

        } else if (e.getSource() == order) {
            double totalAmount = 0;
            double cripsyamount = 0;
            double popcornamount = 0;
            double boxamount = 0;
            int a = 0;
            int b = 0;
            int c = 0;

            if (rcripsy.isSelected() == true) {
                a = (bcripsy.getSelectedIndex()) + 1;
                cripsyamount = a * 249;
            }
            if (rpopcorn.isSelected() == true) {
                b = bpopcorn.getSelectedIndex() + 1;
                popcornamount = b * 249;
            }
            if (rbox.isSelected() == true) {
                c = bbox.getSelectedIndex() + 1;
                boxamount = c * 299;
            }

            totalAmount = cripsyamount + popcornamount + boxamount;
            if (totalAmount != 0) {
                int x = JOptionPane.showConfirmDialog(null, "Your Bill = " + totalAmount + " tk. Confirm Order?",
                        " Conformation of Oder", 0);
                if (x == 0) {
                    setVisible(false);
                    new Payment(totalAmount, "Category2", f);

                    try {
                        File newfile = new File("data\\Last.txt");
                        newfile.createNewFile();
                        FileWriter file = new FileWriter("data\\Last.txt");

                        file.write("Cripsy rice bowl--- " + a + cripsyamount + " tk."
                                + "\n Popcorn rice bowl----" + b + popcornamount + " tk."
                                + "\n Rice box---" + c + boxamount + " tk."
                                + "\n" + totalAmount + " tk Total.");
                        file.close();

                    } catch (IOException io) {
                        JOptionPane.showMessageDialog(null, "An error Occured and failed to create the file");
                        io.printStackTrace();
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select something before placing order!", "Message", 0);
            }
        }
    }
}
