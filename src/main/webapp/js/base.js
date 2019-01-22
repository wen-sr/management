$(function(){
	//调用：
	// isLogin();
	$(document).keydown(function(e){   
       var keyEvent;   
       if(e.keyCode==8){   
           var d=e.srcElement||e.target;   
            if(d.tagName.toUpperCase()=='INPUT'||d.tagName.toUpperCase()=='TEXTAREA'){   
                keyEvent=d.readOnly||d.disabled;   
            }else{   
                keyEvent=true;   
            }   
        }else{   
            keyEvent=false;   
        }   
        if(keyEvent){   
            e.preventDefault();   
        }
	});
});

/** 
 * 在页面中任何嵌套层次的窗口中获取顶层窗口 
 * @return 当前页面的顶层窗口对象 
 */
function getTopWinow(){  
   var p = window;  
   while(p != p.parent){  
       p = p.parent;  
   }  
   return p;  
}
/**
 * 判断是否登录
 */
function isLogin(){
	var id = "";
	$.ajax({
		type:'post',
    	url:'jc/getUserInfo.action',
    	dataType:'json',
    	async:false,
    	success:function(data){
    		if(data){
    			$("#userid").val(data.id);
    			$("#username").val(data.username);
    			id = data.id;
    		}
    	}
	});
	var id = $("#userid").val();
	if(id == "" || id == null ){
		document.execCommand("Stop");
		var top = getTopWinow(); //获取当前页面的顶层窗口对象
		if(top != window){
			$.messager.alert("操作提示","当前没有登录或登录已过期，请重新登录","error",function(){
				top.location.href = 'http://141.168.1.188:8080/management/login.html'; //跳转到登陆页面
			});
		}else{
			$.messager.alert("操作提示","当前没有登录或登录已过期，请重新登录","error",function(){
				top.location.href = 'http://141.168.1.188:8080/management/login.html'; //跳转到登陆页面
			});
		}
	}
} 

function getUserInfo(){
	
}

