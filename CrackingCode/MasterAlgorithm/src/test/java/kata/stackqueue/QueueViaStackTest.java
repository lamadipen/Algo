package kata.stackqueue;

import org.junit.Assert;
import org.junit.Test;

public class QueueViaStackTest {
    @Test
    public void queueByStack() {
        QueueViaStack queueViaStack = new QueueViaStack();
        queueViaStack.queue(1);
        queueViaStack.queue(2);
        queueViaStack.queue(3);
        queueViaStack.queue(4);

        Assert.assertEquals(1,queueViaStack.dequeue());

        queueViaStack.queue(5);
        Assert.assertEquals(2,queueViaStack.dequeue());
    }
}
