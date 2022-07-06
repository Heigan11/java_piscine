public class UsersArrayList implements UsersList{
    private User[] user_arr;
    private int index;

    public UsersArrayList (){
        this.user_arr = new User[10];
        index = -1;
    }

    public void addUser(User user) {
        this.index++;
        if (this.index >= this.user_arr.length)
            newArrCreate(this.user_arr);
        this.user_arr[index] = user;
    }

    public int getSize() {
        return this.index + 1;
    }

    public User getById(int id) throws UserNotFoundException {
        int i = 0;

        while (i < this.index) {
            if (this.user_arr[i].getId() == id)
                return this.user_arr[i];
            i++;
        }
        throw new UserNotFoundException("No such Id");
    }

    public User getByIndex(int index) throws UserNotFoundException{
        if (index < 0 || index > this.index)
            throw new UserNotFoundException("No such Index");
        return this.user_arr[index];
    }

    public void newArrCreate(User[] old_array){
        int i = 0;
        int size = this.user_arr.length;
        User[] new_array = new User[size + size / 2];
        while (i < size) {
            new_array[i] = old_array[i];
            i++;
        }
        this.user_arr = new_array;
    }

    public int arraySize(){
        return this.user_arr.length;
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String msg){
        super(msg);
    }
}