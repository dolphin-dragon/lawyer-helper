package lawyer.base.ccase.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import lawyer.base.ccase.dao.CasePreLitigationDao;

/**
 * <b>功能：</b>CasePreLitigationService<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
@Service("casePreLitigationService")
public class CasePreLitigationService<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(CasePreLitigationService.class);

	@Autowired
    private CasePreLitigationDao<T> dao;

	public CasePreLitigationDao<T> getDao() {
		return dao;
	}
}