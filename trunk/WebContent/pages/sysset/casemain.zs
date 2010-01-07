import com.law.client.zk.CaseManager;
import java.util.List;
import com.law.bean.CaseSource;
import java.util.Date;
import com.law.client.zk.Messagebox;
import com.law.service.CodeMessageService;
import com.law.bean.SysUser;
import org.zkoss.zul.Comboitem;


CaseManager dmobj = new CaseManager();
List caseLst = dmobj.getCaseSources();
//记录空行数
private int _iList = 0;
//记录是否是修改状态
private boolean _isUpdate = false;
//CaseSource对象
private CaseSource _caseSource = null;
//案源ID
private String _caseid = "";


public void initAddItem(){
	_iList = caseLst.size();
	// 如果节点不够10行，用空行补齐
	if(_iList < 10){
		int iRows = 10 - _iList;
		for (int i = 0; i < iRows; i++) {
			Listitem listitem = new Listitem();
			for (int j = 0; j < 7; j++) {
				Listcell listcell = new Listcell();				
				listcell.setParent(listitem);
			}
			listitem.setParent(winCaseMain.getFellow("box"));						
		}
		winCaseMain.getFellow("box").invalidate();
	}
}

//初始化案件类型
public void initCaseType(){
	List lst = dmobj.getCaseList(CodeMessageService.CODETYPE.AYTYPE.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);
		Comboitem comboitem = new Comboitem(str[1]);
		comboitem.setId(str[0]);
		comboitem.setParent(wincase.getFellow("cmbType"));
	}
}

//初始化案源方式
public void initCaseFS(){
	List lst = dmobj.getCaseList(CodeMessageService.CODETYPE.AJLYFS.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);
		Comboitem comboitem = new Comboitem(str[1]);
		comboitem.setId(str[0]);
		comboitem.setParent(wincase.getFellow("cmbFS"));
	}
}

//初始化案源提供者
public void initCaseTiGong(){
	List lst = dmobj.getSysUsers();
	for (int i = 0; i < lst.size(); i++) {
		SysUser sysobj = (SysUser)lst.get(i);
		Comboitem comboitem = new Comboitem(sysobj.getName());
		comboitem.setId(sysobj.get_ID());
		comboitem.setParent(wincase.getFellow("cmbTiGong"));
	}
}

void btnOK(){
	String caseid = wincase.getFellow("casecode").getValue();
	
	if(null == caseid || "".equals(caseid)){
		Messagebox.showExclamation("MSG", "111");
		return;
	}
	
	String parties = wincase.getFellow("parties").getValue();
	if(null == parties || "".equals(parties)){
		Messagebox.showExclamation("MSG", "112");
		return;
	}
	
	String cateType = wincase.getFellow("cmbType").getSelectedItem().getId();
	if(null == cateType || "".equals(cateType)){
		Messagebox.showExclamation("MSG", "113");
		return;
	}
	
	String strFs = wincase.getFellow("cmbFS").getSelectedItem().getId();
	if(null == strFs || "".equals(strFs)){
		Messagebox.showExclamation("MSG", "114");
		return;
	}
	
	String caseName = wincase.getFellow("txtCaseName").getValue();
	if(null == dossierName || "".equals(caseName)){
		Messagebox.showExclamation("MSG", "115");
		return;
	}
	
	String tigongStr = wincase.getFellow("cmbTiGong").getValue();
	Date dateJieAn = wincase.getFellow("dbJieAn").getValue();
	String dsc = wincase.getFellow("txtDsc").getValue();
	
	Map parmap = new HashMap();
	parmap.put("CASEID",caseid);
	parmap.put("PARTIES",parties);
	parmap.put("TYEP",cateType);
	parmap.put("FANGSHI",strFs);
	parmap.put("CASENAME",caseName);
	parmap.put("TIGONG",tigongStr);
	parmap.put("JIEANDATE",dateJieAn);
	parmap.put("DSC",dsc);
		
	if(!_isUpdate){//新建部门
		dmobj.addCase(parmap);
		CaseSource caseSourceObj = dmobj.getCaseSource();
		initWin();	
		addListbox(caseSourceObj);
	}else{//修改部门
		this._caseSource.setName(caseName);		
		this._caseSource.setContactType(cateType);
		this._caseSource.setDesc(dsc);
		this._caseSource.setEdate(dateJieAn);
		this._caseSource.setSdate(dateJieAn);
		this._caseSource.setContacterid(parties);
		this._caseSource.setProvider(tigongStr);

		dmobj.updateCase(this._caseSource);
		initWin();	
		updateListbos(winCaseMain.getFellow("box").getSelectedItem(),this._caseSource);
	}
	
	wincase.setVisible(false);
}

//添加一行记录
void addListbox(CaseSource caseSourceObj){
	Listitem li = null;
	if(_iList < 10){
		li = winCaseMain.getFellow("box").getItemAtIndex(_iList);
		li.setId(caseSourceObj.getId());
		updateListbos(li,caseSourceObj);
		_iList++;
	}else{
		li = new Listitem();
		li.setId(caseSourceObj.getId());				
		li.appendChild(new Listcell(caseSourceObj.getName()));//案源名称			
		li.appendChild(new Listcell(caseSourceObj.getContactType()));//分类
		li.appendChild(new Listcell(caseSourceObj.getEdate()));//建立时间	
		li.appendChild(new Listcell(caseSourceObj.getEdate()));//接案时间
		li.appendChild(new Listcell(caseSourceObj.getProvider()));//案源提供者
		li.appendChild(new Listcell(caseSourceObj.getDesc()));//案件描述
		
		winCaseMain.getFellow("box").appendChild(li);
	}		
}

//更新Listbox
void updateListbos(Listitem listitem,CaseSource caseSourceObj){
	try {
		List list = listitem.getChildren();
		
		for (int i = 0; i < list.size(); i++) {
			Listcell listcell = (Listcell)list.get(i);
			if(i==0){
				listcell.setLabel(caseSourceObj.getName());
			}else if(i==1){
				listcell.setLabel(caseSourceObj.getContactType());
			}else if(i==2){
				listcell.setLabel("" + caseSourceObj.getEdate());
			}else if(i==3){
				listcell.setLabel("" + caseSourceObj.getEdate());
			}else if(i==4){
				listcell.setLabel(caseSourceObj.getProvider());
			}else if(i==5){
				listcell.setLabel(caseSourceObj.getDesc());
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}	
}

public void update(){
	_isUpdate = true;
	_caseid = winCaseMain.getFellow("box").getSelectedItem().getId();
	_caseSource = dmobj.getCaseSource(_caseid);
		
	//设置案源编码
	wincase.getFellow("casecode").setValue(_caseSource.getId());
	//设置联系人
	wincase.getFellow("parties").setValue(_caseSource.getProviderid());
	//设置案源类型
	List lst = dmobj.getCaseList(CodeMessageService.CODETYPE.AYTYPE.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);
		if(str[0].equals(_caseSource.getContactType())){
			wincase.getFellow("cmbType").setSelectedIndex(i);
		}
	}	
	//设置案源来源方式
	List lst = dmobj.getCaseList(CodeMessageService.CODETYPE.AJLYFS.name());
	for (int i = 0; i < lst.size(); i++) {
		String[] str = (String[])lst.get(i);
		if(str[0].equals(_caseSource.getContactType())){
			wincase.getFellow("cmbFS").setSelectedIndex(i);
		}
	}
	//设置案源提供者
	List lst = dmobj.getSysUsers();
	String userStr = _caseSource.getProviderid();
	for (int i = 0; i < lst.size(); i++) {
		SysUser sysobj = (SysUser)lst.get(i);
		if(userStr.equals(sysobj.get_ID())){
			wincase.getFellow("cmbTiGong").setSelectedIndex(i);
		}
	}
	//设置案源创建时间
	wincase.getFellow("dbJieAn").setValue(_caseSource.getSdate());
	//设置案源名称
	wincase.getFellow("txtCaseName").setValue(_caseSource.getName());
	//设置案源名称
	wincase.getFellow("txtDsc").setValue(_caseSource.getDesc());
	
	wincase.doModal();
	isUpdate = false;
}

public void del(){
	try {
		if(winCaseMain.getFellow("box").getSelectedItem()==null){
			Messagebox.showExclamation("MSG", "124");
			return;
		}
		
		Messagebox.show("确认要删除这条案源吗？", "消息框", Messagebox.YES|Messagebox.NO,
				   Messagebox.QUESTION,
				   new EventListener() {
					public void onEvent(Event evt) {
						if ("onYes".equals(evt.getName())) {														
							String caseid = winCaseMain.getFellow("box").getSelectedItem().getId();
							dmobj.deleteCase(caseid);
							winCaseMain.getFellow("box").removeItemAt(winCaseMain.getFellow("box").getSelectedIndex());
							_iList--;
							if(_iList < 10){
								Listitem li = new Listitem();										
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

void btnCancle(){	
	initWin();
	wincase.setVisible(false);
}

private void initWin(){
	wincase.getFellow("casecode").setValue("");
	wincase.getFellow("parties").setValue("");
	wincase.getFellow("cmbType").setSelectedIndex(0);
	wincase.getFellow("cmbFS").setSelectedIndex(0);
	wincase.getFellow("cmbTiGong").setValue("");
	wincase.getFellow("dbJieAn").setValue(new Date());
	wincase.getFellow("txtCaseName").setValue("");
	wincase.getFellow("txtDsc").setValue("");
}