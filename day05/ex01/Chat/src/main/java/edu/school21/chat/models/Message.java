package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Message {
    private Long messageId;
    private User messageAuthor;
    private Chatroom messageRoom;
    private String messageText;
    private LocalDateTime messageTime;

    public Message(Long messageId, User messageAuthor, Chatroom messageRoom, String messageText, LocalDateTime messageTime) {
        this.messageId = messageId;
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
        return Objects.equals(messageId, that.messageId) && messageAuthor.equals(that.messageAuthor) && messageRoom.equals(that.messageRoom) && messageText.equals(that.messageText) && messageTime.equals(that.messageTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, messageAuthor, messageRoom, messageText, messageTime);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", messageAuthor=" + messageAuthor.toString() +
                ", messageRoom=" + messageRoom.toString() +
                ", messageText='" + messageText + '\'' +
                ", messageTime=" + messageTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
                '}';
    }

    public Long getId() {
        return messageId;
    }

    public void setId(Long messageId) {
        this.messageId = messageId;
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
