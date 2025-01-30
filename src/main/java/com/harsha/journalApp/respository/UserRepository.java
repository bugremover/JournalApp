package com.harsha.journalApp.respository;

import com.harsha.journalApp.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findByuserName(String userName);
    void deleteByUserName(String userName);
}
