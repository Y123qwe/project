//测试循环队列
public class TestCircular{
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue=new MyCircularQueue(10);
        myCircularQueue.enQueue(10);
        myCircularQueue.enQueue(20);
        myCircularQueue.enQueue(30);
        myCircularQueue.enQueue(40);
        myCircularQueue.deQueue();
        //20
        System.out.println(myCircularQueue.Front());
        //40
        System.out.println(myCircularQueue.Rear());
    }
}
