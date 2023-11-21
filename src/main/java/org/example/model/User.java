package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String login;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    //@JoinColumn(name="user_id")Association 'org.example.model.User.orders' is 'mappedBy' another entity and may not specify the '@JoinColumn'
    private List<Order> orders;
    public User(String login) {
        this.login = login;
    }

    public User() {
        // Auto-generated constructor stub
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
