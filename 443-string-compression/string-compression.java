class Solution {
    public int compress(char[] chars) {
       int r=0,w=0;
       while(r<chars.length)
       {
            char current=chars[r];
            int c=0;
            while(r<chars.length && current==chars[r])
            {
                r++;
                c++;
            }
            chars[w++]=current;
            if(c>1)
            {
                for(char ch:Integer.toString(c).toCharArray())
                {
                    chars[w++]=ch;
                }
            }
       }
       return w;
        }
    }