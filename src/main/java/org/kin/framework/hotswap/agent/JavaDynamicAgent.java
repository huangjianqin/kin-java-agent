package org.kin.framework.hotswap.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author huangjianqin
 * @date 2018/2/3
 */
public class JavaDynamicAgent {
    /** {@link Instrumentation}实例 */
    private static Instrumentation instrumentation;
    /** 充当锁的单例 */
    private static final Object LOCK = new Object();

    /**
     * 方法必须叫agentmain
     */
    public static void agentmain(String args, Instrumentation inst) {
        synchronized (LOCK) {
            if (instrumentation == null) {
                instrumentation = inst;
            }
        }
    }

    /**
     * 获取{@link Instrumentation}实例
     */
    public static Instrumentation getInstrumentation() {
        return instrumentation;
    }

    /**
     * 获取实例size
     */
    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }
}
