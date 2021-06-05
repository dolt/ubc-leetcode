package ca.ubc.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CombinationSum3Arman implements CombinationSum3 {

    @Override
    public List<List<Integer>> combinationSum3(int k, int targetSum) {
        List<List<Integer>>[] dp = new List[targetSum + 1];
        dp[0] = new ArrayList<>();

        for (int i = 1; i < 10 && i <= targetSum; i++) {
            List<Integer> combo = new ArrayList<>();
            combo.add(i);

            dp[i] = new ArrayList<>();
            dp[i].add(combo);
        }

        for (int i = 1; i < dp.length; i++) {
            List<List<Integer>> currentCombos = dp[i];

            if (currentCombos == null)
                continue;

            for (int j = 1; j < 10; j++) {

                int next = i + j;
                if (next > dp.length - 1)
                    continue;

                for (List<Integer> curr : currentCombos) {
                    if (curr.contains(j))
                        continue;

                    List<Integer> newCombo = new ArrayList<>(curr);
                    newCombo.add(j);
                    newCombo.sort(Comparator.naturalOrder());

                    if (dp[next] == null)
                        dp[next] = new ArrayList<>();

                    if (!dp[next].contains(newCombo))
                        dp[next].add(newCombo);
                }
            }
        }

        if (dp[targetSum] == null)
            return Collections.emptyList();

        List<List<Integer>> results = new ArrayList<>();
        for (List<Integer> combo : dp[targetSum]) {
            if (combo.size() == k)
                results.add(combo);
        }

        return results;
    }

}
