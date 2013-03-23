package implement_strStr;

public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int head = 0;
        int pHaystack = 0;
        int pNeedle = 0;
        
        while(true){
            while(pHaystack < haystack.length() && pNeedle < needle.length() && 
             haystack.charAt(pHaystack) != needle.charAt(pNeedle)){
                 pHaystack ++;
             }
             
             head = pHaystack;
             
             while(pHaystack < haystack.length() && pNeedle < needle.length() && 
             haystack.charAt(pHaystack) == needle.charAt(pNeedle)){
                 pHaystack++;
                 pNeedle++;
             }
             
             if(pNeedle == needle.length()){
                 return haystack.substring(head);
             }
             
             if(pHaystack == haystack.length()){
                 return null;
             }
             
             pNeedle = 0;
             head++;
             pHaystack = head;
        }        
    }
}