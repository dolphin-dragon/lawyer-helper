package com.code;

import code.generate.def.GenerateDef;
import code.generate.factory.GenerateCodeFactory;

public class CodeUtil {
	public static void main(String[] args) {
		String tables[] = new String[] {"case_apply","case_carry_out","case_customer","case_first_instance","case_info","case_pre_litigation","case_second_instance","sys_user_ext"};
		String tableInfo[] = new String[]{"案件确立阶段信息","案件执行阶段信息","客户信息","案件一审阶段信息","案件基础信息","案件诉前和解信息","案件二审阶段信息","用户信息设置"};
		
		tables = new String[] { "case_m_info"};
		tableInfo = new String[]{"案件综合信息"};
		
		for (int i = 0; i < tables.length; i++) {
			String tableName = tables[i];
			String codeName = tableInfo[i];// 中文注释 当然你用英文也是可以的
			String entityPackage = "ccase";// 实体包

			String keyType = GenerateDef.KEY_TYPE_02;// 主键生成方式 01:UUID 02:ID自增长方式 03:表名称序列方式
			GenerateCodeFactory.codeGenerate(tableName, codeName, entityPackage, keyType,true);
		}
	}
}