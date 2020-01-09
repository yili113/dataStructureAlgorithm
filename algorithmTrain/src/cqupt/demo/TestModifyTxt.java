package cqupt.demo;

import java.io.*;

/**
 * @author yiLi
 * @create 2019-11-07 19:05
 */
public class TestModifyTxt {
    private static String path = "G:\\1108test.txt"; // 目标文件路径
    private static File file = new File(path); // 创建目标文件
    private static int numOfModify = 6;

    public static void alterStringToCreateNewFile(String[] oldStringStr, String[] newStringStr) {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file))); // 创建对目标文件读取流
            File newFile = new File("G:/1108testModify.txt"); // 创建临时文件
            if (!newFile.exists()) {
                newFile.createNewFile(); // 不存在则创建
            }
            // 创建对临时文件输出流，并追加
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(newFile, true)));
            String string = null; // 存储对目标文件读取的内容
            while ((string = br.readLine()) != null) {
                for (int i = 0; i < oldStringStr.length; i++) {
                    // 判断读取的内容是否包含原字符串
                    if (string.contains(oldStringStr[i])) {
                        // 替换读取内容中的原字符串为新字符串
                        string = new String(string.replace(oldStringStr[i], newStringStr[i]));
                    }
                }

                bw.write(string);
                bw.newLine(); // 添加换行
            }
            br.close(); // 关闭流，对文件进行删除等操作需先关闭文件流操作
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        String[] oldStringStr = new String[numOfModify];
        String[] newStringStr = new String[numOfModify];
        oldStringStr[0] = "(";
        newStringStr[0] = "";
        oldStringStr[1] = ")";
        newStringStr[1] = "i";
        oldStringStr[2] = "#[";
        newStringStr[2] = "";
        oldStringStr[3] = "]";
        newStringStr[3] = "";
        oldStringStr[4] = ",";
        newStringStr[4] = "+";
        oldStringStr[5] = "+-";
        newStringStr[5] = "-";
        alterStringToCreateNewFile(oldStringStr, newStringStr);
    }
}
