package threadPool.lock;

/**
 * @version V1.0
 * @Package threadPool.lock
 * @auther ZouJiaLiang
 * @data 2021/4/23 下午6:40
 */
public class Account2 {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public Account2(int balance) {
        this.balance = balance;
    }

    public synchronized void transfer(Account2 target, int amt) {
        if (this.balance >= amt) {
            this.balance -= amt;
            target.balance += amt;
        }
    }
}
