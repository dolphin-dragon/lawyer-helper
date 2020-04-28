package lawyer.base.ccase.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import lawyer.base.ccase.dao.ArbitrationCaseDao;

/**
 * <b>功能：</b>ArbitrationCaseService<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-04-28 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
@Service("arbitrationCaseService")
public class ArbitrationCaseService<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(ArbitrationCaseService.class);

	@Autowired
    private ArbitrationCaseDao<T> dao;

	public ArbitrationCaseDao<T> getDao() {
		return dao;
	}
}