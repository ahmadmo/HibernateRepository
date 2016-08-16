package com.myapp.service;

import com.myapp.model.User;
import com.myapp.repository.UserRepository;
import org.apache.commons.validator.routines.EmailValidator;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ahmad
 */
@Service("userService")
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String email, String password) throws InvalidDataEntryException, DuplicateEmailAddressException {
        if (!EmailValidator.getInstance().isValid(email)) {
            throw new InvalidDataEntryException("invalid email address = " + email);
        }
        User user = new User(email, password);
        try {
            userRepository.add(user);
        } catch (ConstraintViolationException e) {
            throw new DuplicateEmailAddressException(email);
        }
        return user;
    }

    public User findByEmail(final String email) {
        return userRepository.namedQuery(User.FIND_BY_EMAIL)
                .use(q -> q.setString("email", email))
                .get();
    }

}
