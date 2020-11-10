package com.franco.SOLIDPrinciples.PracticeSomeFunctions

fun main(){

    val program=Program()
    val myLambda :(Int)->Unit={s:Int->println()}
    program.sumOfTwoNumbers(5,5,myLambda)

    //val LambdaInt:(Int,Int) -> Int = { a:Int, b:Int -> a+b}
    program.sumOfTwoNumbersTwo(10,10, { a, b -> a + b})

    /**
     * The it is only available if and only if we have one parameter in the parameters
     * of the function
     */
    program.reversedString("Pulguita",{it.reversed()})
}

 class Program{

//    val a:Int=1
//    val b=2
     /**
      * (Int) ->Unit The first part Int indicates that it will receive parameters of type Int
      * and what goes after the Lambda or arrow -> is the return type of the action which in this case is
      * a+b!
      * Notice that the return type is Unit because println(sum) returns void so this stands for Unit
      */

     fun sumOfTwoNumbers(a:Int, b:Int, action: (Int) -> Unit ){
         val sum =a+b
         println(sum)
     }

     fun sumOfTwoNumbersTwo(a: Int,b: Int,action: (Int,Int) -> Int){
         val result=action(a,b)

         println(result)
     }

     fun reversedString(s:String,Func:(String)->String){

         val result=s.reversed()
         println(result)

     }

//    fun sum(a: Int,b: Int) {
//        println(sum())
//    }

}