package lawyer.base.ccase.dao;

import java.util.List;

import com.base.dao.BaseDao;
/**
 * <b>功能：</b>MeetingRoomInfoDao<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-12-27 <br>
 * <b>版权所有：<blawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public interface MeetingRoomInfoDao<T> extends BaseDao<T> {
	public List<T> listDatas(T t);
}