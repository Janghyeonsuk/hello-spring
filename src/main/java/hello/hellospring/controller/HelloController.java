package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //static
    @GetMapping("hello")
    public String hello(Model model) {
        Model data = model.addAttribute("data", "hello!!");
        return "hello";
    }

    //MVC
    //viewResolver 맞는 template 달라고 던짐
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    //API ResponseBody 문자 반환
    //HTML 태그가 넘어가는게 아니라 그냥 문자가 그대로 내려간다.
    //템플릿 엔진과 다른 점은 뷰라는 템플릿에서 조작하는 방식이고 이 방식은 데이터를 그대로 내려준다.
    @GetMapping("hello-string")
    @ResponseBody //response 메세지 바디에 직접 넣어준다
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //"hello spring"
    }

    //JSON 방식
    //API ResponseBody 객체 반환
    //객체 반환시에 기본 default 가 JSON 방식으로 데이터를 만들어서 HTTP 응답에 반환한다.
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
