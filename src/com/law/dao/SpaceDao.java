package com.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.law.bean.Space;
import com.law.util.LawyerException;

/**
 * ˵�����洢�ռ�־û�����
 *
 */
public class SpaceDao {
	private String SPACETABLE="T_SPACE";
	
	public void saveSpace(Connection con,Space source) throws LawyerException{
		String sql = "INSERT INTO "+SPACETABLE+" (ID,NAME,CREATOR,CDATE,SIZE,ISUSED) VALUES(?,?,?,?,?,?)";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getId());
			psment.setString(2,source.getName());
			psment.setString(3,source.getCreator());
			psment.setDate(4,new java.sql.Date(new Date().getTime()));
			psment.setInt(5,50);
			psment.setString(6, "1");
			
			psment.addBatch();
	        //ִ�����ݿ���봦��
			psment.execute();			
			
		} catch (SQLException e) {
			throw new LawyerException("Save Space is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
	
	/**
	 * ˵������ȡϵͳ�Ĵ洢�ռ��б�
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param sysid ϵͳ��ʶ
	 * @return
	 * @throws LawyerException
	 */
	public List<Space> querySpaces(Connection con,String sysid) throws LawyerException{
		String sql = "SELECT ID,NAME,CREATOR,CDATE,SIZE,ISUSED FROM "+SPACETABLE;
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = con.createStatement();
			result = statement.executeQuery(sql);
			List<Space> resultSet = new ArrayList<Space>();
			Space space = null;
			while (result.next()) {
				space = new Space(sysid,result.getString("ID"));
				space.setCreator(result.getString("CREATOR"));
				space.setName(result.getString("NAME"));
				
				resultSet.add(space);
			}
			return resultSet;
		} catch (SQLException e) {
			throw new LawyerException("Query Space is error! "+ e.getMessage());
		} finally {
			try {
				result.close();
				statement.close();
			} catch (SQLException e) {
			}
			result = null;
			statement = null;
		}
	}
	
	/**
	 * ˵����ɾ�������Ĵ洢�ռ�
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source �洢�ռ����
	 * @throws LawyerException
	 */
	public void deleteSpace(Connection con,Space source) throws LawyerException{
		deleteSpace(con, source.getId());
	}
	
	/**
	 * ˵����ɾ��ָ����ʶ�Ĵ洢�ռ����
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param sourceid �洢�ռ��ʶ
	 * @throws LawyerException
	 */
	public void deleteSpace(Connection con,String sourceid) throws LawyerException{
		String sql ="DELETE "+SPACETABLE+" FROM "+SPACETABLE+" WHERE ID='"+sourceid+"'";
		Statement statement = null;
		try {
			statement = con.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			throw new LawyerException("Delete Space is error! "+ e.getMessage());
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = null;
		}
	}
	
	/**
	 * ˵�������¸����Ĵ洢�ռ�
	 * 
	 * @param con ���ݿ����Ӷ���
	 * @param source �洢�ռ����
	 * @throws LawyerException
	 */
	public void updataSpace(Connection con,Space source) throws LawyerException{
		String sql = "UPDATE "+SPACETABLE+" SET (NAME=?,CREATOR=?,CDATA=?,SIZE=?,ISUSED=?) FROM "+SPACETABLE+" WHERE ID='"+source.getId()+"'";
		PreparedStatement psment = null;
		try {
			psment = con.prepareStatement(sql);
			 //�������
			psment.clearBatch();

			psment.setString(1,source.getName());
			psment.setString(2,source.getCreator());
			
			psment.addBatch();
	        //ִ�����ݿ���봦��
			psment.execute();			
			
		} catch (SQLException e) {
			throw new LawyerException("UPDATE Space is error! " + e.getMessage());
		}finally{
			try {
				psment.close();
			} catch (SQLException e) {
			}
			psment = null;
		}
	}
}
