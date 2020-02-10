package com.time.demo.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadUtil {

	private final String path = System.getProperty("user.dir") + "/src/main/resources/static/picture/";

	// 单文件上传
	public String upload(MultipartFile file) {
		// 获取原始名字
		String fileName = file.getOriginalFilename();
		String newFilename = this.path + UUID.randomUUID() + fileName;

		File dest = new File(newFilename);
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdir();
		}
		try {
			file.transferTo(dest);
			return newFilename;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "上传失败";
	}

}
