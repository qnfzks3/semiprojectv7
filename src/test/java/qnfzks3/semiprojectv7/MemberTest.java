package qnfzks3.semiprojectv7;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import qnfzks3.semiprojectv7.model.Member;
import qnfzks3.semiprojectv7.model.Zipcode;
import qnfzks3.semiprojectv7.repository.MemberRepository;
import qnfzks3.semiprojectv7.repository.ZipcodeRepository;

import java.util.List;

@SpringBootTest
public class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("member save")
    public void findZipByDong()
    {

       Member m = new Member(null,"abc123","123456",
               "1234567","abc123","987xyz","123-456",
               "서울시 구로구 구로동","더조은 IT 아카데미",
               "abc123@987xyz.co.kr","123-1234-5678",null);



       memberRepository.save(m);


    }


    @Test
    @DisplayName("member update")
    public void updateZipByDong()
    {

        Member m = new Member(2L,"abc123","123456",
                "1234567","abc123","987xyz","123-456",
                "서울시 구로구 구로동","더조은 IT 아카데미",
                "abc123@987xyz.co.kr","123-1234-5678",null);



        memberRepository.save(m);


    }

    @Test
    @DisplayName("member delete")
    public void deleteZipByDong()
    {

        Member m = new Member();
        m.setMbno(2L);



        memberRepository.delete(m);


    }


}
