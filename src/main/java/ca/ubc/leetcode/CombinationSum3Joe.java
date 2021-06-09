package ca.ubc.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.min;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class CombinationSum3Joe implements CombinationSum3 {

    @Override
    public List<List<Integer>> combinationSum3(int k, int n) {
        return search(k, n, min(n, 9), new ArrayList<>());
    }

    private List<List<Integer>> search(int maxMinuses, int remaining, int minus, List<Integer> combo) {

        if (remaining <= 0 || minus <= 0 || combo.size() >= maxMinuses) {
            if (remaining == 0 && maxMinuses == combo.size()) {
                return singletonList(combo);
            }
            return emptyList();
        }

        List<List<Integer>> combinations = new ArrayList<>();

        combinations.addAll(search(maxMinuses, remaining, minus - 1, new ArrayList<>(combo)));

        combo.add(0, minus);
        combinations.addAll(search(maxMinuses, remaining - minus, minus - 1, combo));

        return combinations;
    }
}
