package qnfzks3.semiprojectv7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import qnfzks3.semiprojectv7.model.Gallery;
import qnfzks3.semiprojectv7.model.Pds;


public interface GalleryRepository extends JpaRepository<Gallery, Long> {


    /*@Modifying
    @Transactional
    @Query("update Gallery set views = views + 1 where gno = :gno")
    void countViewById(long gno)*/;
}
