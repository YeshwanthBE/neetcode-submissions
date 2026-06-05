class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
         List<String> group = new ArrayList<>();
         Map<String,List<String>> temp = new HashMap<>();
        for(var str : strs){
          String sortedStr = new String(str.chars().sorted().collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append).toString());
          List<String> groupIndex = temp.getOrDefault(sortedStr, new ArrayList<>());
          groupIndex.add(str);
          temp.put(sortedStr,groupIndex);
        }
        return new ArrayList<>(temp.values());
    }
}
