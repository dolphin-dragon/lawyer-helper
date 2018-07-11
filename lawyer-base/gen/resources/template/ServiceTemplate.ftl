package ${bussPackage}.${entityPackage}.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import ${bussPackage}.${entityPackage}.dao.${className}Dao;

/**
 * <b>功能：</b>${className}Service<br>
 * <b>作者：</b>${author}<br>
 * <b>日期：</b> ${time} <br>
 * <b>版权所有：<b>${copyright}，${organization}<br>
 */
@Service("$!{lowerName}Service")
public class ${className}Service<T> extends BaseService<T> {
	private final Logger log= Logger.getLogger(${className}Service.class);

	@Autowired
    private ${className}Dao<T> dao;

	public ${className}Dao<T> getDao() {
		return dao;
	}
}