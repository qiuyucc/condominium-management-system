/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaseproject001;
import java.util.*;
import javax.swing.JFrame;

/**
 *
 * @author Jkery
 */
public class MainForm extends JFrame{
    public LoginPanel loginPanel = new LoginPanel(this);
    public UserJPanel userPanel = new UserJPanel(this);
    public ManagerJPanel managerPanel = new ManagerJPanel(this);
    public OfficeJPanel officeJPanel = new OfficeJPanel(this);
    public ArrayList<User> userOrders = new ArrayList<User>();
    
    public MainForm(int userRole){
        ShowByUserRole(userRole);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);		
        this.setSize(800, 600);		
        this.setResizable(false);		
        this.setLocationRelativeTo(null);
    }
      
    public void ShowByUserRole(int userRole){
        this.remove(loginPanel);
        this.remove(userPanel);
        this.remove(managerPanel);
        this.remove(officeJPanel);
        if(userRole==0){
            this.add(loginPanel);
        }else if(userRole==1){
            this.add(managerPanel);
            managerPanel.initForm();
        }else if(userRole==2){
            this.add(officeJPanel);
            officeJPanel.initForm();
        }else if(userRole==3){
            this.add(userPanel);
            userPanel.initForm();
        }
        this.repaint();

    }
}
