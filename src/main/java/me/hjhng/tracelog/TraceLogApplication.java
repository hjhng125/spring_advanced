package me.hjhng.tracelog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import me.hjhng.tracelog.proxy.config.AppV1Configuration;
import me.hjhng.tracelog.proxy.config.AppV2Configuration;

@Import({AppV1Configuration.class, AppV2Configuration.class})
@SpringBootApplication(scanBasePackages = "me.hjhng.tracelog.proxy.app")
public class TraceLogApplication {

  public static void main(String[] args) {
    SpringApplication.run(TraceLogApplication.class, args);
  }

}
