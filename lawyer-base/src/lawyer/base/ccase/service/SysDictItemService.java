package lawyer.base.ccase.service;

import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import lawyer.base.ccase.dao.SysDictItemDao;

/**
 * <b>功能：</b>SysDictItemService<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-06 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
@Service("sysDictItemService")
public class SysDictItemService<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(SysDictItemService.class);

	@Autowired
    private SysDictItemDao<T> dao;

	public SysDictItemDao<T> getDao() {
		return dao;
	}
	
	public List<T> listItems(T t) throws Exception {
		return getDao().listItems(t);
	}
}