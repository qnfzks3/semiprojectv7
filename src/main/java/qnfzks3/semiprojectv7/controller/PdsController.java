package qnfzks3.semiprojectv7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import qnfzks3.semiprojectv7.model.Pds;
import qnfzks3.semiprojectv7.service.PdsService;

@Controller
@RequestMapping("/pds")
public class PdsController {

   @Autowired PdsService pdssrv;

    @GetMapping("/list")
    public String list() {
        return "pds/list";
    }

    @GetMapping("/write")
    public String write(Model m){    //모델 m으로 받아와서 유효성 검사 가능하도록

        m.addAttribute("pds",new Pds());  //모델pds 타입으로 pds라는 이름생성   유효성위해서 - 이러면 html빨간줄 사라짐

        return "pds/write";
    }

    @PostMapping("/write")
    public String writeok(Pds pds , MultipartFile attach){   //모델 pds받아옴, MultipartFile로  attach 받아옴

        String viewPage = "error";

        int pno=pdssrv.newPds(pds); //service 가져오기 -> pds 모델로 가서 @Autowired 적어주고 만든다.

        if (pdssrv.newPdsAttach(attach,pno))
            viewPage = "redirect:/pds/list";


        
        return viewPage;
    }



}
