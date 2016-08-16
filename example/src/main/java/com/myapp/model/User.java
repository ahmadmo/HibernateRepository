package com.myapp.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;

/**
 * @author ahmad
 */
@Entity
@Table
@DynamicUpdate
@OptimisticLocking
@NamedQueries({
        @NamedQuery(name = User.FIND_BY_EMAIL, query = "select u from User u where u.email = (:email)"),
})
public final class User extends BaseEntity {

    public static final String FIND_BY_EMAIL = "user.findByEmail";

    private static final long serialVersionUID = 6839701266504505755L;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
