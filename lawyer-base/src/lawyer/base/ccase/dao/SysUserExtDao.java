package lawyer.base.ccase.dao;

import java.util.List;

import com.base.dao.BaseDao;
/**
 * <b>功能：</b>SysUserExtDao<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<blawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public interface SysUserExtDao<T> extends BaseDao<T> {
	public List<T> listDatas(T t);
}