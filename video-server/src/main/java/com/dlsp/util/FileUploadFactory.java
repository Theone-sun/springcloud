package com.dlsp.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadFactory {
	
	public static final String FILE_PATH="d://test//";
	
	public static String upload(MultipartFile file)
	{
		String name = file.getOriginalFilename();
		String ext = name.substring(name.lastIndexOf("."));
		String fileName=UUID.randomUUID().toString();
		String newName = fileName + ext;
		OutputStream os = null;
		InputStream in = null;
		
		try {
			in = file.getInputStream();
			os = new FileOutputStream(FILE_PATH + newName);
			//实现上传  
			int len = -1;
			byte[] bytes = new byte[1024];
			while((len = in.read(bytes)) != -1)
			{
				os.write(bytes, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(in != null)
					in.close();
				if(os != null)
					os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return newName;
	}

}
