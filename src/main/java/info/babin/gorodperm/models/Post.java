package info.babin.gorodperm.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "content")
    private String content;

//    @ManyToOne(optional=false, cascade=CascadeType.ALL)
//    @JoinColumn(name="user_id")
//    private User author;

    @Column(name = "status")
    private Short status;

    @Column(name = "content_hash")
    private String contentHash;
}
