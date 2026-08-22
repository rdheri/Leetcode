class Data {

private String value;
private int timestamp;

public Data() {}

public Data(String value, int timestamp) {
    this.value = value;
    this.timestamp = timestamp;
}

public int getTimestamp() {return this.timestamp;}
public String getValue() {return this.value;}
}



class TimeMap {

    HashMap<String, ArrayList<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Data data = new Data(value, timestamp);

        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(data);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        ArrayList<Data> data = map.get(key);

        int left = 0;
        int right = data.size() - 1;

        while(left < right) {
            int middle = left + (right-left)/2;

            if(data.get(middle).getTimestamp() == timestamp) {
                return data.get(middle).getValue();
            }
            else if(data.get(middle).getTimestamp() < timestamp) {
                left = middle + 1;
            }
            else {
                right = middle;
            }
        }
        return data.get(left).getValue();
    }
}
