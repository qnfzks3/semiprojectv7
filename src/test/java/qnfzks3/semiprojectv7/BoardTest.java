package qnfzks3.semiprojectv7;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import qnfzks3.semiprojectv7.model.Board;
import qnfzks3.semiprojectv7.model.Zipcode;
import qnfzks3.semiprojectv7.repository.BoardRepository;
import qnfzks3.semiprojectv7.repository.ZipcodeRepository;

import java.util.List;

@SpringBootTest
public class BoardTest {

    @Autowired
    BoardRepository boardRepository;  //zipcodeRepository 가 스프링부트에서 자동으로 값을 가져오게 한다.

    @Test
    @DisplayName("board save")
    public void saveBoard() {
        Board b = new Board(null, "테스트입니다.","abc123",null,null,"테스트",null);

        boardRepository.save(b);

    }
}
