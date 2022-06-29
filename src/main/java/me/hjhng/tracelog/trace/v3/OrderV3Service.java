package me.hjhng.tracelog.trace.v3;

import org.springframework.stereotype.Service;

import me.hjhng.tracelog.trace.LogTrace;
import me.hjhng.tracelog.trace.TraceStatus;

@Service
public class OrderV3Service {

  private final OrderV3Repository repository;

  private final LogTrace trace;

  public OrderV3Service(OrderV3Repository repository, LogTrace trace) {
    this.repository = repository;
    this.trace = trace;
  }

  public void orderItem(String itemId) {
    TraceStatus status = null;
    try {
      status = trace.begin("OrderV3Service.orderItem");
      repository.save(itemId);
      trace.end(status);
    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }
  }
}
