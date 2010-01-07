import com.law.client.zk.OrgManager;
import com.law.client.zk.Messagebox;
import com.law.service.Service;


OrgManager _orgObj = new OrgManager();
private String _sysid = Service.getCurrentSessionLogin().getSysid();
List deptItems = _orgObj.getDepts(_sysid);
void cmbDeptSelected(){
	String deptId = winOrg.getFellow("cmbDept").getSelectedItem().getId();
	winOrg.getFellow("inlorglist").setSrc("sysset/orglist.zul?deptId="+deptId);
	winOrg.getFellow("inlorglist").invalidate();
}