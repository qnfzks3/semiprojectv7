package qnfzks3.semiprojectv7.service;

import qnfzks3.semiprojectv7.model.Member;

public interface JoinService {

    String findZipcode(String dong);

    boolean newMember(Member m);

    int checkUserid(String uid);

    boolean loginMember(Member m);

    int insertMember(Member m);

}
