package com.example.exercise2

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

enum class PengelolaHalaman{
    home,
    summary,
    form,
}

@Composable
fun PengelolaHalaman(
    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){

}