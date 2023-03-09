package videoplayer.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class FileUtils {

    public static List<String> readFilePath(String folderPath) {
        List<String> list = new ArrayList<>();
        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            return list;
        }
        File[] files = folder.listFiles();
        if (Objects.isNull(files) || files.length <= 0) {
            return list;
        }
        for (File file : files) {
            if (!file.isFile()) {
                continue;
            }
            list.add(file.getAbsolutePath());
        }
        return list;
    }

    public static List<String> readAllFilePath(String folderPath) {
        Stack<File> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            return list;
        }
        stack.push(folder);
        while (!stack.isEmpty()) {
            File tmpFile = stack.pop();
            File[] subFiles = tmpFile.listFiles();
            if (subFiles == null) {
                continue;
            }
            for (File subFile : subFiles) {
                if (subFile.isDirectory()) {
                    stack.push(subFile);
                } else {
                    list.add(subFile.getAbsolutePath());
                }
            }
        }
        return list;
    }

    public static String getFileName(String path) {
        if (StringUtils.isBlank(path) || !path.contains(File.separator)) {
            return path;
        }
        return path.substring(path.lastIndexOf(File.separator) + 1);
    }
}
