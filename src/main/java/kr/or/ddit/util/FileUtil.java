package kr.or.ddit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {
	
	//contentDisoisition ==> form-data; name="file"; filename="1.png"
	public static String getFileName(String contentDisposition) {
		String[] attrs = contentDisposition.split("; ");
		for(String attr : attrs) {
			if(attr.startsWith("filename=")) {
				//filename="brown.png"
				attr = attr.replace("filename=","");
				//"brown.png"
				return attr.substring(1, attr.length() -1);	
//				012345678
//				 "hamburger".substring(4, 8) returns "urge"
//				 012345
//				 "smiles".substring(1, 5) returns "mile"	
			}
		}		
		return "";
	}
	
	public static String getFileExtension(String filename) {
		//line.brown.png
		/*
		 * filename.lastIndexOf("."); filename.substring(filename.lastIndexOf(".")+1);
		 */
		/* return filename.split("\\.")[1]; */
		//주의
		
		if(filename.indexOf(".") == -1) {
			return "";
		}else {
		return "." + filename.substring(filename.lastIndexOf(".")+1);
		}
	}
}
