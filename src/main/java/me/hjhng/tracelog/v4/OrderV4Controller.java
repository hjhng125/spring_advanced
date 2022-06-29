package me.hjhng.tracelog.v4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.hjhng.tracelog.trace.LogTrace;
import me.hjhng.tracelog.trace.TraceStatus;
import me.hjhng.tracelog.trace.template.AbstractTemplate;

@RestController
public class OrderV4Controller {

  private final OrderV4Service service;

  private final LogTrace trace;

  public OrderV4Controller(OrderV4Service service, LogTrace trace) {
    this.service = service;
    this.trace = trace;
  }

  @GetMapping("/v4/request")
  public String request(String itemId) {
    AbstractTemplate<String> template = new AbstractTemplate<>(trace) {

      @Override
      protected String call() {
        service.orderItem(itemId);
        return "ok";
      }
    };
    return template.execute("OrderV4Controller.request");
  }
}
