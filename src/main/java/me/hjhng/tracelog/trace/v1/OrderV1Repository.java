package me.hjhng.tracelog.trace.v1;

import org.springframework.stereotype.Repository;

import me.hjhng.tracelog.trace.Trace;
import me.hjhng.tracelog.trace.TraceStatus;

@Repository
public class OrderV1Repository {

  private final Trace trace;

  public OrderV1Repository(Trace trace) {
    this.trace = trace;
  }

  public void save(String itemId) {
    TraceStatus status = null;
    try {
      status = trace.begin("OrderV1Repository.save");
      if (itemId.equals("ex")) {
        throw new IllegalStateException("예외 발생!");
      }
      sleep(1000);
      trace.end(status);
    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }
  }

  private void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
