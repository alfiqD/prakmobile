package com.example.alfiq_apps.pertemuan_2

fun main () {
    println("hai rekan-rekan....")
    println("Selamat datang di bahasa pemrograman kotlin")

    println("================")

    var angka = 15
    println("HAsil dari 15 + 10 = ${angka + 10}")

    val nilaiInt = 10000
    val nilaiDouble = 100.003
    val nilaiFloat = 1000.0f

    println("Nilai Integer = $nilaiInt")
    println("Nilai Double = $nilaiDouble")
    println("Nilai Float = $nilaiFloat")

    println("======= STRING =======")
    val huruf = 'a'
    println("Ini penggunsan karakter '$huruf'")

    val nilaiString = "Mawar"
    println("Halo $nilaiString!\nApa Kabar?")

    println("======= KONDISI =======")

    val nilai = 10
    if (nilai < 0)
        println("bilangan negatif")
    else {
        if (nilai % 2 == 0)
            println("bilangan Genap")
        else
            println("Bilangan Ganjil")
    }


    println("======= PERULANGAN =======")
    val kampusKu: Array<String> = arrayOf("Kampus", "Politeknik", "caltex", "Riau")
    for (kampus: String in kampusKu) {
        println(kampus)
    }
}