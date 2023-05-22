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

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("member save")
    public void saveMember()
    {

       Member m = new Member(null,"abc123","123456",
               "1234567","abc123","987xyz","123-456",
               "서울시 구로구 구로동","더조은 IT 아카데미",
               "abc123@987xyz.co.kr","123-1234-5678",null);



       memberRepository.save(m);


    }


    @Test
    @DisplayName("member update")
    public void updateMember()
    {

        Member m = new Member(null,"abc123","123456",
                "1234567","abc123","987xyz","123-456",
                "서울시 구로구 구로동","더조은 IT 아카데미",
                "abc123@987xyz.co.kr","123-1234-5678",null);
        //null 이라고 해도 자동으로 값이 채워지도록 dao에 설정 했기 때문에 상관없다.



        memberRepository.save(m);


    }

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
