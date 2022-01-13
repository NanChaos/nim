package cn.nanchaos.nim;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Default Description
 *
 * @author: nanchaos
 * @date: 2022/1/13
 * @time: 17:49
 */
@MapperScan("cn.nanchaos.nim")
@SpringBootApplication
public class NimServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NimServiceApplication.class, args);
    }
}
