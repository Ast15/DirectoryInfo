
package com.tle.di;

import java.util.LinkedList;
import java.util.List;

import com.tle.di.util.CommonUtil;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
		
			String directoryAbsPath="/Users/tle/test1/";
			List<String>result=null;
					
			
			System.out.println("==============Print OutputB START==============");
			System.out.println("**************Print DFS result***************");
			result=CommonUtil.DfsListFiles(directoryAbsPath);
			for(String s: result){
				System.out.println(s);				
			}
			
			System.out.println("**************Print BFS result***************");
			result=CommonUtil.BfsListFiles(directoryAbsPath);
			for(String s: result){
				System.out.println(s);				
			}
			
			System.out.println("**************Print Recursive result***************");
			result=new LinkedList<String>();
			CommonUtil.RecursiveListFiles(directoryAbsPath, result);;
			for(String s: result){
				System.out.println(s);				
			}
			System.out.println("==============Print OutputB END==============");
			
			
			
			System.out.println("==============Print OutputA START==============");
			System.out.println("**************Print DFS result***************");
			result=CommonUtil.DfsListFiles(directoryAbsPath);
			for(String s: result){
				String[]temp=s.split(",");
				System.out.println(temp[0]);
			}
			System.out.println("==============Print OutputA END==============");

		}
		
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	

}
