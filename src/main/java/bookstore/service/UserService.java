package bookstore.service;

import java.util.List;

import bookstore.entities.Reclamation;
import bookstore.entities.User;

public interface UserService {
	// SERVICE user -MOHAMED BDIOUI-
	User findByUsernameOrEmail(String usernameOrEmail);
	public User addCustomer(User u);
	public Iterable<User> showAllCustomer();
	public List<User> showAlladmin() ;
	public User GetUser(int id);
	public void Delete(int id);
	public void mailling(String mail,String message);
	public String Signup(User us);
	public User Authority(String login, String password);
	public User Update(User us);
	public String UpdateRestPassword(int code,String password,Long id);
	public void ifNotverifiedVerif(Long id,String verification_code);
	public String VerifyMyaccount(User u, String verifcode);
	public boolean isVerified(String login, String pwd);
	public void AddCode(String code,User user_id) ;
}
