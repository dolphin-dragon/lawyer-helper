function commonAjaxFileUpload(fileElementId,selfCallback) {
    $.ajaxFileUpload({
        url: urls.msUrl + '/commonUpload/fileUpload.do',
        secureuri: false, //是否需要安全协议，一般设置为false
        fileElementId: fileElementId, //文件上传的ID
        dataType: 'JSON', //返回值类型
        success: function (data, status) {
        	//var ldata = data.substring(data.indexOf('{'),data.lastIndexOf('}')+1);
        	var ldata = $.parseJSON(data);
        	selfCallback(ldata);
        },
        error: function (data, status, e)//服务器响应失败处理函数
        {
            alert(e);
        }
    });
    return false;
}

function formAjaxFileUpload(fdata,selfCallback) {
    $.ajax({
        url: urls.msUrl + '/commonUpload/fileUpload.do',
        secureuri: false, //是否需要安全协议，一般设置为false
        //fileElementId: fileElementId, //文件上传的ID
        dataType: 'JSON', //返回值类型
        type: 'POST',
        data : fdata,
        // 告诉jQuery不要去处理发送的数据
        processData : false,                 
        // 告诉jQuery不要去设置Content-Type请求头
        contentType : false,
        async : false,
        success: function (data, status) {
        	//var ldata = data.substring(data.indexOf('{'),data.lastIndexOf('}')+1);
        	var ldata = $.parseJSON(data);
        	selfCallback(ldata);
        },
        error: function (data, status, e)//服务器响应失败处理函数
        {
            alert(e);
        }
    });
    return false;
}