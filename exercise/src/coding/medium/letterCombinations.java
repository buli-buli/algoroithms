package coding.medium;

import java.util.*;

/**
 * @author yzw
 * @Description 电话号码的字母组合
 * @createTime 2024年11月12日
 */
public class letterCombinations {
    public List<String> letterCombinations(String digits) {
        Map<Integer, List<String>> map = new HashMap<>();

        map.put(2, Arrays.asList("a","b","c"));
        map.put(3, Arrays.asList("d","e","f"));
        map.put(4, Arrays.asList("g","h","i"));
        map.put(5, Arrays.asList("j","k","l"));
        map.put(6, Arrays.asList("m","n","o"));
        map.put(7, Arrays.asList("p","q","r","s"));
        map.put(8, Arrays.asList("t","u","v"));
        map.put(9, Arrays.asList("w","x","y","z"));

        Integer n = digits.length();

        List<String> res = new ArrayList<>();

        int a,b,c,d;
        List<String> aList,bList,cList,dList;

        switch (n){
            case 1:
                return map.getOrDefault(Integer.parseInt(digits), new ArrayList<>());
            case 2:
                a = Integer.parseInt(digits.substring(0, 1));
                b = Integer.parseInt(digits.substring(1, 2));

                aList = map.getOrDefault(a, new ArrayList<>());
                bList = map.getOrDefault(b, new ArrayList<>());

                for (int i = 0 ; i < aList.size(); i++){
                    for (int j = 0; j < bList.size(); j++){
                        res.add(aList.get(i) + bList.get(j));
                    }
                }
                break;
            case 3:
                a = Integer.parseInt(digits.substring(0, 1));
                b = Integer.parseInt(digits.substring(1, 2));
                c = Integer.parseInt(digits.substring(2, 3));

                aList = map.getOrDefault(a, new ArrayList<>());
                bList = map.getOrDefault(b, new ArrayList<>());
                cList = map.getOrDefault(c, new ArrayList<>());

                for (int i = 0 ; i < aList.size(); i++){
                    for (int j = 0; j < bList.size(); j++){
                        for (int k = 0; k < cList.size(); k++){
                            res.add(aList.get(i) + bList.get(j) + cList.get(k));
                        }
                    }
                }
                break;
            case 4:
                a = Integer.parseInt(digits.substring(0, 1));
                b = Integer.parseInt(digits.substring(1, 2));
                c = Integer.parseInt(digits.substring(2, 3));
                d = Integer.parseInt(digits.substring(3, 4));

                aList = map.getOrDefault(a, new ArrayList<>());
                bList = map.getOrDefault(b, new ArrayList<>());
                cList = map.getOrDefault(c, new ArrayList<>());
                dList = map.getOrDefault(d, new ArrayList<>());

                for (int i = 0 ; i < aList.size(); i++){
                    for (int j = 0; j < bList.size(); j++){
                        for (int k = 0; k < cList.size(); k++){
                            for (int l = 0; l < dList.size(); l++){
                                res.add(aList.get(i) + bList.get(j) + cList.get(k) + dList.get(l));
                            }
                        }
                    }
                }
                break;
        }

        return res;
    }
}
