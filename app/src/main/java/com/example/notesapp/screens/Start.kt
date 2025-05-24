package com.example.notesapp.screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.MainViewModel
import com.example.notesapp.MainViewModelFactory
import com.example.notesapp.navigation.NavRoute
import com.example.notesapp.ui.theme.NotesAppTheme
import com.example.notesapp.utils.TYPE_FIREBASE
import com.example.notesapp.utils.TYPE_ROOM


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StartScreen(navController: NavHostController) {
    val context = LocalContext.current
    val mViewModel: MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "What will we use?")
            Button(
                onClick = {
                    mViewModel.initDatabase(TYPE_ROOM)
                    navController.navigate(route = NavRoute.Main.route)
                },
                modifier = Modifier.width(200.dp).padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8A6758),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Room database")
            }
            Button(
                onClick = {
                    mViewModel.initDatabase(TYPE_FIREBASE)
                    navController.navigate(route = NavRoute.Main.route)
                },
                modifier = Modifier.width(200.dp).padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8A6758),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Firebase database")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun prevStartScreen() {
    NotesAppTheme {
        StartScreen(navController = rememberNavController())
    }
}