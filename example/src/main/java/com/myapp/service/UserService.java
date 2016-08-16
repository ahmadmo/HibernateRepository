package com.myapp.service;

import com.myapp.model.User;
import com.myapp.repository.UserRepository;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

    @Transactional(rollbackFor = DuplicateEmailAddressException.class)
    public User register(String email, String password) throws InvalidDataEntryException, DuplicateEmailAddressException {
        if (!EmailValidator.getInstance().isValid(email)) {
            throw new InvalidDataEntryException("invalid email address = " + email);
        }
        User user = new User(email, password);
        userRepository.add(user);
        try {
            userRepository.getHibernateTemplate().flush();
            return user;
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailAddressException(email);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User findByEmail(final String email) {
        return userRepository.namedQuery(User.FIND_BY_EMAIL)
                .use(q -> q.setString("email", email))
                .get();
    }

}
