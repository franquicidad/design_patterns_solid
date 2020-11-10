package com.franco.SOLIDPrinciples

fun main(){
    var col1 = ArrayList<Int>()
    var col2 = ArrayList<Any>()



    for (i in 1..10){
        if(i % 2 != 0){
            col1.add(i)
        }

    }

    val words ="The cat is Meowing in the hood of the Car".split(" ")
    val shortWords= mutableListOf<String>()
    words.getShortWordsTo(shortWords,3)
    print(shortWords)

    print(col1)

}

fun List<String>.getShortWordsTo(shortWords: MutableList<String>, maxLength: Int) {
    this.filterTo(shortWords) {shortWords->
        shortWords.length <= maxLength
    }
    // throwing away the articles
    val articles = setOf("a", "A", "an", "An", "the", "The")
    shortWords -= articles
}


