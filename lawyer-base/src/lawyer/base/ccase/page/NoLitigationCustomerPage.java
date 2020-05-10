package lawyer.base.ccase.page;

import org.springframework.format.annotation.DateTimeFormat;

import com.base.page.BasePage;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <b>功能：</b>NoLitigationCustomerPage<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-05-10 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class NoLitigationCustomerPage extends BasePage {
	private java.lang.Integer status;//   状态
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
}