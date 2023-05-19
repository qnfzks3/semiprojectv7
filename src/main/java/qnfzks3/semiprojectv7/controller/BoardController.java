package qnfzks3.semiprojectv7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import qnfzks3.semiprojectv7.model.Board;
import qnfzks3.semiprojectv7.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired private BoardService bdsrv;

    @GetMapping("/list")
    public ModelAndView list(int cpg) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("board/list");

        mv.addObject("bdlist", bdsrv.readBoard(cpg));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", bdsrv.countBoard());

        return mv;
    }

    @GetMapping("/find") // 검색 처리
    public ModelAndView find(int cpg, String ftype, String fkey) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("bdlist", bdsrv.readBoard(cpg, ftype, fkey));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", bdsrv.countBoard(ftype, fkey));
        mv.setViewName("board/list");
        return mv;
    }



    @GetMapping("/write")
    public String write(){
        return "board/write";
    }

    @PostMapping("/write")
    public String writeok(Board bd){   //이름이 같으면 오류남
        String viewPage ="error";   //error페이지
        if(bdsrv.newBoard(bd)){   //만약 Service에 newBoard(bd)가
            viewPage="redirect:/board/list?cpg=1";
        }

        return viewPage;
    }


    


    @GetMapping("/view")
    public ModelAndView view(int bno){  //주소창에 bno를 넘겨 받아서 bno를 토대로 게시글을 가져오자
        ModelAndView mv= new ModelAndView();
        mv.addObject("bd",bdsrv.readOneBoard(bno));  //프론트쪽으로 보냄 - 보낼 때 데이터를 bd로 가내겠다.
        mv.setViewName("board/view");

        return mv;
    }


}