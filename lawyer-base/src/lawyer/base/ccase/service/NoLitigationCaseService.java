package lawyer.base.ccase.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import lawyer.base.ccase.dao.NoLitigationCaseDao;

/**
 * <b>功能：</b>NoLitigationCaseService<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-04-28 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
@Service("noLitigationCaseService")
public class NoLitigationCaseService<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(NoLitigationCaseService.class);

	@Autowired
    private NoLitigationCaseDao<T> dao;

	public NoLitigationCaseDao<T> getDao() {
		return dao;
	}
}