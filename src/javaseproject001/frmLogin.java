/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaseproject001;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author JKERY
 */
public class frmLogin extends JFrame{
    JTextField login ;
    JPasswordField pwd;
    JLabel jl_Login;
    JLabel jl_pwd;
    JButton jb_Login;
    JButton jb_Cancel;
       
    public frmLogin(){
        JLabel jl = new JLabel("welcome",SwingUtilities.CENTER);		
        Font font = new Font("Times New Roman",Font.BOLD,24);		
        jl.setFont(font);		
        jl.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.add(jl,BorderLayout.NORTH);
        font = new Font("Times New Roman",Font.PLAIN,12);				
        JLabel jl_name = new JLabel("username：",SwingUtilities.RIGHT);		
        jl_name.setFont(font);				
        JLabel jl_id = new JLabel("ID number：",SwingUtilities.RIGHT);		
        jl_id.setFont(font);				
        JLabel jl_pass1 = new JLabel("password：",SwingUtilities.RIGHT);		
        jl_pass1.setFont(font);				
        JLabel jl_pass2 = new JLabel("confirm password：",SwingUtilities.RIGHT);		
        jl_pass2.setFont(font);				
        JLabel jl_count = new JLabel("Storage amount：",SwingUtilities.RIGHT);		
        jl_count.setFont(font);				
        JPanel jp_center_left = new JPanel();				
        jp_center_left.setLayout(new GridLayout(5,1));
        jp_center_left.add(jl_name);		
        jp_center_left.add(jl_id);		
        jp_center_left.add(jl_pass1);		
        jp_center_left.add(jl_pass2);		
        jp_center_left.add(jl_count);				
        JTextField jt_name = new JTextField();		
        JTextField jt_id = new JTextField("                     ");		
        JPasswordField jt_pass1 = new JPasswordField();		
        JPasswordField jt_pass2 = new JPasswordField();		
        jt_pass1.setEchoChar('*');		
        jt_pass2.setEchoChar('*');		
        JTextField jt_count = new JTextField();				
        JPanel jp_center_right = new JPanel();		
        jp_center_right.setLayout(new GridLayout(5,1));		
        jp_center_right.add(jt_name);		
        jp_center_right.add(jt_id);		
        jp_center_right.add(jt_pass1);		
        jp_center_right.add(jt_pass2);		
        jp_center_right.add(jt_count);				
        JPanel jp_center = new JPanel();		
        jp_center.setLayout(new GridLayout(1,2));		
        jp_center.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 60));
        jp_center.add(jp_center_left);		
        jp_center.add(jp_center_right);
        JButton jb1 = new JButton("sure");
        JButton jb2 = new JButton("back");
        JPanel jp_south = new JPanel();
        jp_south.add(jb1);
        jp_south.add(jb2);
        jp_south.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(jp_center);
        this.add(jp_south,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(370, 280);
        this.setResizable(false);                    
        this.setLocationRelativeTo(null);
    }
}
