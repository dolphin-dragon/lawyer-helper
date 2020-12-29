package lawyer.base.ccase.service;

import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import lawyer.base.ccase.dao.MeetingRoomInfoDao;

/**
 * <b>功能：</b>MeetingRoomInfoService<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-12-27 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
@Service("meetingRoomInfoService")
public class MeetingRoomInfoService<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(MeetingRoomInfoService.class);

	@Autowired
    private MeetingRoomInfoDao<T> dao;

	public MeetingRoomInfoDao<T> getDao() {
		return dao;
	}
	public List<T> listDatas(T t) throws Exception {
		return getDao().listDatas(t);
	}
}