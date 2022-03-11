package org.example.Model;

import javax.persistence.*;

@Entity(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer Id;
    private String Name;
    private String Email;
    private String Password;
    private String Contact;

    public User(Integer id, String name, String email, String password, String contact) {
        Id = id;
        Name = name;
        Email = email;
        Password = password;
        Contact = contact;
    }
    public User(){};

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Contact='" + Contact + '\'' +
                '}';
    }
}
