package me.hjhng.tracelog.v4;

import org.springframework.stereotype.Repository;

import me.hjhng.tracelog.trace.LogTrace;
import me.hjhng.tracelog.trace.TraceStatus;
import me.hjhng.tracelog.trace.template.AbstractTemplate;

@Repository
public class OrderV4Repository {

  private final LogTrace trace;

  public OrderV4Repository(LogTrace trace) {
    this.trace = trace;
  }

  public void save(String itemId) {
    AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
      @Override
      protected Void call() {
        if (itemId.equals("ex")) {
          throw new IllegalStateException("예외 발생!");
        }
        sleep(1000);
        return null;
      }
    };
    template.execute("OrderV4Repository.save");

  }

  private void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
