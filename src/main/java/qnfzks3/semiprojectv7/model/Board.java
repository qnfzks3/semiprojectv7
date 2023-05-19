package qnfzks3.semiprojectv7.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    private String title;
    private String userid;

    @Column(insertable = false,updatable = false)
    private Integer thumbs;

    @Column(insertable = false,updatable = false)
    private Integer views;

    private String content;

    @CreatedDate
    @Column(insertable = false,updatable = false)
    private LocalDateTime regdate;




}




