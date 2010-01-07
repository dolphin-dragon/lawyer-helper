
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.law.client.zk.TreeBuild;
import com.law.client.zk.LoginManager;

TreeBuild buildobj = null;

//判断是否已经登录
LoginManager loginObj = new LoginManager();
if(!loginObj.isLogined()){
	Executions.sendRedirect("../pages/login.zul");
	return;
}

public void initDate(){
	SimpleDateFormat sdfV = new SimpleDateFormat("yyyy年MM月dd日 EEEE", Locale.CHINA);		
	
	Calendar c = java.util.Calendar.getInstance();
	String[] str = sdfV.format(c.getTime()).split(" ");
	
	today.setValue(str[0]);
	week.setValue(str[1]);
}

void initTree() {	
	buildobj = new TreeBuild();	
	buildobj.init(tree);
}

void treeOnSelect() {	
	buildobj.treeOnSelect(tabbox);
}
