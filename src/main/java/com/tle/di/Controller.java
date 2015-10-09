
package com.tle.di;

import java.util.LinkedList;
import java.util.List;

import com.tle.di.util.CommonUtil;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			
			//Three input parameters
			String directoryAbsPath="/Users/tle/test1/";//This must be an absolute path
			int searchOption=0;//0: BFS, 1: DFS, 2: Recursion
			boolean outPutA=false;//true: print outPutA, false: print OutputB
			
			

			List<String>result=null;
			
			switch (searchOption){
				case 0: result=CommonUtil.BfsListFiles(directoryAbsPath); 
						System.out.println("*****Using BFS*****");
						break;
				
				case 1: result=CommonUtil.DfsListFiles(directoryAbsPath); 
						System.out.println("*****Using DFS*****");
						break;
				
				case 2: result=new LinkedList<String>(); 
						CommonUtil.RecursiveListFiles(directoryAbsPath, result);
						System.out.println("*****Using Recursion*****");		
						break;
				
				default:System.err.println("Invalid search option");
						break;			
			}
			
			if(result!=null){
				if(outPutA){
					System.out.println("*****Printing OutputA*****");
					for(String s: result){
						String[]temp=s.split(",");
						System.out.println(temp[0]);
					}
				}
				else{
					System.out.println("*****Printing OutputB*****");
					for(String s: result){
						System.out.println(s);
					}
				}
			}

		}
		
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	

}
