/**
* @package file_operation
* @author ZS@ZJU
* @version V1.0
*/
package file_operation;

import java.io.File;
import java.io.IOException;

/**
* @className FileUtils
* @description 列出File的一些常用操作
* @author ZS@ZJU
* @date Apr 14, 2016 11:12:38 PM
*/
public class FileUtils {

    /**
    * @description 列出指定目录下（包括其子目录）所有文件
    * @param dir
    * @throws IOException 
    * @returnType void
    */
    public static void listDirectory(File dir) throws IOException { // 这里声明抛出IOException是因为这里的代码处理的是文件相关的
        if (!dir.exists()) {
            throw new IllegalArgumentException("Directory " + dir + " does not exist.");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + " is not a directory.");
        }
        // 取到该目录下所有的File对象
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            // 遍历所有File对象
            for (File file : files) {
                if (file.isDirectory())
                    // 如果File还是目录，则递归遍历该目录
                    listDirectory(file);
                else
                    // 如果不是目录，则打印其路径和名称
                    System.out.println(file.getAbsolutePath());
            }
        }
    }

    /**
    * @description 删除指定文件或目录（包括其中所有内容）
    * @param dir
    * @return
    * @throws IOException 
    * @returnType boolean
    */
    public static void deleteDirectoryOrFile(File f) throws IOException { // 这里声明抛出IOException是因为这里的代码处理的是文件相关的
        if (!f.exists()) {
            throw new IllegalArgumentException("File or directory " + f + " does not exist.");
        }

        // 如果是目录
        if (f.isDirectory()) {
            // 先取到该目录下所有的File对象
            File[] files = f.listFiles();
            if (files != null && files.length > 0) {
                // 遍历所有File对象，并递归地调用删除
                for (File file : files)
                    deleteDirectoryOrFile(file);
            }
            // 最后删除该目录本身，并打印删除记录
            if (f.delete())
                System.out.println("Directory " + f.getAbsolutePath() + " deleted!");
        }
        // 如果不是目录，直接删除，并打印删除记录
        else if (f.delete())
            System.out.println("File " + f.getAbsolutePath() + " deleted!");
    }

    // 简单测试
    public static void main(String[] args) throws IOException {
        // FileUtils.listDirectory(new File("E:" + File.separator + "E-book"));
        FileUtils.deleteDirectoryOrFile(new File("F:\\Mass Relay\\coreJava"));
    }
}
