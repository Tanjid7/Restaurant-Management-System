package classes;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Category3 extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton pepsi, dwo, water, back, order;
    private JLabel prpepsi, prdwo, prwater, banner;
    private JButton cpepsi, cdwo, cwater;
    private JCheckBox rpepsi, rdwo, rwater;
    private JComboBox<String> bpepsi;
    private JComboBox<String> bdwo;
    private JComboBox<String> bwater;
    private String a[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String b[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String d[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String f;

    public Category3(String user) {

        ImageIcon framelogo = new ImageIcon("Image/logo.png");
        setIconImage(framelogo.getImage());

        f = user;

        Icon bicon = new ImageIcon("Image/Drinks Banner.png");
        Icon pepsii = new ImageIcon("Image/pepsi.png");
        Icon dwoi = new ImageIcon("Image/Duo.png");
        Icon wateri = new ImageIcon("Image/Water.png");

        setTitle("DRINKS");
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

        pepsi = new JButton(pepsii);
        pepsi.setBounds(120, 175, 200, 200);
        pepsi.addActionListener(this);
        panel.add(pepsi);

        rpepsi = new JCheckBox("Pepsi");
        rpepsi.setBounds(120, 385, 200, 30);
        rpepsi.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(rpepsi);

        prpepsi = new JLabel("50 Tk");
        prpepsi.setBounds(150, 415, 150, 20);
        prpepsi.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(prpepsi);

        bpepsi = new JComboBox<String>(a);
        bpepsi.setBounds(120, 445, 70, 20);
        panel.add(bpepsi);

        dwo = new JButton(dwoi);
        dwo.setBounds(350, 175, 200, 200);
        dwo.addActionListener(this);
        panel.add(dwo);

        rdwo = new JCheckBox("Mountain Dew");
        rdwo.setBounds(350, 385, 200, 30);
        rdwo.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(rdwo);

        prdwo = new JLabel("50 Tk");
        prdwo.setBounds(380, 415, 150, 20);
        prdwo.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(prdwo);

        bdwo = new JComboBox<String>(b);
        bdwo.setBounds(350, 445, 70, 20);
        panel.add(bdwo);

        water = new JButton(wateri);
        water.setBounds(600, 175, 200, 200);
        water.addActionListener(this);
        panel.add(water);

        rwater = new JCheckBox("Aquafina Water");
        rwater.setBounds(600, 385, 200, 30);
        rwater.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(rwater);

        prwater = new JLabel("20 Tk");
        prwater.setBounds(630, 415, 150, 20);
        prwater.setFont(new Font("Areal", Font.PLAIN, 15));
        panel.add(prwater);

        bwater = new JComboBox<String>(b);
        bwater.setBounds(600, 445, 70, 20);
        panel.add(bwater);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Restaurant(f);
            setVisible(false);
        } else if (e.getSource() == order) {
            double totalAmount = 0;
            double pepsiamount = 0;
            double dwoamount = 0;
            double wateramount = 0;
            int a = 0;
            int b = 0;
            int c = 0;

            if (rpepsi.isSelected() == true) {
                a = (bpepsi.getSelectedIndex()) + 1;
                pepsiamount = a * 50;
            }
            if (rdwo.isSelected() == true) {
                b = bdwo.getSelectedIndex() + 1;
                dwoamount = b * 50;
            }
            if (rwater.isSelected() == true) {
                c = bwater.getSelectedIndex() + 1;
                wateramount = c * 20;
            }

            totalAmount = pepsiamount + dwoamount + wateramount;
            if (totalAmount != 0) {
                int x = JOptionPane.showConfirmDialog(null, "Your Bill = " + totalAmount + " tk. Confirm Order?",
                        " Conformation of Oder", 0);
                if (x == 0) {
                    setVisible(false);
                    new Payment(totalAmount, "Category3", f);

                    try {
                        File newfile = new File("data\\Last.txt");
                        newfile.createNewFile();
                        FileWriter file = new FileWriter("data\\Last.txt");

                        file.write("Pepsi--- " + a + pepsiamount + " tk."
                                + "\nMountain Dew----" + b + dwoamount + " tk."
                                + "\nWater---" + c + wateramount + " tk."
                                + "\n" + totalAmount + " tk Total.");
                        file.close();

                    } catch (IOException io) {
                        JOptionPane.showMessageDialog(null, "An error Occurred and failed to create the file");
                        io.printStackTrace();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select something before placing an order!", "Message", 0);
            }
        }
    }
}
