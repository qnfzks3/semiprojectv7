package qnfzks3.semiprojectv7.dao;


import org.springframework.stereotype.Repository;
import qnfzks3.semiprojectv7.model.GalAttach;
import qnfzks3.semiprojectv7.model.Gallery;

@Repository("galdao")
public class GalleryDAOImpl implements GalleryDAO{

    @Override
    public int insertGal(Gallery gallery) {
        return 0;
    }

    @Override
    public int insertGalAttach(GalAttach ga) {
        return 0;
    }
}
