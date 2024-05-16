package com.example.oblig3;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public boolean registerUser(User user){
        String sql = "INSERT INTO users (username, password) values (?, ?)";
        try {
            db.update(sql, user.getUsername(), user.getPassword());
            return true;
        } catch (Exception e) {
            logger.error("Error: "+e.getCause());
            return false;
        }
    }

    public boolean checkUsernameAndPassword(User inUser){
        String sql = "SELECT * FROM users WHERE username = ?";
        User registeredUser = db.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class),
                inUser.getUsername());
        if (BCrypt.checkpw(inUser.getPassword(), registeredUser.getPassword())){
            logger.info("Password is correct");
            return true;
        }
        logger.info("Password is not correct");
        return false;
    }
}