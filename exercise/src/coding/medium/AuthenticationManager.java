package coding.medium;

import java.util.HashMap;
import java.util.Map;

class AuthenticationManager {

    Map<String, Integer> tokenIdMap;
    int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        tokenIdMap = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        tokenIdMap.put(tokenId, currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        Integer expireTime = tokenIdMap.getOrDefault(tokenId, 0);
        if (currentTime >= expireTime.intValue()){
            return;
        }else {
            tokenIdMap.put(tokenId, currentTime + timeToLive);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (String tokenId : tokenIdMap.keySet()){
            if (tokenIdMap.get(tokenId) < currentTime){
                count++;
            }
        }

        return count;
    }
}