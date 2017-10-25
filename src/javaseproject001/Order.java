/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaseproject001;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author JKERY
 */
public class Order implements Serializable  {
    private Date orderDate= new Date();
    private double money;
    private String type;//"+"or"-"
    
    public Order(String type,double money){
        this.type = type;
        this.money = money;
    }
    
    public Date getOrderDate(){
        return orderDate;
    }
    
    public String getOrderType(){
        return type;
    }
    public void setOrderType(String type){
       this.type = type;
    }
    
    public double getOrderMoney(){
        return money;
    }
    public void setOrderMoney(double money){
       this.money = money;
    }
     
}
