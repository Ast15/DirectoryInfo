package com.tle.di.util;

import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CommonUtil {
	
	public static List<String> BfsListFiles(String directoryAbsPath) throws Exception{
		List<String>result=new LinkedList<String>();
		File directory = new File(directoryAbsPath);
	    Queue<File> q=new LinkedList<File>();
	    q.add(directory);
	    
	    while(!q.isEmpty()){
	    	File current=q.remove();
	    	result.add(fileInfo(current));
	    	if(current.isDirectory()){
		    	File[] fList = current.listFiles();
		    	if(fList!=null)
		        for (File file : fList) {
		        	q.add(file);
		        }
	        }
	    }	        
	    return result;
	}
	
	public static List<String> DfsListFiles(String directoryAbsPath) throws Exception {
		List<String>result=new LinkedList<String>();
		File directory = new File(directoryAbsPath);
	    Stack<File> s=new Stack<File>();
	    s.push(directory);
	    
	    while(!s.isEmpty()){
	    	File current=s.pop();
	    	result.add(fileInfo(current));
	    	if(current.isDirectory()){
		    	File[] fList = current.listFiles();
		    	if(fList!=null)
		        for (File file : fList) {
		        	s.push(file);
		        }
	        }
	    }        
	    return result;
	}
	
	public static void RecursiveListFiles(String directoryAbsPath, List<String>result) throws Exception {
		File directory = new File(directoryAbsPath);
		result.add(fileInfo(directory));
		if(directory.isDirectory()){
		    	File[] fList = directory.listFiles();
		    	if(fList!=null)
		        for (File file : fList) {
		        	RecursiveListFiles(file.getAbsolutePath(),result);
		        }
	     }
	}
	
	private static String fileInfo(File file) throws Exception{
		StringBuffer result=new StringBuffer();
		result.append(file.getAbsolutePath());
		
		double size=(double)file.length()/(1024*1024);//Need to work on this if size is too large...
		result.append(","+size+" MB");
		
		Date d=new Date(file.lastModified());
		result.append(","+d);
		
		return result.toString();
	}	
}