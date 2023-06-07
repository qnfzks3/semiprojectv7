package qnfzks3.semiprojectv7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import qnfzks3.semiprojectv7.model.PdsAttach;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PdsaRepository extends JpaRepository<PdsAttach, Long>{
    PdsAttach findByPno(int pno);

    @Transactional
    @Modifying
    @Query("update PdsAttach set fdown = fdown + 1 where pno = :pno")
    void countDownByPno(@Param("pno") int pno);

    @Query(value = "select ftype from pdsattach", nativeQuery=true)
    List<String> findByFtypes();
}
