package qnfzks3.semiprojectv7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import qnfzks3.semiprojectv7.model.Pds;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface PdsRepository  extends JpaRepository<Pds, Long> {

    @Modifying
    @Transactional
    @Query("update Pds set views = views + 1 where pno = :pno")
    void countViewById(long pno);
}
