package history;

public class ConstructorArr {


    public static int[] makeArr(int size) {

        if (size == 1) {
            return new int[]{1};
        }

        int halfSize = (size + 1) / 2;
        int[] halfArr = makeArr(halfSize);
        int index = 0;
        int[] res = new int[size];
        for (; index < halfSize; index++) {
            //利用一半的数组，构造奇数数组
            res[index] = 2 * halfArr[index] + 1;
        }
        for (int i=0; index <size ; i++,index++) {
            //利用一半的数组，构造偶数数组
            res[index] = 2 * halfArr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = makeArr(7);
        System.out.println(res);
    }
}
