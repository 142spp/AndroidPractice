package com.example.week4

import java.util.*

class menu(var name:String, var price:Int)

class Vandingmachine(sc_input:Scanner) {
    var sc = sc_input
    var select : Int = 0
    var menus : List<menu> = listOf(
        menu("참깨라면",1000),
        menu("햄버거",1500),
        menu("콜라",800),
        menu("핫바",1200),
        menu("초코우유",1500))

    open fun getChange(coin : Int): Unit?{
        if(coin < getPrice()) {
            println("현금이 부족합니다.")
            return null
        }
        println("감사합니다. 잔돈반환 : ${coin - getPrice()}")
        return Unit
    }
    open fun getCoin() :Unit?{
        println("Insert Coin")
        try{
            var coin = sc.nextLine().toInt()
            println("${coin} 원을 넣었습니다.")
            getChange(coin)

        } catch(e:Exception){
            println("현금을 넣지 않았습니다.")
            return null
        }

        return Unit
    }
    open fun getMenu(): Unit? {
        print_menu()
        println("Choose menu: ")
        try {
            var temp = sc.nextLine().toInt()
            if (temp !in 1..5) throw Exception()
            select = temp - 1
            println("${menus.get(select).name} 이/가 선택되었습니다.")
            while(getCoin()==null){}
        } catch (e: Exception) {
            println("아무것도 선택하지 않았습니다.")
            println("다시 선택해주세요")
            return null
        }
        return Unit
    }

    open fun getPrice() : Int{
        return menus.get(select).price
    }
}

fun print_menu(){
    println("=========== MENU ============")
    System.out.printf("| (1) %-5s \t - %7s   |\n","참깨라면","1,000원")
    System.out.printf("| (2) %-5s \t - %7s   |\n","햄버거","1,500원")
    System.out.printf("| (3) %-5s \t - %7s   |\n","콜라","800원")
    System.out.printf("| (4) %-5s \t - %7s   |\n","핫바","1,200원")
    System.out.printf("| (5) %-5s \t - %7s   |\n","초코우유","1,500원")

}

fun main(){
    val sc:Scanner = Scanner(System.`in`)
    var vm = Vandingmachine(sc)
    while(vm.getMenu()==null) { }

}