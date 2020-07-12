package lawyer.base.ccase.controller;

import java.util.ArrayList;
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

import lawyer.base.ccase.entity.SimpleFlow;
import lawyer.base.ccase.entity.SimpleFlowAttach;
import lawyer.base.ccase.entity.SysFileAttach;
import lawyer.base.ccase.page.SimpleFlowAttachPage;
import lawyer.base.ccase.page.SimpleFlowPage;
import lawyer.base.ccase.service.SimpleFlowAttachService;
import lawyer.base.ccase.service.SimpleFlowService;
 
/**
 * <b>功能：</b>SimpleFlowController<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-06 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */ 
@Controller
@RequestMapping("/simpleFlow") 
public class SimpleFlowController extends BaseAction{
	
	private final Logger log= Logger.getLogger(SimpleFlowController.class);
	/*********************************** generation code  start ***********************************/
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private SimpleFlowService<SimpleFlow> simpleFlowService; 
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private SimpleFlowAttachService<SimpleFlowAttach> simpleFlowAttachService; 
	
	/**
	 * 说明：
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(SimpleFlowPage page,HttpServletRequest request) throws Exception{
		log.info("/simpleFlow/list page :"+page+" request:"+request);
		
		Map<String,Object>  context = getRootMap();
		
		log.info("forword lawyer/base/ccase/simpleFlow ---- context:"+Arrays.toString(context.entrySet().toArray()));
		return forword("lawyer/base/ccase/simpleFlow",context); 
	}
	
	/**
	 * 说明：
	 * @param page
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(SimpleFlowPage page,HttpServletResponse response) throws Exception{
		log.info("/simpleFlow/dataList page :"+page+" response:"+response);
		SysUser user = SessionUtilsExt.getUser(request);
		
		List<SimpleFlow> dataList = null;
		if(!SessionUtilsExt.isAdmin(request) && null != user) {
			page.setCreatedBy(user.getId()+"");
		}
		if(StringUtils.isBlank(page.getPager().getOrderField())) {
			page.setSort("id");
			page.getPager().setOrderDirection(false);
		}
	
		dataList = simpleFlowService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		
		log.info("/simpleFlow/dataList writerJson ---- context:"+Arrays.toString(jsonMap.entrySet().toArray()));
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
	public void save(SimpleFlow entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		log.info("/simpleFlow/save entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" response:"+response);
		SysUser user = SessionUtilsExt.getUser(request);
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			entity.setCreatedBy(null!=user?user.getId()+"":"");
			entity.setCreatedTime(new Date());
			entity.setStatus("0");
			simpleFlowService.add(entity);
		}else{
			SimpleFlow dbentity = simpleFlowService.queryById(entity.getId());
			dbentity.setRemark(entity.getRemark());
			dbentity.setTitle(entity.getTitle());
			dbentity.setNote(entity.getNote());
			dbentity.setFtype(entity.getFtype());
			dbentity.setApprover(entity.getApprover());
			dbentity.setFileAckImg(entity.getFileAckImg());
			dbentity.setBizAckImg(entity.getBizAckImg());

			dbentity.setUpdatedBy(null!=user?user.getId()+"":"");
			dbentity.setUpdatedTime(new Date());
			dbentity.setStatus("0");
			simpleFlowService.update(dbentity);
		}
		
		//删除附件表对应关系
		simpleFlowAttachService.delete(entity.getId());
		List<SysFileAttach> attachs = entity.getAttachs();
		if(null != attachs) {
			//根据附件列表进行新关系保存
			SimpleFlowAttach tmp = null;
			for(SysFileAttach at:attachs) {
				tmp = new SimpleFlowAttach();
				tmp.setSfileAttachId(at.getId());
				tmp.setSflowId(entity.getId());
				simpleFlowAttachService.add(tmp);
			}
		}
		
		log.info("/simpleFlow/save sendSuccessMessage 保存成功~");
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
		log.info("/simpleFlow/getId id :"+id+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		SimpleFlow entity  = simpleFlowService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		
		List<SysFileAttach> attachs = new ArrayList<SysFileAttach>();//entity.getAttachs();
		SimpleFlowAttachPage page = new SimpleFlowAttachPage();
		page.setSflowId(entity.getId());
		List<SimpleFlowAttach> dataList = simpleFlowAttachService.queryByList(page);
		SysFileAttach tmp = null;
		for(SimpleFlowAttach sfat : dataList) {
			tmp = new SysFileAttach();
			tmp.setId(sfat.getSfileAttachId());
			tmp.setFilename(sfat.getFilename());
			tmp.setExt(sfat.getExt());
			tmp.setFilepath(sfat.getFilepath());;
			tmp.setFiletype(sfat.getFiletype());
			tmp.setSize(sfat.getSize());
			tmp.setUrl(sfat.getUrl());
			attachs.add(tmp);
		}
		entity.setAttachs(attachs);
		
		context.put(SUCCESS, true);
		context.put("data", entity);
		
		log.info("/simpleFlow/getId writerJson ---- context:"+Arrays.toString(context.entrySet().toArray()));
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
		log.info("/simpleFlow/delete id :"+Arrays.toString(id)+" response:"+response);
		
		simpleFlowService.delete(id);
		
		log.info("/simpleFlow/delete sendSuccessMessage 删除成功~");
		sendSuccessMessage(response, "删除成功");
	}
	/*********************************** generation code  end ***********************************/
	@RequestMapping("/push")
	public void push(SimpleFlow entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		log.info("/simpleFlow/save entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" response:"+response);
		SysUser user = SessionUtilsExt.getUser(request);
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			entity.setCreatedBy(null!=user?user.getId()+"":"");
			entity.setCreatedTime(new Date());
			entity.setStatus("1");
			simpleFlowService.add(entity);
		}else{
			SimpleFlow dbentity = simpleFlowService.queryById(entity.getId());
			dbentity.setRemark(entity.getRemark());
			dbentity.setTitle(entity.getTitle());
			dbentity.setNote(entity.getNote());
			dbentity.setFtype(entity.getFtype());
			dbentity.setApprover(entity.getApprover());
			dbentity.setFileAckImg(entity.getFileAckImg());
			dbentity.setBizAckImg(entity.getBizAckImg());

			dbentity.setUpdatedBy(null!=user?user.getId()+"":"");
			dbentity.setUpdatedTime(new Date());
			dbentity.setStatus("1");
			
			simpleFlowService.update(dbentity);
		}
		
		//删除附件表对应关系
		simpleFlowAttachService.delete(entity.getId());
		List<SysFileAttach> attachs = entity.getAttachs();
		if(null != attachs) {
			//根据附件列表进行新关系保存
			SimpleFlowAttach tmp = null;
			for(SysFileAttach at:attachs) {
				tmp = new SimpleFlowAttach();
				tmp.setSfileAttachId(at.getId());
				tmp.setSflowId(entity.getId());
				simpleFlowAttachService.add(tmp);
			}
		}
		log.info("/simpleFlow/save sendSuccessMessage 保存成功~");
		sendSuccessMessage(response, "保存成功~");
	}
	
	/**
	 * 说明：审批人流程列表
	 */
	@RequestMapping("/alist") 
	public ModelAndView  alist(SimpleFlowPage page,HttpServletRequest request) throws Exception{
		log.info("/simpleFlow/alist page :"+page+" request:"+request);
		
		Map<String,Object>  context = getRootMap();
		
		log.info("forword lawyer/base/ccase/simpleAFlow ---- context:"+Arrays.toString(context.entrySet().toArray()));
		return forword("lawyer/base/ccase/simpleAFlow",context); 
	}
	
	/**
	 * 说明：审批人流程数据
	 * @param page
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/adataList") 
	public void  adatalist(SimpleFlowPage page,HttpServletResponse response) throws Exception{
		log.info("/simpleFlow/adataList page :"+page+" response:"+response);
		SysUser user = SessionUtilsExt.getUser(request);
		List<SimpleFlow> dataList = null;
		if(!SessionUtilsExt.isAdmin(request) && null != user) {
			page.setApprover(user.getId()+"");
		}
		if(StringUtils.isBlank(page.getPager().getOrderField())) {
			page.setSort("id");
			page.getPager().setOrderDirection(false);
		}
		dataList = simpleFlowService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		
		log.info("/simpleFlow/adataList writerJson ---- context:"+Arrays.toString(jsonMap.entrySet().toArray()));
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	@RequestMapping("/audit")
	public void audit(SimpleFlow entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		SysUser user = SessionUtilsExt.getUser(request);
		if(null != user) {
			SimpleFlow db_entity  = simpleFlowService.queryById(entity.getId());
			
			if(!SessionUtilsExt.isAdmin(request) && !StringUtils.equals(user.getId()+"", db_entity.getApprover())) {
				sendFailureMessage(response, "操作异常，无权操作当前流程，请重新查看数据!");
				return;
			}
			
			if(!SessionUtilsExt.isAdmin(request) && !StringUtils.equals("1", db_entity.getStatus())) {
				sendFailureMessage(response, "操作异常，流程状态已经变更，请刷新数据!");
				return;
			}
			if(null != typeIds[0]) {
				if(1 == typeIds[0]) {//审批通过
					db_entity.setUpdatedBy(null!=user?user.getId()+"":"");
					db_entity.setUpdatedTime(new Date());
					db_entity.setStatus("2");
				}else if(2 == typeIds[0]) {//审批驳回
					db_entity.setUpdatedBy(null!=user?user.getId()+"":"");
					db_entity.setUpdatedTime(new Date());
					db_entity.setStatus("9");
				}else if(3 == typeIds[0]){//流程完结
					db_entity.setUpdatedBy(null!=user?user.getId()+"":"");
					db_entity.setUpdatedTime(new Date());
					db_entity.setStatus("8");
				}else {
					sendFailureMessage(response, "操作异常，非法请求!");
					return;
				}
			}else {
				sendFailureMessage(response, "操作异常，非法请求!");
				return;
			}
			
			simpleFlowService.update(db_entity);
			log.info("/caseInfo/audit sendSuccessMessage 保存成功~");
			sendSuccessMessage(response, "保存成功~");
		}else
			sendFailureMessage(response, "未登陆，无权进行任何处理!");
	}
}