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

import com.base.entity.BaseEntity.DELETED;
import com.base.util.HtmlUtil;
import com.base.util.SessionUtilsExt;
import com.base.web.BaseAction;
import com.otter.entity.SysUser;
import com.otter.service.SysUserService;

import lawyer.base.ccase.entity.SysUserExt;
import lawyer.base.ccase.page.SysUserExtPage;
import lawyer.base.ccase.service.SysUserExtService;
 
/**
 * <b>功能：</b>SysUserExtController<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2018-07-16 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */ 
@Controller
@RequestMapping("/sysUserExt") 
public class SysUserExtController extends BaseAction{
	
	private final Logger log= Logger.getLogger(SysUserExtController.class);
	/*********************************** generation code  start ***********************************/
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private SysUserExtService<SysUserExt> sysUserExtService; 
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private SysUserService<SysUser> sysUserService; 
	
	/**
	 * 说明：
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(SysUserExtPage page,HttpServletRequest request) throws Exception{
		log.info("/sysUserExt/list page :"+page+" request:"+request);
		
		Map<String,Object>  context = getRootMap();
		
		log.info("forword lawyer/base/ccase/sysUserExt ---- context:"+Arrays.toString(context.entrySet().toArray()));
		return forword("lawyer/base/ccase/sysUserExt",context); 
	}
	
	/**
	 * 说明：
	 * @param page
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(SysUserExtPage page,HttpServletResponse response) throws Exception{
		log.info("/sysUserExt/dataList page :"+page+" response:"+response);
		
		List<SysUserExt> dataList = sysUserExtService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		
		log.info("/sysUserExt/dataList writerJson ---- context:"+Arrays.toString(jsonMap.entrySet().toArray()));
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
	public void save(SysUserExt entity,Integer[] typeIds,HttpServletRequest request,HttpServletResponse response) throws Exception{
		log.info("/sysUserExt/save entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" response:"+response);
		
		SysUser user = SessionUtilsExt.getUser(request);
		if(entity.getUid()==null||StringUtils.isBlank(entity.getUid().toString())){
			int count = sysUserService.getUserCountByEmail(entity.getEmail());
			if(count>0) {
				sendFailureMessage(response, "当前邮箱已经被使用，请更换邮箱地址!");
				return;
			}
			SysUser n_user = new SysUser();
			n_user.setEmail(entity.getEmail());
			n_user.setNickName(entity.getName());
			n_user.setCreateBy(null!=user?user.getId():null);
			n_user.setState(0);
			n_user.setDeleted(DELETED.NO.key);
			sysUserService.add(n_user);
			
			entity.setUid(n_user.getId());
			entity.setCreatedBy(null!=user?user.getId()+"":"");
			entity.setCreatedTime(new Date());
			entity.setUpdatedBy(null!=user?user.getId()+"":"");
			entity.setUpdatedTime(new Date());
			
			sysUserExtService.add(entity);
		}else{
//			int count = sysUserService.getUserCountByEmail(entity.getEmail());
//			if(count>0) {
//				sendFailureMessage(response, "当前邮箱已经被使用，请更换邮箱地址!");
//				return;
//			}
//			
//			SysUser n_user = sysUserService.queryById(entity.getUid());
//			n_user.setEmail(entity.getEmail());
//			n_user.setNickName(entity.getName());
//			n_user.setUpdateBy(null!=user?user.getId():null);
//			sysUserService.updateBySelective(n_user);
			
			entity.setUpdatedBy(null!=user?user.getId()+"":"");
			entity.setUpdatedTime(new Date());
			sysUserExtService.update(entity);
		}
		
		log.info("/sysUserExt/save sendSuccessMessage 保存成功~");
		sendSuccessMessage(response, "保存成功~");
	}
	
	/**
	 * 说明：
	 * @param uid
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/getId")
	public void getId(String uid,HttpServletResponse response) throws Exception{
		log.info("/sysUserExt/getId id :"+uid+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		SysUserExt entity  = sysUserExtService.queryById(uid);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		
		log.info("/sysUserExt/getId writerJson ---- context:"+Arrays.toString(context.entrySet().toArray()));
		HtmlUtil.writerJson(response, context);
	}
	
	/**
	 * 说明：
	 * @param id
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/delete")
	public void delete(Integer[] id,HttpServletResponse response) throws Exception{
		log.info("/sysUserExt/delete id :"+Arrays.toString(id)+" response:"+response);
		sysUserService.delete(id);
		sysUserExtService.delete(id);
		log.info("/sysUserExt/delete sendSuccessMessage 删除成功~");
		sendSuccessMessage(response, "删除成功");
	}
	/*********************************** generation code  end ***********************************/
	
	@RequestMapping("/listDatas")
	public void dataListByStatus(HttpServletResponse response) throws Exception {
		List<SysUserExt> dataList = sysUserExtService.queryByList(new SysUserExtPage());
		HtmlUtil.writerJson(response, dataList);
	}
}