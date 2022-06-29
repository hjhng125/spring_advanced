package me.hjhng.tracelog.trace.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.hjhng.tracelog.trace.Trace;
import me.hjhng.tracelog.trace.TraceStatus;

@RestController
public class OrderV1Controller {

  private final OrderV1Service service;

  private final Trace trace;

  public OrderV1Controller(OrderV1Service service, Trace trace) {
    this.service = service;
    this.trace = trace;
  }

  @GetMapping("/v1/request")
  public String request(String itemId) {
    TraceStatus status = null;
    try {
      status = trace.begin("OrderV1Controller.request");
      service.orderItem(itemId);
      trace.end(status);
      return "ok";
    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }
  }
}
