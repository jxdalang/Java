package exam;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

// 模拟CPU调度，求平均等待时间
public class AverageCPUWaitTime {

    // arrival数组代表task的到达时间
    // run数组代表task需要多少时间能执行完
    // 数组下标代表task编号，两个数组长度相同，元素皆为正整数
    // q代表CPU时间片长度，为正整数
    public static float calculateAWT(int[] arrival, int[] run, int q) {
        // INSERT YOUR CODE HERE
        int taskCount = arrival.length;
        int[] waitTime = new int[taskCount];

        // 计算一个所有task都能执行完的时间
        int TotalTimeLimit = arrival[taskCount - 1];
        for (int i = 0; i < taskCount; i++) {
            TotalTimeLimit += run[i];
        }

        // make a index of arrival tasks in a specific time
        HashMap<Integer, ArrayList<Integer>> timeOfArrival = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < taskCount; i++) {
            if (timeOfArrival.containsKey(arrival[i])) {
                timeOfArrival.get(arrival[i]).add(i);
            } else {
                ArrayList<Integer> tasks = new ArrayList<Integer>();
                tasks.add(i);
                timeOfArrival.put(arrival[i], tasks);
            }
        }

        // CPU initial status
        boolean cpuIdle = true;
        int cpuTaskID = -1;
        int cpuRuntime = 0;

        // task等待CPU调度的队列（用链表来实现）
        Queue<Integer> taskWaitQueue = new LinkedList<Integer>();

        // 从开始到所有task肯定运行完成
        for (int time = 0; time <= TotalTimeLimit; time++) {

            System.out.println("Current time = " + time + "s:");

            // 新到达的task入队
            if (timeOfArrival.containsKey(time)) {
                for (int task : timeOfArrival.get(time)) {
                    taskWaitQueue.offer(task);
                    System.out.println("Task " + task + " arrives at time = " + time + ".");
                }
            }

            // CPU运行情况
            if (!cpuIdle) {
                cpuRuntime++;
                System.out.println("Task " + cpuTaskID + " runs for " + cpuRuntime + "s in CPU.");
                run[cpuTaskID]--;
                System.out.println("Task " + cpuTaskID + " still has " + run[cpuTaskID] + "s to finish.");
                // 检查当前task是否运行完成或者用完时间片
                if (run[cpuTaskID] == 0) {
                    cpuIdle = true;
                } else if (cpuRuntime == q) {
                    taskWaitQueue.offer(cpuTaskID);
                    // 将这个回到等待队列的task看成刚到达的，以免重复计算等待时间
                    arrival[cpuTaskID] = time;
                    System.out.println("Task " + cpuTaskID + " back to wait queue.");
                    cpuIdle = true;
                }
            }
            if (cpuIdle) {
                // 调度新的任务进入CPU
                if (!taskWaitQueue.isEmpty()) {
                    // 如果新调度的task和上个task不同，进入CPU前的这一秒仍然要算成等待时间（不包括第0秒时的情况）
                    int cpuNewTask = taskWaitQueue.poll();
                    if (cpuTaskID != cpuNewTask) {
                        cpuTaskID = cpuNewTask;
                        if (time >= 1) {
                            waitTime[cpuTaskID]++;
                            System.out.println(
                                    "Task " + cpuTaskID + " wait time +1s, waitTime = " + waitTime[cpuTaskID] + ".");
                        }
                    }
                    System.out.println("Task " + cpuTaskID + " has CPU time.");
                    cpuRuntime = 0;
                    cpuIdle = false;
                }
            }

            // 从第1秒开始
            if (time >= 1) {
                // 所有处于等待队列中的，除了刚到的（其中包含刚从CPU里回来的）task等待时间加一
                for (int task : taskWaitQueue) {
                    if (arrival[task] != time) {
                        waitTime[task]++;
                        System.out.println("Task " + task + " wait time +1s, waitTime = " + waitTime[task] + ".");
                    }
                }
            }

            System.out.println("----------------------------------------------");
        }

        int totalWaitTime = 0;
        for (int i = 0; i < taskCount; i++) {
            totalWaitTime += waitTime[i];
        }

        return (float) (totalWaitTime * 1.0 / taskCount);
    }

    // test
    public static void main(String[] args) {
        int[] arrival = new int[] { 0, 1, 4 };
        int[] run = new int[] { 5, 2, 5 };
        int q = 3;
        System.out.println("AWT = " + AverageCPUWaitTime.calculateAWT(arrival, run, q));
    }
}
