package info.babin.gorodperm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.StringTokenizer;

@Entity
@Data
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private long id;

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

    /**
     * Calculate the reading time
     * @return minutes
     */
    public int readingTime() {
        int totalWords = totalWords(content);
        // Dividing by average words per minute reading speed
        return totalWords / 220;
    }

    private int totalWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) { return 0; }
        StringTokenizer tokens = new StringTokenizer(sentence);
        return tokens.countTokens();
    }
}
