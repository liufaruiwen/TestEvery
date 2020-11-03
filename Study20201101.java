package Study11;

import java.util.*;

public class Study20201101 {

    public static void main(String[] args) {

        //思路是把三角形，，分解成三个小的三角形
        //然后一个一个实现，再拼接起来
        // 1----2----3
        //妙啊
        for(int i = 1; i <= 5; i++){
            for(int j = 5 ;i <= j; j--)//建立1号图形
                System.out.print(" ");
            for(int j = 1; j <= i; j++)//建立2号图形
                System.out.print("*");
            for(int j = 1; j < i; j ++)//建立3号图形
                System.out.print("*");

            //换行
            System.out.println();

        }
    }






    public static void main1(String[] args) {

    }

//    输入:
//    s = "catsanddog"
//    wordDict = ["cat", "cats", "and", "sand", "dog"]
//    输出:
//            [
//              "cats and dog",
//              "cat sand dog"
//            ]

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<List<String>>();
            if (index == length) {
                wordBreaks.add(new LinkedList<String>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }


    /**
     * 利用动态规划可以解决很多问题，下面列举了一些：
     *
     * 分区问题：给定一组整数，找出它是否可以分成两个具有相等和的子集
     * 子集和问题：给你一个正整数的数组及元素还有一个合计值，是否在数组中存在一个子集的的元素之和等于合计值。
     * 硬币变化问题：鉴于给定面额的硬币无限供应，找到获得所需变化的不同方式的总数
     * k变量线性方程的所有可能的解：给定k个变量的线性方程，计算它的可能解的总数
     * 找到醉汉不会从悬崖上掉下来的概率：给定一个线性空间代表距离悬崖的距离，让你知道酒鬼从悬崖起始的距离，以及他向悬崖p前进并远离悬崖1-p的倾向，计算出他的生存概率
     */
    //stack abuse
    //两个字符串的公共子串
    //采用动态规划的做法
     static class LCS {
        public static void main(String[] args) {
            String s1 = new String("Hillfinger");
            String s2 = new String("Hilfiger");
            int n = s1.length();
            int m = s2.length();
            int[][] solutionMatrix = new int[n+1][m+1];
            for (int i = 0; i < n; i++) {
                solutionMatrix[i][0] = 0;
            }
            for (int i = 0; i < m; i++) {
                solutionMatrix[0][i] = 0;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    int max1, max2, max3;
                    max1 = solutionMatrix[i - 1][j];
                    max2 = solutionMatrix[i][j - 1];
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        max3 = solutionMatrix[i - 1][j - 1] + 1;
                    } else {
                        max3 = solutionMatrix[i - 1][j - 1];
                    }
                    int tmp = Math.max(max1, max2);
                    solutionMatrix[i][j] = Math.max(tmp, max3);
                }
            }

            System.out.println("Length of longest continuous subsequence: " + solutionMatrix[n][m]);
        }
    }
}
