package edu.school21.sockets.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Message {
    private Long id;
    private User author;
    private String text;
    private LocalDateTime time;

    public Message(Long id, User author, String text, LocalDateTime time) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(getId(), message.getId()) && Objects.equals(getAuthor(), message.getAuthor()) && Objects.equals(getText(), message.getText()) && Objects.equals(getTime(), message.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthor(), getText(), getTime());
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", author=" + author +
                ", text='" + text + '\'' +
                ", time=" + time +
                '}';
    }
}
