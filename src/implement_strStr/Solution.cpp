class Solution {
public:
    char *strStr(char *haystack, char *needle) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        char * head = haystack;
        char * p1= haystack;
        char * p2 = needle;
        
        while(1){
            while(*p1 != *p2 && *p1!= '\0' && *p2!='\0'){
                p1++;
            }
            
            head = p1;
            
            while(*p1 == *p2 && *p1!= '\0' && *p2!='\0'){
                p1++;
                p2++;
            }
            if(*p2 =='\0')
            {
                return head;
            }
            if(*p1 =='\0')
            {
                return NULL;
            }            
            
            p2 = needle;
            head++;
            p1 = head;
        }
    }
};