package me.hjhng.tracelog.v2;

import org.springframework.stereotype.Repository;

import me.hjhng.tracelog.trace.Trace;
import me.hjhng.tracelog.trace.TraceId;
import me.hjhng.tracelog.trace.TraceStatus;
import me.hjhng.tracelog.trace.TraceV2;

@Repository
public class OrderV2Repository {

  private final TraceV2 trace;

  public OrderV2Repository(TraceV2 trace) {
    this.trace = trace;
  }

  public void save(TraceId traceId, String itemId) {
    TraceStatus status = null;
    try {
      status = trace.beginSync(traceId, "OrderV2Repository.save");
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
