import com.law.client.zk.DossierManager;
import com.law.service.DossierService;
import com.law.service.Service;
import com.law.service.CodeMessageService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import com.law.bean.Dossier;


DossierManager dmobj = new DossierManager();
DossierService _DossierService = new DossierService();

//系统ID
private String _sysid = Service.getCurrentSessionLogin().getSysid();
//登录用户ID
private String _userid = Service.getCurrentSessionLogin().getUserid();

List dossierLst = dmobj.getDossisers();
//记录空行数
private int _iList = 0;
//记录是否是修改状态
private boolean _isUpdate = false;
//CaseSource对象
private Dossier _Dossier = null;
//案源ID
private String _dossierid = "";


public void initAddItem(){
	_iList = dossierLst.size();
	// 如果节点不够10行，用空行补齐
	if(_iList < 10){
		int iRows = 10 - _iList;
		for (int i = 0; i < iRows; i++) {
			Listitem listitem = new Listitem();
			for (int j = 0; j < 7; j++) {
				Listcell listcell = new Listcell();				
				listcell.setParent(listitem);
			}
			listitem.setParent(winDossierMain.getFellow("box"));						
		}
		winDossierMain.getFellow("box").invalidate();
	}
}

//初始化案卷状态
public void initDossierStatus(){
	List lst = dmobj.getDossierList(CodeMessageService.CODETYPE.AQZT.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);
		Comboitem comboitem = new Comboitem(str[1]);
		comboitem.setId(str[0]);
		comboitem.setParent(windossier.getFellow("STATUS"));
	}
}

//初始化收案方式
public void initShouAn(){
	List lst = dmobj.getDossierList(CodeMessageService.CODETYPE.AJLYFS.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);
		Comboitem comboitem = new Comboitem(str[1]);
		comboitem.setId(str[0]);
		comboitem.setParent(windossier.getFellow("SAFS"));
	}
}

//初始化案卷类型
public void initDossierType(){
	List lst = dmobj.getDossierList(CodeMessageService.CODETYPE.AYTYPE.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);
		Comboitem comboitem = new Comboitem(str[1]);
		comboitem.setId(str[0]);
		comboitem.setParent(windossier.getFellow("AJLX"));
	}
}

//初始化审理阶段
public void initJieDuan(){
	List lst = dmobj.getDossierList(CodeMessageService.CODETYPE.AJSJ.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);
		Comboitem comboitem = new Comboitem(str[1]);
		comboitem.setId(str[0]);
		comboitem.setParent(windossier.getFellow("SLJD"));
	}
}

//初始化当事人身份
public void initShenFen(){
	List lst = dmobj.getDossierList(CodeMessageService.CODETYPE.DSRSF.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);
		Comboitem comboitem = new Comboitem(str[1]);
		comboitem.setId(str[0]);
		comboitem.setParent(windossier.getFellow("DSRSF"));
	}
}

//初始化司法分类
public void initSiFa(){
	List lst = dmobj.getDossierList(CodeMessageService.CODETYPE.SFFL.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);		
		Comboitem comboitem = new Comboitem(str[1]);
		comboitem.setId(str[0]);
		comboitem.setParent(windossier.getFellow("SFFL"));
	}
}

void btnOK(){
	String dossierid = windossier.getFellow("DOSSIERCODE").getValue();	
	if(null == dossierid || "".equals(dossierid)){//校验案卷编号是否为空
		Messagebox.showExclamation("MSG", "125");
		windossier.getFellow("DOSSIERCODE").focus();
		return;
	}
	
	String dosName = windossier.getFellow("DOSSIERNAME").getValue();
	if(null == dosName || "".equals(dosName)){//校验案卷名称是否为空
		Messagebox.showExclamation("MSG", "126");
		windossier.getFellow("DOSSIERNAME").focus();
		return;
	}
	
	int iBiaodi = windossier.getFellow("BIAODI").getValue().intValue();//标的
//	String shoufeiFSStr = windossier.getFellow("FANGSHI").getSelectedItem()==null?"":windossier.getFellow("FANGSHI").getSelectedItem().getId();//收费方式
	int iAnyuanSF = windossier.getFellow("SHOUFEI").getValue().intValue();//案源收费
//	String biliStr = windossier.getFellow("BILI").getValue();//案源比例
	String statusStr = windossier.getFellow("STATUS").getSelectedItem()==null?"":windossier.getFellow("STATUS").getSelectedItem().getId();//案卷状态
	Date dateShouAn = windossier.getFellow("SHOUANRQ").getValue();//收案日期
	String typeStr = windossier.getFellow("AJLX").getSelectedItem()==null?"":windossier.getFellow("AJLX").getSelectedItem().getId();//案件类型
	String fangshiStr = windossier.getFellow("SAFS").getSelectedItem()==null?"":windossier.getFellow("SAFS").getSelectedItem().getId();//收案方式
	Date dateGuiDang = windossier.getFellow("GDRQ").getValue();//归档日期
	String dangshirenStr = windossier.getFellow("DSR").getValue();//当事人
	String jieduanStr = windossier.getFellow("SLJD").getSelectedItem()==null?"":windossier.getFellow("SLJD").getSelectedItem().getId();//审理阶段
	String shenfenStr = windossier.getFellow("DSRSF").getSelectedItem()==null?"":windossier.getFellow("DSRSF").getSelectedItem().getId();//当事人身份
	String yuanzhuStr = windossier.getFellow("FLYZ").getSelectedItem().getId();//法律援助
	String zhubanStr = windossier.getFellow("ZBLS").getValue();//主办律师
	String shewaiStr = windossier.getFellow("SW").getSelectedItem().getId();//是否涉外
	String xiebanStr = windossier.getFellow("XBLS").getValue();//协办律师
	String fenleiStr = windossier.getFellow("SFFL").getSelectedItem()==null?"":windossier.getFellow("SFFL").getSelectedItem().getId();//司法分类
	String anyouStr = windossier.getFellow("AY").getValue();//案由
	String anqingStr = windossier.getFellow("JBAQ").getValue();//基本案情	

	if(!_isUpdate){//新建部门
		Dossier dossierObj = this._DossierService.createDossier(this._sysid, dossierid, dosName);		
		dossierObj.setTaget(iBiaodi);
		dossierObj.setStatus(statusStr);
		dossierObj.seteDate(dateShouAn);
		dossierObj.setcDate(new Date());
		dossierObj.setType(typeStr);
		dossierObj.setAdmissionType(fangshiStr);
		dossierObj.setArchiveDate(dateGuiDang);
		dossierObj.setParty(dangshirenStr);
		dossierObj.setJudge(jieduanStr);
		dossierObj.setParty_status(shenfenStr);
		dossierObj.setIsaid(yuanzhuStr);
		dossierObj.setMlawyer(zhubanStr);
		dossierObj.setIsforeign(shewaiStr);
		dossierObj.setSlawyer(zhubanStr);
		dossierObj.setJudicialtype(fenleiStr);
		dossierObj.setBrief(anyouStr);
		dossierObj.setSummary(anqingStr);
				
		dmobj.addDossier(dossierObj);
		initWin();	
		addListbox(dossierObj);
	}else{//修改部门
		this._Dossiser.setCode(dossierid);
		this._Dossier.setTaget(iBiaodi);
		this._Dossier.setStatus(statusStr);
		this._Dossier.seteDate(dateShouAn);
		this._Dossier.setcDate(new Date());
		this._Dossier.setType(typeStr);
		this._Dossier.setAdmissionType(fangshiStr);
		this._Dossier.setArchiveDate(dateGuiDang);
		this._Dossier.setParty(dangshirenStr);
		this._Dossier.setJudge(jieduanStr);
		this._Dossier.setParty_status(shenfenStr);
		this._Dossier.setIsaid(yuanzhuStr);
		this._Dossier.setMlawyer(zhubanStr);
		this._Dossier.setIsforeign(shewaiStr);
		this._Dossier.setSlawyer(zhubanStr);
		this._Dossier.setJudicialtype(fenleiStr);
		this._Dossier.setBrief(anyouStr);
		this._Dossier.setSummary(anqingStr);

		dmobj.updateDossier(this._Dossier);
		initWin();	
		updateListbos(winDossierMain.getFellow("box").getSelectedItem(),this._Dossier);
	}
	
	windossier.setVisible(false);
}

//添加一行记录
private void addListbox(Dossier dossierObj){
	Listitem li = null;
	if(_iList < 10){
		li = winDossierMain.getFellow("box").getItemAtIndex(_iList);
		li.setId(dossierObj.getId());
		updateListbos(li,dossierObj);
		_iList++;
	}else{
		li = new Listitem();
		li.setId(dossierObj.getId());				
		li.appendChild(new Listcell(dossierObj.getId()));//案件编号		
		li.appendChild(new Listcell(dossierObj.getCode()));//案卷编号
		li.appendChild(new Listcell(dossierObj.getType()));//分类
		li.appendChild(new Listcell(dossierObj.getcDate()));//建立时间
		li.appendChild(new Listcell(dossierObj.getStatus()));//状态
		li.appendChild(new Listcell(dossierObj.getJudge()));//案件阶段
		li.appendChild(new Listcell("未设置"));//备注
		
		winDossierMain.getFellow("box").appendChild(li);
	}		
}

//更新Listbox
private void updateListbos(Listitem listitem,Dossier dossierObj){
	try {
		List list = listitem.getChildren();
		
		for (int i = 0; i < list.size(); i++) {
			Listcell listcell = (Listcell)list.get(i);
			if(i==0){
				listcell.setLabel(dossierObj.getId());
			}else if(i==1){
				listcell.setLabel(dossierObj.getCode());
			}else if(i==2){
				listcell.setLabel(dossierObj.getType());
			}else if(i==3){
				listcell.setLabel("" + dossierObj.getcDate());
			}else if(i==4){
				listcell.setLabel(dossierObj.getStatus());
			}else if(i==5){
				listcell.setLabel(dossierObj.getJudge());
			}else if(i==6){
				listcell.setLabel("未设置");
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}	
}

public void update(){
	_isUpdate = true;
	_dossierid = winDossierMain.getFellow("box").getSelectedItem().getId();
	_Dossier = dmobj.getDossierSource(_dossierid);
		
	//设置案卷编号
	windossier.getFellow("DOSSIERCODE").setValue(_Dossier.getCode());
	//设置案卷名称
	windossier.getFellow("DOSSIERNAME").setValue(_Dossier.getName());
	//案卷标的
	windossier.getFellow("BIAODI").setValue(BigDecimal.valueOf(_Dossier.getTaget()));
	//案源收费
	windossier.getFellow("SHOUFEI").setValue(BigDecimal.valueOf(_Dossier.getCharge()));
	//设置案卷状态
	List lst = dmobj.getDossierList(CodeMessageService.CODETYPE.AQZT.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);
		if(str[0].equals(_Dossier.getStatus())){
			windossier.getFellow("STATUS").setSelectedIndex(i);
		}
	}	
	//收案日期
	windossier.getFellow("SHOUANRQ").setValue(_Dossier.geteDate());	
	//设置案件类型
	List lst = dmobj.getDossierList(CodeMessageService.CODETYPE.AYTYPE.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);
		if(str[0].equals(_Dossier.getType())){
			windossier.getFellow("AJLX").setSelectedIndex(i);
		}
	}
	//设置收案方式
	List lst = dmobj.getDossierList(CodeMessageService.CODETYPE.AJLYFS.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);
		if(str[0].equals(_Dossier.getAdmissionType())){
			windossier.getFellow("SAFS").setSelectedIndex(i);
		}
	}
	//归档日期
	windossier.getFellow("GDRQ").setValue(_Dossier.getArchiveDate());	
	//当事人
	windossier.getFellow("DSR").setValue(_Dossier.getParty());
	//审理阶段
	List lst = dmobj.getDossierList(CodeMessageService.CODETYPE.AJSJ.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);
		if(str[0].equals(_Dossier.getJudge())){
			windossier.getFellow("SLJD").setSelectedIndex(i);
		}
	}
	//当事人身份
	List lst = dmobj.getDossierList(CodeMessageService.CODETYPE.DSRSF.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);
		if(str[0].equals(_Dossier.getParty_status())){
			windossier.getFellow("DSRSF").setSelectedIndex(i);
		}
	}
	//法律援助
	String status = _Dossier.getIsaid();
	if("01".equals(status)){
		windossier.getFellow("FLYZ").setSelectedIndex(0);
	}else{
		windossier.getFellow("FLYZ").setSelectedIndex(1);
	}
	//主办律师
	windossier.getFellow("ZBLS").setValue(_Dossier.getMlawyer());
	//是否涉外
	String shewai = _Dossier.getIsforeign();
	if("1".equals(shewai)){
		windossier.getFellow("SW").setSelectedIndex(0);
	}else{
		windossier.getFellow("SW").setSelectedIndex(1);
	}
	//协办律师
	windossier.getFellow("XBLS").setValue(_Dossier.getSlawyer());
	//司法分类
	List lst = dmobj.getDossierList(CodeMessageService.CODETYPE.SFFL.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);
		if(str[0].equals(_Dossier.getJudicialtype())){
			windossier.getFellow("SFFL").setSelectedIndex(i);
		}
	}
	//案由
	windossier.getFellow("AY").setValue(_Dossier.getBrief());
	//基本案情
	windossier.getFellow("JBAQ").setValue(_Dossier.getSummary());
	
	windossier.doModal();
	isUpdate = false;
}

public void del(){
	try {
		if(winDossierMain.getFellow("box").getSelectedItem()==null){
			Messagebox.showExclamation("MSG", "124");
			return;
		}
		
		Messagebox.show("确认要删除这条案卷吗？", "消息框", Messagebox.YES|Messagebox.NO,
				   Messagebox.QUESTION,
				   new EventListener() {
					public void onEvent(Event evt) {
						if ("onYes".equals(evt.getName())) {														
							String dossierid = winDossierMain.getFellow("box").getSelectedItem().getId();
							dmobj.deleteDossier(dossierid);
							winDossierMain.getFellow("box").removeItemAt(winDossierMain.getFellow("box").getSelectedIndex());
							_iList--;
							if(_iList < 10){
								Listitem li = new Listitem();										
								li.appendChild(new Listcell());		
								li.appendChild(new Listcell());
								li.appendChild(new Listcell());	
								li.appendChild(new Listcell());
								li.appendChild(new Listcell());
								li.appendChild(new Listcell());
								li.appendChild(new Listcell());
								winCaseMain.getFellow("box").appendChild(li);
							}
							winCaseMain.getFellow("box").invalidate();							
						}
					}
				   }
				);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void onUploadEvent(){
	
}

void btnCancle(){	
	initWin();
	windossier.setVisible(false);
}

public void btnAttCancle(){
	winAtt.setVisible(false);
}

void initWin(){
	windossier.getFellow("DOSSIERCODE").setValue("");
	windossier.getFellow("DOSSIERNAME").setValue("");
	windossier.getFellow("BIAODI").setValue(BigDecimal.valueOf(0.00));
//	windossier.getFellow("FANGSHI").setValue("");
	windossier.getFellow("SHOUFEI").setValue(BigDecimal.valueOf(0.00));
//	windossier.getFellow("BILI").setValue("");
	windossier.getFellow("STATUS").setValue("");
	windossier.getFellow("SHOUANRQ").setValue(new Date());
	windossier.getFellow("AJLX").setValue("");
	windossier.getFellow("SAFS").setValue("");
	windossier.getFellow("GDRQ").setValue(new Date());
	windossier.getFellow("DSR").setValue("");
	windossier.getFellow("SLJD").setValue("");
	windossier.getFellow("DSRSF").setValue("");
	windossier.getFellow("FLYZ").setSelectedIndex(0);
	windossier.getFellow("ZBLS").setValue("");
	windossier.getFellow("SW").setSelectedIndex(0);
	windossier.getFellow("XBLS").setValue("");
	windossier.getFellow("SFFL").setSelectedIndex(0);
	windossier.getFellow("AY").setValue("");
	windossier.getFellow("JBAQ").setValue("");
}