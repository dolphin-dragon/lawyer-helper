package lawyer.base.ccase.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.util.HtmlUtil;
import com.base.util.SessionUtilsExt;
import com.base.web.BaseAction;
import com.otter.entity.SysUser;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import lawyer.base.ccase.entity.CaseMInfo;
import lawyer.base.ccase.page.CaseMInfoPage;
import lawyer.base.ccase.service.CaseMInfoService;
 
/**
 * <b>功能：</b>CaseMInfoController<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-04-11 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */ 
@Controller
@RequestMapping("/caseMInfo") 
public class CaseMInfoController extends BaseAction{
	
	private final Logger log= Logger.getLogger(CaseMInfoController.class);
	/*********************************** generation code  start ***********************************/
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private CaseMInfoService<CaseMInfo> caseMInfoService; 
	
	/**
	 * 说明：
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(CaseMInfoPage page,HttpServletRequest request) throws Exception{
		log.info("/caseMInfo/list page :"+page+" request:"+request);
		
		Map<String,Object>  context = getRootMap();
		
		log.info("forword lawyer/base/ccase/caseMInfo ---- context:"+Arrays.toString(context.entrySet().toArray()));
		return forword("lawyer/base/ccase/caseMInfo",context); 
	}
	
	/**
	 * 说明：
	 * @param page
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(CaseMInfoPage page,HttpServletResponse response) throws Exception{
		log.info("/caseMInfo/dataList page :"+page+" response:"+response);
		
		if(!SessionUtilsExt.isAdmin(request)) {
			page.setCaseDelFlag("0");
		}
		
		if(StringUtils.isBlank(page.getPager().getOrderField())) {
			page.setSort("id");
			page.getPager().setOrderDirection(false);
		}
		
		List<CaseMInfo> dataList = caseMInfoService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		
		log.info("/caseMInfo/dataList writerJson ---- context:"+Arrays.toString(jsonMap.entrySet().toArray()));
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
	public void save(CaseMInfo entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		log.info("/caseMInfo/save entity :"+entity+" typeIds:"+Arrays.toString(typeIds)+" response:"+response);
		
		//Map<String,Object>  context = new HashMap<String,Object>();
//		if(entity.getId()==null||StringUtils.isBlank(entity.getId().toString())){
//				caseMInfoService.add(entity);
//		}else{
//			caseMInfoService.update(entity);
//		}
		
		log.info("/caseMInfo/save sendSuccessMessage 保存成功~");
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
		log.info("/caseMInfo/getId id :"+id+" response:"+response);
		
		Map<String,Object>  context = new HashMap<String,Object>();
		CaseMInfo entity  = caseMInfoService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		
		log.info("/caseMInfo/getId writerJson ---- context:"+Arrays.toString(context.entrySet().toArray()));
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
		log.info("/caseMInfo/delete id :"+Arrays.toString(id)+" response:"+response);
		
//		caseMInfoService.delete(id);
		
		log.info("/caseMInfo/delete sendSuccessMessage 删除成功~");
		sendSuccessMessage(response, "删除成功");
	}
	/*********************************** generation code  end ***********************************/
	/**
	 * 导出数据
	 */
	@RequestMapping("/exceportExcel")
	public void exceportExcel(HttpServletResponse response, CaseMInfoPage page) {
		OutputStream out = null;
		try {
			if(!SessionUtilsExt.isAdmin(request)) {
				page.setCaseDelFlag("0");
			}

			if(StringUtils.isBlank(page.getPager().getOrderField())) {
				page.setSort("id");
				page.getPager().setOrderDirection(false);
			}

			List<CaseMInfo> dataList = caseMInfoService.queryList(page);
			Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(null, "案件信息"), CaseMInfo.class,dataList);
			String fileName = "案件信息.xls";
			// 设置返回响应头
			response.setContentType("application/xls;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			out = response.getOutputStream();
			workbook.write(out);
		} catch (Exception e) {
			log.error("exceportExcel case info error", e);
		} finally {
			if (null != out) {
				try {
					out.flush();
				} catch (IOException e) {
					log.error("exceportExcel case info flush error", e);
				}
				try {
					out.close();
				} catch (IOException e) {
					log.error("exceportExcel case info close error", e);
				}
			}
		}
	}
	
	/**********************普通用户数据统计功能****************************/
	/**
	 * 说明：
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list2User") 
	public ModelAndView  listByUser(CaseMInfoPage page,HttpServletRequest request) throws Exception{
		log.info("/caseMInfo/list2User page :"+page+" request:"+request);
		
		Map<String,Object>  context = getRootMap();
		
		log.info("forword lawyer/base/ccase/list2User ---- context:"+Arrays.toString(context.entrySet().toArray()));
		return forword("lawyer/base/ccase/caseMInfoByUser",context); 
	}
	
	/**
	 * 说明：
	 * @param page
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/dataList2User") 
	public void  datalistByUser(CaseMInfoPage page,HttpServletResponse response) throws Exception{
		log.info("/caseMInfo/dataList2User page :"+page+" response:"+response);
		List<CaseMInfo> dataList = null;
		SysUser user = SessionUtilsExt.getUser(request);
		if(null != user) {
			if(!SessionUtilsExt.isAdmin(request)) {
				page.setCaseCreatedBy(user.getId()+"");
				page.setCaseDelFlag("0");
			}

			if(StringUtils.isBlank(page.getPager().getOrderField())) {
				page.setSort("id");
				page.getPager().setOrderDirection(false);
			}
			dataList = caseMInfoService.queryByList(page);
		}
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		
		log.info("/caseMInfo/dataList2User writerJson ---- context:"+Arrays.toString(jsonMap.entrySet().toArray()));
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 导出数据
	 */
	@RequestMapping("/exportExcel2User")
	public void exportExcel2User(HttpServletResponse response, CaseMInfoPage page) {
		OutputStream out = null;
		try {
			List<CaseMInfo> dataList = null;
			SysUser user = SessionUtilsExt.getUser(request);
			if(null != user) {
				if(!SessionUtilsExt.isAdmin(request)) {
					page.setCaseCreatedBy(user.getId()+"");
					page.setCaseDelFlag("0");
				}
				if(StringUtils.isBlank(page.getPager().getOrderField())) {
					page.setSort("id");
					page.getPager().setOrderDirection(false);
				}
				dataList = caseMInfoService.queryList(page);
			}
			Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(null, "案件信息"), CaseMInfo.class,dataList);
			String fileName = "案件信息.xls";
			// 设置返回响应头
			response.setContentType("application/xls;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			out = response.getOutputStream();
			workbook.write(out);
		} catch (Exception e) {
			log.error("exportExcel2User case info error", e);
		} finally {
			if (null != out) {
				try {
					out.flush();
				} catch (IOException e) {
					log.error("exportExcel2User case info flush error", e);
				}
				try {
					out.close();
				} catch (IOException e) {
					log.error("exportExcel2User case info close error", e);
				}
			}
		}
	}
	/**********************普通用户数据统计功能****************************/
}