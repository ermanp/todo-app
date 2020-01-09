package com.huawei.todo.jwt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.huawei.todo.doa.UserRepository;
import com.huawei.todo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "",
            "", "ROLE_USER_2"));

    inMemoryUserList.add(new JwtUserDetails(2L, "",
            "", "ROLE_USER_2"));

  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findUserbyUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),
             Arrays.asList(new SimpleGrantedAuthority("USER")));
  }

}


