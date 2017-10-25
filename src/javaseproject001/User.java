/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaseproject001;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author JKERY
 */
public class User implements Serializable {
     private static final long serialVersionUID = -5809782578272943999L;
     public User(String userId,String userName,String userPwd,String userPhone,String userEmail,int userRole,double userBalance){
         this.userId=userId;
         this.userName=userName;
         this.userPwd=userPwd;
         this.userPhone=userPhone;
         this.userEmail=userEmail;
         this.userRole=userRole;
         this.userBalance=userBalance;
     }
     
     private String userId;
     public String getUserId(){
         return userId;
     }
     public void setUserId(String userId){
         this.userId=userId;
     }
     
     private String userName;
     public String getUserName(){
         return userName;
     }
     public void setUserName(String name){
         this.userName=name;
     }
     
     private String userPwd;
     public String getUserPwd(){
         return userPwd;
     }
     public void setUserPwd(String Pwd){
         this.userPwd=Pwd;
     }
     
     private String userPhone;
     public String getUserPhone(){
         return userPhone;
     }
     public void setUserPhone(String phone){
         this.userPhone=phone;
     }
     
     private String userEmail;
     public String getUserEmail(){
         return userEmail;
     }
     public void setUserEmail(String email){
         this.userEmail=email;
     }
     
     private int userRole; // 1:普通用户 //2:办公室用户 //3:经理
     public int getUserRole(){
         return userRole;
     }
     public void setUserRole(int role){
         this.userRole=role;
     }
     
     
    private double userBalance;
    public double getUserBalance(){
         return userBalance;
     }
     public void setUserBalance(double balance){
         this.userBalance=balance;
     }
     
     public ArrayList<Order> userOrders = new ArrayList<Order>();
     
     
}
