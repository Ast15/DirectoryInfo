package com.tle.di.util;
import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.createMock;
import static org.powermock.api.easymock.PowerMock.expectNew;
import static org.powermock.api.easymock.PowerMock.replayAll;
import static org.powermock.api.easymock.PowerMock.verifyAll;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.testng.PowerMockTestCase;


@RunWith(PowerMockRunner.class)
@PrepareForTest(CommonUtil.class)
public class CommonUtilTest extends PowerMockTestCase {
	@Test
	public void BfsListFilesTest() {
		  String directoryAbsPath="testDirectory";
		  File mDirectory=createMock(File.class);
		  File mFile1=createMock(File.class);
		  File mFile2=createMock(File.class);
		  File mSubfolder=createMock(File.class);
		  File mFile3=createMock(File.class);
		  File[]mFileList={mFile1,mFile2,mSubfolder};
		  File[]mFileList2={mFile3};
		  
		  
		  try {
			long dateValue=(long)1444292348000L;
			Date date=new Date(dateValue);
			expectNew(File.class,directoryAbsPath).andReturn(mDirectory);
			expect(mDirectory.getAbsolutePath()).andReturn("root");
			expect(mDirectory.length()).andReturn((long)1024*1024);
			expect(mDirectory.lastModified()).andReturn((long)1444292348000L);
			expect(mDirectory.isDirectory()).andReturn(true);
			expect(mDirectory.listFiles()).andReturn(mFileList);
			
			expect(mSubfolder.getAbsolutePath()).andReturn("root/subfolder");
			expect(mSubfolder.length()).andReturn((long)1024*1024);
			expect(mSubfolder.lastModified()).andReturn(dateValue);
			expect(mSubfolder.isDirectory()).andReturn(true);
			expect(mSubfolder.listFiles()).andReturn(mFileList2);
			
			
			expect(mFile1.getAbsolutePath()).andReturn("root/file1");
			expect(mFile1.length()).andReturn((long)1024*1024);
			expect(mFile1.lastModified()).andReturn(dateValue);
			expect(mFile1.isDirectory()).andReturn(false);
		
			expect(mFile2.getAbsolutePath()).andReturn("root/file2");
			expect(mFile2.length()).andReturn((long)1024*1024);
			expect(mFile2.lastModified()).andReturn(dateValue);
			expect(mFile2.isDirectory()).andReturn(false);
		
			expect(mFile3.getAbsolutePath()).andReturn("root/subfolder/file3");
			expect(mFile3.length()).andReturn((long)1024*1024);
			expect(mFile3.lastModified()).andReturn(dateValue);
			expect(mFile3.isDirectory()).andReturn(false);
			
			
			replayAll();
			List<String> searchResult=CommonUtil.BfsListFiles(directoryAbsPath);
			
			String[]info={"root,1.0 MB,"+date.toString(),"root/file1,1.0 MB,"+date.toString(),"root/file2,1.0 MB,"+date.toString(),"root/subfolder,1.0 MB,"+date.toString(),"root/subfolder/file3,1.0 MB,"+date.toString()};
			List<String>expectedResult=Arrays.asList(info);
			Assert.assertEquals(searchResult, expectedResult);
			verifyAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
	
  @Test
  public void DfsListFilesTest() {
		  String directoryAbsPath="testDirectory";
		  File mDirectory=createMock(File.class);
		  File mFile1=createMock(File.class);
		  File mFile2=createMock(File.class);
		  File mSubfolder=createMock(File.class);
		  File mFile3=createMock(File.class);
		  File[]mFileList={mFile1,mFile2,mSubfolder};
		  File[]mFileList2={mFile3};
		  
		  
		  try {
			long dateValue=(long)1444292348000L;
			Date date=new Date(dateValue);
			expectNew(File.class,directoryAbsPath).andReturn(mDirectory);
			expect(mDirectory.getAbsolutePath()).andReturn("root");
			expect(mDirectory.length()).andReturn((long)1024*1024);
			expect(mDirectory.lastModified()).andReturn((long)1444292348000L);
			expect(mDirectory.isDirectory()).andReturn(true);
			expect(mDirectory.listFiles()).andReturn(mFileList);
			
			expect(mSubfolder.getAbsolutePath()).andReturn("root/subfolder");
			expect(mSubfolder.length()).andReturn((long)1024*1024);
			expect(mSubfolder.lastModified()).andReturn(dateValue);
			expect(mSubfolder.isDirectory()).andReturn(true);
			expect(mSubfolder.listFiles()).andReturn(mFileList2);
			
			
			expect(mFile1.getAbsolutePath()).andReturn("root/file1");
			expect(mFile1.length()).andReturn((long)1024*1024);
			expect(mFile1.lastModified()).andReturn(dateValue);
			expect(mFile1.isDirectory()).andReturn(false);
		
			expect(mFile2.getAbsolutePath()).andReturn("root/file2");
			expect(mFile2.length()).andReturn((long)1024*1024);
			expect(mFile2.lastModified()).andReturn(dateValue);
			expect(mFile2.isDirectory()).andReturn(false);
		
			expect(mFile3.getAbsolutePath()).andReturn("root/subfolder/file3");
			expect(mFile3.length()).andReturn((long)1024*1024);
			expect(mFile3.lastModified()).andReturn(dateValue);
			expect(mFile3.isDirectory()).andReturn(false);
			
			
			replayAll();
			List<String> searchResult=CommonUtil.DfsListFiles(directoryAbsPath);
			
			String[]info={"root,1.0 MB,"+date.toString(),"root/subfolder,1.0 MB,"+date.toString(),"root/subfolder/file3,1.0 MB,"+date.toString(),"root/file2,1.0 MB,"+date.toString(),"root/file1,1.0 MB,"+date.toString()};
			List<String>expectedResult=Arrays.asList(info);
			Assert.assertEquals(searchResult, expectedResult);
			verifyAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
	
    @Test
	public void RecursiveListFilesTest() {
		  String directoryAbsPath="testDirectory";
		  File mDirectory=createMock(File.class);
		  File mFile1=createMock(File.class);
		  File mFile2=createMock(File.class);
		  File mSubfolder=createMock(File.class);
		  File mFile3=createMock(File.class);
		  File[]mFileList={mFile1,mFile2,mSubfolder};
		  File[]mFileList2={mFile3};
		  
		  
		  try {
			long dateValue=(long)1444292348000L;
			Date date=new Date(dateValue);
			expectNew(File.class,directoryAbsPath).andReturn(mDirectory);
			expectNew(File.class,"root/subfolder").andReturn(mSubfolder);
			expectNew(File.class,"root/file1").andReturn(mFile1);
			expectNew(File.class,"root/file2").andReturn(mFile2);
			expectNew(File.class,"root/subfolder/file3").andReturn(mFile3);
			
			
			expect(mDirectory.getAbsolutePath()).andReturn("root");
			expect(mDirectory.length()).andReturn((long)1024*1024);
			expect(mDirectory.lastModified()).andReturn((long)1444292348000L);
			expect(mDirectory.isDirectory()).andReturn(true);
			expect(mDirectory.listFiles()).andReturn(mFileList);
			
			expect(mSubfolder.getAbsolutePath()).andReturn("root/subfolder").times(2);
			expect(mSubfolder.length()).andReturn((long)1024*1024);
			expect(mSubfolder.lastModified()).andReturn(dateValue);
			expect(mSubfolder.isDirectory()).andReturn(true);
			expect(mSubfolder.listFiles()).andReturn(mFileList2);
			
			
			expect(mFile1.getAbsolutePath()).andReturn("root/file1").times(2);
			expect(mFile1.length()).andReturn((long)1024*1024);
			expect(mFile1.lastModified()).andReturn(dateValue);
			expect(mFile1.isDirectory()).andReturn(false);
		
			expect(mFile2.getAbsolutePath()).andReturn("root/file2").times(2);
			expect(mFile2.length()).andReturn((long)1024*1024);
			expect(mFile2.lastModified()).andReturn(dateValue);
			expect(mFile2.isDirectory()).andReturn(false);
		
			expect(mFile3.getAbsolutePath()).andReturn("root/subfolder/file3").times(2);
			expect(mFile3.length()).andReturn((long)1024*1024);
			expect(mFile3.lastModified()).andReturn(dateValue);
			expect(mFile3.isDirectory()).andReturn(false);
			
			
			replayAll();
			List<String> searchResult=new LinkedList<String>();
			CommonUtil.RecursiveListFiles(directoryAbsPath,searchResult);
			
			String[]info={"root,1.0 MB,"+date.toString(),"root/file1,1.0 MB,"+date.toString(),"root/file2,1.0 MB,"+date.toString(),"root/subfolder,1.0 MB,"+date.toString(),"root/subfolder/file3,1.0 MB,"+date.toString()};
			List<String>expectedResult=Arrays.asList(info);

			Assert.assertEquals(searchResult, expectedResult);
			
			verifyAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
	
	
}
