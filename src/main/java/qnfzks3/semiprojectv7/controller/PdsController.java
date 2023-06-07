package qnfzks3.semiprojectv7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import qnfzks3.semiprojectv7.model.PdsAttach;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import qnfzks3.semiprojectv7.model.Pds;
import qnfzks3.semiprojectv7.model.PdsReply;
import qnfzks3.semiprojectv7.service.PdsService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pds")
public class PdsController {

   @Autowired PdsService pdssrv;

    @GetMapping("/list")
    public ModelAndView list(Integer cpg) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pds/list");
        if (cpg == null || cpg == 0) cpg = 1;

        Map<String, Object> pds = pdssrv.readPds(cpg);

        // 게시글의 첨부파일 유형 읽어옴
        List<String> ftypes = pdssrv.readFtype();

        mv.addObject("pdslist", pds.get("pdslist"));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", pds.get("cntpg"));

        mv.addObject("ftypes", ftypes);

        return mv;
    }


    @GetMapping("/write")
    public String write(Model m){    //모델 m으로 받아와서 유효성 검사 가능하도록

        m.addAttribute("pds",new Pds());  //모델pds 타입으로 pds라는 이름생성   유효성위해서 - 이러면 html빨간줄 사라짐

        return "pds/write";
    }

    @PostMapping("/write")
    public String writeok(Pds pds , MultipartFile attach){   //모델 pds받아옴, MultipartFile로  attach 받아옴

        String viewPage = "error";

        Map<String, Object> pinfo = pdssrv.newPds(pds);

        if (!attach.isEmpty()) // 첨부파일이 존재한다면
            pdssrv.newPdsAttach(attach, pinfo);

        viewPage = "redirect:/pds/list";


        
        return viewPage;
    }
    @GetMapping("/view")
    public String view(int pno, Model m) {

        m.addAttribute("pds", pdssrv.readOnePds(pno));
        m.addAttribute("attach", pdssrv.readOnePdsAttach(pno));
        m.addAttribute("rplist", pdssrv.readPdsReply(pno));

        return "pds/view";
    }
    @GetMapping("/down")
    public ResponseEntity<Resource> down(int pno) {

        // 업로드 파일의 uuid와 파일명 알아냄
        String uuid = pdssrv.readOnePds(pno).getUuid();
        String fname = pdssrv.readOnePdsAttach(pno).getFname();

        // 알아낸 uuid와 파일명을 이용해서 header와 리소스 객체 생성
        HttpHeaders header = pdssrv.getHeader(fname, uuid);
        UrlResource resource = pdssrv.getResource(fname, uuid);

        // 다운로드 수 증가
        pdssrv.downfile(pno);

        return ResponseEntity.ok().headers(header).body(resource);
    }

    @PostMapping("/replyok")
    public String replyok(PdsReply reply) {
        String viewPage = "error";

        if (pdssrv.newReply(reply))
            viewPage = "redirect:/pds/view?pno=" + reply.getPno();

        return viewPage;
    }
    @PostMapping("/rreplyok")
    public String rreplyok(PdsReply reply) {
        String viewPage = "error";

        if (pdssrv.newRreply(reply))
            viewPage = "redirect:/pds/view?pno=" + reply.getPno();

        return viewPage;
    }


}
