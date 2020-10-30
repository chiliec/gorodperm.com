package info.babin.gorodperm.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

//    @OneToMany(mappedBy="author", fetch=FetchType.LAZY)
//    private Collection<Post> posts;
}
