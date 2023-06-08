package qnfzks3.semiprojectv7.service;

import org.springframework.web.multipart.MultipartFile;
import qnfzks3.semiprojectv7.model.Gallery;

import java.util.List;
import java.util.Map;

public interface GalleryService {

    Map<String, Object> newGallery(Gallery gallery);
    boolean newGalAttach(List<MultipartFile> attachs, Map<String, Object> ginfo);
}
