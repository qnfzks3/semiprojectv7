package qnfzks3.semiprojectv7.service;


import org.springframework.web.multipart.MultipartFile;
import qnfzks3.semiprojectv7.model.Pds;

public interface PdsService {


    int newPds(Pds pds);       //값이 저장되면 저장된 값으로 받아와야하기에

    boolean newPdsAttach(MultipartFile attach, int pno);



}
