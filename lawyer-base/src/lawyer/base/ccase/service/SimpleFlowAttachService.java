package lawyer.base.ccase.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import lawyer.base.ccase.dao.SimpleFlowAttachDao;

/**
 * <b>功能：</b>SimpleFlowAttachService<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-06 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
@Service("simpleFlowAttachService")
public class SimpleFlowAttachService<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(SimpleFlowAttachService.class);

	@Autowired
    private SimpleFlowAttachDao<T> dao;

	public SimpleFlowAttachDao<T> getDao() {
		return dao;
	}
}