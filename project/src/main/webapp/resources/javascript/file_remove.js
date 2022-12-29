async function fileRemoveDelete(uuid){
    try {
        url = "/file/"+uuid;
        config = {
            method: "delete"
        }
        response = await fetch(url, config);
        result = await response.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

function file_remove(e){
    fileRemoveDelete(e.dataset.uuid).then(result => {
        if(result>0){
            console.log("이미지 삭제 완료");
            e.closest("li").remove();
        }
    })
}