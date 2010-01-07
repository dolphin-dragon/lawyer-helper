import com.law.client.zk.CaseManager;

CaseManager caseobj = null;

void initTabbox(){	
	caseobj = new CaseManager();
	caseobj.init(tabcase);
}

void tabboxOnSelect(){
	caseobj.treeOnSelect();
}