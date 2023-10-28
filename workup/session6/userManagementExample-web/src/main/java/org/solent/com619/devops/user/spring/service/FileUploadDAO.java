package org.solent.com619.devops.user.spring.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadDAO {
    private static final Logger LOG = LogManager.getLogger(FileUploadDAO.class);
    
    @Autowired
    private Environment env;

	public void saveFile(String relativeUploadDir, String fileName, MultipartFile multipartFile) throws IOException {
		
		String savePath = env.getProperty("image.file.uploadpath");
		Path uploadPath = Paths.get(savePath+relativeUploadDir);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
			LOG.debug("file upload path: "+filePath.toString());
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Could not save image file: " + fileName, ioe);
		}
	}
}