package qnfzks3.semiprojectv7.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import qnfzks3.semiprojectv7.model.Board;
import qnfzks3.semiprojectv7.repository.BoardRepository;

import java.util.List;
import java.util.Map;

@Repository("bddao")
public class BoardDAOImpl implements BoardDAO {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public List<Board> selectBoard(int cpage) {
        //페이징 시 정렬 순서 지정 - PageRequest.of(cpage,25,Sort.by("bno").descending());
        Pageable paging = PageRequest.of(cpage,25, Sort.Direction.DESC,"bno");

        return boardRepository.findAll(paging).getContent();  //전체 데이터 글 보기

    }
    @Override
    public List<Board> selectBoard(Map<String, Object> params) {
        // like 검색에 대한 query method
        //findByTitleLike      :%검색어%  (%문자사용 필요o)
        //findByTitleContains  :%검색어%  (%문자제공 필요x)
        //findByTitleStartWith  : 검색어% (%문자 제공 필요 x)
        //findByTitleEndsWith   : %검색어 (%문자 제공 필요 x)


        //푸는 작업
        String fkey=params.get("fkey").toString();
        String ftype=params.get("ftype").toString();
        int cpage = (int) params.get("stbno");

        Pageable paging = PageRequest.of(cpage,25, Sort.Direction.DESC,"bno");

        List <Board> result=null;

        switch (ftype) {

            //이름 뒤에 like 붙인거 만으로도 자동실행
            //제목으로 검색
            case "title": result = boardRepository.findByTitleContains(paging, fkey); break;
            //제목+본문으로 검색
            case "titcont":result = boardRepository.findByTitleContainsOrContentContains(paging, fkey, fkey); break;
            //작성자로 검색
            case "userid":
                fkey=fkey.replace("%","");
                result = boardRepository.findByUserid(paging, fkey); break;
            //본문으로 검색
            case "content":result = boardRepository.findByContentContains(paging, fkey);

        }

        return result;
    }

    @Override
    public int countBoard() {
        // select ceil(count(bno)/25) from board
        int allcnt = boardRepository.countBoardBy();

        return (int) Math.ceil(allcnt / 25);

    }

    @Override
    public int countBoard(Map<String, Object> params) {
        String fkey=params.get("fkey").toString();
        String ftype=params.get("ftype").toString();


        int cnt = 0;
        switch (ftype) {

            //이름 뒤에 like 붙인거 만으로도 자동실행
            //제목으로 검색
            case "title": cnt = boardRepository.countByTitleContains(fkey); break;
            //제목+본문으로 검색
            case "titcont":cnt = boardRepository.countByTitleContainsOrContentContains(fkey, fkey); break;
            //작성자로 검색
            case "userid":
                fkey=fkey.replace("%","");
                cnt = boardRepository.countByUserid(fkey); break;
            //본문으로 검색
            case "content":cnt = boardRepository.countByContentContains(fkey);

        }

        return (int) Math.ceil(cnt/25);


    }

    @Override
    public int insertBoard(Board bd) {
        return Math.toIntExact(boardRepository.save(bd).getBno());
    }

    @Override
    public Board selectOneBoard(int bno) {
        boardRepository.countViewBoard((long) bno);    //조회수 증가 할수 있도록
        return boardRepository.findById((long) bno).get();   //본문 보기 -
    }
}