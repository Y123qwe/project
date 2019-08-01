//循环队列
public class MyCircularQueue {
    private int front;//对头的下标
    private int rear;//队尾的下标
    private int[] elum;//数组
    private int usedSize;//有效的数据个数

    public MyCircularQueue(int k) {
        this.elum = new int[k];
        this.front = 0;
        this.rear = 0;
        this.usedSize = 0;
    }

    //入队
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.elum[this.rear] = value;
        this.rear = (this.rear + 1) % this.elum.length;
        this.usedSize++;
        return true;
    }

    //出队
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front + 1) % this.elum.length;
        this.usedSize--;
        return true;
    }

    //得到队头元素
    public int Front() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("队列为空");
        }
        return this.elum[this.front];
    }

    //得到队尾元素
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
//      if (this.rear==0){
//          return this.elum[this.elum.length-1];
//      }
//      return this.elum[this.rear-1];
        //简化版本
        int index = this.rear == 0 ? this.elum.length - 1 : this.rear - 1;
        return this.elum[index];
    }

    //是否为空
    public boolean isEmpty() {
        return this.rear == this.front;
//      return this.usedSize==0;
    }

    //是否为满
    public boolean isFull() {
        if ((this.rear + 1) % this.elum.length == this.front) {
            return true;
        }
        return false;
    }
}

