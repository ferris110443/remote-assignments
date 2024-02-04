package org.yplinq.assignment3.entity;


import jakarta.persistence.*;


/**
 * representation of a user entity related to database
 */
@Entity // indicate the class represents a table in relational database
public class UserInformation {
    @SequenceGenerator(name = "allocationSizeOneGenerator", allocationSize = 1)
    // avoid restart server id increase default allocationSize 50
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "allocationSizeOneGenerator")
    private Integer user_information_id;
    private String email;
    private String password;

    public UserInformation() {
    }


    @Override
    public String toString() {
        return "UserInformation{" +
                "id=" + user_information_id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public Integer getId() {
        return user_information_id;
    }

    public void setId(Integer id) {
        this.user_information_id = id;
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
}
