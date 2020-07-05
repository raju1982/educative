package com.ds.algo.recursion;

import java.lang.*;

class RopeCutting
{
    static int rodCutting(int ropeSize, int a, int b, int c)
    {
        if(ropeSize== 0)
            return 0;
        if(ropeSize < 0)
            return -1;

        int res = Math.max(Math.max(rodCutting(ropeSize-a, a, b, c),
                rodCutting(ropeSize-b, a, b, c)),rodCutting(ropeSize-c, a, b,c));

        if(res == -1)
            return -1;
        return 1+res;
    }

    public static void main (String[] args)
    {
        int n = 25;
        int a = 11, b = 12, c = 13;
        System.out.println(rodCutting(n, a, b, c));

    }
}
