package cqupt.algorithmBook;

/**
 * @author yiLi
 * @create 2019-12-19 20:45
 */
public class MyArrayList {
    private static final int DEFAULT_CAPACITY = 10;// 默认容量
    private static Integer[] theItems;// 表示当前数组
    private static int theSize;// 当前数组的真实大小  只有在add和remove操作时才会对 这个属性改变

    /**
     * 构造器
     */
    public MyArrayList() {
        doClear();
    }

    /**
     * 确保数组容量够用
     *
     * @param newCapacity
     */
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;// 不做改变
        }
        Integer[] old = theItems;
        theItems = new Integer[newCapacity];
        for (int i = 0; i < size(); i++) {  //   ！！！此处old的size>=size()   old数组中在size()后面的值都是null,遍历到这些地方时就会出现空指针
            theItems[i] = old[i];
        }
    }

    /**
     * 数组清空 容量回归默认
     */
    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    /**
     * 执行clear操作
     */
    public void doClear() {
        clear();
    }

    /**
     * @return 当前数组大小
     */
    public int size() {
        return theSize;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size() == 0 ? true : false;
    }

    /**
     * 去掉多余
     */
    public void trimToSize() {
        ensureCapacity(size());
    }

    /**
     * set方法
     *
     * @param idx
     * @param value
     * @return 返回替换掉的那个值
     */
    public Integer set(int idx, Integer value) {
        if (idx < 0 || idx >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Integer old = theItems[idx];
        theItems[idx] = value;
        return old;
    }

    /**
     * @param idx
     * @return
     */
    public Integer get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    /**
     * 一定不能忘记最后有个 size++
     * 从idx开始往后的位置元素整体后移
     *
     * @param idx
     * @param value
     */
    public void add(int idx, Integer value) {
        if (theItems.length == size()) {// 现有大小已经占满了数组容量 再加就溢出 所以需要先扩容
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = size(); i > idx; i--) {// size()表示末尾元素的下一个   i>idx不能有=
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = value;
        theSize++;
    }

    /**
     * 在末尾添加
     *
     * @param value
     * @return
     */
    public boolean add(Integer value) {
        add(size(), value);
        return true;// 如果上一步没进行 这步就会false
    }

    /**
     * @param idx
     * @return
     */
    public Integer remove(int idx) {
        Integer removeOne = theItems[idx];
        for (int i = idx; i < size() - 1; i++) {// 循环只能到倒数第二个元素 因为下面有i++
            theItems[i] = theItems[i++];
        }
        theSize--;
        return removeOne;
    }
}
