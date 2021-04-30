package threadPool.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version V1.0
 * @Package threadPool.lock
 * @auther ZouJiaLiang
 * @data 2021/4/26 下午6:42
 */

class Account4 {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public Account4(int balance) {
        this.balance = balance;
    }

    void transfer(Account4 target, int amt) {
        synchronized (this) {
            synchronized (target) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}
