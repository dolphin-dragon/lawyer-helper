package lawyer.base.ccase.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * <b>功能：</b>NoLitigationCaseEntity<br>
 * <b>作者：</b>dragon<br>
 * <b>日期：</b> 2020-04-28 <br>
 * <b>版权所有：<b>lawyer-helper版权所有(C) 2018，www.lawyer-helper.com<br>
 */
public class NoLitigationCase extends BaseEntity {
	private java.lang.Integer status;//   状态
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
}