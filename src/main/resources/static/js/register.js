$(function(){

	var error_name = false;
	var error_password = false;
	var error_check_password = false;
	var error_email = false;
	var error_check = false;


	$('#user_name').blur(function() {
		check_user_name();
	});

	$('#pwd').blur(function() {
		check_pwd();
	});

	$('#cpwd').blur(function() {
		check_cpwd();
	});

	$('#email').blur(function() {
		check_email();
	});
	$('#mobile').blur(function() {
		check_mobile();
	});

	$('#allow').click(function() {
		if($(this).is(':checked'))
		{
			error_check = false;
			$(this).siblings('span').hide();
		}
		else
		{
			error_check = true;
			$(this).siblings('span').html('请勾选同意');
			$(this).siblings('span').show();
		}
	});


	function check_user_name(){
		var len = $('#user_name').val().length;
		if(len<5||len>20)
		{
			$('#user_name').next().html('请输入5-20个字符的用户名')
			$('#user_name').next().show();
			error_name = true;
		}
		else
		{
			$('#user_name').next().hide();
			error_name = false;
		}
	}

	function check_pwd(){
		var len = $('#pwd').val().length;
		if(len<8||len>20)
		{
			$('#pwd').next().html('密码最少8位，最长20位')
			$('#pwd').next().show();
			error_password = true;
		}
		else
		{
			$('#pwd').next().hide();
			error_password = false;
		}		
	}


	function check_cpwd(){
		var pass = $('#pwd').val();
		var cpass = $('#cpwd').val();

		if(pass!=cpass)
		{
			$('#cpwd').next().html('两次输入的密码不一致')
			$('#cpwd').next().show();
			error_check_password = true;
		}
		else
		{
			$('#cpwd').next().hide();
			error_check_password = false;
		}		
		
	}

	function check_email(){
		var re = /^[a-z0-9][\w\.\-]*@[a-z0-9\-]+(\.[a-z]{2,5}){1,2}$/;

		if(re.test($('#email').val()))
		{
			$('#email').next().hide();
			error_email = false;
		}
		else
		{
			$('#email').next().html('你输入的邮箱格式不正确')
			$('#email').next().show();
			error_check_password = true;
		}

	}

	function check_mobile(){
		var phone = $("#mobile").val();
        if((/^1(3|4|5|7|8)\d{9}$/.test(phone))){
            $('#mobile').next().hide();
            error_email = false;
        }else{
            $('#mobile').next().html('你输入的手机号不正确,请重新输入')
            $('#mobile').next().show();
            error_check_password = true;
		}
    }

    $("#submit_button").click(function () {
		check_user_name();
		check_pwd();
		check_cpwd();
		// check_email();
		check_mobile();
		if(error_name == false && error_password == false && error_check_password == false && error_email == false && error_check == false)
		{
            $.ajax({
                url: "/user/register",
                type: "post",
                dataType: "json",
                data: $('#reg_form').serialize(),
                success: function (data) {
                    console.log(data.data);
                    if(data.code=="1"){
                        alert(data.msg);
                        var localStorage = window.localStorage;
                        var curTime = new Date().getTime();
                        localStorage.setItem("user",JSON.stringify({"userId":data.data.id,"userName":data.data.username,"time":curTime}));
                        window.location.href="index";
                    }else{
                        alert(data.msg);
                    }
                }
            });
			return true;
		}
		else
		{
			return false;
		}

	});

});