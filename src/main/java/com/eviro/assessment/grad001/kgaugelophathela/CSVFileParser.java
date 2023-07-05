package com.eviro.assessment.grad001.kgaugelophathela;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Component;

@Component
public class CSVFileParser implements FileParser {
	
	@Autowired
	private ImageRepository imageRepository;
	public String format; //instance of the imageFormat 

	@Override
	public void parseCSV(File csvFile) {
		
		try  {
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			br.readLine(); //skip first row
            String row;
            while ((row = br.readLine()) != null) {
                String[] data = row.split(",");

                String name = data[0];
                String surname = data[1];
                String imageFormat = data[2];
                String imageData = data[3];
                format = imageFormat;
                
                //convert base64 image
                File dataToImage=convertCSVDataToImage(imageData);
                
                //create URI return as string
                String link =createImageLink(dataToImage).toString(); 
                
                List<AccountProfile> details = new ArrayList<>(Arrays.asList(
            			new AccountProfile(name, surname, link)));
                 
                 imageRepository.saveAll(details);   
            }
        } 
		
		catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public File convertCSVDataToImage(String base64ImageData) {
		try {
			//Decodes a Base64 encoded String into a byte array
            byte[] imageData = Base64.getDecoder().decode(base64ImageData);
            
            String[] decodeFormat=format.split("/");
            
            File imageFile = File.createTempFile("image", '.'+decodeFormat[1]);
            Path filePath = imageFile.toPath();
            Files.write(filePath, imageData); // write the imageData to a file
            
            return imageFile;
        } 
		
		catch (Exception e) {
            return null;
        }
	}

	@Override
	public URI createImageLink(File fileImage) {
		return fileImage.toURI();
	}}
