package com.common.scheduler.job;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Job1
 * @Description 定时任务1
 * @Author acer
 * @Date 2019/7/27 13:49
 * @Version 1.0
 **/
@Component("job1")
public class Job1 {

    public void start() throws InterruptedException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(new Date());
        Thread.sleep(2000);
/*
        System.out.println(format1 + "----" + this + "++++++++++++++++++");
*/
    }

}
