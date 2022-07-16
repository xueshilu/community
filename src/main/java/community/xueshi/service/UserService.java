package community.xueshi.service;

import community.xueshi.mapper.UserMapper;
import community.xueshi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        System.out.println("cou");
        User dbUser = userMapper.findByAccountId(user.getAccount_id());
        if(dbUser == null){
            //insert
            System.out.println("insert");
            user.setGmt_create(System.currentTimeMillis());
            user.setGmt_modified(user.getGmt_create());
            userMapper.insert(user);
        }
        else{
            //update
            System.out.println("updaste");
            dbUser.setGmt_create(System.currentTimeMillis());
            dbUser.setGmt_modified(user.getGmt_create());
            dbUser.setName(user.getName());
            dbUser.setToken(user.getToken());
            dbUser.setAvatar_url(user.getAvatar_url());
            userMapper.update(dbUser);
        }

    }
}
