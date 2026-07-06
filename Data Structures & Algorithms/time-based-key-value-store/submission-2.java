class TimeMap {

    Map<String,LinkedHashMap<Integer,String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
       timeMap.computeIfAbsent(key,k->new LinkedHashMap<>()).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        Map<Integer,String> timeValueMap = timeMap.get(key);

        if(timeValueMap == null){
            return "";
        }   

        int i=0,j = timeValueMap.size()-1;
        List<Integer> keyList = new ArrayList<>(timeValueMap.keySet());
        String result = "";
        while(i<=j){
            int mid = i + (j-i)/2;
            if(keyList.get(mid) <= timestamp){
                result = timeValueMap.get(keyList.get(mid));
                i=mid+1;
            }
            else{
                j=mid-1;
            }
            
        }
       return result;
    }
}
