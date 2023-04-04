package com.example.springudomljavanjezivotinja.service;

import com.example.springudomljavanjezivotinja.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {


      public void save(User user);
      public List<Object> isUserPresent(User user);











}
