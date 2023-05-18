package qnfzks3.semiprojectv7.service;

import qnfzks3.semiprojectv7.model.Member;

import javax.servlet.http.HttpSession;

public interface MemberService {
    boolean checkLogin(Member m, HttpSession sess);
}
