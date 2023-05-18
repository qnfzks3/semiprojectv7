package qnfzks3.semiprojectv7.dao;

import qnfzks3.semiprojectv7.model.Member;
import qnfzks3.semiprojectv7.model.Zipcode;

import java.util.List;

public interface JoinDAO {

    List<Zipcode> selectZipcode(String dong);

    int insertMember(Member m);

    int selectOneUserid(String uid);

    int selectOneMember(Member m);

}
