package com.eviro.assessment.grad001.kgaugelophathela;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
	
	@Autowired
	private ImageRepository imageRepository;
	
	//Method to retrieve httpImageLink from database
	 public FileSystemResource gethttpImageLink(String name, String surname) {
		 
	      Optional<AccountProfile> accountProfileOptional = imageRepository.findById(name);
	      AccountProfile accountProfile = accountProfileOptional.get();
	      String httpImageLink = accountProfile.getHttpImageLink();
	      String filePath = httpImageLink.replaceFirst("file:", "");
	            
	      return new FileSystemResource(filePath);
	        
	    }
}
