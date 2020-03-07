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
import lawyer.base.ccase.entity.CaseFirstInstance;
import lawyer.base.ccase.entity.CaseInfo;
import lawyer.base.ccase.entity.CasePreLitigation;
import lawyer.base.ccase.page.CaseApplyPage;
import lawyer.base.ccase.service.CaseApplyService;
import lawyer.base.ccase.service.CaseFirstInstanceService;
import lawyer.base.ccase.service.CaseInfoService;
import lawyer.base.ccase.service.CasePreLitigationService;
 
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
		SysUser user = SessionUtilsExt.getUser(request);
		if(!SessionUtilsExt.isAdmin(request))
			page.setCreatedBy(user.getId()+"");
		
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
		
		SysUser user = SessionUtilsExt.getUser(request);
		if(entity.getCaseId()==null||StringUtils.isBlank(entity.getCaseId().toString())){
			CaseInfo caseInfo = new CaseInfo();
			caseInfo.setLitigant(entity.getLitigant());
			caseInfo.setDefendantArea(entity.getDefendantArea());
			caseInfo.setDefendantName(entity.getDefendantName());
			caseInfo.setDefendantRegCapital(entity.getDefendantRegCapital());
			
			caseInfo.setCreatedBy(null!=user?user.getId()+"":"");
			caseInfo.setCreatedTime(new Date());
			caseInfo.setUpdatedBy(null!=user?user.getId()+"":"");
			caseInfo.setUpdatedTime(new Date());
			caseInfoService.add(caseInfo);

			entity.setCaseId(caseInfo.getId());
			entity.setCreatedBy(null!=user?user.getId()+"":"");
			entity.setCreatedTime(new Date());
			entity.setUpdatedBy(null!=user?user.getId()+"":"");
			entity.setUpdatedTime(new Date());
			caseApplyService.add(entity);
		}else{
			CaseInfo caseInfo = caseInfoService.queryById(entity.getCaseId());
			caseInfo.setLitigant(entity.getLitigant());
			caseInfo.setDefendantArea(entity.getDefendantArea());
			caseInfo.setDefendantName(entity.getDefendantName());
			caseInfo.setDefendantRegCapital(entity.getDefendantRegCapital());
			caseInfo.setUpdatedBy(null!=user?user.getId()+"":"");
			caseInfo.setUpdatedTime(new Date());
			caseInfoService.update(caseInfo);
			
			entity.setUpdatedBy(null!=user?user.getId()+"":"");
			entity.setUpdatedTime(new Date());
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
	public void getId(String caseId,HttpServletResponse response) throws Exception{
		log.info("/caseApply/getId id :"+caseId+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		CaseApply entity  = caseApplyService.queryById(caseId);
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

	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private CaseFirstInstanceService<CaseFirstInstance> caseFirstInstanceService;
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private CasePreLitigationService<CasePreLitigation> casePreLitigationService;
	
	@RequestMapping("/pushNext")
	public void pushNext(CaseApply entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		log.info("/caseApply/pushNext entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" response:"+response);
		SysUser user = SessionUtilsExt.getUser(request);
		if(null != user) {
			//查询当前案件信息
			CaseApply dbentity  = caseApplyService.queryById(entity.getCaseId());
			//进行案件信息检查
			boolean checkstatus =false;
			if(!(null == dbentity || null == dbentity.getStatus() || dbentity.getStatus() == 0)) checkstatus = true;
			//信息检查处理
			String acImg = dbentity.getActionImg();
			String litigantImg = dbentity.getLitigantAcImg();
			if(StringUtils.isBlank(acImg) || StringUtils.isBlank(litigantImg)) checkstatus = true;
			
			//信息检查未通过
			if(checkstatus) {
				sendFailureMessage(response, "案件推进异常，请检查案件信息是否完整!");
				return;			
			}

			int status = 0;
			//判断是否直接诉讼
			if(StringUtils.equals("1", dbentity.getIsDirectAction())) {
				CaseFirstInstance caseFirstInstance = caseFirstInstanceService.queryById(entity.getCaseId());
				if(null == caseFirstInstance) {
					caseFirstInstance = new CaseFirstInstance();
					caseFirstInstance.setCaseId(entity.getCaseId());
					
					caseFirstInstance.setCreatedBy(null!=user?user.getId()+"":"");
					caseFirstInstance.setCreatedTime(new Date());
					caseFirstInstance.setUpdatedBy(null!=user?user.getId()+"":"");
					caseFirstInstance.setUpdatedTime(new Date());

					caseFirstInstanceService.add(caseFirstInstance);
					status=31;
				}else {
					sendFailureMessage(response, "案件推进异常，已经推进到下阶段!");
					return;
				}
			}else {
				CasePreLitigation casePreLitigation = casePreLitigationService.queryById(entity.getCaseId());
				if(null == casePreLitigation) {
					casePreLitigation = new CasePreLitigation();
					casePreLitigation.setCaseId(entity.getCaseId());
					
					casePreLitigation.setCreatedBy(null!=user?user.getId()+"":"");
					casePreLitigation.setCreatedTime(new Date());
					casePreLitigation.setUpdatedBy(null!=user?user.getId()+"":"");
					casePreLitigation.setUpdatedTime(new Date());

					casePreLitigationService.add(casePreLitigation);
					status=21;
				}else {
					sendFailureMessage(response, "案件推进异常，已经推进到下阶段!");
					return;
				}
			}
			
			CaseInfo caseInfo = caseInfoService.queryById(entity.getCaseId());
			caseInfo.setStatus(status);
			caseInfoService.update(caseInfo);
			
			dbentity.setStatus(1);
			dbentity.setUpdatedBy(null!=user?user.getId()+"":"");
			dbentity.setUpdatedTime(new Date());
			
			caseApplyService.update(dbentity);
			log.info("/caseApply/pushNext sendSuccessMessage 推进成功~");
			sendSuccessMessage(response, "推进成功~");
		}else
			sendFailureMessage(response, "无权进行案件推进处理!");
	}
}