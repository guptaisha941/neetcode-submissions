class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        ArrayList<String> st = new ArrayList<>(Arrays.asList(strs));
        List<List<String>> ll = new ArrayList<>();

        if(st.size() == 1) {
            return List.of(List.of(st.get(0)));
        }

        for(int i=0; i<st.size(); i++) {

            ArrayList<String> ft = new ArrayList<>();
            ft.add(st.get(i));

            HashMap<Character, Integer> m = countChars(st.get(i));

            for(int j=i+1; j<st.size(); j++ ) {

                HashMap<Character, Integer> mnew = countChars(st.get(j));

                if(m.equals(mnew)) {
                    ft.add(st.get(j));
                    st.remove(j);
                    j--;
                }
            }

            ll.add(ft);
        }

        return ll;
    }

    public HashMap<Character, Integer> countChars(String s) {

        HashMap<Character, Integer> m  = new HashMap<>();

        for (char ch : s.toCharArray()) {

            if(m.containsKey(ch)) {
                m.put(ch, m.get(ch)+1);
            }
            else {
                m.put(ch, 1);
            }
        }

        return m;
    }
}