package qnfzks3.semiprojectv7;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import org.springframework.data.domain.Pageable;
import qnfzks3.semiprojectv7.model.Zipcode;

import qnfzks3.semiprojectv7.repository.ZipcodeRepository;

import java.util.List;

@SpringBootTest
public class ZipcodeTest {

    @Autowired
    ZipcodeRepository zipcodeRepository;  //zipcodeRepository 가 스프링부트에서 자동으로 값을 가져오게 한다.

    @Test
    @DisplayName("zipcode")
    public void findZipByDong()
    {
       List<Zipcode> addr = zipcodeRepository.findZipcodeByDong("구로동");

        System.out.println(addr);
    }

    @Test
    @DisplayName("zipcode page1")
    public void pageZipcode()
    {
        Pageable pageable = PageRequest.of(1,15);  //1 페이지당 15개 데이터 가져와  - 1페이지
        Page<Zipcode> page = zipcodeRepository.findAll(pageable);
        List<Zipcode> zips = page.getContent();
        System.out.println(zips);
    }



    @Test
    @DisplayName("zipcode page2")
    public void page2Zipcode()
    {
        String dong= "%"+"구로"+"%";

        Pageable pageable = PageRequest.of(0,15);  //1 페이지당 15개 데이터 가져와  - 1페이지

        Page<Zipcode> page = zipcodeRepository.findByDongLike(dong, pageable);

        List<Zipcode> zips = page.getContent();
        System.out.println(zips);




    }



}
