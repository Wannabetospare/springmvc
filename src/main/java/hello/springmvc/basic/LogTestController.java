package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Slf4j // 로그 전용 어노테이션 - 롬복
@RestController // 반환 값으로 뷰를 찾는 것이 아니라, HTTP 메시지 바디에 바로 입력한다.
public class LogTestController {

    // private final Logger logger = LoggerFactory.getLogger(getClass()); -> @Slf4j 가 있으면 없어도 됨

    @RequestMapping("/log-test") // 매핑 주소
    public String logTest(){

        String name = "Spring";


        // log 는 순서대로 우선순위가 있다.
        // LEVEL: TRACE > DEBUG > INFO > WARN > ERROR
        // 로그를 사용할 때는 연산을 사용하지 않아야 한다.
        // 연산이 로그에 있다면 로그를 띄우기 전에 연산을 먼저하는데, 이때 메모리도 발생하고 여러가지 단점이 있다.

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);


        //로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 X
        log.debug("String concat log=" + name);

        // 결과를 String 으로 반환한다.
        return "ok";

    }
}


/*

    스프링 부트 라이브러리를 사용하면 스프링 부트 로깅 라이브러리( spring-boot-starter-logging )가 함께 포함된다.
    쉽게 이야기해서 SLF4J는 인터페이스이고, 그 구현체로 Logback 같은 로그 라이브러리를 선택하면 된다.
    실무에서는 스프링 부트가 기본으로 제공하는 Logback을 대부분 사용한다.


*/
