package com.example.oblig3;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    UserRepository rep;

    @Autowired
    private HttpSession session;

    @GetMapping("/login")
    public boolean login(User user){
        if(rep.checkUsernameAndPassword(user)){
            session.setAttribute("loggedIn", user);
            return true;
        }
        return false;
    }

    @GetMapping("/logout")
    public boolean logout(){
        try{
            session.removeAttribute("loggedIn");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkIfLoggedIn(){
        return session.getAttribute("loggedIn") != null;
    }

    @PostMapping("/registerTestUser")
    public void registerTestUser(User testUser, HttpServletResponse response) throws IOException {
        String encryptedPassword = BCrypt.hashpw(testUser.getPassword(),BCrypt.gensalt(10));
        testUser.setPassword(encryptedPassword);
        if (!rep.registerUser(testUser)){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "testUser already exists");
        }
    }


}