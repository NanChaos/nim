package cn.nanchaos.nim.job.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Default Description
 *
 * @author: nanchaos
 * @date: 2022/1/19
 * @time: 16:22
 */
@Component
public class MyJob {

    @Scheduled(cron = "${nanchaos.dataCrypto.jobOne}")
    public void executeJobOne() {
        System.out.println("JOB ONE RUNNING ... " + System.currentTimeMillis());
    }

    @Scheduled(cron = "${nanchaos.dataCrypto.jobTwo}")
    public void executeJobTwo() {
        System.out.println("JOB TWO RUNNING ... " + System.currentTimeMillis());
    }
}
