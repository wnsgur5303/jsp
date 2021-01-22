package kr.or.ddit.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FileUtilTest {
	private static final Logger logger = LoggerFactory.getLogger(FileUtilTest.class);
	//contentDisoisition ==> form-data; name="file"; filename="1.png"
	@Test
	public void getFileNameTest(){
		/***Given***/
		String contentDisposition = "form-data; name =\"file\"; filename=\"brown.png\"";

		/***When***/
		String filename = FileUtil.getFileName(contentDisposition);

		/***Then***/
		logger.debug(filename);
		assertEquals("brown.png", filename);
		
	}
	
	@Test
	public void getFileExtensionTest() {
	/***Given***/
	String filename = "brown.png";

	/***When***/
	String extension = FileUtil.getFileExtension(filename);
	
	/***Then***/
	assertEquals(".png", extension);
	}
	
}
