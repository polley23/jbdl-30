package com.gfg.jbdl30session9.manager;

import com.gfg.jbdl30session9.entity.User;
import com.gfg.jbdl30session9.model.UserReq;
import com.gfg.jbdl30session9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManagr{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(UserReq userReq) {
        User user = new User();
        user.setUserName(userReq.getUserName());
        user.setPhone(userReq.getPhone());
        user.setEmail(userReq.getEmail());
        userRepository.save(user);
    }
}
