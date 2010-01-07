package com.law.client.zk;

public class Messagebox extends org.zkoss.zul.Messagebox {

	public static void showExclamation(String type,String number){
		try {
			Messagebox.show(MSG.getContent(type, number),MSG.getContent(type, "100"), Messagebox.OK, Messagebox.EXCLAMATION);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	public static void showInformation(String type,String number){
		try {
			Messagebox.show(MSG.getContent(type, number),MSG.getContent(type, "100"), Messagebox.OK, Messagebox.INFORMATION);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
}
