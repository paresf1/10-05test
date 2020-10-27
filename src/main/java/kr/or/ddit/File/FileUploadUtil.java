package kr.or.ddit.File;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUtil {
   private static final Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);
   //form-data; name="img"; filename="sally.png"
   // ==> sally.png
   
   //FileUploadUtilTest
   public static String getFilename(String contentDisposition) {
      String filename = "";
      String[] values = contentDisposition.split("; ");
      
      for (String index : values) {
         String[] value = index.split("=");
         if (value[0].equals("filename")){
//            filename = value[1];
            return value[1].replaceAll("\"", "");
         }
      }
      return filename;
   
   }
   
   // filename : sally.png == > .png
   
   public static String getExtension(String filename) {
//	   String b = filename.substring(5, 8);
			 
	   if(filename == null || filename.indexOf(".") == -1)
		   return "";
	   
	   else {
		   
		   return filename.split("\\.")[1];
	   }
   }
}






