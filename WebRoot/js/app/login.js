$(document).ready(function() {
	onfocus();
	$('#login').click(function(e) {
		submitform();
	});
});
function onfocus(){
	$("#username").focus();
}
function refreshCaptcha() {
	var date = new Date();
	var captcha = document.getElementById("img_captcha");
	captcha.src = "captchaCode?t=" + date.getTime();
}


$(document).keydown(function(e){
	if(e.keyCode == 13) {
		submitform();
	}
});

function submitform(){
	$("#errormsg").text('');
	if($("#username").val() == ''){
		$("#errormsg").text('');
		return false;
	}
	if($("#password").val() == ''){
		$("#errormsg").text('');
		return false;
	}
	if($("#captcha").val() == ''){
		$("#errormsg").text('');
		return false;
	}
	
	
	var actionurl = $('form').attr('action');
	var checkurl = $('form').attr('check');
	var username = "username="+$("#username").val();
	var password = "password="+$("#password").val();
	var captcha = "captcha="+$("#captcha").val();
	var formData = username+"&"+password+"&"+captcha;
	
	loading('', 1);
	setTimeout(function () { 
		unloading();
		$.ajax({
			async : false,
			cache : false,
			type : 'POST',
			url : checkurl,
			data : formData,
			error : function() {
			},
			success : function(d) {
				if (d.success) {
					window.location.href = actionurl;
				}else{
					$("#errormsg").text(d.msg);
				}
			}
		});
    }, 1000);
	
}

function loading(name, overlay) {
	$('section').append('<div id="overlay"></div><div id="preloader">' + name + '</div>');
	if (overlay == 1) {
		$('#overlay').css('opacity', 0.1).fadeIn(function() {
			$('#preloader').fadeIn();
		});
		return false;
	}
	$('#preloader').fadeIn();
}

function unloading() {
	$('#preloader').fadeOut('fast', function() {
		$('#overlay').fadeOut();
	});
}
