let fileInput = document.getElementById("test-image-file");
let info = document.getElementById("test-file-info");
let preview = document.getElementById("test-image-preview");
let button = document.getElementById("preview-btn");

function upload() {
    preview.style.backgroundImage = ''; // 清空背景图片
    // 检查图片是否选择
    if(!fileInput.value) {
        info.innerHTML = "没有选择文件";
        return;
    }
    let file = fileInput.files[0];
    let size = file.size;
    if (size > 100 * 1024 * 1024) {
        alert("文件大于100M无法上传");
        return false;
    }
    info.innerHTML = '文件名称: ' + file.name + '<br>' +
        '文件大小: ' + file.size + '<br>' +
        '上传时间: ' + file.lastModifiedDate;
    if (file.type !== "image/jpeg" && file.type !== 'image/png' && file.type !== 'image/gif' && file.type !== 'image/heic') {
        alert("非有效图片文件");
        return;
    }

    let reader = new FileReader();
    reader.onload = function(e) {
        let data = e.target.result;
        preview.src = data;
    };
    reader.readAsDataURL(file);
}

button.addEventListener("click", function(){
    upload();
});