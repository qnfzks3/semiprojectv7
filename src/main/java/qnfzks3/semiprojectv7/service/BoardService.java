package qnfzks3.semiprojectv7.service;

import qnfzks3.semiprojectv7.model.Board;
import qnfzks3.semiprojectv7.model.Member;

import java.util.List;

public interface BoardService {

    List<Board> readBoard(int cpage);
    List<Board> readBoard(int cpage, String ftype, String fkey);

    int countBoard();
    int countBoard(String ftype, String fkey);

    boolean newBoard(Board bd);

    Board readOneBoard(int bno);


}
