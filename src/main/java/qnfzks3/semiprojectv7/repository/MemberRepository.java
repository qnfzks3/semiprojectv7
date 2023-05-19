package qnfzks3.semiprojectv7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import qnfzks3.semiprojectv7.model.Member;


import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {




}
