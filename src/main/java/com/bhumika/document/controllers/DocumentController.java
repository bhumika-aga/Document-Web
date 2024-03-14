package com.bhumika.document.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.bhumika.document.entities.Document;
import com.bhumika.document.repos.DocumentRepository;

@RestController
public class DocumentController {

	@Autowired
	DocumentRepository repository;

	@GetMapping("/displayUpload")
	public String displayUpload(ModelMap modelMap) {
		List<Document> documents = repository.findAll();
		System.out.println(documents.size());
		modelMap.addAttribute("documents", documents);
		return "documentUpload";
	}

	@PostMapping("/upload")
	public String uploadDocument(@RequestParam("document") MultipartFile multipartFile, @RequestParam("id") long id,
			ModelMap modelMap) {
		Document document = new Document();
		document.setId(id);
		document.setName(multipartFile.getOriginalFilename());
		try {
			document.setData(multipartFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		repository.save(document);
		List<Document> documents = repository.findAll();
		System.out.println(documents.size());
		modelMap.addAttribute("documents", documents);
		return "documentUpload";
	}

	@GetMapping("/download")
	public StreamingResponseBody download(@RequestParam("id") long id, HttpServletResponse response) {
		Document download = repository.findById(id).get();
		byte[] data = download.getData();
		response.setHeader("Content-Disposition", "attachment;filename=downloaded.jpeg");
		return outputStream -> {
			outputStream.write(data);
		};
	}
}