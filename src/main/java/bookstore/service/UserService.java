package bookstore.service;

import bookstore.entities.User;

public interface UserService {
	// SERVICE user -MOHAMED BDIOUI-
	User findByUsernameOrEmail(String usernameOrEmail);
	
}
