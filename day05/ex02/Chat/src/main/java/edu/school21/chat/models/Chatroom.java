package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Long roomId;
    private String name;
    private User owner;
    private List<Message> chatroomMessageList;

    public Chatroom(Long roomId, String name, User owner, List<Message> chatroomMessageList) {
        this.roomId = roomId;
        this.name = name;
        this.owner = owner;
        this.chatroomMessageList = chatroomMessageList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chatroom)) return false;
        Chatroom chatRoom = (Chatroom) o;
        return getId().equals(chatRoom.getId()) && name.equals(chatRoom.name) && owner.equals(chatRoom.owner) && Objects.equals(getChatMessageList(), chatRoom.getChatMessageList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, owner, getChatMessageList());
    }

    public Long getId() {
        return roomId;
    }

    public void setId(Long roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Message> getChatMessageList() {
        return chatroomMessageList;
    }

    public void setChatMessageList(List<Message> chatroomMessageList) {
        this.chatroomMessageList = chatroomMessageList;
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "roomId=" + roomId +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", chatroomMessageList=" + chatroomMessageList +
                '}';
    }
}
