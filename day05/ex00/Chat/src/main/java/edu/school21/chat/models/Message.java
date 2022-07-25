package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Message {
    private Long id;
    private User messageAuthor;
    private Chatroom messageRoom;
    private String messageText;
    private LocalDateTime messageTime;

    public Message(Long id, User messageAuthor, Chatroom messageRoom, String messageText, LocalDateTime messageTime) {
        this.id = id;
        this.messageAuthor = messageAuthor;
        this.messageRoom = messageRoom;
        this.messageText = messageText;
        this.messageTime = messageTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message that = (Message) o;
        return Objects.equals(id, that.id) && messageAuthor.equals(that.messageAuthor) && messageRoom.equals(that.messageRoom) && messageText.equals(that.messageText) && messageTime.equals(that.messageTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, messageAuthor, messageRoom, messageText, messageTime);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", messageAuthor=" + messageAuthor +
                ", messageRoom=" + messageRoom +
                ", messageText='" + messageText + '\'' +
                ", messageTime=" + messageTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return messageAuthor;
    }

    public void setSender(User messageAuthor) {
        this.messageAuthor = messageAuthor;
    }

    public Chatroom getRoom() {
        return messageRoom;
    }

    public void setRoom(Chatroom messageRoom) {
        this.messageRoom = messageRoom;
    }

    public String getData() {
        return messageText;
    }

    public void setData(String messageText) {
        this.messageText = messageText;
    }

    public LocalDateTime getTime() {
        return messageTime;
    }

    public void setTime(LocalDateTime messageTime) {
        this.messageTime = messageTime;
    }
}
