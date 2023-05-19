package qnfzks3.semiprojectv7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import qnfzks3.semiprojectv7.model.Board;
import qnfzks3.semiprojectv7.model.Zipcode;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {



}
