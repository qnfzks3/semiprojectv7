package qnfzks3.semiprojectv7.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import qnfzks3.semiprojectv7.model.Member;
import qnfzks3.semiprojectv7.model.Zipcode;
import qnfzks3.semiprojectv7.repository.MemberRepository;
import qnfzks3.semiprojectv7.repository.ZipcodeRepository;

import java.util.List;

@Repository("jndao")
public class JoinDAOImpl implements JoinDAO {

    @Autowired
    ZipcodeRepository zipcodeRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<Zipcode> selectZipcode(String dong) {
        return zipcodeRepository.findZipcodeByDong(dong);
    }

    @Override
    public int insertMember(Member m) {
        return Math.toIntExact(memberRepository.save(m).getMbno()); //
    }

    @Override
    public int selectOneUserid(String uid) {
        return 0;
    }

    @Override
    public int selectOneMember(Member m) {
        return 0;
    }
}
