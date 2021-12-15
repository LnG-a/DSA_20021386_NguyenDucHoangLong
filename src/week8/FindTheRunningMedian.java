package week8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindTheRunningMedian {
    public static List<Double> runningMedian1(List<Integer> a) {
        // Write your code here
        List<Integer> arr=new ArrayList<>();
        List<Double> b=new ArrayList<>();
        for (int i =0;i<a.size();i++){
            int value=a.get(i);
            arr.add(value);
            for (int j=arr.size()-1;j>0;j--){
                if (arr.get(j-1)>value) {
                    arr.set(j,arr.get(j-1));
                } else break;
            }
            if (arr.size()%2!=0){
                b.add(Double.valueOf(arr.get(arr.size()/2)));
            } else {
                b.add((Double.valueOf(arr.get(arr.size()/2))+Double.valueOf(arr.get(arr.size()/2-1)))/2);
            }
        }
        return  b;
    }
    public static List<Double> runningMedian(List<Integer> a) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Double> b=new ArrayList<>();

        for (int i = 0; i < a.size(); ++i) {
            int v = a.get(i);
            if (maxHeap.isEmpty() || (v < maxHeap.peek())) {
                maxHeap.offer(v);
            } else {
                minHeap.offer(v);
            }

            if (maxHeap.size() > (minHeap.size() + 1)) {
                minHeap.offer(maxHeap.poll());
            }

            if (minHeap.size() > (maxHeap.size() + 1)) {
                maxHeap.offer(minHeap.poll());
            }

            if (maxHeap.size() > minHeap.size()) {
                b.add(Double.valueOf(maxHeap.peek()));
            } else if (minHeap.size() > maxHeap.size()) {
                b.add(Double.valueOf(minHeap.peek()));
            } else {
                b.add(0.5 * (Double.valueOf(maxHeap.peek()) + Double.valueOf(minHeap.peek())));
            }
        }
        return b;
    }
}
