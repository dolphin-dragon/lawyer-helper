$package('otter.lawCustomer');
otter.lawCustomer = function(){
	var _box = null;
	var _this = {
		config:{
			event:{
				add:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.add();
				},
				edit:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.edit();
				}
			},
  			dataGrid:{
  				title:'客户信息数据表',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'code',title:'客户编码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.code;
							}
						},
					{field:'name',title:'客户名称',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.name;
							}
						},
					{field:'ctype',title:'客户类别',align:'center',sortable:true,
							formatter:function(value,row,index){
								//return row.ctype;
								if(value == 0){
									return "个人";
								}
								if(value == 1){
									return "企业";
								}
								return "";
							}
						},
					{field:'id_card',title:'客户身份证信息',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.idCard;
							}
						},
					{field:'e_code',title:'企业组织机构代码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.eCode;
							}
						},
					{field:'phone',title:'联系电话',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.phone;
							}
						},
					{field:'linkman',title:'联系人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.linkman;
							}
						},
/*					{field:'create_by',title:'创建者ID',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createBy;
							}
						},*/
					{field:'create_name',title:'创建人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createName;
							}
						},
					{field:'create_date',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createDate;
							}
						},
/*					{field:'update_by',title:'修改人ID',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updateBy;
							}
						},*/
					{field:'update_name',title:'修改人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updateName;
							}
						},
					{field:'update_date',title:'修改时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updateDate;
							}
						},
					{field:'remarks',title:'备注信息',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.remarks;
							}
						},
					{field:'del_flag',title:'删除标记',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 0){
									return "有效";
								}
								if(value == 1){
									return "删除";
								}
								return "有效";
							}
						},
					]]
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

$(function(){
	otter.lawCustomer.init();
});