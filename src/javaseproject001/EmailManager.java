/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaseproject001;

/**
 *
 * @author YU
 */
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;


public class EmailManager { 

	private Properties props; //system property
	private Session session; //the session object
	private MimeMessage mimeMsg; //the person who receive the msg
	private Multipart mp; //Multipart which include (subject, tittle ,content and so on)
	 
	/**
	 * Constructor
	 * @param smtp Sent E-mail
	 */
	public EmailManager(){
		props = System.getProperties();	
		props.put("mail.smtp.auth","false"); 
		session = Session.getDefaultInstance(props, null);
		session.setDebug(true);
		mimeMsg = new MimeMessage(session);
		mp = new MimeMultipart(); 
	} 
	/**
	 * Constructor
	 * @param smtp email send to server
	 */
	public EmailManager(String smtp, String username, String password){ 
		//set the username and password for administrator's email
                props = System.getProperties();
                //set the smtp (simple mail transfer protocol)
		props.put("mail.smtp.auth","true"); 
		props.put("mail.smtp.host", smtp);
		props.put("username", username);
		props.put("password", password);
		session = Session.getDefaultInstance(props, null);
		session.setDebug(true);
		mimeMsg = new MimeMessage(session);
		mp = new MimeMultipart(); 
	} 

	public boolean sendMail(String from, String[] to, String[] copyto, String subject, String content, String filename) {
		try {
			//set the sender
			mimeMsg.setFrom(new InternetAddress(from)); 
			//set the receiver
			for (int i = 0; i < to.length; i++) {
				mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to[i])); 
			}
			//set subject
			mimeMsg.setSubject(subject);
			//set content
			BodyPart bp = new MimeBodyPart(); 
			bp.setContent(content, "text/html;charset=utf-8");
			mp.addBodyPart(bp);
			bp = new MimeBodyPart();
                        //pass the filename as parameter which set by user.
			FileDataSource fileds = new FileDataSource(filename); 
                        //Convert inputstream to datahandler
			bp.setDataHandler(new DataHandler(fileds)); 
                        //Encde the filename to enhance the security.
			bp.setFileName(MimeUtility.encodeText(fileds.getName(),"UTF-8","B"));
                        
			mp.addBodyPart(bp); 
			mimeMsg.setContent(mp); 
			mimeMsg.saveChanges(); 
			//send the email based on protocol setting
			if(props.get("mail.smtp.auth").equals("true")){
				Transport transport = session.getTransport("smtp"); 
                                // get the eamil address, username and passowrd of email manager
				transport.connect((String)props.get("mail.smtp.host"), (String)props.get("username"), (String)props.get("password")); 
				transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO)); // sent to the recipient's address
				transport.close(); 
			}else{
				Transport.send(mimeMsg);
			}
			System.out.println("the email has been sent successfully");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public static void main(String[] args){
		String smtp = "smtp.163.com";
		String username="xxx@163.com";
		String password="xxx";
		String from = "xxx@163.com";
		String[] to = {"xxx@qq.com"};
		String[] copyto = {"xxx@qq.com"};
		String subject = "主题";
		String content = "邮件内容";
	 	String filename = "D:\\xxx.txt";
	 	EmailManager email = new EmailManager(smtp, username, password);
	 	email.sendMail(from, to, copyto, subject, content, filename);
	}
	
}