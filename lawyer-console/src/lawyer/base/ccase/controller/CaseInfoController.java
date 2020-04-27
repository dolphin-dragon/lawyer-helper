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

import lawyer.base.ccase.entity.CaseApply;
import lawyer.base.ccase.entity.CaseCarryOut;
import lawyer.base.ccase.entity.CaseFirstInstance;
import lawyer.base.ccase.entity.CaseInfo;
import lawyer.base.ccase.entity.CasePreLitigation;
import lawyer.base.ccase.entity.CaseSecondInstance;
import lawyer.base.ccase.page.CaseInfoPage;
import lawyer.base.ccase.service.CaseApplyService;
import lawyer.base.ccase.service.CaseCarryOutService;
import lawyer.base.ccase.service.CaseFirstInstanceService;
import lawyer.base.ccase.service.CaseInfoService;
import lawyer.base.ccase.service.CasePreLitigationService;
import lawyer.base.ccase.service.CaseSecondInstanceService;
 
/**
 * <b>功能：</b>CaseInfoController<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-02-12 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */ 
@Controller
@RequestMapping("/caseInfo") 
public class CaseInfoController extends BaseAction{
	
	private final Logger log= Logger.getLogger(CaseInfoController.class);
	/*********************************** generation code  start ***********************************/
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private CaseInfoService<CaseInfo> caseInfoService; 
	
	/**
	 * 说明：
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(CaseInfoPage page,HttpServletRequest request) throws Exception{
		log.info("/caseInfo/list page :"+page+" request:"+request);
		
		Map<String,Object>  context = getRootMap();
		
		log.info("forword lawyer/base/ccase/caseInfo ---- context:"+Arrays.toString(context.entrySet().toArray()));
		return forword("lawyer/base/ccase/caseInfo",context); 
	}
	
	/**
	 * 说明：
	 * @param page
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(CaseInfoPage page,HttpServletResponse response) throws Exception{
		log.info("/caseInfo/dataList page :"+page+" response:"+response);
		SysUser user = SessionUtilsExt.getUser(request);
		if(!SessionUtilsExt.isAdmin(request)) {
			page.setCreatedBy(user.getId()+"");
			page.setDelFlag("0");
		}
		
		List<CaseInfo> dataList = caseInfoService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		
		log.info("/caseInfo/dataList writerJson ---- context:"+Arrays.toString(jsonMap.entrySet().toArray()));
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
	public void save(CaseInfo entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		log.info("/caseInfo/save entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" response:"+response);
		
		//Map<String,Object>  context = new HashMap<String,Object>();
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
				caseInfoService.add(entity);
		}else{
			caseInfoService.update(entity);
		}
		
		log.info("/caseInfo/save sendSuccessMessage 保存成功~");
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
		log.info("/caseInfo/getId id :"+id+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		CaseInfo entity  = caseInfoService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		
		log.info("/caseInfo/getId writerJson ---- context:"+Arrays.toString(context.entrySet().toArray()));
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
		log.info("/caseInfo/delete id :"+Arrays.toString(id)+" response:"+response);
		
		caseInfoService.delete(id);
		
		log.info("/caseInfo/delete sendSuccessMessage 删除成功~");
		sendSuccessMessage(response, "删除成功");
	}
	/*********************************** generation code  end ***********************************/

	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private CaseApplyService<CaseApply> caseApplyService;
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private CasePreLitigationService<CasePreLitigation> casePreLitigationService;
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private CaseFirstInstanceService<CaseFirstInstance> caseFirstInstanceService;
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private CaseSecondInstanceService<CaseSecondInstance> caseSecondInstanceService;
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private CaseCarryOutService<CaseCarryOut> caseCarryOutService;
	
	@RequestMapping("/auditList") 
	public ModelAndView  auditList(CaseInfoPage page,HttpServletRequest request) throws Exception{
		log.info("/caseInfo/auditList page :"+page+" request:"+request);
		
		Map<String,Object>  context = getRootMap();
		
		log.info("forword lawyer/base/ccase/auditList ---- context:"+Arrays.toString(context.entrySet().toArray()));
		return forword("lawyer/base/ccase/caseAuditInfo",context); 
	}
	
	@RequestMapping("/auditData") 
	public void  auditDatalist(CaseInfoPage page,HttpServletResponse response) throws Exception{
		log.info("/caseInfo/auditDatalist page :"+page+" response:"+response);

		if(!SessionUtilsExt.isAdmin(request)) {
			page.setDelFlag("0");
		}
		
		List<CaseInfo> dataList = caseInfoService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		
		log.info("/caseInfo/auditDatalist writerJson ---- context:"+Arrays.toString(jsonMap.entrySet().toArray()));
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/getAuditId")
	public void getAuditId(String id,HttpServletResponse response) throws Exception{
		log.info("/caseInfo/getId id :"+id+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		CaseInfo caseInfo  = caseInfoService.queryById(id);
		if(caseInfo  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", caseInfo);
		
		CaseApply caseApply  = caseApplyService.queryById(id);
		context.put("app", caseApply);

		CasePreLitigation casePreLitigation  = casePreLitigationService.queryById(id);
		context.put("pre", casePreLitigation);
		
		CaseFirstInstance caseFirstInstance  = caseFirstInstanceService.queryById(id);
		context.put("first", caseFirstInstance);
		
		CaseSecondInstance caseSecondInstance  = caseSecondInstanceService.queryById(id);
		context.put("second", caseSecondInstance);

		CaseCarryOut caseCarryOut  = caseCarryOutService.queryById(id);
		context.put("out", caseCarryOut);
		
		log.info("/caseInfo/getId writerJson ---- context:"+Arrays.toString(context.entrySet().toArray()));
		HtmlUtil.writerJson(response, context);
	}
	@RequestMapping("/audit")
	public void audit(CaseInfo entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		log.info("/caseInfo/audit entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" response:"+response);
		SysUser user = SessionUtilsExt.getUser(request);
		if(null != user) {
			CaseInfo caseInfo  = caseInfoService.queryById(entity.getId());
			int status = caseInfo.getStatus();
			if(null == caseInfo || !(0< status &&  status <10)) {
				sendFailureMessage(response, "操作异常，案件已经处理，请仔细查看案件信息!");
				return;
			}
			
			if(null != typeIds[0]) {
				int a_status=0;
				if(1 == typeIds[0]) {//审批通过
					a_status=90+status;
				}else if(2 == typeIds[0]) {//审批驳回
					a_status=-1*status;
				}else {
					sendFailureMessage(response, "操作异常，非法请求!");
					return;
				}
				
				if(status == 1) {
					CaseApply caseApply  = caseApplyService.queryById(entity.getId());
					caseApply.setStatus(typeIds[0]+1);
					caseApply.setUpdatedBy(null!=user?user.getId()+"":"");
					caseApply.setUpdatedTime(new Date());
					caseApplyService.update(caseApply);
				}else if(status == 2) {
					CasePreLitigation casePreLitigation  = casePreLitigationService.queryById(entity.getId());
					casePreLitigation.setStatus(typeIds[0]+1);
					casePreLitigation.setUpdatedBy(null!=user?user.getId()+"":"");
					casePreLitigation.setUpdatedTime(new Date());
					casePreLitigationService.update(casePreLitigation);
				}else if(status == 3) {
					CaseFirstInstance caseFirstInstance  = caseFirstInstanceService.queryById(entity.getId());
					caseFirstInstance.setStatus(typeIds[0]+1);
					caseFirstInstance.setUpdatedBy(null!=user?user.getId()+"":"");
					caseFirstInstance.setUpdatedTime(new Date());
					caseFirstInstanceService.update(caseFirstInstance);
				}else if(status == 4) {
					CaseSecondInstance caseSecondInstance  = caseSecondInstanceService.queryById(entity.getId());
					caseSecondInstance.setStatus(typeIds[0]+1);
					caseSecondInstance.setUpdatedBy(null!=user?user.getId()+"":"");
					caseSecondInstance.setUpdatedTime(new Date());
					caseSecondInstanceService.update(caseSecondInstance);
				}else if(status == 5) {
					CaseCarryOut caseCarryOut  = caseCarryOutService.queryById(entity.getId());
					caseCarryOut.setStatus(typeIds[0]+1);
					caseCarryOut.setUpdatedBy(null!=user?user.getId()+"":"");
					caseCarryOut.setUpdatedTime(new Date());
					caseCarryOutService.update(caseCarryOut);
				}
				
				caseInfo.setStatus(a_status);
				caseInfo.setUpdatedBy(null!=user?user.getId()+"":"");
				caseInfo.setUpdatedTime(new Date());
				caseInfoService.update(caseInfo);
			}else {
				sendFailureMessage(response, "操作异常，非法请求!");
				return;
			}
			log.info("/caseInfo/audit sendSuccessMessage 保存成功~");
			sendSuccessMessage(response, "保存成功~");
		}else
			sendFailureMessage(response, "无权进行案件推进处理!");
	}
	
}