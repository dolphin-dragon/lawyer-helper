import com.law.client.zk.DossierManager;

DossierManager caseobj = null;

void initTabbox(){	
	caseobj = new DossierManager();
	caseobj.init(tabdossier);
}

void tabboxOnSelect(){
	//buildobj.treeOnSelect(tabobj);
}