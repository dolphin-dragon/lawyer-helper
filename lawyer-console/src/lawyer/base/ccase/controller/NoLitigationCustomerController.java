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
import lawyer.base.ccase.entity.NoLitigationCustomer;
import lawyer.base.ccase.page.NoLitigationCustomerPage;
import lawyer.base.ccase.service.NoLitigationCustomerService;
 
/**
 * <b>功能：</b>NoLitigationCustomerController<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-10 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */ 
@Controller
@RequestMapping("/noLitigationCustomer") 
public class NoLitigationCustomerController extends BaseAction{
	
	private final Logger log= Logger.getLogger(NoLitigationCustomerController.class);
	/*********************************** generation code  start ***********************************/
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private NoLitigationCustomerService<NoLitigationCustomer> noLitigationCustomerService; 
	
	/**
	 * 说明：
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(NoLitigationCustomerPage page,HttpServletRequest request) throws Exception{
		log.info("/noLitigationCustomer/list page :"+page+" request:"+request);
		
		Map<String,Object>  context = getRootMap();
		
		log.info("forword lawyer/base/ccase/noLitigationCustomer ---- context:"+Arrays.toString(context.entrySet().toArray()));
		return forword("lawyer/base/ccase/noLitigationCustomer",context); 
	}
	
	/**
	 * 说明：
	 * @param page
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(NoLitigationCustomerPage page,HttpServletResponse response) throws Exception{
		log.info("/noLitigationCustomer/dataList page :"+page+" response:"+response);
		
		List<NoLitigationCustomer> dataList = noLitigationCustomerService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		
		log.info("/noLitigationCustomer/dataList writerJson ---- context:"+Arrays.toString(jsonMap.entrySet().toArray()));
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
	public void save(NoLitigationCustomer entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		log.info("/noLitigationCustomer/save entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" response:"+response);
		
		//Map<String,Object>  context = new HashMap<String,Object>();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
				noLitigationCustomerService.add(entity);
		}else{
			noLitigationCustomerService.update(entity);
		}
		
		log.info("/noLitigationCustomer/save sendSuccessMessage 保存成功~");
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
		log.info("/noLitigationCustomer/getId id :"+id+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		NoLitigationCustomer entity  = noLitigationCustomerService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		
		log.info("/noLitigationCustomer/getId writerJson ---- context:"+Arrays.toString(context.entrySet().toArray()));
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
		log.info("/noLitigationCustomer/delete id :"+Arrays.toString(id)+" response:"+response);
		
		noLitigationCustomerService.delete(id);
		
		log.info("/noLitigationCustomer/delete sendSuccessMessage 删除成功~");
		sendSuccessMessage(response, "删除成功");
	}
	/*********************************** generation code  end ***********************************/
}