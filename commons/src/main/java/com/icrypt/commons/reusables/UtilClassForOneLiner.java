package com.icrypt.commons.reusables;

public class UtilClassForOneLiner {
	private String tmpString="";
	public String getTmpString() {
		return tmpString;
	}
	public void setTmpString(String tmpString) {
		this.tmpString += tmpString;
	}
	public void printTest() {
		System.out.println(tmpString);
	}
	
	
}
