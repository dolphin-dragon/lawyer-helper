package com.code;

import code.generate.def.GenerateDef;
import code.generate.factory.GenerateCodeFactory;

public class CodeUtil {
	public static void main(String[] args) {
		String tables[] = new String[] { "pdf","pdf_img","NewTable" };
		String tableInfo[] = new String[]{"PDF文档","PDF图集","测试数据表"};
		
		tables = new String[] { "t_person"};
		tableInfo = new String[]{"人员管理"};
		
		tables = new String[] { "t_note"};
		tableInfo = new String[]{"通知系统"};
		
		for (int i = 0; i < tables.length; i++) {
			String tableName = tables[i];
			String codeName = tableInfo[i];// 中文注释 当然你用英文也是可以的
			String entityPackage = "case";// 实体包

			String keyType = GenerateDef.KEY_TYPE_02;// 主键生成方式 01:UUID 02:ID自增长方式 03:表名称序列方式
			GenerateCodeFactory.codeGenerate(tableName, codeName, entityPackage, keyType,true);
		}
	}
}