package ${bussPackage}.${entityPackage}.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
#if ($keyType =='01')
import java.util.UUID;
#end

import org.apache.commons.lang.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.web.BaseAction;
import com.base.util.HtmlUtil;
import com.base.util.SessionUtilsExt;
import ${bussPackage}.${entityPackage}.entity.${className};
import ${bussPackage}.${entityPackage}.page.${className}Page;
import ${bussPackage}.${entityPackage}.service.${className}Service;
 
/**
 * <b>功能：</b>${className}Controller<br>
 * <b>作者：</b>${author}<br>
 * <b>日期：</b> ${time} <br>
 * <b>版权所有：<b>${copyright}，${organization}<br>
 */ 
@Controller
@RequestMapping("/${lowerName}") 
public class ${className}Controller extends BaseAction{
	
	private final Logger log= Logger.getLogger(${className}Controller.class);
	/*********************************** generation code  start ***********************************/
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private ${className}Service<${className}> ${lowerName}Service; 
	
	/**
	 * 说明：
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(${className}Page page,HttpServletRequest request) throws Exception{
		log.info("/${lowerName}/list page :"+page+" request:"+request);
		
		Map<String,Object>  context = getRootMap();
		
		log.info("forword ${bussPackageWebPath}/${entityPackageWebPath}/${lowerName} ---- context:"+Arrays.toString(context.entrySet().toArray()));
		return forword("${bussPackageWebPath}/${entityPackageWebPath}/${lowerName}",context); 
	}
	
	/**
	 * 说明：
	 * @param page
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(${className}Page page,HttpServletResponse response) throws Exception{
		log.info("/${lowerName}/dataList page :"+page+" response:"+response);
		//超级管理员可查看删除数据
		SysUser user = SessionUtilsExt.getUser(request);
		if(!SessionUtilsExt.isAdmin(request)) {
			page.setCreatedBy(user.getId()+"");
			page.setDelFlag("0");
		}
		List<${className}> dataList = ${lowerName}Service.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		
		log.info("/${lowerName}/dataList writerJson ---- context:"+Arrays.toString(jsonMap.entrySet().toArray()));
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 说明：添加或修改数据
	 * @param entity
	 * @param typeIds
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public void save(${className} entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		log.info("/${lowerName}/save entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" response:"+response);
		
		//Map<String,Object>  context = new HashMap<String,Object>();
		SysUser user = SessionUtilsExt.getUser(request);
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
	#if ($keyType =='01')
		entity.setId(UUID.randomUUID().toString());
	#end
			entity.setCreatedBy(null!=user?user.getId()+"":"");
			entity.setCreatedTime(new Date());
			entity.setUpdatedBy(null!=user?user.getId()+"":"");
			entity.setUpdatedTime(new Date());
			${lowerName}Service.add(entity);
		}else{
			entity.setUpdatedBy(null!=user?user.getId()+"":"");
			entity.setUpdatedTime(new Date());
			${lowerName}Service.update(entity);
		}
		
		log.info("/${lowerName}/save sendSuccessMessage 保存成功~");
		sendSuccessMessage(response, "保存成功~");
	}
	
	/**
	 * 说明：
	 * @param id
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/getId")
	public void getId(String id,HttpServletResponse response) throws Exception{
		log.info("/${lowerName}/getId id :"+id+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		${className} entity  = ${lowerName}Service.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		
		log.info("/${lowerName}/getId writerJson ---- context:"+Arrays.toString(context.entrySet().toArray()));
		HtmlUtil.writerJson(response, context);
	}
	
	/**
	 * 说明：
	 * @param id
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/delete")
	public void delete(String[] id,HttpServletResponse response) throws Exception{
		log.info("/${lowerName}/delete id :"+Arrays.toString(id)+" response:"+response);
		
		${lowerName}Service.delete(id);
		
		log.info("/${lowerName}/delete sendSuccessMessage 删除成功~");
		sendSuccessMessage(response, "删除成功");
	}
	/*********************************** generation code  end ***********************************/
}