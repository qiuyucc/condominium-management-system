/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaseproject001;
import java.beans.Statement;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.MessageFormat;
import java.util.*;
/**
 *
 * @author JKERY
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static User loginUser;
    public static void main(String[] args) throws Exception {
/*
        Class.forName("com.mysql.jdbc.Driver");
        //get conncetion with SQL server, the username is chen, password is 123456789
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/TSS","chen","123456789");
        Statement st=(Statement) cn.createStatement();
        //The create a userList.bin in main funcation when system initialization 
        File f1= new File("UserList.bin"); 
        FileInputStream fin=new FileInputStream(f1);
        //insert the binary file in to SQL
        PreparedStatement pst = cn.prepareStatement("insert into userinformation values(?)"); 
        //Start the binary stream and update the table in the sql server
        pst.setBinaryStream(1,fin,fin.available());
        pst.executeUpdate();
        //close the data stream
        fin.close();
        System.out.println("Quesry Executed Successfully");
     */   
        
        
        
        MainForm mainFrom = new MainForm(0);    
    }
    
    public static void SerializeUserList(ArrayList<User> list) throws FileNotFoundException,IOException {
        //Bind the information of user into one object and save to binary file
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("UserList.bin")));
        oo.writeObject(list);
        System.out.println("data save successlly！");
        oo.close();
    }
    public static ArrayList<User> DeserializeUserList() throws Exception, IOException {
        //Load the infromation from binary file
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("UserList.bin")));
        ArrayList<User> list = (ArrayList<User>) ois.readObject();
        System.out.println("data load successlly！");
        return list;
    }
    
    public static void CreateData(){
        ArrayList<User> userList = new ArrayList<User>();
        User user = new User("admin001","admin","admin","138123456789","admin@admin.com",1,0.0);//经理账号 role =1
        User user2 = new User("office001","office","office","138123456789","office@office.com",2,0.0);//office 账号 role =2
        //User user3 = new User("A0101","test001","test001","123456789","test001@test.com",1,0.0);//住户信息 userId 表示用户的编号 比如 A0101 A栋1单元1室
        userList.add(user);
        userList.add(user2);
        //循环添加住户信息
        int count =1;
        for(int i =1 ;i<=2;i++){
            for(int j =1 ;j<=10;j++){
                for(int k=1;k<=5;k++){
                    String userId = (i==1?"A":"B")+String.format("%02d", j)+String.format("%02d", k);
                    String userName = "test"+String.format("%03d", count);
                    String userPwd =  "test"+String.format("%03d", count);
                    String phone ="123456"+String.format("%03d", count);
                    String email=userName+"@test.com";
                    int role = 3;
                    double userBalance =0.0;
                        userList.add(new User(userId,userName,userPwd,phone,email,role,0.0));
                    count++;
                }
            }
        }
        try{
            SerializeUserList(userList);
        }catch(Exception e){
            System.out.println("cannot save！");
        }
    }
  
    
}
