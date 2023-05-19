package qnfzks3.semiprojectv7.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="member")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor//date - 롬북의 date  -셋겟 생성자
public class Board {

    @Id
    private String bno;
    private String title;
    private String userid;
    private String thumbs;
    private String views;
    private String content;

    @CreatedDate
    @Column(insertable = false,updatable = false)
    private LocalDateTime regdate;




}




