package me.hjhng.tracelog.v3;

import org.springframework.stereotype.Repository;

import me.hjhng.tracelog.trace.LogTrace;
import me.hjhng.tracelog.trace.TraceId;
import me.hjhng.tracelog.trace.TraceStatus;
import me.hjhng.tracelog.trace.TraceV2;

@Repository
public class OrderV3Repository {

  private final LogTrace trace;

  public OrderV3Repository(LogTrace trace) {
    this.trace = trace;
  }

  public void save(String itemId) {
    TraceStatus status = null;
    try {
      status = trace.begin("OrderV3Repository.save");
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
