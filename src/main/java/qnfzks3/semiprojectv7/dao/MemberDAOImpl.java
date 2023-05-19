package qnfzks3.semiprojectv7.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import qnfzks3.semiprojectv7.model.Member;
import qnfzks3.semiprojectv7.repository.MemberRepository;

@Repository("mdao")
public class MemberDAOImpl implements MemberDAO {
    @Autowired    //어노테이션은 해당 필드, 생성자, 메서드 매개변수 등에 붙여서 해당 타입의 객체를 자동으로 주입받을 수 있도록 지정합니다
    MemberRepository memberRepository;


    @Override
    public int selectLogin(Member m) {



        return memberRepository.countByUseridAndPasswd(m.getUserid(), m.getPasswd());
    }
}
