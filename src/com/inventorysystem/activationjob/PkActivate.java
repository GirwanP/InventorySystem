package com.inventorysystem.activationjob;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PkActivate {
	
	public boolean activate(String entKey) {
		boolean validpk=KeyVerifierClass.verifyPKey(entKey);
		if(validpk) {
		this.writePk(entKey);
		}
		return validpk;
	}
	
	private void writePk(String pkey) {
		File mff=new File("G:inventorysys/astatus/keyfile.txt");
		
		try {
			if(!mff.exists()) {
				new File(mff.getParent()).mkdirs();
				mff.createNewFile();
			}
			
			FileWriter fr=new FileWriter(mff);
			
			fr.write(pkey);
			fr.close();
			System.out.println("key file generated");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
