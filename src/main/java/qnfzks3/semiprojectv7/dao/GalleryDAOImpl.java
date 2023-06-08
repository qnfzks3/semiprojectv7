package qnfzks3.semiprojectv7.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import qnfzks3.semiprojectv7.model.GalAttach;
import qnfzks3.semiprojectv7.model.Gallery;
import qnfzks3.semiprojectv7.repository.GalleryRepository;
import qnfzks3.semiprojectv7.repository.GalleryaRepository;

@Repository("galdao")
public class GalleryDAOImpl implements GalleryDAO{

    
    //생성자를 이용한 스프링 빈 주입
    private final GalleryRepository galleryRepository;

    private final GalleryaRepository galleryaRepository;

    //Autowired 는 보통 1개만 사용하는데, 2개쓰기보단 생성자 주입을 사용한다.   생성자 주입은 2개 이상일 때
    @Autowired
    public GalleryDAOImpl(GalleryRepository galleryRepository, GalleryaRepository galleryaRepository) {
        this.galleryRepository = galleryRepository;
        this.galleryaRepository = galleryaRepository;
    }

    @Override
    public int insertGal(Gallery gallery) {
        return Math.toIntExact(galleryRepository.save(gallery).getGno());
    }

    @Override
    public int insertGalAttach(GalAttach ga) {
        return Math.toIntExact(galleryaRepository.save(ga).getGano());
    }


}
