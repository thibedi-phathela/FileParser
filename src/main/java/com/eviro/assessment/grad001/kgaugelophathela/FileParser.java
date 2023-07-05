package com.eviro.assessment.grad001.kgaugelophathela;

import java.io.File;
import java.net.URI;

interface FileParser {
	void parseCSV(File csvFile);
	File convertCSVDataToImage(String base64ImageData);
	URI createImageLink(File fileImage);
}


