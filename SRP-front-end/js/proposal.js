$(document).ready(
    function () {
        console.log("ready!");
        let photoName;
        let documentName;
        let photo_in_base64;
        let document_in_base64;
        let uploadObj = new Object();
        function upload(jsonStr) {
            $.ajax({
                type:"POST",
                url:"/api/upload-proposal",
                contentType: "application/json",
                dataType:"json",
                data:jsonStr,
                success:function (data) {
                    alert("OK!");
                }
            })
        }
        $("#select-photo").click(
            function () {
                $("#photo").trigger('click');
                $("#photo").change(
                    function () {
                        let file = this.files[0];
                        photoName = file.name;
                        if(window.FileReader) {
                            let reader = new FileReader();
                            reader.readAsDataURL(file);
                            reader.onloadend = function () {
                                photo_in_base64 = reader.result.substring(reader.result.indexOf(",")+1);
                            };
                        }
                    }
                );
            }
        );
        $("#select-document").click(
            function () {
                $("#document").trigger('click');
                $("#document").change(
                    function () {
                        let file = this.files[0];
                        documentName = file.name;
                        if(window.FileReader) {
                            let reader = new FileReader();
                            reader.readAsDataURL(file);
                            reader.onloadend = function () {
                                document_in_base64 = reader.result.substring(reader.result.indexOf(",")+1);
                            };
                        }
                    }
                );
            }
        );
        $("#submit").click(
            function () {
                uploadObj.photo = photo_in_base64;
                photo_in_base64 = ""; // 释放内存
                uploadObj.photoName = photoName;
                uploadObj.document = document_in_base64;
                document_in_base64 = ""; // 释放内存
                uploadObj.documentName = documentName;
                uploadObj.proposalTitle = $("#proposalTitle").val();
                uploadObj.userName = $("#userName").val();
                uploadObj.userCollegeAndProfession = $("#userCollegeAndProfession").val();
                uploadObj.userId = $("#userId").val();
                uploadObj.userContact = $("#userContact").val();
                uploadObj.userEmail = $("#userEmail").val();
                uploadObj.proposalContent = $("#proposalContent").val();
                uploadObj.solution = $("#solution").val();
                let objComplete;
                if(Object.keys(uploadObj).length === 0) {
                    objComplete = false;
                }
                else {
                    objComplete = true;
                }
                if(objComplete) {
                    // 用户已经填完了所有信息
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