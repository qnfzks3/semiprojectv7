package qnfzks3.semiprojectv7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import qnfzks3.semiprojectv7.model.Board;
import qnfzks3.semiprojectv7.model.Zipcode;

import javax.transaction.Transactional;
import java.util.List;

//public interface BoardRepository extends JpaRepository<Board,Long> {
public interface BoardRepository extends PagingAndSortingRepository<Board,Long> {


    //Spring Data JPA에서는 직접 SQL 문을 매핑하는 것보다 메서드 이름을 통해 쿼리를 자동으로 생성하고 실행하는 방식을 주로 사용합니다.
    //mybatis는 mapper에 sql문을 직접 작성하고 작성된걸 토대로 매핑하는 것
    
   //jpaRepository 에서는 DML은 지원 X
   //단, Modifying, Transactional등을 추가하면 사용 가능

    @Modifying //데이터 수정 어노테이션
    @Transactional  //  트랜잭션 범위에서 메서드를 실행하기 위해 사용
    @Query("update Board set views= views+1 Where bno= :bno")
    int countViewBoard(@Param("bno") long bno);




}
