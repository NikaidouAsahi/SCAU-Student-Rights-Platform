param2 = "test";

var uploadObj = new Object();
obj.content = param2;
var uploadJson = JSON.stringify(uploadObj);

function upload() {
    $.ajax({
        type:"POST",
        url:"/api/upload-comment",
        contentType: "application/json",
        dataType:"json",
        data:uploadJson,
        success:function (data) {
            alert("OK!");
        }
    })
}