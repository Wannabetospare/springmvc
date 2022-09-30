package hello.springmvc.basic.request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host")String host,
                          @CookieValue(value = "myCookie", required = false) String cookie
                          ) {

        log.info("request={}", request); // 요청
        log.info("response={}", response); // 응답
        log.info("httpMethod={}", httpMethod); // 어떤 메서드인지
        log.info("locale={}", locale); // 언어 나라
        log.info("headerMap={}", headerMap); // 모든 HTTP 헤더를 MultiValueMap 형식으로 조회한다.
        log.info("header host={}", host); // 특정 HTTP 헤더를 조회한다 - 호스트 주소
        log.info("myCookie={}", cookie); // 특정 쿠키를 조회한다.

        return "ok";
    }

}