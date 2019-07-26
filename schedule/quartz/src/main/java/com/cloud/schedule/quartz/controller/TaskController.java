package com.cloud.schedule.quartz.controller;

import com.cloud.schedule.quartz.task.schedule.HelloSchedule;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    @GetMapping("test")
    public void add() throws SchedulerException {
        new HelloSchedule().task();
    }
}
