package lawyer.base.ccase.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * <b>功能：</b>MeetingInfoEntity<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-12-27 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class MeetingInfo extends BaseEntity {
	private java.lang.Integer status;//   状态
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	
	private java.util.List<SysUserExt> members;//会议参会人列表,根据mtMembers进行数据处理
	
	private java.lang.String mtSponsorName;
	private java.lang.String mtrName;
	
	private java.util.List<Object> mtMembersIds;//   会议参会人列表
	
	public java.util.List<SysUserExt> getMembers() {
		return members;
	}
	public void setMembers(java.util.List<SysUserExt> members) {
		this.members = members;
	}
	public java.lang.String getMtSponsorName() {
		return mtSponsorName;
	}
	public void setMtSponsorName(java.lang.String mtSponsorName) {
		this.mtSponsorName = mtSponsorName;
	}
	public java.lang.String getMtrName() {
		return mtrName;
	}
	public void setMtrName(java.lang.String mtrName) {
		this.mtrName = mtrName;
	}
	public java.util.List<Object> getMtMembersIds() {
		if(StringUtils.isNotBlank(mtMembers)) {
			List<Object> tmp= new ArrayList<Object>();
			String[] ids = StringUtils.split(mtMembers.replace("[", "").replace("]", ""), ",");
			for (int i = 0; i < ids.length; i++) {
				tmp.add(Integer.valueOf(ids[i].trim()));
			}
			mtMembersIds = tmp;
		}
		return mtMembersIds;
	}
	public void setMtMembersIds(java.util.List<Object> mtMembersIds) {
		this.mtMembersIds = mtMembersIds;
		if(null != mtMembersIds && mtMembersIds.size()>0)
			this.setMtMembers(Arrays.toString(mtMembersIds.toArray()));
		else
			this.setMtMembers("");
	}
}