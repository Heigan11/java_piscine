public class User {
    private Integer id;
    private String name;
    private Integer balance = 0;
    private TransactionsList transactionsList = new TransactionsLinkedList();;

    public User () {
        this.id = UserIdsGenerator.getInstance().generateId();
    }

    public User (String name, Integer balance){
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        if (balance > 0)
            this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}