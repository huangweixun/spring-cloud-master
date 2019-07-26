package com.cloud.schedule.quartz.task.schedule;

import com.cloud.schedule.quartz.task.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class HelloSchedule {

    public void task() throws SchedulerException {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("name", "黄伟勋");
        jobDataMap.put("age", 23);

        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("helloJob", "group1")
                .usingJobData(jobDataMap)
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("helloTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler schedule = schedulerFactory.getScheduler();
        schedule.scheduleJob(jobDetail, trigger);
        schedule.start();
    }
}
