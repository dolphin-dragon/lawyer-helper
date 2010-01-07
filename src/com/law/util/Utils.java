package com.law.util;

public class Utils {
	/**
	 * 说明：获取最大长度为length的source的下个数值的字符串，数值的字符长度不足length则在前面补零
	 * 
	 * @param length 最大的限定长度
	 * @param source 当前的数值
	 * @return 返回下一个数值的字符串
	 * @throws LawyerException 超越了length的限定
	 */
	public static String getNextStr(int length,long source) throws LawyerException{
		String temp = source+1+"";
		if(temp.length()>length)
			throw new LawyerException("The key "+source+" is max "+length);
		int num = length-temp.length();
		for(int i = 0 ; i<num ; i++)
			temp = "0"+temp;
		return temp;
	}
	
	//Test
	public static void main(String args[]){
		String str = "S_99999998";
		System.out.println(str);
		System.out.println(str.hashCode());
//		System.out.println(str.substring(2));
//		System.out.println(Long.valueOf(str.substring(2)).longValue()+1);
		Long max = Long.valueOf(str.substring(2)).longValue();
		if(max<99999999){
			String temp = Long.valueOf(str.substring(2)).longValue()+1+"";
			if(temp.length()<8){
				int num = 8-temp.length();
				for(int i = 0; i<num;i++)
					temp = "0"+temp;
			}
			System.out.println("S_"+temp);	
		}else{
			System.out.println("THE KEY IS MAX !"+max);
		}
	}
}
