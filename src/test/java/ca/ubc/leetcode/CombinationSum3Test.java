package ca.ubc.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationSum3Test {

    @Test
    public void combinationSum3() {
        assertCombos(Arrays.asList(), 4, 54);

        assertCombos(Arrays.asList(
                Arrays.asList(1, 2, 6),
                Arrays.asList(1, 3, 5),
                Arrays.asList(2, 3, 4)),
                3, 9);

        assertCombos(Arrays.asList(Arrays.asList(1, 2, 4)), 3, 7);
        assertCombos(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)), 9, 45);
        assertCombos(Arrays.asList(), 3, 2);
        assertCombos(Arrays.asList(), 4, 1);
    }

    private void assertCombos(List<List<Integer>> expected, int k, int n) {
        List<CombinationSum3> impls = Arrays.asList(
                new CombinationSum3Arman(),
                new CombinationSum3Joe());

        impls.forEach(impl -> {
            List<List<Integer>> results = impl.combinationSum3(k, n);
            assertThat(results).containsExactlyInAnyOrderElementsOf(expected)
                    .as("%s: wrong answer for k = %d, n = %d",
                            impl.getClass().getSimpleName(), k, n);
        });
    }

}