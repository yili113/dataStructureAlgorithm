package cqupt.algorithmBook;

/**
 * @author yiLi
 * @create 2019-12-19 21:19
 */
public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(10);
        myArrayList.add(4);
        myArrayList.add(8);
        myArrayList.add(5);

//        myArrayList.doClear();
//        myArrayList.set(2,100);
//        myArrayList.remove(4);
        System.out.println(myArrayList.get(2));
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.print(myArrayList.get(i) + " ");
        }
        myArrayList.ensureCapacity(12);


    }
}
