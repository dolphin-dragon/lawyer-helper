$package('otter.login');
otter.login = function(){
	return {
		toLogin:function(){
			try{
				var form = $("#loginForm");
				if(form.form('validate')){
					otter.progress('Please waiting','Loading...');
					otter.submitForm(form,function(data){
						otter.closeProgress();
						if(data.success){
					 		window.location= "main.shtml";
				        }else{
				       	   otter.alert('提示',data.msg,'error');  
				        }
				        otter.login.loadVrifyCode();//刷新验证码
					});
				}
			}catch(e){
				
			}
			return false;
		},
		loadVrifyCode:function(){//刷新验证码
			var _url = "ImageServlet?time="+new Date().getTime();
			$(".vc-pic").attr('src',_url);
		},
		init:function(){
			if(window.top != window.self){
				window.top.location =  window.self.location;
			}
			//验证码图片绑定点击事件
			$(".vc-pic").click(otter.login.loadVrifyCode);
			
			var form = $("#loginForm");
			form.submit(otter.login.toLogin);
		}
	}
}();

$(function(){
	otter.login.init();
});		