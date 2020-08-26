package com.otter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.annotation.Auth;
import com.base.entity.TreeNode;
import com.base.util.SessionUtils;
import com.base.util.SessionUtilsExt;
import com.base.util.TreeUtil;
import com.base.util.URLUtils;
import com.base.util.SystemConstant.SuperAdmin;
import com.base.web.BaseAction;
import com.otter.entity.SysMenu;
import com.otter.entity.SysMenuBtn;
import com.otter.entity.SysUser;
import com.otter.service.SysMenuBtnService;
import com.otter.service.SysMenuService;
//import com.otter.service.SysUserService;

@Controller
public class DeskTopAction extends BaseAction {
	
	@Autowired(required = false)
	private SysMenuService<SysMenu> sysMenuService;

//	@Autowired(required = false)
//	private SysUserService<SysUser> sysUserService;

	@Autowired(required = false)
	private SysMenuBtnService<SysMenuBtn> sysMenuBtnService;
	
	@Auth(verifyURL = false)
	@RequestMapping("/desktop")
	public ModelAndView main(HttpServletRequest request) {
		Map<String, Object> context = getRootMap();
		SysUser user = SessionUtilsExt.getUser(request);
		List<SysMenu> rootMenus = null;
		List<SysMenu> childMenus = null;
		List<SysMenuBtn> childBtns = null;
		// 超级管理员
		if (user != null && SuperAdmin.YES.key == user.getSuperAdmin()) {
			rootMenus = sysMenuService.getRootMenu(null);// 查询所有根节点
			childMenus = sysMenuService.getChildMenu();// 查询所有子节点
		} else {
			rootMenus = sysMenuService.getRootMenuByUser(user.getId());// 根节点
			childMenus = sysMenuService.getChildMenuByUser(user.getId());// 子节点
			childBtns = sysMenuBtnService.getMenuBtnByUser(user.getId());// 按钮操作
			buildData(childMenus, childBtns, request); // 构建必要的数据
		}
		context.put("user", user);
		context.put("menuList", treeMenu(rootMenus, childMenus));
		return forword("main/desktop", context);
	}
	
	/**
	 * 构建树形数据
	 * 
	 * @return
	 */
	private void buildData(List<SysMenu> childMenus, List<SysMenuBtn> childBtns, HttpServletRequest request) {
		// 能够访问的url列表
		List<String> accessUrls = new ArrayList<String>();
		// 菜单对应的按钮
		Map<String, List> menuBtnMap = new HashMap<String, List>();
		for (SysMenu menu : childMenus) {
			// 判断URL是否为空
			if (StringUtils.isNotBlank(menu.getUrl())) {
				List<String> btnTypes = new ArrayList<String>();
				for (SysMenuBtn btn : childBtns) {
					if (menu.getId().equals(btn.getMenuid())) {
						btnTypes.add(btn.getBtnType());
						URLUtils.getBtnAccessUrls(menu.getUrl(), btn.getActionUrls(), accessUrls);
					}
				}
				menuBtnMap.put(menu.getUrl(), btnTypes);
				URLUtils.getBtnAccessUrls(menu.getUrl(), menu.getActions(), accessUrls);
				accessUrls.add(menu.getUrl());
			}
		}
		SessionUtils.setAccessUrl(request, accessUrls);// 设置可访问的URL
		SessionUtils.setMemuBtnMap(request, menuBtnMap); // 设置可用的按钮
	}
	
	/**
	 * 构建树形数据
	 * 
	 * @return
	 */
	private List<TreeNode> treeMenu(List<SysMenu> rootMenus, List<SysMenu> childMenus) {
		TreeUtil util = new TreeUtil(rootMenus, childMenus);
		return util.getTreeNode();
	}
}
