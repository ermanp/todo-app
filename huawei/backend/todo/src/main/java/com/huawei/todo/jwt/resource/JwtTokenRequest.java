package com.huawei.todo.jwt.resource;
import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;

    /*
    *
    *   {
            "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU3ODk5MzY0NywiaWF0IjoxNTc4Mzg4ODQ3fQ.o99lrsfXPzlUVUKoYDz9C2JPBW91kjYnDUcRdvtKC7yOx1qmFyktXv2XDtnHu5Fr0NXQAimiVTWKtfOzFdmyWA"
         }
    *
    *
    *
    *
    * */

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

