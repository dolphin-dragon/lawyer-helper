package lawyer.base.ccase.service;

import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.page.BasePage;
import com.base.service.BaseService;
import lawyer.base.ccase.dao.CaseMInfoDao;

/**
 * <b>功能：</b>CaseMInfoService<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-04-11 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
@Service("caseMInfoService")
public class CaseMInfoService<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(CaseMInfoService.class);

	@Autowired
    private CaseMInfoDao<T> dao;

	public CaseMInfoDao<T> getDao() {
		return dao;
	}

	//query Entity List no page
	public List<T> queryList(BasePage page){
		return getDao().queryList(page);
	}
}