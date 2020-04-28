$package('otter.arbitrationCase');
otter.arbitrationCase = function(){
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
  				title:'仲裁案件信息表',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'id',title:'序号',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.id;
						}
					},
					/*{field:'del_flag',title:'删除标记',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.delFlag;
							}
						},
					{field:'org',title:'机构编码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.org;
							}
						},
					{field:'created_by',title:'创建人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createdBy;
							}
						},
					{field:'created_time',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createdTime;
							}
						},
					{field:'updated_by',title:'更新人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updatedBy;
							}
						},
					{field:'updated_time',title:'更新时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updatedTime;
							}
						},*/
					{field:'src',title:'案件来源',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.src;
							}
						},
					{field:'supply',title:'案源人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.supply;
							}
						},
					{field:'litigant',title:'当事人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.litigant;
							}
						},
					{field:'cause',title:'案由',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cause;
							}
						},
					{field:'applicant',title:'申请人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.applicant;
							}
						},
					{field:'respondent',title:'被申请人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.respondent;
							}
						},
					{field:'request',title:'反请求状况',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.request;
							}
						},
					{field:'trust_date',title:'委托协议日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.trustDate;
							}
						},
					{field:'lawyer',title:'主办律师',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.lawyer;
							}
						},
					{field:'agent',title:'出庭代理人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.agent;
							}
						},
					{field:'chief_arbitrator',title:'首席仲裁员',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.chiefArbitrator;
							}
						},
					{field:'our_side',title:'我方边裁',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.ourSide;
							}
						},
					{field:'other_side',title:'对方边裁',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.otherSide;
							}
						},
					{field:'arb_secretary',title:'仲裁秘书',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.arbSecretary;
							}
						},
					{field:'secretary_contact',title:'仲裁秘书联系方式',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.secretaryContact;
							}
						},
					{field:'op_court_nums',title:'开庭次数',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.opCourtNums;
							}
						},
					{field:'op_court_date',title:'开庭日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.opCourtDate;
							}
						},
					{field:'clos_type',title:'结案方式',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.closType;
							}
						},
					{field:'status',title:'状态',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.status;
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
	otter.arbitrationCase.init();
});