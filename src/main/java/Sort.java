public class Sort {
    public void bubbleSort(int[] list) {
        int temp = 0; // 用来交换的临时数

                // 要遍历的次数
        for (int i = 0; i < list.length - 1; i++) {
            // 从后向前依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = list.length - 1; j > i; j--) {
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (list[j - 1] > list[j]) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                }
            }

            System.out.format("第 %d 趟：\t", i+1);
            printAll(list);
        }
    }

    // 对 bubbleSort 的优化算法
    public void bubbleSort_2(int[] list) {
        int temp = 0; // 用来交换的临时数
        boolean bChange = false; // 交换标志
        // 要遍历的次数
        for (int i = 0; i < list.length - 1; i++) {
            bChange = false;
            // 从后向前依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = list.length - 1; j > i; j--) {
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (list[j - 1] > list[j]) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                    bChange = true;
                }
            }
            // 如果标志为false，说明本轮遍历没有交换，已经是有序数列，可以结束排序
            if (false == bChange)
                break;
            System.out.format("第 %d 趟：\t", i+1);
            printAll(list);
        }
    }

    // 打印完整序列
    public void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr={4,3,1,2,5};
        Sort sort = new Sort();
        System.out.println("排序前"+arr);
        System.out.println("排序后");
        sort.bubbleSort_2(arr);

        sort.bubbleSort(arr);

            /*// 初始化一个随机序列
            final int MAX_SIZE = 10;
            int[] array = new int[MAX_SIZE];
            Random random = new Random();
            for (int i = 0; i < MAX_SIZE; i++) {
                array[i] = random.nextInt(MAX_SIZE);
            }

            // 调用冒泡排序方法
            System.out.print("排序前:\t");
            sort.printAll(array);
            sort.bubbleSort_2(array);
            System.out.print("排序后:\t");
            sort.printAll(array);*/


    }
}
