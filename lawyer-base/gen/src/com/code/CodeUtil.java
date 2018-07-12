package com.code;

import code.generate.def.GenerateDef;
import code.generate.factory.GenerateCodeFactory;

public class CodeUtil {
	public static void main(String[] args) {
		String tables[] = new String[] { "law_case_close_stat","law_case_legal","law_case_source","law_customer"};
		String tableInfo[] = new String[]{"结案统计数据表","案件信息登记数据表","案源信息收集数据表","客户信息数据表"};
		
		for (int i = 0; i < tables.length; i++) {
			String tableName = tables[i];
			String codeName = tableInfo[i];// 中文注释 当然你用英文也是可以的
			String entityPackage = "ccase";// 实体包

			String keyType = GenerateDef.KEY_TYPE_02;// 主键生成方式 01:UUID 02:ID自增长方式 03:表名称序列方式
			GenerateCodeFactory.codeGenerate(tableName, codeName, entityPackage, keyType,true);
		}
	}
}