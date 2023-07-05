package com.eviro.assessment.grad001.kgaugelophathela;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/api/image")
public class ImageController {
	
	@Autowired
	private CSVFileParser csvFileParser;
	@Autowired
	private ImageService imageService;
	
	@GetMapping(value = "/{name}/{surname}/{\\w\\.\\w}")
	public ResponseEntity<FileSystemResource> getHttpImageLink(@PathVariable String name, @PathVariable String surname) {
		
		String imageFormat = csvFileParser.format;
		FileSystemResource imageFile = imageService.gethttpImageLink(name, surname);
	    HttpHeaders headers = new HttpHeaders(); 
	    
	    //Setting content-type(image/jpg or image/png)
	    MediaType mediaType = MediaType.parseMediaType(imageFormat);
	    headers.setContentType(mediaType);
	    
	    return ResponseEntity.ok()
	            .headers(headers)
	            .body(imageFile); //image

	}
    
	

}
