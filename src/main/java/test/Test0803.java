package test;

import java.util.ArrayList;
import java.util.List;

public class Test0803 {
    public static void main(String[] args) {
        //字符串由单词和下划线组成，要求单词倒序输出、下划线正序输出
        //示例：
        //输入：“my_name____is__dd”
        //输出：“dd_is____name__my”
        String s = "my_name____is__dd";
        String res = reverseWord(s);
        System.out.println(res);
    }

    public static String reverseWord(String s) {
        char[] arr = s.toCharArray();
        int index = 0;
        int start = -1;
        int end = -1;


        while (index < arr.length) {
            if (arr[index] != '_') {
                if (start == -1) {
                    start = index;
                }
            } else {
                // == '_'
                if (start != -1 && end == -1) {
                    end = index - 1;
                    swap(arr, start, end);
                    start = -1;
                    end = -1;
                }
            }
            index++;
        }
        if(index == arr.length){
            if (start != -1 && end == -1) {
                end = index-1;
                swap(arr, start, end);
            }
        }
        // 下划线 不交换
        swap(arr, 0, arr.length - 1);

        return new String(arr);


    }

    public void swap2(){

    }

    public static void swap(char[] arr, int i, int j) {

        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }


}
