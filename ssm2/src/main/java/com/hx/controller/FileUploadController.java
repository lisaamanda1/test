package com.hx.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hx.bean.MyFile;

@Controller
public class FileUploadController {
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest request, @ModelAttribute MyFile myFile, Model model) throws IllegalStateException, IOException {
		if(!myFile.getFile().isEmpty()) {
			//�ϴ��ļ�·��
			String path = request.getServletContext().getRealPath("/images");
			//�ϴ��ļ���
			String filename = myFile.getFile().getOriginalFilename();
			File filepath = new File(path, filename);
			//�ж�·���Ƿ���ڣ���������ھʹ���һ��
			if(!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			//���ϴ��ļ����浽һ��Ŀ���ļ�����
			myFile.getFile().transferTo(new File(path + File.separator + filename));
			model.addAttribute("myFile", myFile);
			return "success";
		} else {
			return "error";
		}
	}
	
	@RequestMapping(value = "/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename, Model model) throws Exception {
		//�ļ�·��
		String path = request.getServletContext().getRealPath("/images");
		File file = new File(path + File.separator + filename);
		HttpHeaders headers = new HttpHeaders();
		//������ʾ���ļ������������������������  
		String downloadFileName = new String(filename.getBytes("UTF-8"), "iso-8859-1");
		//֪ͨ�������attachment�����ط�ʽ����ͼƬ
		headers.setContentDispositionFormData("attachment", downloadFileName);
		//application/octet-stream �� �����������ݣ�������ļ����أ���
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
}
