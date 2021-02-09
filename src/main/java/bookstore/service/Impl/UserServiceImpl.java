package bookstore.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import bookstore.entities.Livre;
import bookstore.entities.Reclamation;
import bookstore.entities.StatutReclamation;
import bookstore.entities.TypeReclamation;
import bookstore.entities.User;
import bookstore.entities.Verification_Code;
import bookstore.exception.ReclamationException;
import bookstore.exception.StockException;
import bookstore.repository.ReclamationRepository;
import bookstore.repository.StockRepository;
import bookstore.repository.UserRepository;
import bookstore.repository.VerificationCodeRepository;
import bookstore.service.ReclamationAdminService;
import bookstore.service.ReclamationClientService;
import bookstore.service.StockService;
import bookstore.service.UserService;

import org.apache.logging.log4j.*;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	private static final Logger L = LogManager.getLogger(UserServiceImpl.class);
	VerificationCodeRepository vcRepo;
	Verification_Code Vc=new Verification_Code();
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	public static int  coderest=0;
	public static int  idverif=0;
	// GESTION User -MOHAMED BDIOUI-
	@Override
	public User findByUsernameOrEmail(String usernameOrEmail) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//add user
		public User addCustomer(User u){
		    return userRepository.save(u);
	    }
		//get all user *********************************
		  public Iterable<User> showAllCustomer() {
			  return userRepository.findAll();
		  }
		  //get all admin**********************************
		  public List<User> showAlladmin() {
			return (List<User>)userRepository.adminlist();
			  }
			//get user by id***************************************
			public Optional<User> GetUser(Long id) {
				return userRepository.findById(id);
			}
			//delete user ************************************ 
			public void Delete(Long id) {
				Optional<User> x=userRepository.findById(id);
				if(x!=null) {
					userRepository.deleteById((long) id);
				}
			}
			
			public String Signup(User us) {
				L.info(us);
				if(userRepository.Existmail(us.getEmail(),us.getUsername())==false) {
					System.out.println(us.getPassword());
					String encodedPassword1 = bCryptPasswordEncoder.encode("123");
					System.out.println(encodedPassword1);
					String encodedPassword = bCryptPasswordEncoder.encode(us.getPassword());
					String verifCode = bCryptPasswordEncoder.encode(us.getNom());
					us.setPassword(encodedPassword);
					User x=userRepository.save(us);

					mailling(us.getEmail(),"Your verification code is : "+verifCode );
					return "User added successfully !";
				}
				return "User already Exist";
			}
		
			public void mailling(String mail,String message) {
				final String username = "booklab.pro@gmail.com";
				final String password = "esprit123";
				String fromEmail = "booklab.pro@gmail.com";
				Properties properties = new Properties();
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.starttls.enable", "true");
				properties.put("mail.smtp.host", "smtp.gmail.com");
				properties.put("mail.smtp.port", "587");
				Session session = Session.getInstance(properties,new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username,password);
					}
				});
				MimeMessage msg = new MimeMessage(session);
				try {
					msg.setFrom(new InternetAddress(fromEmail));
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
					msg.setSubject("User Verification");
					Multipart emailContent = new MimeMultipart();
					MimeBodyPart textBodyPart = new MimeBodyPart();
					textBodyPart.setText(message);
					emailContent.addBodyPart(textBodyPart);
					msg.setContent(emailContent);
					Transport.send(msg);
					System.out.println("Sent message");
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
			
			public User Update(User us) {
				if(userRepository.findById(us.getId())!=null) {
					String encodedPassword = bCryptPasswordEncoder.encode(us.getPassword());
					// TODO Auto-generated method stub
					us.setPassword(encodedPassword);
					userRepository.save(us);
					return us;
				}
				return null;
			}
			public User Authority(String username, String password)  {
				User logged= userRepository.Auth(username);
				  System.out.println(logged);
				if(bCryptPasswordEncoder.matches(password,logged.getPassword())){
					return logged;
				}

				return null;
			}
			
			public String UpdateRestPassword(int code, String password, Long id) {
				// TODO Auto-generated method stub
				Optional<User> optt= userRepository.findById(id);
				User t=optt.get();
				System.out.println(t);
				if(t==null) {
					return "User not found";
				}
				if(UserServiceImpl.coderest==code) {
					t.setPassword(bCryptPasswordEncoder.encode(password));
					userRepository.save(t);
					return "Password updated successfully !";
				}

				return "wrong code";
			}
			public void AddCode(String code, User user_id) {
				Vc.setCode(code);
				Vc.setUser_id(user_id);
				vcRepo.save(Vc);
			}
			public boolean isVerified(String login, String pwd) {
				if(userRepository.isverified(login)==null)
					return false;
				return true;
			}
			public String VerifyMyaccount(User u, String verifcode) {
				// TODO Auto-generated method stub
				if(isVerified(u.getUsername(),u.getPassword()))
					return "you are already verified";

				else if(bCryptPasswordEncoder.matches(userRepository.Auth(u.getUsername()).getNom(),verifcode) && (userRepository.Auth(u.getUsername())!=null )) {
					AddCode(verifcode, userRepository.Auth(u.getUsername()));
					return "you have been verified";
				}
				return "Something went wrong";
			}
			public void ifNotverifiedVerif(Long id,String verification_code) {
				// TODO Auto-generated method stub
				if(vcRepo.CheckVerification(verification_code,id)==null) {
					Optional<User> opt = userRepository.findById( id);
					User u =opt.get();
					AddCode(verification_code,u );
				}
			}
			//******************************************************************
			@Override
			public User GetUser(int id) {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public void Delete(int id) {
				// TODO Auto-generated method stub
				
			}
	}
