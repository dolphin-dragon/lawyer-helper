$package('otter.lawCaseCloseStat');
otter.lawCaseCloseStat = function(){
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
  				title:'结案统计数据表',
	   			url:'dataList.do',
	   			toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btndelete',text:'删除',btnType:'remove'}
				],
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'ccode',title:'案件编号',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.ccode;
							}
						},
					{field:'plaintiff',title:'原告',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.plaintiff;
							}
						},
					{field:'defendant',title:'被告',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.defendant;
							}
						},
					{field:'close_type',title:'结案方式',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.closeType;
							}
						},
					{field:'close_date',title:'结案时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.closeDate;
							}
						},
					{field:'compensation_amont',title:'赔偿金额',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.compensationAmont;
							}
						},
					{field:'fair_fee',title:'公证费用',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.fairFee;
							}
						},
					{field:'travel_expenses',title:'差旅费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.travelExpenses;
							}
						},
					{field:'defendant_legal_fare',title:'被告负担诉费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.defendantLegalFare;
							}
						},
					{field:'advance_fair_fee',title:'实际垫付公证费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.advanceFairFee;
							}
						},
					{field:'advance_legal_fare',title:'实际垫付诉讼费/公告费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.advanceLegalFare;
							}
						},
					{field:'refund_fee',title:'应退诉费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.refundFee;
							}
						},
					{field:'return_fee',title:'实退诉费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.returnFee;
							}
						},
					{field:'cost_fair_fee',title:'公证费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.costFairFee;
							}
						},
					{field:'cost_legal_fare',title:'诉讼费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.costLegalFare;
							}
						},
					{field:'receive_due',title:'应收总计',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.receiveDue;
							}
						},
					{field:'receive_date',title:'到账时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.receiveDate;
							}
						},
					{field:'receive_account',title:'实收总计',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.receiveAccount;
							}
						},
					{field:'lawyer_pay_base',title:'律师费计算基数',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.lawyerPayBase;
							}
						},
					{field:'lawyer_pay',title:'总律师费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.lawyerPay;
							}
						},
					{field:'master_lawyer',title:'主办律师',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.masterLawyer;
							}
						},
					{field:'slave_lawyer_one',title:'协办律师1',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.slaveLawyerOne;
							}
						},
					{field:'slave_lawyer_two',title:'协办律师2',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.slaveLawyerTwo;
							}
						},
					{field:'slave_lawyer_three',title:'协办律师3',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.slaveLawyerThree;
							}
						},
					{field:'account_info',title:'账户信息',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.accountInfo;
							}
						},
					{field:'achievement',title:'绩效',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.achievement;
							}
						},
					{field:'due',title:'应支付给艺人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.due;
							}
						},
					{field:'cost',title:'成本回款',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.cost;
							}
						},
					{field:'ctype',title:'案件分类',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.ctype;
							}
						},
					{field:'provider',title:'线索人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.provider;
							}
						},
					{field:'provider_fee',title:'线索费',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.providerFee;
							}
						},
					{field:'create_by',title:'创建者',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createBy;
							}
						},
					{field:'create_date',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createDate;
							}
						},
					{field:'update_by',title:'更新者',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updateBy;
							}
						},
					{field:'update_date',title:'更新时间',align:'center',sortable:true,
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
								return row.delFlag;
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
	otter.lawCaseCloseStat.init();
});