package bookstore.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bookstore.entities.MyUserDetails;
import bookstore.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository srv;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(srv.Auth(username)==null) {
			throw new UsernameNotFoundException("No user with: " + username);
				}
		return new User(srv.Auth(username).getUsername(),srv.Auth(username).getPassword(),new ArrayList<>());
	}

}
