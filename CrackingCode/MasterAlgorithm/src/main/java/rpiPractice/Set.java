package rpiPractice;

public class Set {

    private int size = 0;
    private Object[] arr;

    public Set() {
        arr = new Object[3];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object i) {
        if (contains(i)){
         return;
        }
        if(size == arr.length){
            resize();
        }
        arr[size] = i;
        size++;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object i) {
        return getIndex(i) != -1;
    }

    public void remove(Object i) {
        int index = getIndex(i);
        arr[index] = arr[size - 1];
        arr[size - 1] = null;
        size--;
    }

    private int getIndex(Object i) {
        for (int j = 0; j < size; j++) {
            if (arr[j].equals(i)) {
               return j;
            }
        }
        return -1;
    }

    private void resize() {
        Object[] temp = new Object[2 * size];
        System.arraycopy(arr,0,temp,0,size);
        arr = temp;
    }

    //List implementation
    public void addList(Object i) {
        if(size == arr.length){
            resize();
        }
        arr[size] = i;
        size++;
    }

    public void removeList(Object item) {
        if(!contains(item)) {
            return;
        }
        int index = getIndex(item);
        for (int i = index; i < size -1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size-1] = null;
        size--;
    }

    public Object getElementByIndex(Object item) {
        return  arr[(int) item];
    }
}
//collecrion
//add
//remove
//no duplicate no order
