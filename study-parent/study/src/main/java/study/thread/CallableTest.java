package study.thread;

import java.util.concurrent.Callable;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/3/25 16:12
 */
public class CallableTest implements Callable<Integer> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(;i<100;i++)
        {

        }
        return i;
    }
}
