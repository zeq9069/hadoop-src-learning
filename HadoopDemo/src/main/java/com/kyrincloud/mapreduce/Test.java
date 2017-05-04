package com.kyrincloud.mapreduce;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Test {
	
	public static void main(String[] args) {
	     try {  
	         String dsf = "hdfs://localhost:9000/user/kyrin/test/in.txt";  
	         Configuration conf = new Configuration();  
	         conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
	           
	         FileSystem fs = FileSystem.get(URI.create(dsf),conf);  
	         FSDataInputStream hdfsInStream = fs.open(new Path(dsf));  
	           
	         byte[] ioBuffer = new byte[1024];  
	         int readLen = hdfsInStream.read(ioBuffer);  
	         while(readLen!=-1)  
	         {  
	             System.out.write(ioBuffer, 0, readLen);  
	             readLen = hdfsInStream.read(ioBuffer);  
	         }  
	         hdfsInStream.close();  
	         fs.close();  
	         } catch (IOException e) {  
	             // TODO Auto-generated catch block  
	             e.printStackTrace();  
	         }  
	           
	     }  
		
}
