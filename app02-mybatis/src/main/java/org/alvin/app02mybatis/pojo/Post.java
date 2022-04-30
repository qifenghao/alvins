package org.alvin.app02mybatis.pojo;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    private Integer id;
    private Integer blogId;
    private String section;
    private String subject;
    private Author author;
    private Integer draft;
    private LocalDateTime createdOn;
    private List<Comment> comments;
    private List<Tag> tags;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", blogId=" + blogId +
                ", section='" + section + '\'' +
                ", subject='" + subject + '\'' +
                ", author=" + author +
                ", draft=" + draft +
                ", createdOn=" + createdOn +
                ", comments=" + comments +
                ", tags=" + tags +
                '}';
    }
}
