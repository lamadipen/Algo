package mum.algo;

public class BinarySearch {

    public static void main(String[] args) {
	// write your code here
         int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
         int index1 =bSearchRecursive(arr,0,arr.length-1,4);
         int index2 = bSearchIterative(arr,0,arr.length-1,4);
         System.out.println(index1);
         System.out.println(index2);
    }

    public static int bSearchRecursive(int [] array, int begin, int end, int target)
    {
        if(begin > end)
        {
            return -1;
        }

        //int mid = (begin+end)/2;
        int mid = begin +((end -begin)/2);
        if(array[mid] == target)
        {
            return mid;
        }
        else if(array[mid] < target)
        {
            return bSearchRecursive(array,mid+1,end,target);
        }
        else
        {
            return bSearchRecursive(array,begin,mid-1,target);
        }
    }

    public static int bSearchIterative(int [] array, int begin, int end, int target)
    {
        while(begin <= end)
        {
            int mid = (begin+end)/2;
            //int mid = begin +((end -begin)/2);
            if(array[mid] == target)
            {
                return mid;
            }
            else if(array[mid] < target)
            {
                begin = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        return -1;
    }

}
