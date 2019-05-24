package com.inventorysystem.activationjob;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActivationStatusChecker {
	public boolean hasActivated() {
		System.out.println("checking activation status");
		File mff=new File("G:inventorysys/astatus/keyfile.txt");
		boolean afile=mff.exists();
		if(!afile) {return false;}
		try {
			FileReader fr=new FileReader(mff);
			StringBuffer chse=new StringBuffer("");
			int i=0;
			while(true) {
				int ch=fr.read();
				if(ch==-1) {break;}
				System.out.print((char)ch);
				chse.append((char)ch);
				
				i++;
			}
			System.out.println("\n"+chse);
			
			fr.close();
			
			if(KeyVerifierClass.verifyPKey(chse.toString())) {
				System.out.println("activation status:success");
				return true;
			}else {System.out.println("activation status:not activated");}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		
		
		
		return false;
	}
}
