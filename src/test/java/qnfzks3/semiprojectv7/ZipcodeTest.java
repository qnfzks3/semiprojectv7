package qnfzks3.semiprojectv7;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
}
