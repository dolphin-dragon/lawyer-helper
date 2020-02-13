package lawyer.base.ccase.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import lawyer.base.ccase.dao.CaseInfoDao;

/**
 * <b>功能：</b>CaseInfoService<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
@Service("caseInfoService")
public class CaseInfoService<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(CaseInfoService.class);

	@Autowired
    private CaseInfoDao<T> dao;

	public CaseInfoDao<T> getDao() {
		return dao;
	}
}