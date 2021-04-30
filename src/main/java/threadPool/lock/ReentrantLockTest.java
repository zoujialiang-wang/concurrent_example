package threadPool.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version V1.0
 * @Package threadPool.LOCK
 * @auther ZouJiaLiang
 * @data 2021/4/21 下午7:06
 */
public class ReentrantLockTest {
    private static final ReentrantLock LOCK = new ReentrantLock();
    Condition condition = LOCK.newCondition();
    int value;

    public int get() {
        // 获取锁
        LOCK.lock();
        try {
            condition.awaitUninterruptibly();
            return value;
        } finally {
            // 保证锁能释放
            LOCK.unlock();
        }
    }

    public void addOne() {
        // 获取锁
        LOCK.lock();
        try {
            value = 1 + get();
        } finally {
            // 保证锁能释放
            LOCK.unlock();
        }
    }

    public static void main(String[] args) {
        synchronized (ReentrantLockTest.class){}
    }
}
