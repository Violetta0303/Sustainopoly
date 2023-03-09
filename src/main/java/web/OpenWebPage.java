package web;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;

public class OpenWebPage {

    public static void main(String[] args) {
        // index.html文件在项目根目录下
        String filePath = "src/main/java/webresources/MentalHealth/index.html";
        // 获取文件对象
        File file = new File(filePath);

        try {
            // 创建URI对象
            URI uri = file.toURI();
            // 获取桌面对象
            Desktop desktop = Desktop.getDesktop();
            // 打开网页
            desktop.browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}










