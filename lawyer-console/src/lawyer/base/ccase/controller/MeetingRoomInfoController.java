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

import lawyer.base.ccase.entity.CaseInfo;
import lawyer.base.ccase.entity.MeetingRoomInfo;
import lawyer.base.ccase.page.MeetingRoomInfoPage;
import lawyer.base.ccase.service.MeetingRoomInfoService;
 
/**
 * <b>功能：</b>MeetingRoomInfoController<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-12-27 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */ 
@Controller
@RequestMapping("/meetingRoomInfo") 
public class MeetingRoomInfoController extends BaseAction{
	
	private final Logger log= Logger.getLogger(MeetingRoomInfoController.class);
	/*********************************** generation code  start ***********************************/
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private MeetingRoomInfoService<MeetingRoomInfo> meetingRoomInfoService; 
	
	/**
	 * 说明：
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(MeetingRoomInfoPage page,HttpServletRequest request) throws Exception{
		log.info("/meetingRoomInfo/list page :"+page+" request:"+request);
		
		Map<String,Object>  context = getRootMap();
		
		log.info("forword lawyer/base/ccase/meetingRoomInfo ---- context:"+Arrays.toString(context.entrySet().toArray()));
		return forword("lawyer/base/ccase/meetingRoomInfo",context); 
	}
	
	/**
	 * 说明：
	 * @param page
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(MeetingRoomInfoPage page,HttpServletResponse response) throws Exception{
		log.info("/meetingRoomInfo/dataList page :"+page+" response:"+response);
		
		List<MeetingRoomInfo> dataList = meetingRoomInfoService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		
		log.info("/meetingRoomInfo/dataList writerJson ---- context:"+Arrays.toString(jsonMap.entrySet().toArray()));
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
	public void save(MeetingRoomInfo entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		log.info("/meetingRoomInfo/save entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" response:"+response);
		SysUser user = SessionUtilsExt.getUser(request);
		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
			entity.setCreatedBy(null!=user?user.getId()+"":"");
			entity.setCreatedTime(new Date());
			entity.setUpdatedBy(null!=user?user.getId()+"":"");
			entity.setUpdatedTime(new Date());
			entity.setStatus(0);
			meetingRoomInfoService.add(entity);
		}else{
			entity.setUpdatedBy(null!=user?user.getId()+"":"");
			entity.setUpdatedTime(new Date());
			meetingRoomInfoService.update(entity);
		}
		log.info("/meetingRoomInfo/save sendSuccessMessage 保存成功~");
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
		log.info("/meetingRoomInfo/getId id :"+id+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		MeetingRoomInfo entity  = meetingRoomInfoService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		
		log.info("/meetingRoomInfo/getId writerJson ---- context:"+Arrays.toString(context.entrySet().toArray()));
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
		log.info("/meetingRoomInfo/delete id :"+Arrays.toString(id)+" response:"+response);
		
		meetingRoomInfoService.delete(id);
		
		log.info("/meetingRoomInfo/delete sendSuccessMessage 删除成功~");
		sendSuccessMessage(response, "删除成功");
	}
	/*********************************** generation code  end ***********************************/
	@RequestMapping("/listDatas")
	public void dataListByStatus(HttpServletResponse response,MeetingRoomInfo entity) throws Exception {
		List<MeetingRoomInfo> dataList = meetingRoomInfoService.listDatas(entity);
		HtmlUtil.writerJson(response, dataList);
	}
	@RequestMapping("/control")
	public void controlMeetRoom(HttpServletResponse response,Integer[] typeIds,MeetingRoomInfo entity) throws Exception {
		SysUser user = SessionUtilsExt.getUser(request);
		if(null != user) {
			MeetingRoomInfo meetingRoom  = meetingRoomInfoService.queryById(entity.getId());
			if(null == meetingRoom || StringUtils.equals("1", meetingRoom.getDelFlag())) {
				sendFailureMessage(response, "操作异常，请管理员协助进行会议室信息修订!");
				return;
			}
			if(null != typeIds[0]) {
				if(1 == typeIds[0]) {//启用会议室
					meetingRoom.setStatus(typeIds[0]);
					meetingRoom.setUpdatedBy(null!=user?user.getId()+"":"");
					meetingRoom.setUpdatedTime(new Date());
					meetingRoomInfoService.update(meetingRoom);
				}else if(2 == typeIds[0]) {//关闭会议室
					meetingRoom.setStatus(typeIds[0]);
					meetingRoom.setUpdatedBy(null!=user?user.getId()+"":"");
					meetingRoom.setUpdatedTime(new Date());
					meetingRoomInfoService.update(meetingRoom);
				}else {
					sendFailureMessage(response, "操作异常，非法请求!");
					return;
				}
				log.info("/meetingRoomInfo/control sendSuccessMessage 保存成功~");
				sendSuccessMessage(response, "保存成功~");
			}else {
				sendFailureMessage(response, "操作异常，非法请求!");
				return;
			}
		}else
			sendFailureMessage(response, "无权进行控制处理!");
	}
}