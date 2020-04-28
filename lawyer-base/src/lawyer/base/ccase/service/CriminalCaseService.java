package lawyer.base.ccase.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import lawyer.base.ccase.dao.CriminalCaseDao;

/**
 * <b>功能：</b>CriminalCaseService<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-04-28 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
@Service("criminalCaseService")
public class CriminalCaseService<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(CriminalCaseService.class);

	@Autowired
    private CriminalCaseDao<T> dao;

	public CriminalCaseDao<T> getDao() {
		return dao;
	}
}