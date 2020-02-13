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
import lawyer.base.ccase.entity.CaseApply;
import lawyer.base.ccase.page.CaseApplyPage;
import lawyer.base.ccase.service.CaseApplyService;
 
/**
 * <b>功能：</b>CaseApplyController<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */ 
@Controller
@RequestMapping("/caseApply") 
public class CaseApplyController extends BaseAction{
	
	private final Logger log= Logger.getLogger(CaseApplyController.class);
	/*********************************** generation code  start ***********************************/
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private CaseApplyService<CaseApply> caseApplyService; 
	
	/**
	 * 说明：
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(CaseApplyPage page,HttpServletRequest request) throws Exception{
		log.info("/caseApply/list page :"+page+" request:"+request);
		
		Map<String,Object>  context = getRootMap();
		
		log.info("forword lawyer/base/ccase/caseApply ---- context:"+Arrays.toString(context.entrySet().toArray()));
		return forword("lawyer/base/ccase/caseApply",context); 
	}
	
	/**
	 * 说明：
	 * @param page
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(CaseApplyPage page,HttpServletResponse response) throws Exception{
		log.info("/caseApply/dataList page :"+page+" response:"+response);
		
		List<CaseApply> dataList = caseApplyService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		
		log.info("/caseApply/dataList writerJson ---- context:"+Arrays.toString(jsonMap.entrySet().toArray()));
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
	public void save(CaseApply entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		log.info("/caseApply/save entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" response:"+response);
		
		//Map<String,Object>  context = new HashMap<String,Object>();
		if(entity.getCaseId()==null||StringUtils.isBlank(entity.getCaseId().toString())){
				caseApplyService.add(entity);
		}else{
			caseApplyService.update(entity);
		}
		
		log.info("/caseApply/save sendSuccessMessage 保存成功~");
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
		log.info("/caseApply/getId id :"+id+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		CaseApply entity  = caseApplyService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		
		log.info("/caseApply/getId writerJson ---- context:"+Arrays.toString(context.entrySet().toArray()));
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
		log.info("/caseApply/delete id :"+Arrays.toString(id)+" response:"+response);
		
		caseApplyService.delete(id);
		
		log.info("/caseApply/delete sendSuccessMessage 删除成功~");
		sendSuccessMessage(response, "删除成功");
	}
	/*********************************** generation code  end ***********************************/
}