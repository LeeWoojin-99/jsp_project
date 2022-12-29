document.getElementById("trigger").addEventListener("click", function(){
    document.getElementById("files").click();
})

// 정규 표현식을 이용한 생성자 함수 만들기
// fileload시 형식 제한 함수
// 실행파일 막기
// 이미지 파일
const regExp = new RegExp("\.(exe|sh|bat|msi|dll|js)$"); // 실행 파일 막기
const regExpImg = new RegExp("\.(jpg|jpeg|png|gif)$"); // 이미지 파일
const maxSize = 1024*1024*20; // 20MB보다 큰지 체크

function fileSizeValidataion(fileName, fileSize){
    if(regExp.test(fileName)){
        return 0;
    }else if(!regExpImg.test(fileName)){
        return 0;
    }else if(fileSize > maxSize){
        return 0;
    }else{
        return 1;
    }

}
document.addEventListener("change", (e)=>{
    if(e.target.id == "files"){
        // input type="file" element fileObject 객체로 리턴
        const fileObject = document.getElementById("files").files;
        console.log(fileObject);    
        let div = document.getElementById("fileZone");
        div.innerHTML = "";
        let ul = "<ul class='list-group list-goup-flush'>";
        let isOK = 1;
        for(let file of fileObject){
            let validResult = fileSizeValidataion(file.name, file.size);
            isOK *= validResult;
            ul+=`<li class="list-group-itm d-flex justify-content-between align-items-start">`;
            // 업로드 가능여부 표시
            ul+= `${validResult?'<div class="fw-bold text-success">업로드 가능':'<div class="fw-bold text-danger">업로드 불가'}</div>`;
            ul+=`${file.name}`;
            ul+=`<span class="badge bg-${validResult?"success":"danger"} rounded-pill">${file.size} Byte</span></li>`;
        }
        ul+=`</ul>`;
        if(isOK>0){
            div.innerHTML += ul;
        }else{
            div.innerHTML += "isOK = 0";
        }
    }
})