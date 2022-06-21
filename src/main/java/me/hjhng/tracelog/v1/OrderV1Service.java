package me.hjhng.tracelog.v1;

import org.springframework.stereotype.Service;

import me.hjhng.tracelog.trace.Trace;
import me.hjhng.tracelog.trace.TraceStatus;

@Service
public class OrderV1Service {

  private final OrderV1Repository repository;

  private final Trace trace;

  public OrderV1Service(OrderV1Repository repository, Trace trace) {
    this.repository = repository;
    this.trace = trace;
  }

  public void orderItem(String itemId) {
    TraceStatus status = null;
    try {
      status = trace.begin("OrderV1Service.orderItem");
      repository.save(itemId);
      trace.end(status);
    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }
  }
}
