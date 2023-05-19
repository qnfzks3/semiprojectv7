package qnfzks3.semiprojectv7.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity           //엔티티 라고 정의
@Table(name="member") //엔티티를 매핑할 데이터베이스 테이블의 이름을 지정
@Setter            //setter,getter ,Tostring자동 생성
@Getter
@ToString
@NoArgsConstructor         
@AllArgsConstructor       //생성자를 명시 하지않아도 알아서 필요에 맞게 생성자를 자동으로 생성
public class Member {
    //@GeneratedValue이 어노테이션을 엔티티의 필드에 적용하면,
    // JPA는 해당 필드의 값을 데이터베이스에 삽입할 때 자동으로 증가된 값을 할당합니다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    //@Temporal(TemporalType.TIMESTAMP)
    @CreatedDate                //현재 시간이 자동으로 삽입 되도록 어노테이션 해줌
    @Column(insertable = false,updatable = false)
    private LocalDateTime regdate;       //jdk 에서 LocalDateTime 형식 지원

    /*
    @Column(insertable = false, updatable = false)는
   설명 - 우리가 데이터를 업데이트 하거나 삽입 할 시에 이 regdate만은 변동되거나 하지 않도록 설정해줌
     */

}
