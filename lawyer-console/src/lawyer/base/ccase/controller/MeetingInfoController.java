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

import lawyer.base.ccase.entity.MeetingInfo;
import lawyer.base.ccase.page.MeetingInfoPage;
import lawyer.base.ccase.service.MeetingInfoService;
 
/**
 * <b>功能：</b>MeetingInfoController<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-12-27 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */ 
@Controller
@RequestMapping("/meetingInfo") 
public class MeetingInfoController extends BaseAction{
	
	private final Logger log= Logger.getLogger(MeetingInfoController.class);
	/*********************************** generation code  start ***********************************/
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private MeetingInfoService<MeetingInfo> meetingInfoService; 
	
	/**
	 * 说明：
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(MeetingInfoPage page,HttpServletRequest request) throws Exception{
		log.info("/meetingInfo/list page :"+page+" request:"+request);
		
		Map<String,Object>  context = getRootMap();
		
		log.info("forword lawyer/base/ccase/meetingInfo ---- context:"+Arrays.toString(context.entrySet().toArray()));
		return forword("lawyer/base/ccase/meetingInfo",context); 
	}
	
	/**
	 * 说明：
	 * @param page
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(MeetingInfoPage page,HttpServletResponse response) throws Exception{
		log.info("/meetingInfo/dataList page :"+page+" response:"+response);
		
		List<MeetingInfo> dataList = meetingInfoService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		
		log.info("/meetingInfo/dataList writerJson ---- context:"+Arrays.toString(jsonMap.entrySet().toArray()));
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
	public void save(MeetingInfo entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		log.info("/meetingInfo/save entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" response:"+response);
		SysUser user = SessionUtilsExt.getUser(request);
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			entity.setCreatedBy(null!=user?user.getId()+"":"");
			entity.setCreatedTime(new Date());
			entity.setUpdatedBy(null!=user?user.getId()+"":"");
			entity.setUpdatedTime(new Date());
			entity.setStatus(0);
			meetingInfoService.add(entity);
		}else{
			entity.setUpdatedBy(null!=user?user.getId()+"":"");
			entity.setUpdatedTime(new Date());
			meetingInfoService.update(entity);
		}
		log.info("/meetingInfo/save sendSuccessMessage 保存成功~");
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
		log.info("/meetingInfo/getId id :"+id+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		MeetingInfo entity  = meetingInfoService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		
		log.info("/meetingInfo/getId writerJson ---- context:"+Arrays.toString(context.entrySet().toArray()));
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
		log.info("/meetingInfo/delete id :"+Arrays.toString(id)+" response:"+response);
		meetingInfoService.delete(id);
		log.info("/meetingInfo/delete sendSuccessMessage 删除成功~");
		sendSuccessMessage(response, "删除成功");
	}
	/*********************************** generation code  end ***********************************/
}