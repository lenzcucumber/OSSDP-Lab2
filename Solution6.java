import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 *
 * 给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。
 *
 * 请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
 * 输出：[0,1,4]
 * 解释：
 * favoriteCompanies[2]=["google","facebook"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集。
 * favoriteCompanies[3]=["google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 和 favoriteCompanies[1]=["google","microsoft"] 的子集。
 * 其余的收藏清单均不是其他任何人收藏的公司清单的子集，因此，答案为 [0,1,4] 。
 * 示例 2：
 *
 * 输入：favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
 * 输出：[0,1]
 * 解释：favoriteCompanies[2]=["facebook","google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集，因此，答案为 [0,1] 。
 * 示例 3：
 *
 * 输入：favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
 * 输出：[0,1,2,3]
 *
 *
 * 提示：
 *
 * 1 <= favoriteCompanies.length <= 100
 * 1 <= favoriteCompanies[i].length <= 500
 * 1 <= favoriteCompanies[i][j].length <= 20
 * favoriteCompanies[i] 中的所有字符串 各不相同 。
 * 用户收藏的公司清单也 各不相同 ，也就是说，即便我们按字母顺序排序每个清单， favoriteCompanies[i] != favoriteCompanies[j] 仍然成立。
 * 所有字符串仅包含小写英文字母。
 *
 */
public class Solution6 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> sets = new ArrayList<>();
        // 将每个用户的公司清单转换为HashSet，以便进行子集检查
        for (List<String> list : favoriteCompanies) {
            sets.add(new HashSet<>(list));
        }

        List<Integer> ans = new ArrayList<>();
        // 逐个检查每个HashSet是否是其他HashSet的子集
        for (int i = 0; i < sets.size(); i++) {
            boolean isSubset = false;
            for (int j = 0; j < sets.size(); j++) {
                if (i != j && sets.get(j).containsAll(sets.get(i))) {
                    // 注意这里是检查sets.get(i)是否是sets.get(j)的子集
                    // 如果sets.get(i)是sets.get(j)的子集，则标记为isSubset = true并退出内层循环
                    isSubset = true;
                    break;
                }
            }
            // 如果当前HashSet不是任何其他HashSet的子集，则添加到结果列表中
            if (!isSubset) {
                ans.add(i);
            }
        }

        return ans;
    }

    // 测试类
    public static void main(String[] args) {
        Solution6 solution = new Solution6();

        // 测试用例1
        List<List<String>> favoriteCompanies1 = new ArrayList<>();
        favoriteCompanies1.add(List.of("leetcode", "google", "facebook"));
        favoriteCompanies1.add(List.of("google", "microsoft"));
        favoriteCompanies1.add(List.of("google", "facebook"));
        favoriteCompanies1.add(List.of("google"));
        favoriteCompanies1.add(List.of("amazon"));
        System.out.println("Test case 1: " + solution.peopleIndexes(favoriteCompanies1)); // Output: [0, 1, 4]

        // 测试用例2
        List<List<String>> favoriteCompanies2 = new ArrayList<>();
        favoriteCompanies2.add(List.of("leetcode", "google", "facebook"));
        favoriteCompanies2.add(List.of("leetcode", "amazon"));
        favoriteCompanies2.add(List.of("facebook", "google"));
        System.out.println("Test case 2: " + solution.peopleIndexes(favoriteCompanies2)); // Output: [0, 1]

        // 测试用例3
        List<List<String>> favoriteCompanies3 = new ArrayList<>();
        favoriteCompanies3.add(List.of("leetcode"));
        favoriteCompanies3.add(List.of("google"));
        favoriteCompanies3.add(List.of("facebook"));
        favoriteCompanies3.add(List.of("amazon"));
        System.out.println("Test case 3: " + solution.peopleIndexes(favoriteCompanies3)); // Output: [0, 1, 2, 3]
    }
}