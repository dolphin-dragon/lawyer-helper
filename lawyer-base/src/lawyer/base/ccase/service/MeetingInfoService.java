package lawyer.base.ccase.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import lawyer.base.ccase.dao.MeetingInfoDao;

/**
 * <b>功能：</b>MeetingInfoService<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-12-27 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
@Service("meetingInfoService")
public class MeetingInfoService<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(MeetingInfoService.class);

	@Autowired
    private MeetingInfoDao<T> dao;

	public MeetingInfoDao<T> getDao() {
		return dao;
	}
}