package me.hjhng.tracelog.proxy.app.v3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping
@RestController
public class OrderControllerV3 {

  private final OrderServiceV3 service;

  public OrderControllerV3(OrderServiceV3 service) {
    this.service = service;
  }

  @GetMapping("/v3/request")
  public String request(String itemId) {
    service.orderItem(itemId);
    return "ok";
  }

  @GetMapping("/v3/no-log")
  public String noLog() {
    return "ok";
  }
}
