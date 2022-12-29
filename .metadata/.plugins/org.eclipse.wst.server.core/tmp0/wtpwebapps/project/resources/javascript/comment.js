document.getElementById("comment_post_btn").onclick = function(){
    comment_post_area = document.getElementById("comment_post_area");
    cmtData = {
        bno: bnoVal,
        writer: comment_post_area.querySelector("label").innerText,
        content: comment_post_area.querySelector("input").value
    }
    console.log(cmtData);
    postPost(cmtData).then(result => {
        if(result>0) alert("댓글 쓰기 성공");
        commentList(bnoVal);
    })
}

async function postPost(cmtData) {
    try {
        url = "/comment/";
        config = {
            method: "post",
            headers: {"content-type" : "application/json; charset=utf-8"},
            body: JSON.stringify(cmtData)
        }
        response = await fetch(url, config);
        result = await response.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

function commentList(bno){
    commentListGet(bno).then(result => {
        spreadCommentList(result);
    })
}

async function commentListGet(bno){
    try {
        const response = await fetch("/comment/"+bno);
        const result = await response.json();
        return result;
    } catch (error) {
        console.log(error);
    }
}

function spreadCommentList(result){
    if(result.length>0){
        console.log(result.length+"개의 댓글이 있습니다.");
        ul = document.getElementById("comments");
        ul.innerHTML = "";

        for(i=0; i<result.length; i++){
            html = `<li class="list-group-item comment" data-cno="${result[i].cno}">`;
            html += `writer : <span class="writer">${result[i].writer}</span><br>`;
            html += `mod_date : <span class="mod_date">${result[i].mod_date}</span>`;
            html += `<input type="text" class="form-control content" value="${result[i].content}">`;
            html += `<div class="btn-group" role="group">`;
            html += `<button type="button" class="btn btn-primary comment_modify" onclick="comment_modify(this)">modify</button>`;
            html += `<button type="button" class="btn btn-primary comment_remove" onclick="comment_remove(this)">remove</button>`;
            html += `</div>`;
            html += `</li>`;
            ul.innerHTML += html;
        }
    }else{
        document.getElementById("comments").innerHTML = "댓글이 없습니다.";
    }
}

function comment_modify(e){
    console.log(e);
    li = e.closest("li");
    cmtData = {
        bno: bnoVal,
        cno: li.dataset.cno,
        writer: li.querySelector(".writer").innerText,
        content: li.querySelector(".content").value
    }
    console.log(cmtData);
    modifyPut(cmtData).then(result => {
        if(result>0) console.log("수정 완료");
        commentList(bnoVal);
    })
}

async function modifyPut(cmtData){
    try {
        url = "/comment/";
        config = {
            method: "put",
            headers: {"content-type" : "application/json; charset=utf-8"},
            body: JSON.stringify(cmtData)
        }
        response = await fetch(url, config);
        result = await response.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

function comment_remove(e){
    li = e.closest("li");
    removeDelete(li.dataset.cno).then(result => {
        if(result>0) console.log("삭제 완료");
        commentList(bnoVal);
    })
}

async function removeDelete(cno){
    try {
        url = "/comment/"+cno;
        config = {
            method: "delete"
        }
        response = await fetch(url, config);
        result = response.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}