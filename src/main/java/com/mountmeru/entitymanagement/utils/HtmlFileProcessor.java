package com.mountmeru.entitymanagement.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class HtmlFileProcessor {

    public static String readHtmlFile(String filePath) throws IOException {
        // Read the HTML file content as a String
        return Files.readString(Paths.get(filePath));
    }

    public static String replacePlaceholders(String htmlContent, Map<String, String> placeholders) {
        if (htmlContent == null || placeholders == null) {
            return htmlContent; // Return original content if null
        }

        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (key != null && value != null) {
                htmlContent = htmlContent.replace(key, value);
            }
        }
        return htmlContent;
    }

    public static void writeHtmlFile(String filePath, String modifiedHtmlContent) throws IOException {
        Files.writeString(Paths.get(filePath), modifiedHtmlContent);
    }
}
