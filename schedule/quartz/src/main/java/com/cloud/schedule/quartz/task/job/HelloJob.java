package com.cloud.schedule.quartz.task.job;

import org.quartz.*;

import java.time.LocalDateTime;

public class HelloJob implements Job {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("传入参数name" + name);
        System.out.println("传入参数age" + age);


        //打印当前的执行时间 例如 2017-11-23 00:00:00
        LocalDateTime date = LocalDateTime.now();
        System.out.println("现在的时间是：" + date);
        //具体的业务逻辑
        System.out.println("Hello Quartz");
    }
}
