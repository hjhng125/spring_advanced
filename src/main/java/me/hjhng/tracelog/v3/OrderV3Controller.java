package me.hjhng.tracelog.v3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.hjhng.tracelog.trace.LogTrace;
import me.hjhng.tracelog.trace.TraceStatus;
import me.hjhng.tracelog.trace.TraceV2;

@RestController
public class OrderV3Controller {

  private final OrderV3Service service;

  private final LogTrace trace;

  public OrderV3Controller(OrderV3Service service, LogTrace trace) {
    this.service = service;
    this.trace = trace;
  }

  @GetMapping("/v3/request")
  public String request(String itemId) {
    TraceStatus status = null;
    try {
      status = trace.begin("OrderV3Controller.request");
      service.orderItem(itemId);
      trace.end(status);
      return "ok";
    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }
  }
}
