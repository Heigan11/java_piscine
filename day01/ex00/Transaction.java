import java.util.UUID;

public class Transaction {
    private UUID identifier;
    private User recipient;
    private User sender;
    private Category category;
    private Integer amount;

    enum Category
    {
        DEBITS,
        CREDITS
    }

    public Transaction(User sender, User recipient, Category category, Integer amount){
        this.recipient = recipient;
        this.sender = sender;
        this.category = category;
        setAmount(amount);
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        if (this.category == Category.DEBITS && amount >= 0  && sender.getBalance() >= amount)
            this.amount = amount;
        else if (this.category == Category.CREDITS && amount <= 0 && recipient.getBalance() >= amount * (-1))
            this.amount = amount;
        else
            System.out.println("Wrong transaction");
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public String getRecipient() {
        return this.recipient.getName();
    }

    public String getSender() {
        return this.sender.getName();
    }

    public Category getCategory(){
        return this.category;
    }

    public UUID getIdentifier() {
        return identifier;
    }
}