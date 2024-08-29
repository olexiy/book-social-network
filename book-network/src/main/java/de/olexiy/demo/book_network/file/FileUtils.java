package de.olexiy.demo.book_network.file;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class FileUtils {
    public static byte[] readFileFromLocation(String fileUrl) {
        if (StringUtils.isBlank(fileUrl)) {
            return null;
        }
        try {
            return Files.readAllBytes(Paths.get(fileUrl));
        } catch (IOException e) {
            log.warn("No file found at location: {}", fileUrl);
        }
        return new byte[0];
    }
}
