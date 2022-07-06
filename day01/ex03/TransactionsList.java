import java.util.UUID;

public interface TransactionsList {
    public void addTransaction(Transaction transaction);
    public void deleteById(UUID id) throws TransactionNotFoundException;
    public Transaction[] toArray();
}