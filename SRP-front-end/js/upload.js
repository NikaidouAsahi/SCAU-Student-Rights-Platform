$document.ready(
    function () {
        var uploadObj = new Object();
        uploadObj.commentText = "试图把我激怒";
        uploadObj.userName = "otto";
        uploadObj.userEmail = "114514@1919.net";
        uploadObj.userCollege = "数学与信息学院"
        uploadObj.userGrade = "2020级";
        uploadObj.userProfession = "硬件工程";
        uploadObj.userPhoneNumber = "+86-1145141919810"

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
    }
);