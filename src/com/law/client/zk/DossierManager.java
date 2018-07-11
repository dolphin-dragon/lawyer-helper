package com.law.client.zk;
import java.util.List;

import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Vbox;

import com.law.bean.Dossier;
import com.law.bean.Login;
import com.law.service.CodeMessageService;
import com.law.service.DossierService;
import com.law.service.Service;

public class DossierManager {
	private Tabbox tabcase = null;
	private static String[] _strnodes = null;	
	private DossierService _DossierService = null;
	private CodeMessageService _CodeMessageService = null;
	private String _sysid = "";
	private String _UserId = "";
	
	public DossierManager(){
		this._strnodes = MSG.getTabName();
		this._DossierService = new DossierService();
		this._CodeMessageService = CodeMessageService.getInstance();
		Login loginObj = Service.getCurrentSessionLogin();
		this._sysid = loginObj.getSysid();
		this._UserId = loginObj.getUserid();
	}
	
	public void init(Tabbox tabcase){
		this.tabcase = tabcase;
		initTabbox();
	}
	
	private void initTabbox(){
		initTabs();
		initTabpanels();
		initCases(this.tabcase.getSelectedPanel(), 1);
	}
	
	private void initTabs(){
		Tabs tabs = new Tabs();
		for (int i = 0; i < this._strnodes.length; i++) {
			Tab tab = new Tab(this._strnodes[i]);
			tab.setId("tab" + i);
			tab.setParent(tabs);
		}
		tabs.setParent(this.tabcase);
	}
	
	private void initTabpanels(){
		Tabpanels tabpanels = new Tabpanels();
		for (int i = 0; i < this._strnodes.length; i++) {
			Tabpanel tabpanel = new Tabpanel();
			tabpanel.setId("PANEL" + i);
			tabpanel.setParent(tabpanels);
		}
		tabpanels.setParent(this.tabcase);
		this.tabcase.setSelectedIndex(0);
	}
	
	/**
	 * ��tabpanel�ϼ��ذ�Դ�б�
	 */
	private void initCases(Tabpanel tabpanel, int day) {
		try {
			if (!tabpanel.getChildren().isEmpty()) {
				return;
			}
			Vbox vbox = new Vbox();
			List<Dossier> caseSourceList = this._DossierService
					.getDossiers(this._sysid, this._UserId, day);
			int lstSize = caseSourceList.size();

			for (int i = 0; i < lstSize; i++) {
				Dossier dossierSource = caseSourceList.get(i);
				Toolbarbutton toolbarbutton = new Toolbarbutton();

				toolbarbutton
						.setId(tabpanel.getId() + "_" + dossierSource.getId());
				toolbarbutton.setLabel(dossierSource.getName());
				toolbarbutton.setHref("");				
				toolbarbutton.setStyle("color:blue;");
				toolbarbutton.setParent(vbox);
			}
			// Div div=new Div();
			// div.setStyle("overflow-y:auto;height:100%;");
			// vbox.setParent(div);
			// div.setParent(tabpanel);
			
			vbox.setParent(tabpanel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ����˵����tabboxѡ���¼�
	 */
	public void treeOnSelect() {
		// ���ѡ�е�tab��ID
		String tabIdStr = this.tabcase.getSelectedTab().getId();
		// ���ѡ�е�Tabpanel����
		Tabpanel tabpanel = this.tabcase.getSelectedPanel();

		if ("tab0".equals(tabIdStr)) {
			initCases(tabpanel, 1);
		} else if ("tab1".equals(tabIdStr)) {
			initCases(tabpanel, 3);
		} else if ("tab2".equals(tabIdStr)) {
			initCases(tabpanel, 7);
		} else if ("tab3".equals(tabIdStr)) {
			initCases(tabpanel, 30);
		}
	}
	
	//�½���Դ
	public boolean addDossier(Dossier source){
		try {					
			return this._DossierService.updateDossier(source);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}
	//�޸İ�Դ
	public boolean updateDossier(Dossier source){
		return this._DossierService.updateDossier(source);
	}	
	//ɾ����Դ
	public boolean deleteDossier(String dossierid){
		return this._DossierService.deleteDossier(this._sysid,dossierid);
	}
	public List<String[]>  getDossierList(String type){
		return this._CodeMessageService.queryCatelogMessage(type, this._sysid);
	}
		
	public List<Dossier> getDossisers(){
		return this._DossierService.getUserDossier(this._sysid, this._UserId);
	}
	
	public Dossier getDossierSource(String dossierid){
		return this._DossierService.getDossier(this._sysid, dossierid);
	}
}
