package com.franco.SOLIDPrinciples.PracticeSomeFunctions

import java.math.BigInteger

fun main(){
    var listOddNumbers= arrayListOf<Int>()
    returnOddNumbers(
        listOddNumbers
    )
    print(listOddNumbers.toList())

    print("\n This is the Fibbonacci-->${getFibonnaciNumber(4, BigInteger("0"),BigInteger("1"))}")



}
fun returnOddNumbers(list:MutableList<Int>):MutableList<Int>{
    for (i in 0..30)if (i%2==0){
         list.add(i)
    }
    return list

}

/**
 * Function returns the n-th parameter in fibbonacci series
 * if n is 10000 it will give a very large number so to prevent
 * the stackOverflowError which states that the memory has ran out
 * the use tailrec before fun keyword
 * so 0,1,1,2,3,5,8,13,21
 */
tailrec fun getFibonnaciNumber(n:Int,a:BigInteger,b:BigInteger):BigInteger {
    if(n==0)
        return b
    else
        return getFibonnaciNumber(n-1,a+b,a)

}

