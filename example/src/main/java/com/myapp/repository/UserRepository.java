package com.myapp.repository;

import com.myapp.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hibernate5.repository.HibernateRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ahmad
 */
@Repository("userRepository")
public class UserRepository extends HibernateRepository<User, Long> {

    @Autowired
    public UserRepository(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
    }

}
