package com.inventorysystem.activationjob;

import java.util.ArrayList;
import java.util.List;

public class KeyVerifierClass {
	private static String[] pkl={"123","234","345","456","567"};
	private List<String> pkList=new ArrayList<String>();
	
	public static boolean verifyPKey(String entKey) {
		for(int i=0;i<pkl.length;i++) {
			if(pkl[i].equals(entKey)) {
				System.out.println("Key validity check success");
				return true;
			}
		}
		return false;
	}
}
