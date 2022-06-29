package me.hjhng.tracelog.trace.thread.local.code;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import me.hjhng.tracelog.trace.thread.local.code.ThreadLocalService;

@Slf4j
public class ThreadLocalServiceTest {

  ThreadLocalService service = new ThreadLocalService();

  @Test
  void field() {
    log.info("main start");
    Runnable userA = () -> {
      service.logic("userA");
    };

    Runnable userB = () -> {
      service.logic("userB");
    };

    Runnable userC = () -> {
      service.logic("userC");
    };

    Thread threadA = new Thread(userA);
    threadA.setName("A-");
    Thread threadB = new Thread(userB);
    threadB.setName("B-");
    Thread threadC = new Thread(userC);
    threadC.setName("C-");

    threadA.start();
    sleep(2000);
    threadB.start();
    sleep(2000);
    threadC.start();
    sleep(3000);
    log.info("Main Exit");
  }

  private void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
