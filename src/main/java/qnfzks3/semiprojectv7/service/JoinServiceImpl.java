package qnfzks3.semiprojectv7.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qnfzks3.semiprojectv7.dao.JoinDAO;
import qnfzks3.semiprojectv7.model.Member;
import qnfzks3.semiprojectv7.repository.MemberRepository;

@Service("jnsrv")
public class JoinServiceImpl implements JoinService {

    @Autowired private JoinDAO jndao;
    @Autowired
    private MemberRepository memberRepository;


    @Override
    public String findZipcode(String dong) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        dong = "%" + dong + "%";

        try {
            json = mapper.writeValueAsString(
                    jndao.selectZipcode(dong));
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

        return json;
    }

    @Override
    public int insertMember(Member m){
        int isSaved = -1;
        m= memberRepository.save(m);
        if(m != null)
            isSaved=Math.toIntExact(m.getMbno());

        return isSaved ;
    }


    @Override
    public boolean newMember(Member m) {

        boolean result = false;

        if (jndao.insertMember(m) > 0) result = true;  //intsetMember 에서 값이 널이 아니면 으로 할때 적용하도록

        return result;
    }

    @Override
    public int checkUserid(String uid) {
        return jndao.selectOneUserid(uid);
    }

    @Override
    public boolean loginMember(Member m) {
        return false;
    }

}
