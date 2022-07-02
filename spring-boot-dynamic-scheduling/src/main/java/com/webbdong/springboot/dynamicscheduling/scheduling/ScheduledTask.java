package com.webbdong.springboot.dynamicscheduling.scheduling;

import java.util.concurrent.ScheduledFuture;

/**
 * @author Webb Dong
 * @date 2022-01-11 8:00 PM
 */
public final class ScheduledTask {

    volatile ScheduledFuture<?> future;

    /**
     * 取消定时任务
     */
    public void cancel() {
        if (this.future != null) {
            this.future.cancel(true);
        }
    }

}
