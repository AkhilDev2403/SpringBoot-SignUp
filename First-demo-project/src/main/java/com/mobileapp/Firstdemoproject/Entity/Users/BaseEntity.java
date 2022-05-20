package com.mobileapp.Firstdemoproject.Entity.Users;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Comparable<BaseEntity>, Serializable {

    private static final long SerialVersionUID = 1L;

    @Access(AccessType.PROPERTY)
    @Id()
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Override
    public int compareTo(BaseEntity o) {
        return 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
