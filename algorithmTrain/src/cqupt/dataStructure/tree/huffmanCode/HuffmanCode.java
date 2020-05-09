package cqupt.dataStructure.tree.huffmanCode;

import java.io.*;
import java.util.*;

/**
 * @author yiLi
 * @create 2020-01-07 22:23
 */
public class HuffmanCode {
    public static void main(String[] args) {
     /*   String str = "i like like like java do you like a java";
*//*        byte[] strContent = str.getBytes();
        List<Node> nodes = getNodes(strContent);
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        System.out.println("哈夫曼编码：" + huffmanCodes);
        // 压缩
        byte[] zipBytes = zip(strContent, huffmanCodes);
        System.out.println(Arrays.toString(zipBytes));*//*
        // 编码压缩
        byte[] huffmanBytes = huffmanCodeZip(str);
        // 生成码表
        // Map<Byte, String> byteStringMap = huffmanCode(str);
        // huffmanCodes是类的静态变量  直接用就好

        // 译码解压缩
        byte[] oriBytes = decode(huffmanCodes, huffmanBytes);
        System.out.println(new String(oriBytes));*/

        // 测试文件压缩
        /*String srcFile = "g://MyThreadPoolDemo.txt";
        String dstFile = "g://MyThreadPoolDemo.zip";
        zipFile(srcFile, dstFile);*/
        // 测试文件解压
        String srcFile = "g://test.zip";
        String dstFile = "g://test1.txt";
        unZipFile(srcFile, dstFile);

    }

    /**
     * 文件解压
     * @param srcFile
     * @param dstFile
     */
    public static void unZipFile(String srcFile, String dstFile) {
        // 创建输入流
        FileInputStream is = null;
        // 与输入流关联的对象输入流
        ObjectInputStream ois = null;
        // 文件输出流
        FileOutputStream os = null;

        try {
            is = new FileInputStream(srcFile);
            ois = new ObjectInputStream(is);
            // 按照对象的方式读文件
            // 对象读流得到的是Object   要得到特定的对象需要强转
            byte[] huffmanBytes = (byte[]) ois.readObject();// 读出哈夫曼字节数组
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            // 调用译码解压方法
            byte[] decodeBytes = decode(huffmanCodes, huffmanBytes);
            // 将解压出来的字节数组存放到目标文件中
            os = new FileOutputStream(dstFile);
            os.write(decodeBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 文件压缩
     * @param srcFile 原文件路径
     * @param dstFile 压缩到的目的地
     */
    public static void zipFile(String srcFile, String dstFile) {
        // 创建输出流
        OutputStream os = null;
        ObjectOutput oos = null;
        // 创建输入流
        FileInputStream is = null;

        try {
            is = new FileInputStream(srcFile);
            // 创建一个和源文件大小一言改的byte[]
            byte[] b = new byte[is.available()];
            // 读取文件
            is.read(b);// 把文件读到这个数组中
            // 对文件压缩
            byte[] huffmanBytes = huffmanCodeZip(b);
            // 创建输出流 存放压缩文件
            os = new FileOutputStream(dstFile);
            // 创建一个和文件输出流关联的 ObjectOutputStream
            oos = new ObjectOutputStream(os);
            // 把编码压缩后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            // 同时把编码表也要写进去
            // 用对象流 是为了恢复方便
            oos.writeObject(huffmanCodes);// 这种流可以写进去对象
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                oos.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 重载压缩方法
     * @param strContent 字节数组
     * @return
     */
    public static byte[] huffmanCodeZip(byte[] strContent) {
        // 将英文字节数组转成对应的哈夫曼结点
        List<Node> nodes = getNodes(strContent);
        // 用结点生成哈夫曼树  返回的是哈夫曼树的根结点
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        // 将哈夫曼树转成对应的字符和其出现次数 存放在map中
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        // 将map转换成字节数组 压缩
        byte[] zipBytes = zip(strContent, huffmanCodes);
        return zipBytes;
    }

    /**
     * 哈夫曼编码压缩方法
     * @param string 一串英文字符串
     * @return 生成的哈夫曼字节数组
     */
    public static byte[] huffmanCodeZip(String string) {
        byte[] strContent = string.getBytes();
        // 将英文字节数组转成对应的哈夫曼结点
        List<Node> nodes = getNodes(strContent);
        // 用结点生成哈夫曼树  返回的是哈夫曼树的根结点
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        // 将哈夫曼树转成对应的字符和其出现次数 存放在map中
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        // 将map转换成字节数组 压缩
        byte[] zipBytes = zip(strContent, huffmanCodes);
        return zipBytes;
    }

    /**
     * 生成包含字符和该字符出现次数两个属性的结点
     * @param bytes 字符串转成的字符数组
     * @return 组成的结点数组 里面的node存放的属性有 字符和其次数
     */
    public static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<>();
        // 遍历bytes 统计每个byte出现的次数 用map存储
        Map<Byte, Integer> counts = new HashMap<>();
        for(byte b : bytes) {
            Integer count = counts.get(b);
            if(count == null) {// 表示第一次出现该字符
                counts.put(b, 1);
            }else {// 在之前的次数上累加
                counts.put(b, count + 1);
            }
        }
        // 此时已经将字符串中各个字符和其出现次数存放到了map中
        for(Map.Entry<Byte, Integer> entry : counts.entrySet()) {// mapd的遍历 还不熟
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        // 此时已经将字符与其出现的次数放在了node结点中了
        return nodes;
    }

    /**
     *
     * @param nodes 由字符表示的node数组
     * @return 形成的哈夫曼树 返回的是根结点
     */
    public static Node createHuffmanTree(List<Node> nodes) {

        // 开始处理
        // 当列表中只剩一个结点时结束 这个最后剩下的结点就是最终哈夫曼树的根结点
        while (nodes.size() > 1) {
            // 1.排序从小到大
            Collections.sort(nodes);
            // 2.取出当前列表中权值最小的两个结点 每个结点都可以看做是一个二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            // 3.构建一个新的二叉树
            // 新的结点没有data 只有 weight 只有叶子结点才有data
            // byte没有null 只有Byte才有null
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            // 拼接上
            parent.left = leftNode;
            parent.right = rightNode;
            // 4.从列表中删除刚才用于拼接新二叉树的两个结点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 5.将父结点（新拼接的二叉树的根结点）放进列表中
            nodes.add(parent);
        }
        // 返回最终哈夫曼树的根结点
        return nodes.get(0);
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();// 调用结点类中的前序遍历
        }else {
            System.out.println("哈夫曼树为空");
        }
    }
    /**
     * 生成 哈夫曼树对应的编码表
     * 1.编码表是 字符与0101...对应的  存于map中 <Byte, String>
     *     例如 32->01  97->100....
     * 2.用一个stringBuilder保存不断拼接的 010101
     */
    static Map<Byte, String> huffmanCodes = new HashMap<>();// 例如 32->01  97->100....
    static StringBuilder stringBuilder = new StringBuilder();// 用一个stringBuilder保存不断拼接的 010101

    /**
     * 重载生成哈夫曼编码方法
     * @param root
     */
    public static Map<Byte, String> getCodes(Node root) {
        if (root != null) {
            // 处理左子树
            getCodes(root.left, "0", stringBuilder);
            // 处理右子树
            getCodes(root.right, "1", stringBuilder);
        }else {
            System.out.println("哈夫曼树为空！");
        }
        return huffmanCodes;
    }
    /**
     * 将哈夫曼树上的每个结点转成对应的哈夫曼表 010101这样的 用String表示
     * @param node 当前的结点
     * @param code 单一的（当前的0或者1） 01010
     * @param stringBuilder 用于拼接路径010101
     */
    public static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        // 将code不断拼接到stringBuilder中
        stringBuilder2.append(code);
        if (node != null) {
            // 判断node是叶子还是非叶子
            if (null == node.data) {// 没有数据属性的就是非叶子
                // 向左递归  左是0
                getCodes(node.left, "0", stringBuilder2);
                // 向右递归 右是1
                getCodes(node.right, "1", stringBuilder2);

            }else {// 叶子结点
                // 如果到了叶子结点 说明这个叶子结点对应的字符的哈夫曼码已经生成
                // 存放到map中
                huffmanCodes.put(node.data, stringBuilder2.toString());
                // StringBuilder 和 String还是不同 需要转一下
            }
        }
    }

    /**
     * 压缩
     * 将生成的哈夫曼码字进行压缩 转成二进制的数 存放到byte数组
     * @param bytes 原始的字符数组
     * @param huffmanCodes 哈夫曼码字 里面是不同字符对应的二进制码字
     * @return 数字组成的字节数组
     * 1.原本的字符串中的每个字符都会对应一串哈夫曼码字
     * 2.将每个字符对应的哈夫曼码字拼接到一起
     * 3.然后将拼接到一起的码字以8位为一组进行转换
     * 4.将8位为一组的二进制哈夫曼码字以二进制的形式转成十进制数字 有正有负
     * 5.将10进制数放到字节数组中 返回
     */
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        // 1.将不同字符的哈夫曼码字拼接在一起 形成一个长的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for(byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));huffmanCodes.get(b);// 是拿到不同字符对应的码字
        }
        // 2.将1010100010.。。。转成byte[]
        // 下面代码简化成  int len = (stringBuilder.length() + 7) / 8!!!
        int len;
        if (stringBuilder.length() % 8 == 0) {// 刚才是8的倍数 8位一字节
            len = stringBuilder.length() / 8;
        }else {
            len = stringBuilder.length() / 8 + 1;
        }
        // 创建 存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;// 记录byte的索引
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);// 如果最后一组不够8位 那就从i开始 有几位放几位
            }else {
                strByte = stringBuilder.substring(i, i + 8);// 每组都够8位
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);// 将字符串以二进制的形式转成数字
            index ++;
        }
        return huffmanCodeBytes;
    }

    /**
     * 将一个字节（数字）转成二进制的字符串（这个字符串是八位的）
     * @param flag 标识当前byte是不是最后一个
     * @param b 需要转换的byte
     * @return
     * 最后一个byte是不需要不高位的，也就是说不用凑成8位。但是前面的都是以8位一组进行编码的
     * 所以都要以8位一组转回去
     */
    public static String byteToBitString(boolean flag, byte b) {
        int temp = b;// 将byte转成整型  因为Integer类有方法可以转成二进制字符串
        // 如果是正数 还需要补高位
        if (flag) {// 需要补高位
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);// Integer类有方法可以转成二进制字符串
        if (flag) {// 不是最后一个 直接输出后8位
            return str.substring(str.length() - 8 );
        }else {// 是最后一个 不用补高位 输出  是多少位就是多少位
            return str;
        }
    }

    /**
     * 数据解压
     * 1.将 huffmanCodeBytes [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28】
     * 重写先转成 赫夫曼编码对应的二进制的字符串 "1010100010111..."
     * 2. 赫夫曼编码对应的二进制的字符串 "1010100010111..." =》 对照 赫夫曼编码 =》 "i like like like
     * java do you like a java"
     * @param huffmanCodes 哈夫曼编码表 字符跟01字符串对应的
     * @param huffmanBytes 通过哈夫曼压缩之后的数字byte数组
     * @return 原来的 i like.... 数组
     */
    public static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        // 1.得到赫夫曼编码对应的二进制的字符串 "1010100010111..."
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            // 判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);// 要是最后一个字节就为true
            // byteToBitString方法中不是最后一个字节 第一个参数为false 所以取反
            stringBuilder.append(byteToBitString(!flag, b));
        }
        // 2.将哈夫曼表相反存放 key为01010等  value为对应字符
        HashMap<String, Byte> map = new HashMap<>();
        for(Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        // 3.将第一步得到的字符串按照哈夫曼表进行分割 然后存放到list中
        ArrayList<Byte> list = new ArrayList<>();
        // index相当于一个指针 遍历二进制字符串
        for (int index = 0; index < stringBuilder.length();) {
            int count = 1;
            boolean flag = true;// 标识是否匹配到一个字符
            Byte b = null;// 存放匹配到的那个字符
            while (flag) {
                // count一个一个的家 不断得去匹配
                String key = stringBuilder.substring(index, index + count);
                b = map.get(key);
                // 如果上述有对应的key  就能取出来字符
                if (b == null) {
                    count ++;// 一个个的移动
                }else {// 匹配到了
                    flag = false;// 跳出while
                }
            }
            list.add(b);// 存放到list中
            index += count;// !!!指针移动多少取决于count 妙！！！
        }
        // for之后所有的字符都已经存放到了list中
        // 再将list中的存到byte数组中
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }

}

/**
 * 结点类
 */
class Node implements Comparable<Node> {
    Byte data;// 某个字符
    int weight;// 表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // 表示从小到大排序
        // 要是从大到小加个-号即可
        return this.weight - o.weight;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

}
