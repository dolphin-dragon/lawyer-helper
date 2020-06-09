//TODO:可扩展参数传递进行上传文件类型过滤处理
function commonAjaxFileUploadDG(selfCallback) {
var html =
	'<div id="dg_upload" title="文件上传">'
	+ '	<form id="uploadForm" class="ui-form" method="post" enctype="multipart/form-data">'
	+ '		<div class="fitem">'
	+ '			<div class="fitem">'
	+ '  				<label>请选择上传文件：</label>'
	+ '     			<input type="file" id="upt_file" name="upt_file" style="width:300px;" />'
	+ '			</div>'
	+ '			<div class="fitem">'
	+ '				<label>存储路径：</label>'
	+ '				<input name="savePath" type="text" id="savePath" style="width:300px;" readonly=true />'
	+ '				<br/>'
	+ '				<label>请求路径：</label>'
	+ '    			<input name="webUrl" type="text" id="webUrl" style="width:300px;" readonly=true />'
	+ '			</div>'
	+ '			<div class="fitem">'
	+ '				<input type="button" id="uploadButton11" class="hidden" value="上传" />'
	+ '				<input type="button" id="upOkButton" class="hidden" value="确认" />'
	+ '			</div>'
	+ '		</div>'
	+ '	</form>'
	+ '</div>';

	var vdg = $("#dg_upload");
	if(null != vdg)
		$("#dg_upload").dialog('destroy');

	$("body").append(html);
	
	var dialog,
	dialog = $("#dg_upload").dialog({
      autoOpen: false,
      height: 160,
      width: 500,
      modal: true
    });
	
	 $('#upt_file').change(function(e){
		    // console.log($(this).val());//val()获取到的是完整的文件路径值；C:\fakepath\js-dom.png
		    console.log(e)
		    /*
		    简单的获取选择文件的名字
		    currentTarget:获取到的是绑定事件的对象
		    e.currentTarget.files 是一个数组，如果支持多个文件，则需要遍历
		    */
		    var fileMsg = e.currentTarget.files;
		    if(fileMsg != null || fileMsg!=''){
		    	$("#uploadButton11").show();
		    }
//		    var fileName = fileMsg[0].name;
//		    console.log(fileName);//js-dom.png
//		    //大小 字节 
//		    var fileSize = fileMsg[0].size;
//		    console.log(fileSize);//350061
//		    //类型 
//		    var fileType = fileMsg[0].type;
//		    console.log(fileType);//image/png
//		    // 判断文件类型
//		    var type=(fileType.substr(fileType.lastIndexOf("."))).toLowerCase();
//		    if(type!=".jpg"&&type!=".gif"&&type!=".jpeg"&& type!=".png"){
//		      alert("您上传图片的类型不符合(.jpg|.jpeg|.gif|.png)！");
//		       return false;
//		    }
//		    $('.inp_file_name').text(fileName)
		  })

	var obj = {}
	function uploadInfo(ldata){
		if(ldata.code == 1){
    		$("#savePath").val(ldata.savePath);
    		$("#webUrl").val(ldata.webUrl);
    		var f = document.getElementById('upt_file').files[0];
    		//名称  
    		var fname = f.name;  
    		//大小 字节  
    		var fsize = f.size;  
    		//类型  
    		var ftype = f.type; 
    		//文件扩展名
    		var ext=(fname.substr(fname.lastIndexOf("."))).toLowerCase();

    		ftype = (fname.substr(fname.lastIndexOf(".")+1)).toLowerCase();
    		
    		console.log("fname:"+fname+" fsize:"+fsize +" fext:"+ext);
    		
    		obj = {
    			path: ldata.savePath,
    			url: ldata.webUrl,
    			fname: fname,
    			fsize: fsize,
    			ftype: ftype,
    			fext : ext
    		}
    	}else{
    		alert(ldata.msg);
    	}
	}

    $("#uploadButton11").on('click',function(){
    	var upfile = $("#upt_file").val();
		if(upfile == null || upfile==''){
			alert('请选择上传的文件');
			return ;
		}else{
			commonAjaxFileUpload('upt_file',uploadInfo);
			$("#upOkButton").show()
		}
    })
    
  	 setTimeout(function (){
  	  	 $("#upOkButton").hide();
  		 $("#uploadForm").resetForm();
  	 }, 0)

	 $("#upOkButton").click(function () {
      	 $("#uploadForm").resetForm();
      	 dialog.dialog( "close" );
      	  $("#dg_upload").dialog('destroy');
      	 selfCallback(obj);
     });
}