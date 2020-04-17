package lawyer.base.ccase.dao;

import java.util.List;

import com.base.dao.BaseDao;
import com.base.page.BasePage;
/**
 * <b>功能：</b>CaseMInfoDao<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-04-11 <br>
 * <b>版权所有：<blawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public interface CaseMInfoDao<T> extends BaseDao<T> {
	//query Entity List no page
	public List<T> queryList(BasePage page);
}