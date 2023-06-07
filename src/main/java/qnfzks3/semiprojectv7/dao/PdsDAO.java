package qnfzks3.semiprojectv7.dao;


import qnfzks3.semiprojectv7.model.Pds;
import qnfzks3.semiprojectv7.model.PdsAttach;
import qnfzks3.semiprojectv7.model.PdsReply;

import java.util.List;
import java.util.Map;

public interface PdsDAO {
    int insertPds(Pds pds);
    int insertPdsAttach(PdsAttach pa);


    Map<String, Object> selectPds(int i);

    Pds selectOnePds(int pno);
    PdsAttach selectOnePdsAttach(int pno);

    void countDownload(int pno);

    List<String> selectFtype();

    List<PdsReply> selectPdsReply(int pno);

    int insertReply(PdsReply reply);

    int insertRreply(PdsReply reply);
}
