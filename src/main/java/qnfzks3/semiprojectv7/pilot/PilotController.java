package qnfzks3.semiprojectv7.pilot;


import org.apache.tomcat.util.buf.UriUtil;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;


import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/pilot")
public class PilotController {

    @GetMapping("/write")
    public String write(){
        return "pilot/write";
    }



    @PostMapping("/write") //전송된 데이터 처리
    public String writeok(String title, String content, Model m , MultipartFile attach) throws IOException {
        
        //알반 폼 요소 처리
        m.addAttribute("title",title);
        m.addAttribute("content",content);


        //멀티파트 폼 요소 처리

        if (attach.isEmpty())
            m.addAttribute("attach","첨부파일이 없어요!!");

        else {
            String fname = attach.getOriginalFilename();

            //업로드한 파일 이름 알아내기  attach.getOriginalFilename - 파일이름
            m.addAttribute("filename",attach.getOriginalFilename());
            //업로드한 파일 종류 알아내기
            m.addAttribute("filetype",attach.getContentType());
            
            //업로드한 파일 크기 알아내기
            m.addAttribute("filesize",attach.getSize()/1024);

            //겹치지 않는 파일명 작성을 위해 유니크한 값 생성1 - 파일명이 동일할 때 이름이 동일해져버리면 안되서 이름앞에 식별 번호 기입
            //파일이름 + uuid + 확장자
            //abc.jpg - > abcfd2d8f21.jpg
            String uuid = UUID.randomUUID().toString().replace("-",""); //uuid에서 '-'제거
            m.addAttribute("uuid",uuid);

            //파일 이름과 확장자 분리하기 -
            String fileName = fname.split("[.]")[0];
            String fileExt=fname.split("[.]")[1];

/*

            //겹치지 않는 파일명 작성을 위해 유니크한 값 생성2
            String fmt ="yyyyMMddHHmmss";  //연 월 일 시분초
            SimpleDateFormat sdf = new SimpleDateFormat(fmt);
            uuid = sdf.format(new Date());   
*/

            //겹치지 않는 파일명 작성을 위해 유니크한 값 생성2
            uuid = LocalDate.now() + ""+ LocalTime.now();
            uuid.replace("-","").replace("[:]","").replace("[.]","");
            m.addAttribute("uuid",uuid);



            //업로드한 파일 저장하기
            attach.transferTo(new File("C:/Java/bootUpload/"+fileName+uuid+attach.getOriginalFilename() ));
            
            
        }

        return "pilot/list";
    }




    @GetMapping("/list")
    public String list(){
        return "pilot/list";
    }

    @GetMapping("/down")
    public ResponseEntity<Resource> down(int pno) throws IOException {    //내려받을 파일<Resource>

        String savePath= "C:/Java/bootUpload/";  //세이브 포인트 지정
        String fname = "";

        if (pno ==1) fname = "dog.jpg";
        else if (pno ==2) {fname ="write.html";}
        else if (pno ==3) {fname ="newOne.zip";}
        else if (pno ==4) {fname="운동.jpg";}

        //파일 이름에 한글이 포함된 경우 적절한 인코딩 작업 수행
        fname  = UriUtils.encode(fname, StandardCharsets.UTF_8);  //import할때 참고하자 - UriUtils spring에 있는 함수

        // 다운로드할 파일 객체 생성    ,  UrlResource은 예외를 메서드 시그니처에 추가
        UrlResource resource = new UrlResource("file:"+(savePath+fname));


        //MIMEE 타입 지정
        //브라우저에 다운로드할 파일에 대한 정보 제공

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", Files.probeContentType(Paths.get(savePath+fname)));

        header.add("Content-Disposition","attachment; filename="+fname+"");

        //브라우저로 파일 전송하기
        return ResponseEntity.ok().headers(header).body(resource);


    }


    @GetMapping("/showimg")
    @ResponseBody     //view 없이 본문 내용 출력
    public Resource showimg() throws MalformedURLException {
        String fname = "C:/Java/bootUpload/"+"dog.jpg";

        return new UrlResource("file:"+ fname);
    }


}
