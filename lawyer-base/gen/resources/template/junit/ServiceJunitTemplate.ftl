package ${bussPackage}.${entityPackage}.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ${bussPackage}.${entityPackage}.entity.${className};
import ${bussPackage}.${entityPackage}.page.${className}Page;
import ${bussPackage}.${entityPackage}.service.${className}Service;
import ${bussPackage}.${entityPackage}.dao.${className}Dao;

import org.apache.log4j.Logger;

/*
 * @TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true) 
 * transactionManager的默认取值是"transactionManager"，
 * defaultRollback的默认取值是true，当然，你也可以改成false。
 * true表示测试不会对数据库造成污染,false的话当然就会改动到数据库中了。
 * 在方法名上添加@Rollback(false)表示这个测试用例不需要回滚。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-*.xml")
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class ${className}ServiceTest {

	private final Logger log= Logger.getLogger(${className}ServiceTest.class);
	
	private static Object id;
	@Autowired
	private ${className}Service<${className}> $!{lowerName}Service;
	

	@Test
	public void testAdd(){
		try {
			${className} $!{lowerName} = new ${className}();
			$!{lowerName}Service.add($!{lowerName});
			id = $!{lowerName}.getId();
			log.info("-testAdd-----id---------"+id);
		} catch (Exception e) {
			log.error(e,e);
		}
	}
	@Test
	public void testList(){
		try {
			${className}Page $!{lowerName}Page = new ${className}Page();
			List<${className}> $!{lowerName}s = $!{lowerName}Service.queryByList($!{lowerName}Page);
			for(${className} e:$!{lowerName}s){
				System.out.println(e.getName());
			}
			log.info("----testList----------");
		} catch (Exception e) {
			log.error(e,e);
		}
	}
	@Test
	public void testDel(){
		try {
			$!{lowerName}Service.delete(id);
			log.info("---testDel-----------");
		} catch (Exception e) {
			log.error(e,e);
		}
	}
}