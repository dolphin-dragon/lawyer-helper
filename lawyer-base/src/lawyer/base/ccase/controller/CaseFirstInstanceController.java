package lawyer.base.ccase.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import lawyer.base.ccase.entity.CaseFirstInstance;
import lawyer.base.ccase.page.CaseFirstInstancePage;
import lawyer.base.ccase.service.CaseFirstInstanceService;
 
/**
 * <b>功能：</b>CaseFirstInstanceController<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */ 
@Controller
@RequestMapping("/caseFirstInstance") 
public class CaseFirstInstanceController extends BaseAction{
	
	private final Logger log= Logger.getLogger(CaseFirstInstanceController.class);
	/*********************************** generation code  start ***********************************/
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private CaseFirstInstanceService<CaseFirstInstance> caseFirstInstanceService; 
	
	/**
	 * 说明：
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(CaseFirstInstancePage page,HttpServletRequest request) throws Exception{
		log.info("/caseFirstInstance/list page :"+page+" request:"+request);
		
		Map<String,Object>  context = getRootMap();
		
		log.info("forword lawyer/base/ccase/caseFirstInstance ---- context:"+Arrays.toString(context.entrySet().toArray()));
		return forword("lawyer/base/ccase/caseFirstInstance",context); 
	}
	
	/**
	 * 说明：
	 * @param page
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(CaseFirstInstancePage page,HttpServletResponse response) throws Exception{
		log.info("/caseFirstInstance/dataList page :"+page+" response:"+response);
		
		List<CaseFirstInstance> dataList = caseFirstInstanceService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		
		log.info("/caseFirstInstance/dataList writerJson ---- context:"+Arrays.toString(jsonMap.entrySet().toArray()));
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
	public void save(CaseFirstInstance entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		log.info("/caseFirstInstance/save entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" response:"+response);
		
		//Map<String,Object>  context = new HashMap<String,Object>();
		if(entity.getCaseId()==null||StringUtils.isBlank(entity.getCaseId().toString())){
				caseFirstInstanceService.add(entity);
		}else{
			caseFirstInstanceService.update(entity);
		}
		
		log.info("/caseFirstInstance/save sendSuccessMessage 保存成功~");
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
		log.info("/caseFirstInstance/getId id :"+id+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		CaseFirstInstance entity  = caseFirstInstanceService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		
		log.info("/caseFirstInstance/getId writerJson ---- context:"+Arrays.toString(context.entrySet().toArray()));
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
		log.info("/caseFirstInstance/delete id :"+Arrays.toString(id)+" response:"+response);
		
		caseFirstInstanceService.delete(id);
		
		log.info("/caseFirstInstance/delete sendSuccessMessage 删除成功~");
		sendSuccessMessage(response, "删除成功");
	}
	/*********************************** generation code  end ***********************************/
}