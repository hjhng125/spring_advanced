package me.hjhng.tracelog.trace.thread.local.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

  private final ThreadLocal<String> nameStore = new ThreadLocal<>();

  public String logic(String name) {
    log.info("Save name={} -> nameStore={}" , name, nameStore.get());
    nameStore.set(name);
    this.sleep();
    log.info("Select nameStore={}", nameStore.get());
    return nameStore.get();
  }

  private void sleep() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
