package com.inventorysystem.environmentManage;

import java.io.File;
import java.io.IOException;

public class MultipleInstanceCheck {
	public static boolean logInstance() {
		File ifile=new File("G:inventorysys/astatus/instancelog.txt");
		if(ifile.exists()) {
			
		}else {
			try {
				ifile.createNewFile();
				ifile.deleteOnExit();
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public static boolean conformNotAlreadyRunning() {
		File ifile=new File("G:inventorysys/astatus/instancelog.txt");
		if(ifile.exists()) {
			System.out.println("confirm already not running:failed");
			return false;
		}else {
			System.out.println("confirm already not running:success");
			return true;
		}
		
	}
}
