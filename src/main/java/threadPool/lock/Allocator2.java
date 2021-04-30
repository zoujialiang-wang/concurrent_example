package threadPool.lock;

import java.util.List;

/**
 * @version V1.0
 * @Package threadPool.lock
 * @auther ZouJiaLiang
 * @data 2021/4/26 下午6:36
 */

public class Allocator2 {
    private List<Object> als;

    // 一次性申请所有资源
    synchronized void apply(
            Object from, Object to) {
        // 经典写法
        while (als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        als.add(from);
        als.add(to);
    }

    // 归还资源
    synchronized void free(
            Object from, Object to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }
}
class Account6 {
    // actr应该为单例
    private Allocator actr;
    private int balance;

    // 转账
    void transfer(Account6 target, int amt) {
        // 一次性申请转出账户和转入账户，直到成功
        while (!actr.apply(this, target)) {
        }
        try {
            // 锁定转出账户
            synchronized (this) {
                // 锁定转入账户
                synchronized (target) {
                    if (this.balance > amt) {
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        } finally {
            actr.free(this, target);
        }
    }
}
