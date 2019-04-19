$(function () {
    $("#selectShowType input[type=radio]").on("change",function (e) {
        if(this.value==1){

            $("#actionPass").hide();
            $("#staticPass").show();
        }else{
            $("#actionPass").show();
            $("#staticPass").hide();
        }
    });
})

function on_submit() {
    var loginCode=$("#loginCode").val();
    var yzm=$(".i_check_in").html();
    if(loginCode==yzm){
        $.ajax({
            cache:false,
            type:'POST',
            url:'user/login',
            data: $('.form-horizontal').serialize(),
            error:function () {
                alert("与服务器断开连接");
            },
            success:function (str) {
                alert(str);

                if(str=="1"){
                    alert("登录成功!欢迎使用本系统!");
                }else if(str=="0"){
                    alert("登录失败!请重新登录!");
                    window.location.href='loginHtml';
                }else if(str=="00"){
                    alert("账号或密码错误,请重新登录!");
                    window.location.href='loginHtml';
                }
            }
        })
    }else{
        alert("验证码错误!");
    }
}