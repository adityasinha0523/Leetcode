import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import java.lang.*;

class problem912{
    public static void main(String args[]) throws IOException{  
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Redirecting the I/O to external files
            // as ONLINE_JUDGE constant is not defined which
            // means
            // the code is not running on an online judge
            PrintStream ps= new PrintStream(new File("output.txt"));
            InputStream is= new FileInputStream("input.txt");
            System.setIn(is);
            System.setOut(ps);
        }
        Scanner scan = new Scanner(System.in);
        //For reading string from input file
        //String myLine = scan.nextLine();
        //scan.nextLine();
        //To take int array as input
        
        int[] nums=new int[6];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int[] sol=sortArray1(nums);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;
    }

    public static void mergesort(int[] nums,int left,int right){
        if(left<right){
            int mid=left+(right-left)/2;
            mergesort(nums, left, mid);
            mergesort(nums, mid, right);
            mergerJoin(nums,left,mid,right);
        }
    }

    public static void mergerJoin(int[] nums,int left,int mid,int right){
        int leftArrayLen=mid-left+1;
        int rightArrayLen=right-mid;
        int[] leftPartArr=new int[leftArrayLen];
        for (int i = 0; i < leftPartArr.length; i++) {
            leftPartArr[i]=nums[left+i];
        }
        int[] rightPartArr=new int[rightArrayLen];
        for (int i = 0; i < rightPartArr.length; i++) {
            rightPartArr[i]=nums[mid+1+i];
        }
        int leftPointer=0;
        int rightPointer=0;
        int numsIndex=left;
        while(leftPointer<leftArrayLen||rightPointer<rightArrayLen){
            if(rightPointer==rightArrayLen||leftPointer<leftArrayLen
            && leftPartArr[leftPointer]<rightPartArr[rightPointer]){
                nums[numsIndex++]=leftPartArr[leftPointer++];
            }else{
                nums[numsIndex++]=rightPartArr[rightPointer++];
            }
        }
    }


    public static int[] sortArray1(int[] nums) {
        HashMap<Integer,Integer> hMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hMap.put(nums[i],hMap.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->a.getKey()-b.getKey());
        int[] solution=new int[nums.length];
        pq.addAll(hMap.entrySet());
        int k=0;
        while(pq.size()!=0){
            Map.Entry<Integer,Integer>p=pq.poll();
            int key=p.getKey();
            int value=p.getValue();
            for (int i = 0; i < value; i++) {
                solution[k++]=key;
            }
        }
        return solution;
    }

    public List<Integer> sortArray(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        quickSort(nums, 0, nums.length - 1);
        for (int i : nums) res.add(i);
        return res;
    }
    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = partition(nums, l, r);
        quickSort(nums, l, mid);
        quickSort(nums, mid + 1, r);
    }
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

    public int[] sortArray3(int[] nums) {
        int[] sol=new int[nums.length];
        quickSort(nums, 0, nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            sol[i]=nums[i];
        }
        return sol;
    }

    public void quickSort(int[] nums,int l,int r){
        if(l>=r)return;
        int mid=partition(nums,l,r);
        quickSort(nums, l, mid);
        quickSort(nums, mid+1, r);
    }

    public int partition(int[] num,int l,int r){
        int pivot=num[l];
        while(l<r){
            while(l<r && num[l]<=pivot){
                l++;
            }
            num[r]=num[l];
            while(l<r && num[r]>pivot){
                r++;
            }
            num[l]=num[r];
        }
        num[l]=pivot;
        return l;
    }
}  
