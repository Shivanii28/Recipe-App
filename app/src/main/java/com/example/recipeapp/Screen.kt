package com.example.recipeapp

sealed class Screen(val route:String ) {

    object recipeScreen:Screen("reciepescreen")
    object detailscreen:Screen("detailscreen")
}