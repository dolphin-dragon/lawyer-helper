package lawyer.base.ccase.service;

import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.page.BasePage;
import com.base.service.BaseService;
import lawyer.base.ccase.dao.SysUserExtDao;

/**
 * <b>功能：</b>SysUserExtService<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
@Service("sysUserExtService")
public class SysUserExtService<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(SysUserExtService.class);

	@Autowired
    private SysUserExtDao<T> dao;

	public SysUserExtDao<T> getDao() {
		return dao;
	}
	
	public List<T> listDatas(T t) throws Exception {
		return getDao().listDatas(t);
	}
}