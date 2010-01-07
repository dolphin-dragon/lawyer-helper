import java.util.Map;
import java.util.HashMap;
import com.law.client.zk.LoginManager;
import com.law.client.zk.Messagebox;

import java.util.List;

import org.zkoss.zul.Comboitem;

LoginManager loginObj = new LoginManager();
//String imgName = "login_bg.gif";
//DIVLOGIN.setAttribute("style","background-image:url('../images/login_bg.gif')");

void onLogin(){		
	String nameStr = winlogin.getFellow("txtName").getValue();
	String pwdStr = winlogin.getFellow("txtPwd").getValue();
	
	if ("".equals(nameStr.trim())) {
		Messagebox.showExclamation("MSG", "101");
		return;
	}

	if ("".equals(pwdStr.trim())) {
		Messagebox.showExclamation("MSG", "102");
		return;
	}
	
	if (null == winlogin.getFellow("sys").getSelectedItem()) {
		Messagebox.showExclamation("MSG", "118");
		return;
	}
	
	String sysidStr = winlogin.getFellow("sys").getSelectedItem().getId();
	Map parmap = new HashMap();
	parmap.put("USERID",nameStr);
	parmap.put("PWD",pwdStr);
	parmap.put("SYSID",sysidStr);
	loginObj.onLogin(parmap);	
}

public void initSysId(){
	List sysidStr = loginObj.getSysId();
	
	for (int i = 0; i < sysidStr.size(); i++) {
		String[][] sysidStr = (String[][])sysidStr.get(i);
		initItem(sysidStr);
	}
}

private void initItem(String[][] sysidStr){
	for (int i = 0; i < sysidStr[0].length; i++) {
		Comboitem comboitem = new Comboitem();
		comboitem.setId(sysidStr[i][0]);
		comboitem.setLabel(sysidStr[i][1]);
		comboitem.setParent(winlogin.getFellow("sys"));
	}
}