package com.slabstech.revive.server.dropwizard.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity
@Table(name = "user")
@NamedQuery(
        name = "com.slabstech.revive.server.dropwizard.core.Product.findAll",
        query = "SELECT u FROM user u"
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "yearBorn")
    @Min(value = 0)
    @Max(value = 9999)
    private int yearBorn;

    public User() {
    }


    public User(String fullName, String address, int yearBorn) {
        this.fullName = fullName;
        this.address = address;
        this.yearBorn = yearBorn;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String jobTitle) {
        this.address = jobTitle;
    }

    public int getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        return id == user.id &&
                yearBorn == user.yearBorn &&
                Objects.equals(fullName, user.fullName) &&
                Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, address, yearBorn);
    }
}
