package threadPool.lock;

/**
 * @version V1.0
 * @Package threadPool.lock
 * @auther ZouJiaLiang
 * @data 2021/4/26 下午6:34
 */

public class Account3 {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public Account3(int balance) {
        this.balance = balance;
    }

    void transfer(Account3 target, int amt) {
        synchronized (Account3.class) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }
}
