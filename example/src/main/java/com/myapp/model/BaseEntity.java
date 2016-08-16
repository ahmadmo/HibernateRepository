package com.myapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author ahmad
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -8051361867804084642L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, updatable = false)
    private long id;

    public long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof BaseEntity && Objects.equals(id, ((BaseEntity) obj).id);
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }

}
