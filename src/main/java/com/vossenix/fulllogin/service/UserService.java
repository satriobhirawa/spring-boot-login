package com.vossenix.fulllogin.service;

import com.vossenix.fulllogin.model.CurrentUserDetails;
import com.vossenix.fulllogin.model.User;
import com.vossenix.fulllogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {    //retrieve user related data in order to authenticate users
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByConfirmationToken(String confirmationToken) {
        return userRepository.findByConfirmationToken(confirmationToken);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    //requires implement this method because of UserDetailsService interface from Spring security
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByEmail(username);
        if(username == null){
            throw new UsernameNotFoundException("User not found!");
        }
        return new CurrentUserDetails(user);
    }
}
