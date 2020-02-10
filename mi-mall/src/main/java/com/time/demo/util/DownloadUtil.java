package com.time.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownloadUtil{

	@RequestMapping("/download")
	public void download(HttpServletResponse response) throws Exception {
		File file = new File(
				System.getProperty("user.dir")+"\\src\\main\\resources\\static\\picture\\aaa.jpg");
		FileInputStream fileinput = new FileInputStream(file);
		response.setHeader("content-type", "application/octet-stream");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + "ccd.jpg");
		OutputStream os = response.getOutputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = fileinput.read(buf)) != -1) {
			os.write(buf, 0, len);
		}
		os.close();
		fileinput.close();
	}
}
