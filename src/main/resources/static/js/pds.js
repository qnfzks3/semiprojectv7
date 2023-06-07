


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
const newbtn = document.querySelector("#newbtn");
newbtn?.addEventListener('click', () => {
    location.href = '/pds/write';
});

// 본문보기
// 댓글쓰기
const rpnewbtn = document.querySelector("#rpnewbtn");
rpnewbtn?.addEventListener('click', () => {
    const rpfrm = document.forms.rpfrm;
    if (rpfrm.reply.value === '') alert('댓글을 작성하세요!');
    else if (rpfrm.userid.value === '') alert('작성자가 없어요!');
    else if (rpfrm.pno.value === '') alert('본문글번호 없어요!');
    else {
        rpfrm.method = 'post';
        rpfrm.action = '/pds/replyok';
        rpfrm.submit();
    }
});

// 대댓글쓰기 모달 띄우기
let modal = null;
const showComment = (refno) => {
    const frefno = document.querySelector("#refno");
    const cmtModal = document.querySelector("#cmtModal");

    frefno.value = refno;

    let mymodal = null;   // 대댓글 모달창 띄우기
    try {
        mymodal = new bootstrap.Modal(cmtModal, {});
        modal = mymodal;
    } catch (e) {}

    mymodal.show();
};
// 대댓글 쓰기
const cmtbtn = document.querySelector("#cmtbtn");
cmtbtn?.addEventListener('click', () => {
    const cmtfrm = document.forms.cmtfrm;
    if (cmtfrm.reply.value === '') alert('댓글을 작성하세요!');
    else if (cmtfrm.userid.value === '') alert('작성자가 없어요!');
    else if (cmtfrm.pno.value === '') alert('본문글번호 없어요!');
    else if (cmtfrm.refno.value === '') alert('댓글번호 없어요!');
    else {
        cmtfrm.method = 'post';
        cmtfrm.action = '/pds/rreplyok';
        cmtfrm.submit();
    }
});
