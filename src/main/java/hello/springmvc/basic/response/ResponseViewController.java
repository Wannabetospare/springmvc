package hello.springmvc.basic.response;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 반환값이 곧 주소
public class ResponseViewController {

    @RequestMapping("response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello").addObject("data", "hello1");

        return mav;
    }

    @RequestMapping("response-view-v2")
    public String responseViewV2(Model model) {

        model.addAttribute("data", "hello2");

        return "response/hello";
    }

    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {

        model.addAttribute("data", "hello3");
    }


}
