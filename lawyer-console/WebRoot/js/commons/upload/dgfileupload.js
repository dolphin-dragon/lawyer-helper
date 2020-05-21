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
	+ '				<input type="button" id="uploadButton11" value="上传" />'
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

	var obj = {}
	function uploadInfo(ldata){
		if(ldata.code == 1){
    		$("#savePath").val(ldata.savePath);
    		$("#webUrl").val(ldata.webUrl);
    		var f = document.getElementById("upt_file").files;  
    		//名称  
    		var fname = f[0].name;  
    		//大小 字节  
    		var fsize = f[0].size;  
    		//类型  
    		var ftype = f[0].type; 
    		//文件扩展名
    		var ext=(fname.substr(fname.lastIndexOf("."))).toLowerCase()
    		
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