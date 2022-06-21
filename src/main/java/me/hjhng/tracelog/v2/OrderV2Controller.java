package me.hjhng.tracelog.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.hjhng.tracelog.trace.Trace;
import me.hjhng.tracelog.trace.TraceStatus;
import me.hjhng.tracelog.trace.TraceV2;

@RestController
public class OrderV2Controller {

  private final OrderV2Service service;

  private final TraceV2 trace;

  public OrderV2Controller(OrderV2Service service, TraceV2 trace) {
    this.service = service;
    this.trace = trace;
  }

  @GetMapping("/v2/request")
  public String request(String itemId) {
    TraceStatus status = null;
    try {
      status = trace.begin("OrderV2Controller.request");
      service.orderItem(status.traceId(), itemId);
      trace.end(status);
      return "ok";
    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }
  }
}
