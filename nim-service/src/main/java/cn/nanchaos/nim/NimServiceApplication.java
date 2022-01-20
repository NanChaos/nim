package cn.nanchaos.nim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Default Description
 *
 * @author: nanchaos
 * @date: 2022/1/13
 * @time: 17:49
 */
@SpringBootApplication
public class NimServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NimServiceApplication.class, args);
    }
}
