package com.huawei.todo.jwt;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "erman",
            "$2a$10$zTGH0tDFQLSLr94COtbLyuVTKBsUZvCoRhmW6I4VtLx94.TVDTj0i", "ROLE_USER_2"));

    inMemoryUserList.add(new JwtUserDetails(2L, "esra",
            "$2a$10$Wv.WixTAXs288u6fxTo6HefvxRFmCTsJ8enEGfkhTANHiB/vOkH6C", "ROLE_USER_2"));

    // $2a$10$vVPaMK9y.8JlXdi6x4x0QuLgmmP3ynvVih5EZXmv/Sm0x/1q3FD5G

  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


