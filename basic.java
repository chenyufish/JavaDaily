class Book{
    String name;
    double price;

    public Book(String name,double price){
        this.name = name;
        this.price = price;
    }
    public void getInfo(){
        System.out.println("图书名称："+ name + "，价格：" + price);
    }

    public void setPrice(double price){
        this.price = price;
    }
}
public class basic {
    public static void main(String[] args){
        int msg = 100;
        System.out.println("调用方法前msg的值：\n"+ msg);    //100
        fun(msg);
        System.out.println("调用方法后msg的值：\n"+ msg);    //100
        Book book = new Book("Java开发指南",66.6);
        book.getInfo();  //图书名称：Java开发指南，价格：66.6
        fun(book);
        book.getInfo();  //图书名称：Java开发指南，价格：99.9
        int[] list1 = {1, 2, 3};
        //因为数组也是引用，此处可以接收这里的数组应用list1
        Object list2 = list1;
        //但是这里输出时，就需要判断下是否是整型数组，然后再进行输出操作
        if (list2 instanceof int[]){
            //执行向下转型操作
            int[] list3 = (int[]) list2;
            for (int i : list3) {
                System.out.println(i);
            }
        }
    }
    public static void fun(int temp){
        temp = 0;
    }
 
    public static void fun(Book temp){
        temp.setPrice(99.9);
    }
    
}
