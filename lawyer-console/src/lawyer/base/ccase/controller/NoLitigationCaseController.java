package lawyer.base.ccase.controller;

import java.util.Arrays;
import java.util.Date;
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
import com.otter.entity.SysUser;
import com.base.util.HtmlUtil;
import com.base.util.SessionUtilsExt;

import lawyer.base.ccase.entity.NoLitigationCase;
import lawyer.base.ccase.entity.NoLitigationCustomer;
import lawyer.base.ccase.entity.SysDict;
import lawyer.base.ccase.page.NoLitigationCasePage;
import lawyer.base.ccase.service.NoLitigationCaseService;
import lawyer.base.ccase.service.NoLitigationCustomerService;
 
/**
 * <b>功能：</b>NoLitigationCaseController<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-10 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */ 
@Controller
@RequestMapping("/noLitigationCase") 
public class NoLitigationCaseController extends BaseAction{
	
	private final Logger log= Logger.getLogger(NoLitigationCaseController.class);
	/*********************************** generation code  start ***********************************/
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private NoLitigationCaseService<NoLitigationCase> noLitigationCaseService; 
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
	public ModelAndView  list(NoLitigationCasePage page,HttpServletRequest request) throws Exception{
		log.info("/noLitigationCase/list page :"+page+" request:"+request);
		
		Map<String,Object>  context = getRootMap();
		
		log.info("forword lawyer/base/ccase/noLitigationCase ---- context:"+Arrays.toString(context.entrySet().toArray()));
		return forword("lawyer/base/ccase/noLitigationCase",context); 
	}
	
	/**
	 * 说明：
	 * @param page
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(NoLitigationCasePage page,HttpServletResponse response) throws Exception{
		log.info("/noLitigationCase/dataList page :"+page+" response:"+response);
		SysUser user = SessionUtilsExt.getUser(request);
		if(!SessionUtilsExt.isAdmin(request)) {
			page.setCreatedBy(user.getId()+"");
			//page.setDelFlag("0");
		}
		List<NoLitigationCase> dataList = noLitigationCaseService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		
		log.info("/noLitigationCase/dataList writerJson ---- context:"+Arrays.toString(jsonMap.entrySet().toArray()));
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
	public void save(NoLitigationCase entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		SysUser user = SessionUtilsExt.getUser(request);
		String etype = request.getParameter("etype");
		log.info("/noLitigationCase/save entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" response:"+response);
		if(StringUtils.equals("0", etype)) {
			Integer cust_id = entity.getNolitigationCustomerId();
			if(null == cust_id) {
				NoLitigationCustomer cust = new NoLitigationCustomer();
				cust.setBillingModel(entity.getBillingModel());
				cust.setBillingStandard(entity.getBillingStandard());
				cust.setClient(entity.getClient());
				cust.setPrincipal(entity.getPrincipal());
				cust.setCommissionSdate(entity.getCommissionSdate());
				cust.setCommissionEdate(entity.getCommissionEdate());
				
				cust.setCreatedBy(user.getId()+"");
				cust.setCreatedTime(new Date());
				cust.setDelFlag("0");
				noLitigationCustomerService.add(cust);
				
			}else {
				NoLitigationCustomer cust = noLitigationCustomerService.queryById(entity.getNolitigationCustomerId());
				cust.setBillingModel(entity.getBillingModel());
				cust.setBillingStandard(entity.getBillingStandard());
				cust.setClient(entity.getClient());
				cust.setPrincipal(entity.getPrincipal());
				cust.setCommissionSdate(entity.getCommissionSdate());
				cust.setCommissionEdate(entity.getCommissionEdate());
				
				cust.setUpdatedBy(user.getId()+"");
				cust.setUpdatedTime(new Date());
				
				noLitigationCustomerService.update(cust);
			}
		}else {
			//Map<String,Object>  context = new HashMap<String,Object>();
			if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
				entity.setCreatedBy(user.getId()+"");
				entity.setCreatedTime(new Date());
				entity.setDelFlag("0");
				noLitigationCaseService.add(entity);
			}else{
				entity.setUpdatedBy(user.getId()+"");
				entity.setUpdatedTime(new Date());
				noLitigationCaseService.update(entity);
			}
		}
		log.info("/noLitigationCase/save sendSuccessMessage 保存成功~");
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
		log.info("/noLitigationCase/getId id :"+id+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		NoLitigationCase entity  = noLitigationCaseService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		
		log.info("/noLitigationCase/getId writerJson ---- context:"+Arrays.toString(context.entrySet().toArray()));
		HtmlUtil.writerJson(response, context);
	}
	
	@RequestMapping("/getCustId")
	public void getCustId(String id,HttpServletResponse response) throws Exception{
		log.info("/noLitigationCase/getId id :"+id+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		NoLitigationCustomer entity = noLitigationCustomerService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		
		log.info("/noLitigationCase/getId writerJson ---- context:"+Arrays.toString(context.entrySet().toArray()));
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
		String etype = request.getParameter("etype");
		log.info("/noLitigationCase/delete id :"+Arrays.toString(id)+" response:"+response);
		if(StringUtils.equals("0", etype)) {
			noLitigationCustomerService.delete(id);
		}else {
			noLitigationCaseService.delete(id);
		}
		log.info("/noLitigationCase/delete sendSuccessMessage 删除成功~");
		sendSuccessMessage(response, "删除成功");
	}
	/*********************************** generation code  end ***********************************/
}