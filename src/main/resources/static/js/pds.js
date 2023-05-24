


//새글 쓰기  - 새글쓰기 버튼을 눌렀을때 작동시키기 위해서
const writebtn =document.querySelector("#writebtn");

writebtn?.addEventListener('click',()=>{ //jsp에 있는 인풋의 name에 적힌 이름=> 폼에 적힌 인풋네임  bdfrm.title
    const pdsfrm=document.forms.pdsfrm;          //왜있는거지?

    if(pdsfrm.title.value ==='') alert('제목을 작성해주세요');
    else if(pdsfrm.content.value ==='') alert('본문을 작성해주세요!');
    else if(grecaptcha.getResponse()==='') alert('자동가입방지 체크가 안되어있습니다.');
    else{
        bdfrm.method = 'post';            //메서드를 포스트로 해야하며
        bdfrm.enctype = 'multipart/form-data';  //엔씨타입이 폼데이터로 해놓고  첨부한거 인코딩 한다.
        bdfrm.submit();

    }

});