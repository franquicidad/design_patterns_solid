package com.franco.SOLIDPrinciples.DesignPatterns

import android.widget.Toast


fun main(){

    val livingRoomLight : Light = Light()

    var  invoker =Invoker(LightOnCommand( livingRoomLight),LightOffCommand(light = livingRoomLight))
    invoker.clickOn()
}
interface ICommand{
    fun execute()
    fun unExecute()
}

/**
 * This is the receiver of the command
 * LIGHT
 */

class Light{

    fun action(){
        
    }

    fun on(){
       print("The light is On")
    }

    fun off(){
        print("The light is Off")

    }
}

 class LightOnCommand(private val light: Light) :ICommand{

    private val mlight: Light = light

    override fun execute() {
        this.mlight.on()
    }

     override fun unExecute() {
         this.mlight.off()
     }


 }class LightOffCommand(private val light: Light) :ICommand{

    private val mlight: Light = light

    override fun execute() {
        this.mlight.on()
    }

    override fun unExecute() {
        this.mlight.off()
    }

}

class Invoker(on:ICommand,off:ICommand){
    private val turnOn =on
    private val turnOff=off

    fun clickOn(){
        this.turnOn.execute()
    }
    fun clickOff(){
        this.turnOff.unExecute()
    }

}