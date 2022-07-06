public interface UsersList {
    public void addUser(User user);
    public User getById(int id) throws Exception;
    public User getByIndex(int index) throws Exception;
    public int getSize();
}