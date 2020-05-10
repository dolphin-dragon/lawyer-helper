package lawyer.base.ccase.page;

import com.base.page.BasePage;

/**
 * <b>功能：</b>SysDictItemPage<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-06 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class SysDictItemPage extends BasePage {
	
	
	private java.lang.String dictName;
	private java.lang.String dictCode;
	private java.lang.String dictDescription;
	private java.lang.String dictDelFlag;
	
	public java.lang.String getDictName() {
		return dictName;
	}
	public void setDictName(java.lang.String dictName) {
		this.dictName = dictName;
	}
	public java.lang.String getDictCode() {
		return dictCode;
	}
	public void setDictCode(java.lang.String dictCode) {
		this.dictCode = dictCode;
	}
	public java.lang.String getDictDescription() {
		return dictDescription;
	}
	public void setDictDescription(java.lang.String dictDescription) {
		this.dictDescription = dictDescription;
	}
	public java.lang.String getDictDelFlag() {
		return dictDelFlag;
	}
	public void setDictDelFlag(java.lang.String dictDelFlag) {
		this.dictDelFlag = dictDelFlag;
	}
}