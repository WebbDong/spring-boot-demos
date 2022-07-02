package com.webbdong.springboot.dynamicscheduling;

import com.webbdong.springboot.dynamicscheduling.scheduling.CronTaskRegistrar;
import com.webbdong.springboot.dynamicscheduling.scheduling.SchedulingRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Webb Dong
 * @date 2022-01-11 7:55 PM
 */
@SpringBootApplication
public class DynamicSchedulingApplication implements CommandLineRunner {

    @Autowired
    private CronTaskRegistrar cronTaskRegistrar;

    public static void main(String[] args) {
        SpringApplication.run(DynamicSchedulingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SchedulingRunnable task = new SchedulingRunnable("com.webbdong.springboot.dynamicscheduling.task.DemoTask", "taskNoParams");
        cronTaskRegistrar.addCronTask(task, "*/2 * * * * ?");

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("removeCronTaskTimerTask");
                cronTaskRegistrar.removeCronTask(task);
            }
        }, 15000);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("addCronTaskTimerTask");
                cronTaskRegistrar.addCronTask(task, "*/5 * * * * ?");
            }
        }, 20000);
    }

}
