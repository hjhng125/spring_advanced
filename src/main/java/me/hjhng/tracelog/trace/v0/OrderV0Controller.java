package me.hjhng.tracelog.trace.v0;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderV0Controller {

  private final OrderV0Service service;

  public OrderV0Controller(OrderV0Service service) {
    this.service = service;
  }

  @GetMapping("/v0/request")
  public String request(String itemId) {
    service.orderItem(itemId);
    return "ok";
  }
}
