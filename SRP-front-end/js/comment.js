$(document).ready(
    function () {
        console.log("ready!");
        let fileName;
        let file_in_base64;
        let uploadObj = new Object();
        function upload(jsonStr) {
            $.ajax({
                type:"POST",
                url:"/api/upload-comment",
                contentType: "application/json",
                dataType:"json",
                data:jsonStr,
                success:function (data) {
                    alert("OK!");
                }
            })
        }
        $("#select-file").click(
            function () {
                $("#attachment").trigger('click');
                $("#attachment").change(
                    function () {
                        let file = this.files[0];
                        fileName = file.name;
                        if(window.FileReader) {
                            let reader = new FileReader();
                            reader.readAsDataURL(file);
                            reader.onloadend = function () {
                                file_in_base64 = reader.result.substring(reader.result.indexOf(",")+1);
                            };
                        }
                    }
                );
            }
        );
        $("#submit").click(
            function () {
                uploadObj.commentText = $("#commentText").val();
                uploadObj.userName = $("#userName").val();
                uploadObj.userEmail = $("#userEmail").val();
                uploadObj.userCollege = $("#userCollege").val();
                uploadObj.userGrade = $("#userGrade").val();
                uploadObj.userProfession = $("#userProfession").val();
                uploadObj.userPhoneNumber = $("#userPhoneNumber").val();
                uploadObj.attachmentFile = file_in_base64;
                file_in_base64 = "";
                uploadObj.fileName = fileName;
                if(uploadObj.commentText.length && uploadObj.userName.length && uploadObj.userEmail.length && uploadObj.userCollege.length && uploadObj.userGrade.length && uploadObj.userProfession.length && uploadObj.userPhoneNumber) {
                    //用户已经填完了所有信息
                    console.log("开始上传");
                    let uploadJson = JSON.stringify(uploadObj);
                    for(let key in uploadObj) {
                        delete uploadObj[key];
                    } // 回收内存
                    upload(uploadJson);
                }
                else {
                    console.log("用户未填写所需信息");
                }
            }
        );




    }
);