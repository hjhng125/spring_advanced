package me.hjhng.tracelog.trace.v5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.hjhng.tracelog.trace.LogTrace;
import me.hjhng.tracelog.trace.callback.TraceTemplate;

@RestController
public class OrderV5Controller {

  private final OrderV5Service service;

  private final TraceTemplate template;

  public OrderV5Controller(OrderV5Service service, LogTrace trace) {
    this.service = service;
    this.template = new TraceTemplate(trace);
  }

  @GetMapping("/v5/request")
  public String request(String itemId) {
    return template.execute("OrderV5Controller.request", () -> {
      service.orderItem(itemId);
      return "ok";
    });
  }
}
