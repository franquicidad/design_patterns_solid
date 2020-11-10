package com.franco.SOLIDPrinciples.DesignPatterns

fun main(){
    val phoneDiplay=PhoneDiplay(w = WeatherStation())

    val temp: Int =phoneDiplay.temperature
    print(temp)

}
interface IObserver{
    fun update()
}
interface IObservable{

    fun add( addIObserver:IObserver)
    fun remove(iObserver: IObserver)
    fun notifyData()
}

class WeatherStation : IObservable{
    val listObserver=ArrayList<IObserver>()
    var temperature=2;
    override fun add(addIObserver: IObserver) {
        this.listObserver.add(addIObserver)
    }

    override fun remove(removeIObserver: IObserver) {
        listObserver.remove(removeIObserver)
    }

    fun getTempature():Int{
        return this.temperature;

    }

    override fun notifyData() {
        for (element in listObserver){
            element.update()
        }
    }

}
//TODO: Revisar esta parte para que en el main retorne la temperatura
class PhoneDiplay(w: WeatherStation) :IObserver{

    private val weatherStation:WeatherStation
    var temperature = 0

    init {
        this.weatherStation=w
    }

    override fun update() {

       temperature= this.weatherStation.getTempature()

    }

}