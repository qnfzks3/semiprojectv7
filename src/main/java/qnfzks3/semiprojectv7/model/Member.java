package qnfzks3.semiprojectv7.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="member")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//이 어노테이션을 엔티티의 필드에 적용하면, JPA는 해당 필드의 값을 데이터베이스에 삽입할 때 자동으로 증가된 값을 할당합니다.
    private Long mbno;
    private String name;
    private String jumin1;
    private String jumin2;
    private String userid;
    private String passwd;
    private String zipcode;
    private String addr1;
    private String addr2;
    private String email;
    private String phone;

    @CreatedDate
    private LocalDateTime regdate;       //jdk 에서 LocalDateTime 형식 지원

}
