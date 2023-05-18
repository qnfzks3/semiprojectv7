package qnfzks3.semiprojectv7.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import qnfzks3.semiprojectv7.model.Member;

@Repository("mdao")
public class MemberDAOImpl implements MemberDAO {

    @Override
    public int selectLogin(Member m) {
        return 0;
    }
}
