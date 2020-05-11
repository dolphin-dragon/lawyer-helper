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

import lawyer.base.ccase.entity.SysDict;
import lawyer.base.ccase.entity.SysDictItem;
import lawyer.base.ccase.entity.SysUserExt;
import lawyer.base.ccase.page.SysDictItemPage;
import lawyer.base.ccase.service.SysDictItemService;
import lawyer.base.ccase.service.SysDictService;
 
/**
 * <b>功能：</b>SysDictItemController<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-06 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */ 
@Controller
@RequestMapping("/sysDictItem") 
public class SysDictItemController extends BaseAction{
	
	private final Logger log= Logger.getLogger(SysDictItemController.class);
	/*********************************** generation code  start ***********************************/
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private SysDictItemService<SysDictItem> sysDictItemService;
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private SysDictService<SysDict> sysDictService;

	/**
	 * 说明：
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(SysDictItemPage page,HttpServletRequest request) throws Exception{
		log.info("/sysDictItem/list page :"+page+" request:"+request);
		
		Map<String,Object>  context = getRootMap();

		log.info("forword lawyer/base/ccase/sysDictItem ---- context:"+Arrays.toString(context.entrySet().toArray()));
		return forword("lawyer/base/ccase/sysDictItem",context); 
	}
	
	/**
	 * 说明：
	 * @param page
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(SysDictItemPage page,HttpServletResponse response) throws Exception{
		log.info("/sysDictItem/dataList page :"+page+" response:"+response);
		
		List<SysDictItem> dataList = sysDictItemService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		
		log.info("/sysDictItem/dataList writerJson ---- context:"+Arrays.toString(jsonMap.entrySet().toArray()));
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
	public void save(SysDictItem entity,Integer[] typeIds,HttpServletRequest request,HttpServletResponse response) throws Exception{
		SysUser user = SessionUtilsExt.getUser(request);
		String etype = request.getParameter("etype");
		log.info("/sysDictItem/save entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" request:"+request+" response:"+response+" etype:"+etype);
		if(StringUtils.equals("0", etype)) {
			Integer dict_id = entity.getDictId();
			if(null == dict_id) {
				SysDict dict = new SysDict();
				dict.setDictName(entity.getDictName());
				dict.setDictCode(entity.getDictCode());
				dict.setDescription(entity.getDescription());
				dict.setCreatedBy(user.getId()+"");
				dict.setCreatedTime(new Date());
				dict.setDelFlag("0");
				
				sysDictService.add(dict);
			}else {
				SysDict dict = sysDictService.queryById(entity.getDictId());
				dict.setDictName(entity.getDictName());
				dict.setDictCode(entity.getDictCode());
				dict.setDescription(entity.getDescription());
				dict.setUpdatedBy(user.getId()+"");
				dict.setUpdatedTime(new Date());
				sysDictService.update(dict);
			}
		}else {
			if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
				entity.setCreatedBy(user.getId()+"");
				entity.setCreatedTime(new Date());
				entity.setDelFlag("0");
				sysDictItemService.add(entity);
			}else{
				entity.setUpdatedBy(user.getId()+"");
				entity.setUpdatedTime(new Date());
				sysDictItemService.update(entity);
			}
		}
		log.info("/sysDictItem/save sendSuccessMessage 保存成功~");
		sendSuccessMessage(response, "保存成功~");
	}
	
	/**
	 * 说明：
	 * @param id
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/getId")
	public void getId(String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		log.info("/sysDictItem/getId id :"+id+" request:"+request+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		SysDictItem entity  = sysDictItemService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		
		log.info("/sysDictItem/getId writerJson ---- context:"+Arrays.toString(context.entrySet().toArray()));
		HtmlUtil.writerJson(response, context);
	}
	
	/**
	 * 说明：
	 * @param id
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/delete")
	public void delete(String[] id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String etype = request.getParameter("etype");
		log.info("/sysDictItem/delete id :"+Arrays.toString(id)+" request:"+request+" response:"+response+" etype:"+etype);
		if(StringUtils.equals("0", etype)) {
			sysDictService.delete(id);
		}else {
			sysDictItemService.delete(id);
		}

		log.info("/sysDictItem/delete sendSuccessMessage 删除成功~");
		sendSuccessMessage(response, "删除成功");
	}
	/*********************************** generation code  end ***********************************/
	@RequestMapping("/listItems")
	public void dataListByStatus(HttpServletResponse response,SysDictItem entity) throws Exception {
		
		List<SysDictItem> dataList = sysDictItemService.listItems(entity);
		
		HtmlUtil.writerJson(response, dataList);
	}
}