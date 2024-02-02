package com.Sunbase.dev.dao;
import com.Sunbase.dev.repository.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IUserDAO extends JpaRepository<User, Long>{
    public User findByUsername(String username);

}
