package qnfzks3.semiprojectv7.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity           //엔티티 라고 정의
@Table(name="MEMBER") //엔티티를 매핑할 데이터베이스 테이블의 이름을 지정
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

    @NotBlank(message = "아이디를 기입해주세요")
    @Length (min= 6,max = 18 , message = "아이디는 최소 6자, 최대 18자입니다.")
    private String userid;

    @NotBlank(message = "비밀번호를 기입해주세요")
    @Length (min= 6,max = 18 , message = "비밀번호는 최소 6자, 최대 18자입니다.")     //글자수 제한 지정
    private String passwd;



    private String zipcode;

    @NotBlank(message = "주소를 기입해주세요")
    private String addr1;

    @NotBlank(message = "상세 주소를 기입해주세요")
    private String addr2;





    //@Temporal(TemporalType.TIMESTAMP)
    @CreatedDate                //현재 시간이 자동으로 삽입 되도록 어노테이션 해줌
    @Column(insertable = false,updatable = false)
    private LocalDateTime regdate;       //jdk 에서 LocalDateTime 형식 지원

    /*
    @Column(insertable = false, updatable = false)는
   설명 - 우리가 데이터를 업데이트 하거나 삽입 할 시에 이 regdate만은 변동되거나 하지 않도록 설정해줌
     */


    ///--------------------------------------------------------------------------

    @Transient           //필드 영속성은 지원 하지않는다 - 테이블과 무관하게 사용가능
    @NotBlank(message = "우편번호를 기입해주세요")
    private String zip1;

    @Transient
    @NotBlank(message = "우편번호를 기입해주세요")
    private String zip2;

    @Transient
    @NotBlank(message = "이매일을 기입해주세요")
    private String email1;

    @Transient
    @NotBlank(message = "이매일을 기입해주세요")
    private String email2;





    @Transient
    @NotBlank(message = "전화번호를 기입해주세요")
    private String tel2;


    @Transient
    @NotBlank(message = "전화번호를 기입해주세요")
    private String tel3;

}
