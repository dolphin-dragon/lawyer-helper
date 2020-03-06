package lawyer.base.ccase.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.util.HtmlUtil;
import com.base.util.SessionUtilsExt;
import com.base.web.BaseAction;
import com.otter.entity.SysUser;

import lawyer.base.ccase.entity.CaseFirstInstance;
import lawyer.base.ccase.entity.CaseInfo;
import lawyer.base.ccase.page.CaseFirstInstancePage;
import lawyer.base.ccase.service.CaseFirstInstanceService;
import lawyer.base.ccase.service.CaseInfoService;
 
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
	@Autowired(required=false)
	private CaseInfoService<CaseInfo> caseInfoService;
	
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
		
		SysUser user = SessionUtilsExt.getUser(request);
		if(entity.getCaseId()==null||StringUtils.isBlank(entity.getCaseId().toString())){
			sendFailureMessage(response, "没有找到对应的案件登记信息!");
			return;
		}else{
			CaseInfo caseInfo = caseInfoService.queryById(entity.getCaseId());
			caseInfo.setUpdatedBy(null!=user?user.getId()+"":"");
			caseInfo.setUpdatedTime(new Date());
			caseInfoService.update(caseInfo);
			
			entity.setUpdatedBy(null!=user?user.getId()+"":"");
			entity.setUpdatedTime(new Date());
			caseFirstInstanceService.update(entity);
		}
		
		log.info("/caseFirstInstance/save sendSuccessMessage 保存成功~");
		sendSuccessMessage(response, "保存成功~");
	}
	
	/**
	 * 说明：
	 * @param caseId
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/getId")
	public void getId(String caseId,HttpServletResponse response) throws Exception{
		log.info("/caseFirstInstance/getId id :"+caseId+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		CaseFirstInstance entity  = caseFirstInstanceService.queryById(caseId);
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
	
	@RequestMapping("/pushNext")
	public void pushNext(CaseFirstInstance entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		log.info("/caseFirstInstance/pushNext entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" response:"+response);
		//查询当前案件信息
		CaseFirstInstance dbentity  = caseFirstInstanceService.queryById(entity.getCaseId());
		//进行案件信息检查
		boolean checkstatus =false;
		
		//信息检查未通过
		if(checkstatus) {
			sendFailureMessage(response, "案件推进异常，请检查案件信息是否完整!");
			return;			
		}
		log.info("/caseFirstInstance/pushNext sendSuccessMessage 推进成功~");
		sendSuccessMessage(response, "推进成功~");
	}
}