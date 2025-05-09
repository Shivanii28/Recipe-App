package com.example.recipeapp


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController){

    val recipeViewModel:MainViewModel = viewModel()
    val viewstate by recipeViewModel.categoriesState


  NavHost(navController = navController, startDestination =Screen.recipeScreen.route){

      composable(route=Screen.recipeScreen.route){

          recipeScreen(viewState = viewstate , navigateToDetail ={

              navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
              navController.navigate(Screen.detailscreen.route)
          } )

      }
      composable(route=Screen.detailscreen.route){

          val category=navController.previousBackStackEntry?.savedStateHandle?.
          get<Category>("cat")?: Category("","","","")
          CategoryDetailScreen(category = category)
      }
  }
}