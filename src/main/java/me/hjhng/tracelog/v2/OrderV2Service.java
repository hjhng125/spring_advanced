package me.hjhng.tracelog.v2;

import org.springframework.stereotype.Service;

import me.hjhng.tracelog.trace.Trace;
import me.hjhng.tracelog.trace.TraceId;
import me.hjhng.tracelog.trace.TraceStatus;
import me.hjhng.tracelog.trace.TraceV2;

@Service
public class OrderV2Service {

  private final OrderV2Repository repository;

  private final TraceV2 trace;

  public OrderV2Service(OrderV2Repository repository, TraceV2 trace) {
    this.repository = repository;
    this.trace = trace;
  }

  public void orderItem(TraceId traceId, String itemId) {
    TraceStatus status = null;
    try {
      status = trace.beginSync(traceId, "OrderV2Service.orderItem");
      repository.save(status.traceId(), itemId);
      trace.end(status);
    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }
  }
}
