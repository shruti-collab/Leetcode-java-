class Solution {
    private void backtracking(int[] candidates,int start,int target,List<List<Integer>> ans,List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
        }
        if(target < 0) return;
        for(int i = start;i < candidates.length;i++){
            ds.add(candidates[i]);
            backtracking(candidates,i,target - candidates[i],ans,ds);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        backtracking(candidates,0,target,ans,ds);
        return ans;
    }
}