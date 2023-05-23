package qnfzks3.semiprojectv7.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name="BOARD")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor//date - 롬북의 date  -셋겟 생성자
public class Board {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터베이스의 자동 증가 컬럼
    private Long bno;

    @NotBlank(message = "제목은 필수 입력 항목입니다.!!") //문자열길이 0 체크 , 공백 문자열 체크 - 스페이스 같은 거 방지
    private String title;

    @NotBlank(message = "작성자는 필수 입력 항목입니다.!!")
    private String userid;

    @Column(insertable = false,updatable = false)
    private Integer thumbs;

    @Column(insertable = false,updatable = false)
    private Integer views;

    @NotBlank(message = "본문은 필수 입력 항목입니다.!!")
    private String content;

    @CreatedDate
    @Column(insertable = false,updatable = false)
    private LocalDateTime regdate;




}




