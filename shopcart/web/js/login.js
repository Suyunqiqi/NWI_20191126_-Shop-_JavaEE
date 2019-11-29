$(document).ready(function () {
   $("#submit").click(function () {
        $.ajax({
            type:"POST",
            url:"http://localhost:8080/shopcart_war_exploded/login.action",
            data:{
                uacc:$("#uacc").val(),
                upwd:$("#upwd").val()
            },
            success:function (data) {
                console.log("控制台信息-----"+data);
                let json=JSON.parse(data);
                $("#accmsg").html("");
                $("#pwdmsg").html("");
                if (json.flag=="666"){
                    window.location.href="index.html";
                }else if (json.flag=="102"){
                    $("#accmsg").html("账号错误");
                }else{
                    $("#pwdmsg").html("密码错误");
                }
            },
            error:function (error) {
                alert(error);
            }
        })
   });
});