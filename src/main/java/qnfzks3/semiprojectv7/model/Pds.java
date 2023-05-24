package qnfzks3.semiprojectv7.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;



@Entity
@Table(name="pds")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pno;

    @NotBlank(message = "제목은 필수 항목입니다.!!")
    private String title;

    @NotBlank(message = "작성자은 필수 항목입니다.!!")
    private String userid;

    @Column(insertable = false,updatable = false)
    private int thumbs;
    @Column(insertable = false,updatable = false)
    private int views;

    @NotBlank(message = "본문내용을 적어주세요")
    private String content;
    private String uuid;

    @CreatedDate//자동생성 어노테이션
    @Column(insertable = false,updatable = false)     //readonly 적용
    private LocalDate regdate;


}
