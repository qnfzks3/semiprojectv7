package qnfzks3.semiprojectv7.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;



@Setter
@Getter
public class Checkme {  //주민등록번호와 이름만 해서 유효성 검사를 위해 만든 모델
    //유효성 검사 1. 모델을 먼져 만들고 , 필수 사항 미작성 시 (오류 시) 내용을 적는다.
    //          2. html 가서 <span th:if="${#fields.hasErrors('jumin2')}" th:errors="*{jumin2}" class="text-danger"></span> 써줌
    //          3. 컨트롤러 가서  @GetMapping에  m.addAttribute("checkme",new Checkme());를 적어주면 위에 빨간줄 사라진다.
    //          4. 그 다음 @PostMapping 을 만들어주자
    //          5. js 로 가서 action= 의 주소를 다시 이전 페이지의 주소로 지정해준다.


    @NotBlank(message = "이름을 기입해 주세요")
    private String name;

    @NotBlank(message = "주민등록번호를 기입해 주세요")
    private String jumin1;

    @NotBlank(message = "주민등록번호를 기입해 주세요")
    private String jumin2;



}
