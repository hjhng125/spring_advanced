package me.hjhng.tracelog.proxy.app.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping // 스프링 MVC는 @Controller 또는 @RequestMapping 어노테이션이 있어야 스프링 컨트롤러로 인식함
                   // 또한 스프링 컨트롤러로 인식되어야만 HTTP URL이 매핑된고 동작한다. 이 어노테이션은 interface에 사용해도 된다.
@ResponseBody
public interface OrderControllerV1 {

  @GetMapping("/v1/request")
  String request(@RequestParam("itemId") String itemId);

  @GetMapping("/v1/no-log")
  String noLog();
}
