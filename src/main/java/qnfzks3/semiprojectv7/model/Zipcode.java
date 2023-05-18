package qnfzks3.semiprojectv7.model;

import lombok.Data;
import javax.persistence.Id;    // 어디서 가져올지 잘 확인하자
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="ZIPCODE")
public class Zipcode {

    private String zipcode;
    private String sido;
    private String gugun;
    private String dong;
    private String ri;
    private String bunji;

    @Id
    private Long seq;


}
