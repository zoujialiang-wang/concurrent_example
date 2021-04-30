package threadPool.lock;

/**
 * @version V1.0
 * @Package threadPool.lock
 * @auther ZouJiaLiang
 * @data 2021/4/30 上午8:42
 */
public class Account {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public Account(int balance) {
        this.balance = balance;
    }

    public void transfer(Account target, int amt) {
        if (this.balance >= amt) {
            this.balance -= amt;
            target.balance += amt;
        }
    }

}
