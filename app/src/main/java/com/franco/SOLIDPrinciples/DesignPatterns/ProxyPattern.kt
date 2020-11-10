package com.franco.SOLIDPrinciples.DesignPatterns

class BookParser(private val book: String) :IBookParser{
    fun bookParser(book:String){
        print("Expensive parsing")
    }
    override fun getNumPages():Int{
        return 0
    }
}

interface IBookParser{
    fun getNumPages():Int
}

class LazyBookParserProxy(private val book: String):IBookParser{
    private var bookParser: BookParser? = null
    private var mbook =book

    override fun getNumPages(): Int {
        if (this.bookParser==null){
            this.bookParser= BookParser(book = this.mbook)
        }
        return this.bookParser!!.getNumPages()
    }
}