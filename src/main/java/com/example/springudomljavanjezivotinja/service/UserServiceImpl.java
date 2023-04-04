package com.example.springudomljavanjezivotinja.service;

import com.example.springudomljavanjezivotinja.model.Role;
import com.example.springudomljavanjezivotinja.model.User;
import com.example.springudomljavanjezivotinja.respositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole(Role.USER);
        userRepository.save(user);
    }

    @Override
    public List<Object> isUserPresent(User user) {
        boolean presentUser = false;
        String message = null;
        Optional<User> userEmailExist = userRepository.findByEmail(user.getEmail());
        if(userEmailExist.isPresent()){
            presentUser = true;
            message = "Email exist!";
        }
        Optional<User> userPhoneNumberExist = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if(userPhoneNumberExist.isPresent()){
            presentUser = true;
            message = "Phone Number Exist!";
        }
        if (userEmailExist.isPresent() && userPhoneNumberExist.isPresent()) {
            message = "Email and Mobile Number Both Already Present!";
        }
        System.out.println("existingUserEmail.isPresent() - "+userEmailExist.isPresent()+"existingUserMobile.isPresent() - "+userPhoneNumberExist.isPresent());
        return Arrays.asList(presentUser, message);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(
                ()-> new UsernameNotFoundException(
                        String.format("USER_NOT_FOUND", email)
              )  );
    }
}