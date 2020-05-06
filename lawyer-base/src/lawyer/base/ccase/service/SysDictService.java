package lawyer.base.ccase.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import lawyer.base.ccase.dao.SysDictDao;

/**
 * <b>功能：</b>SysDictService<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-06 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
@Service("sysDictService")
public class SysDictService<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(SysDictService.class);

	@Autowired
    private SysDictDao<T> dao;

	public SysDictDao<T> getDao() {
		return dao;
	}
}