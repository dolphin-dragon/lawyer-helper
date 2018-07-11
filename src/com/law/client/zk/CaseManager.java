package com.law.client.zk;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Vbox;

import com.law.bean.CaseSource;
import com.law.bean.Login;
import com.law.bean.SysUser;
import com.law.service.CaseSourceService;
import com.law.service.CodeMessageService;
import com.law.service.Service;
import com.law.service.SysUserService;

public class CaseManager {
	private Tabbox tabcase = null;
	private static String[] _strnodes = null;
	private CaseSourceService _CaseSourceService = null;
	private CodeMessageService _CodeMessageService = null;
	private SysUserService _SysUserService = null;
	private CaseSource _caseSource = null;
	private String _sysid = "";
	private String _UserId = "";
	private String _caseid = "";
	private String _partiesStr = "";
	private String _personStr = "";
	private String _casenameStr = "";
	private String _tigongStr = "";
	private String _typeStr = "";
	private Date _jieanl = null;
	private String _dscStr = "";

	public CaseManager() {
		this._strnodes = MSG.getTabName();
		this._CaseSourceService = new CaseSourceService();
		this._CodeMessageService = CodeMessageService.getInstance();
		this._SysUserService = new SysUserService();
		Login loginObj = Service.getCurrentSessionLogin();
		this._sysid = loginObj.getSysid();
		this._UserId = loginObj.getUserid();
	}

	public void init(Tabbox tabcase) {
		this.tabcase = tabcase;
		initTabbox();
	}

	private void initTabbox() {
		initTabs();
		initTabpanels();
		initCases(this.tabcase.getSelectedPanel(), 1);
	}

	private void initTabs() {
		Tabs tabs = new Tabs();
		for (int i = 0; i < this._strnodes.length; i++) {
			Tab tab = new Tab(this._strnodes[i]);
			tab.setId("tab" + i);
			tab.setParent(tabs);
		}
		tabs.setParent(this.tabcase);
	}

	private void initTabpanels() {
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
			List<CaseSource> caseSourceList = this._CaseSourceService
					.getCaseSource(this._UserId, day);
			int lstSize = caseSourceList.size();

			for (int i = 0; i < lstSize; i++) {
				CaseSource caseSource = caseSourceList.get(i);
				Toolbarbutton toolbarbutton = new Toolbarbutton();

				toolbarbutton
						.setId(tabpanel.getId() + "_" + caseSource.getId());
				toolbarbutton.setLabel(caseSource.getName());
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

	// �½���Դ
	public void addCase(HashMap parmap) {
		initInfo(parmap);
		setCaseInfo();
	}

	public boolean updateCase(CaseSource source) {
		try {
			return this._CaseSourceService.updateCaseSource(source);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCase(String caseid) {
		return this._CaseSourceService.deleteCaseSource(this._sysid, caseid);
	}

	private void setCaseInfo() {
		try {
			this._caseSource = this._CaseSourceService.createNewCaseSoruce(
					this._sysid, this._casenameStr, this._UserId);
			this._caseSource.setType(_typeStr);
			this._caseSource.setContactType(_typeStr);
			this._caseSource.setDesc(_dscStr);
			this._caseSource.setEdate(_jieanl);
			this._caseSource.setSdate(_jieanl);
			this._caseSource.setContacterid(this._tigongStr);
			// this._caseSource.setProviderid(this._tigongStr);
			this._caseSource.setProviderid(this._UserId);
			this._CaseSourceService.updateCaseSource(this._caseSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initInfo(HashMap parmap) {
		this._caseid = parmap.get("CASEID") == null ? "" : (String) parmap
				.get("CASEID");
		this._partiesStr = parmap.get("PARTIES") == null ? "" : (String) parmap
				.get("PARTIES");
		this._typeStr = parmap.get("TYEP") == null ? "" : (String) parmap
				.get("TYEP");
		this._personStr = parmap.get("FANGSHI") == null ? "" : (String) parmap
				.get("FANGSHI");
		this._casenameStr = parmap.get("CASENAME") == null ? ""
				: (String) parmap.get("CASENAME");
		this._tigongStr = parmap.get("TIGONG") == null ? "" : (String) parmap
				.get("TIGONG");
		this._jieanl = (Date) parmap.get("JIEANDATE");
		this._dscStr = parmap.get("DSC") == null ? "" : (String) parmap
				.get("DSC");
	}

	public CaseSource getCaseSource() {
		return this._caseSource;
	}

	/**
	 * ����˵��������Case��ID���CaseSource����һ���޸�ʱ����ѡ��ļ�¼��ö���
	 * 
	 * @param caseSourceID
	 * @return
	 */
	public CaseSource getCaseSource(String caseSourceID) {
		return this._CaseSourceService.getCaseSource(this._sysid, caseSourceID);
	}

	public List<CaseSource> getCaseSources() {
		return this._CaseSourceService.getCaseSources(this._UserId);
	}

	public List<String[]> getCaseList(String type) {
		return this._CodeMessageService.queryCatelogMessage(type, this._sysid);
	}

	public List<SysUser> getSysUsers() {
		return this._SysUserService.getSystemUser(this._sysid);
	}
}
