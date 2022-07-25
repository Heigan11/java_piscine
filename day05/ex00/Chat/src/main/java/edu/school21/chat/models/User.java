package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private Long id;
    private String login;
    private String password;
    private List<Chatroom> listOfCreatedRooms;
    private List<Chatroom> activeChatroomList;

    public User(Long id, String login, String password, List<Chatroom> listOfCreatedRooms, List<Chatroom> activeChatroomList) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.listOfCreatedRooms = listOfCreatedRooms;
        this.activeChatroomList = activeChatroomList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) && login.equals(user.login) && password.equals(user.password) && Objects.equals(getCreatedChatRoomList(), user.getCreatedChatRoomList()) && Objects.equals(getActiveChatRoomList(), user.getActiveChatRoomList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), login, password, getCreatedChatRoomList(), getActiveChatRoomList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getCreatedChatRoomList() {
        return listOfCreatedRooms;
    }

    public void setCreatedChatRoomList(List<Chatroom> listOfCreatedRooms) {
        this.listOfCreatedRooms = listOfCreatedRooms;
    }

    public List<Chatroom> getActiveChatRoomList() {
        return activeChatroomList;
    }

    public void setActiveChatRoomList(List<Chatroom> activeChatroomList) {
        this.activeChatroomList = activeChatroomList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", listOfCreatedRooms=" + listOfCreatedRooms +
                ", activeChatroomList=" + activeChatroomList +
                '}';
    }
}
