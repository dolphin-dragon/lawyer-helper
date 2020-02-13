package lawyer.base.ccase.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import lawyer.base.ccase.dao.CaseApplyDao;

/**
 * <b>功能：</b>CaseApplyService<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
@Service("caseApplyService")
public class CaseApplyService<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(CaseApplyService.class);

	@Autowired
    private CaseApplyDao<T> dao;

	public CaseApplyDao<T> getDao() {
		return dao;
	}
}