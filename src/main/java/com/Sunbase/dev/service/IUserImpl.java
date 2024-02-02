package com.Sunbase.dev.service;
import com.Sunbase.dev.dao.IUserDAO;
import com.Sunbase.dev.repository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
@Service
public class IUserImpl implements IUserService{
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    IUserDAO iUserDAO;
    public List getAll(){
        List<User>myList = iUserDAO.findAll();
        Iterator<User> it = myList.iterator();
        while(it.hasNext()){
            User u = it.next();
            u.setFirstName(u.getFirstName());
            u.setLastName(u.getLastName());
            u.setStreet(u.getStreet());
            u.setAddress(u.getAddress());
            u.setCity(u.getCity());
            u.setState(u.getState());
            u.setEmail(u.getEmail());
            u.setPassword(u.getPassword());
        }
        return iUserDAO.findAll();
    }
    @Override
    public User getById(long id) { return (User) iUserDAO.findById(id).get(); }
    @Override
    public User add(User u) { return (User) iUserDAO.save(u);}
    @Override
    public boolean delete(long id) {
        iUserDAO.deleteById(id);
        return true;
    }
    @Override
    public User update(User u,long id){
        User u1 = (User) iUserDAO.findById(id).get();

        if(u1 != null) {
            if (u.getUsername() != null) {
                u1.setUsername(u.getUsername());
            }
            if (u.getPassword() != null) {
                u1.setPassword(u.getPassword());
            }
        }
        return (User) iUserDAO.save(u1);
    }
}
