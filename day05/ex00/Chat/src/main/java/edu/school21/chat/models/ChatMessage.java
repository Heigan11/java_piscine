package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ChatMessage {
    private int id;
    private ChatUser sender;
    private ChatRoom chatRoom;
    private String msg;
    private LocalDateTime date;

    public ChatMessage(int id, ChatUser sender, ChatRoom chatRoom, String msg, LocalDateTime date) {
        this.id = id;
        this.sender = sender;
        this.chatRoom = chatRoom;
        this.msg = msg;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMessage that = (ChatMessage) o;
        return id == that.id && sender.equals(that.sender) && chatRoom.equals(that.chatRoom) && msg.equals(that.msg) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, chatRoom, msg, date);
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", sender=" + sender +
                ", chatRoom=" + chatRoom +
                ", msg='" + msg + '\'' +
                ", date=" + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChatUser getSender() {
        return sender;
    }

    public void setSender(ChatUser sender) {
        this.sender = sender;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
