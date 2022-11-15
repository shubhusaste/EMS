package employee;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.event.*;
import java.sql.*;


class login  implements ActionListener{

    JFrame f;
    JLabel l1,l2,l4,l5;
    JPanel p;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    login(){

        f=new JFrame("Welcome to Employee Management System");

        f.setBackground(Color.white);
        f.setLayout(null);
        f.setDefaultCloseOperation(3);
        p= new JPanel();
        p.setBackground(Color.ORANGE);
        p.setBounds(0,0,550,60);
        l5= new JLabel("Login");
        l5.setFont(new Font("serif",Font.TRUETYPE_FONT,40));
        p.add(l5);
        f.add(p);


        l1 = new JLabel("Username");
        l1.setBounds(40,115,100,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        f.add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40,155,100,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        f.add(l2);

        l4= new JLabel("Enter Your Login Credentials");
        l4.setBounds(40,65,250,40);
        l4.setFont(new Font("serif",Font.BOLD,20));
        l4.setForeground(Color.GRAY);
        f.add(l4);

        t1=new JTextField();
        t1.setBounds(130,115,150,30);
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(130,155,150,30);
        f.add(t2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,60,200,200);
        f.add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,205,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,205,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);

        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(550,320);
        f.setLocation(400,200);

    }

    public void actionPerformed(ActionEvent ae){

        try {
            if (ae.getSource() == b1) {
                Conn c11 = new Conn();
                String u = t1.getText();
                String v = t2.getText();

                String q = "select * from login where USERNAME='" + u + "' and PASSWORD='" + v + "'";

                ResultSet rs = c11.s.executeQuery(q);
                if (rs.next()) {
                    new details1().f.setVisible(true);
                    f.setVisible(false);
                    // f.dispose();.
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    f.setVisible(false);
                }
            }
            if(ae.getSource()==b2){
                f.setVisible(false);
                new Front_Page().f.setVisible(true);

            }
            }

            catch(Exception e){
                e.printStackTrace();
            }

    }
    public static void main(String[] arg){
        login l=new login();
    }
}