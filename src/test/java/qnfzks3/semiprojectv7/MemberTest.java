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

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class MemberTest {



    @Test
    @DisplayName("member delete")
    public void deleteMember()
    {

        Member m = new Member();
        m.setMbno(2L);



        memberRepository.delete(m);


    }

    @Test
    @DisplayName("member login")
    public void loginMember()
    {

        Member m = new Member();
        m.setUserid("abc123");
        m.setPasswd("abc123");



        assertNull(memberRepository.countByUseridAndPasswd(m.getUserid(),m.getPasswd()));


        m.setUserid("abc123");
        m.setPasswd("987xyz");
        assertNull(memberRepository.countByUseridAndPasswd(m.getUserid(),m.getPasswd()));
    }


}
