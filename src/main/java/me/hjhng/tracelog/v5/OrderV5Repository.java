package me.hjhng.tracelog.v5;

import org.springframework.stereotype.Repository;

import me.hjhng.tracelog.trace.LogTrace;
import me.hjhng.tracelog.trace.callback.TraceTemplate;
import me.hjhng.tracelog.trace.template.AbstractTemplate;

@Repository
public class OrderV5Repository {

  private final TraceTemplate template;

  public OrderV5Repository(LogTrace trace) {
    this.template = new TraceTemplate(trace);
  }

  public void save(String itemId) {
    template.execute("OrderV5Repository.save", () -> {
      if (itemId.equals("ex")) {
        throw new IllegalStateException("예외 발생!");
      }
      sleep(1000);
      return null;
    });
  }

  private void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
