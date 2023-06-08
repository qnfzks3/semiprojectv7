package qnfzks3.semiprojectv7.dao;


import org.springframework.stereotype.Repository;
import qnfzks3.semiprojectv7.model.GalAttach;
import qnfzks3.semiprojectv7.model.Gallery;

import java.util.Map;

@Repository
public interface GalleryDAO {
    int insertGal(Gallery gallery);

    int insertGalAttach(GalAttach ga);

    Map<String, Object> selectGallery(Integer  cpg);

    Object selectOneGallery(int gno);

}
