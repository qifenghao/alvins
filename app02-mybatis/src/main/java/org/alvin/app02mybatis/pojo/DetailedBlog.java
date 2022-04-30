package org.alvin.app02mybatis.pojo;

import java.util.List;

public class DetailedBlog {
    private Integer id;
    private String title;
    private Author author;
    private List<Post> posts;

    public DetailedBlog() {
    }

    public DetailedBlog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "DetailedBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", posts=" + posts +
                '}';
    }
}
