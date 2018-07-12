package lawyer.base.ccase.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import lawyer.base.ccase.dao.LawCaseLegalDao;

/**
 * <b>功能：</b>LawCaseLegalService<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2018-07-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
@Service("lawCaseLegalService")
public class LawCaseLegalService<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(LawCaseLegalService.class);

	@Autowired
    private LawCaseLegalDao<T> dao;

	public LawCaseLegalDao<T> getDao() {
		return dao;
	}
}