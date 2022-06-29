package me.hjhng.tracelog.trace.thread.local.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {

  private String nameStore;

  public String logic(String name) {
    log.info("Save name={} -> nameStore={}" , name, nameStore);
    nameStore = name;
    this.sleep();
    log.info("Select nameStore={}", nameStore);
    return nameStore;
  }

  private void sleep() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
