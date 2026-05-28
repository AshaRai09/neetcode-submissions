class Solution {
    public static List<List<String>> groupAnagrams(String[] str) {
       HashMap<String, List<String>> map = new HashMap<>();
       for(String word : str){
        char ch[]= word.toCharArray();
        Arrays.sort(ch);
        String key = new String(ch);
        if(!map.containsKey(key)){
            map.put(key , new ArrayList<>());
        }
        map.get(key).add(word);
       } 
    return new ArrayList<>(map.values());
}
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int s= sc.nextInt();
        String str[] = new String[s];

         for(int i = 0; i < s; i++) {
            str[i] = sc.nextLine();
        }
    System.out.println(groupAnagrams(str));


    }
}
