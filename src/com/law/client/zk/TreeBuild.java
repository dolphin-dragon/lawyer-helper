package com.law.client.zk;

import java.util.List;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Include;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;

import com.law.service.Service;

public class TreeBuild {
	private String[][] _strNode = null;
	private Tree treeObj = null;
	private String _USERID = "";
	private String _SYSID = "";
	private String[] _ROLES = null;
	private Service _ServiceOBJ = null;

	public TreeBuild() {
	}

	public void init(Tree tree) {
		this._USERID = (String) Sessions.getCurrent().getAttribute("USERID");
		this._SYSID = (String) Sessions.getCurrent().getAttribute("SYSID");
		this.treeObj = tree;
		this._strNode = MSG._strTreeNode;
		initTree();
	}

	private void initTree() {
		Treechildren treechildren = new Treechildren();

		for (int i = 0; i < _strNode[0].length; i++) {
			String codeIdStr = _strNode[0][i];// 节点ID
			String codeNameStr = MSG.getContent("NODENAME", codeIdStr);// 节点名称
			String srcStr = _strNode[1][i];// 节点连接

			Treeitem treeitem = new Treeitem(codeNameStr);
			treeitem.setId(codeIdStr);

			Treechildren tc = new Treechildren();
			tc.setParent(treeitem);
			treeitem.setParent(treechildren);
		}
		treechildren.setParent(this.treeObj);
	}

	public void treeOnSelect(Tabbox tabobj) {
		this._ServiceOBJ = new Service();

		Treeitem treeitem = this.treeObj.getSelectedItem();
		Treechildren treechildren = treeitem.getTreechildren();
		String itemIdStr = treeitem.getId();

		if (treechildren == null) {
			Tab tab = new Tab(treeitem.getLabel());
			tab.setClosable(true);
			tab.setParent(tabobj.getTabs());
			tabobj.setSelectedTab(tab);
			Tabpanel tabpanel = new Tabpanel();
			tabpanel.setParent(tabobj.getTabpanels());

//			if("RICHENG".equals(itemIdStr)){				
				Iframe iframe = new Iframe();
				iframe.setSrc(treeitem.getValue().toString());
				iframe.setHeight("100%");
				iframe.setWidth("100%");
				iframe.setParent(tabpanel);				
//			}else{
//				Include include = new Include();
//				include.setHeight("100%");
//				include.setWidth("100%");
//				include.setSrc(treeitem.getValue().toString());
//				include.setParent(tabpanel);						
//				
//			}
			return;
		}
		initChildren(itemIdStr, treechildren);
	}

	// 初始化子节点
	private void initChildren(String itemIdStr, Treechildren treechildren) {
		String[][] nodes = getChildren(itemIdStr);

		if (null != nodes && treechildren.getChildren().isEmpty()) {
			for (int i = 0; i < nodes[0].length; i++) {
				String codeIdStr = nodes[0][i];
				String codeNameStr = MSG.getContent("NODENAME", codeIdStr);
				String srcStr = nodes[1][i];
				Treeitem item = new Treeitem(codeNameStr);
				item.setId(codeIdStr);
				// if (i == 1) {
				// Treechildren tc = new Treechildren();
				// tc.setParent(item);
				// }else{
				item.setValue(srcStr);
				// }
				item.setParent(treechildren);
			}
		}
	}

	private String[][] getChildren(String treeId) {
		return MSG.getChildrenName(treeId);
	}

	private List<String[]> getActionsByRoles() {
		return this._ServiceOBJ.getRoleActions(this._SYSID, "");
	}
}
