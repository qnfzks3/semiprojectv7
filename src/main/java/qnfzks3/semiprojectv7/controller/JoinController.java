package qnfzks3.semiprojectv7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import qnfzks3.semiprojectv7.model.Board;
import qnfzks3.semiprojectv7.model.Checkme;
import qnfzks3.semiprojectv7.model.Member;
import qnfzks3.semiprojectv7.service.JoinService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/join")
public class JoinController {

    @Autowired private JoinService jnsrv;

    @GetMapping("/agree")
    public String agree() {
         return "join/agree";
     }

     
     
    @GetMapping("/checkme")    //가져와서
    public String checkme(Model m) {
        m.addAttribute("checkme",new Checkme());  //html object로 적은 checkme 는 여기서 가져온것

        return "join/checkme";
    }


    @PostMapping("/checkme")                //유효성 검사를 위해 만들어줌
    public String checkmeok(@Valid Checkme checkme, BindingResult br, HttpSession sess) {
                        //BindingResult 오류 내용 변수에 담아주는 함수
                        // @Valid는 가져온 Checkme checkme를 오류인지 검사하겟다.
                        // HttpSession sess 세션을 사용한거다.

        //checkme에서 작성한 이름 주민번호를 joinme에 보내는 방법
        //session으로 보낸다.
        // c(get) ->      c (post)    ->       joinme           즉 어떤 페이지던 세션으로 담아서 보낸다.
        //       form으로 보내면     session으로 담아서 보냄

        String viewPage= "redirect:/join/joinme"; //오류 없이 정상적으로 간다면 이쪽 주소로 이동

        if(br.hasErrors()) //오류라면(스페이스나 빈 공간으로 확인 버튼 누른다면)
            viewPage = "join/checkme"; // 이쪽 주소로 이동
        else
            sess.setAttribute("ckm",checkme); //checkme를 ckm 라는 이름으로 세션sess에 담아는다.
        

        return viewPage;
    }






    @PostMapping("/joinme")
    public ModelAndView joinme(Member mb) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("join/joinme");
        mv.addObject("mb", mb);

        return mv;
    }

    @PostMapping("/joinok")
    public String joinok(Member m, String grecaptcha) {
        String view = "error";

        if (jnsrv.newMember(m))
            view = "join/joinok";

        return view;
    }

    // 우편번호 검색
    // /join/zipcode?dong=동이름
    // 검색결과는 뷰페이지 없이 바로 응답으로 출력 : RESTful 방식
    // 서블릿에서 제공하는 HttpServletResponse 객체를 이용하면
    // 스프링의 뷰리졸버 없이 바로 응답으로 출력할 수 있음
    // 단, 응답유형은 JSON 형식으로 함
    @ResponseBody
    @GetMapping("/zipcode")
    public void zipcode(String dong, HttpServletResponse res) {
        try {
            // 응답유형은 JSON으로 설정
            res.setContentType("application/json; charset=utf-8");
            // 검색된 우편번호 결과를 뷰없이 바로 응답으로 출력
            res.getWriter().print( jnsrv.findZipcode(dong) );
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // 아이디 사용가능여부 검사
    // /join/checkuid?uid=아이디
    // 사용가능   : 0
    // 사용불가능 : 1
    @ResponseBody
    @GetMapping("/checkuid")
    public void checkuid(String uid, HttpServletResponse res) {
        try {
            // 아이디 사용여부를 뷰없이 바로 응답으로 출력
            res.getWriter().print( jnsrv.checkUserid(uid) );
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
