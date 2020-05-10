package lawyer.base.ccase.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import lawyer.base.ccase.dao.NoLitigationCustomerDao;

/**
 * <b>功能：</b>NoLitigationCustomerService<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-10 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
@Service("noLitigationCustomerService")
public class NoLitigationCustomerService<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(NoLitigationCustomerService.class);

	@Autowired
    private NoLitigationCustomerDao<T> dao;

	public NoLitigationCustomerDao<T> getDao() {
		return dao;
	}
}