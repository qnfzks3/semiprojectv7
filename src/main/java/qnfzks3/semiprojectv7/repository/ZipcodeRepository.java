package qnfzks3.semiprojectv7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import qnfzks3.semiprojectv7.model.Zipcode;

import java.util.List;

public interface ZipcodeRepository extends JpaRepository<Zipcode,Long> { 
          //반드시 spring boot를 사용하려면 위처럼 jpa 참조 <참조할 테이터, 그 데이터 타입> 을 적어주어야한다.



    //메서드 쿼리 : find 엔티티명 All, find 엔티티명 by 컬럼명

    @Query("from Zipcode where dong like %:dong%")
    List<Zipcode> findZipcodeByDong(@Param("dong") String dong);
    //@Param 해주면 String dong이라는 변수가 param dong으로 주고 %:dong% 이게 된다.
    //집코드에서 동이라는 컬럼을 가져와서 리스트 객체로 만든다.




}
