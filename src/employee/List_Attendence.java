package employee;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class List_Attendence extends JFrame implements ActionListener{

    JTable j1;
    JButton b1,b2;
    String h[]={"Emp id","Date Time","First Half","Second Half"};
    String d[][]=new String[15][5];
    int i=0,j=0;

    List_Attendence(){
        super("View Employees Attendence");
        setSize(800,300);
        //setLocation(450,150);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        try{
            String q="select * from attendence";
            Conn c1=new Conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
               // d[i][j++]=rs.getString("name");
                d[i][j++]=rs.getString("EMP_ID");
                d[i][j++]=rs.getString("date_tm");
                d[i][j++]=rs.getString("f_half");
                d[i][j++]=rs.getString("s_half");
                i++;
                j=0;
            }

            j1=new JTable(d,h);

        }catch(Exception e){}

        b1=new JButton("Print");
        b1.setBounds(50,550,200,30);
        b2=new JButton("Cancel");
        b2.setBounds(300,550,200,30);
        add(b2);
        add(b1);
        JScrollPane s1=new JScrollPane(j1);
        add(s1);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()==b1) {
                j1.print();
                setVisible(true);
                setVisible(false);
            }
            if(ae.getSource()==b2){
                setVisible(false);
                new details1();
            }
        }catch(Exception e){}
    }

    public static void main(String[] args){
        new List_Attendence();
    }
}