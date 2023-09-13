package com.example.mycomposeapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycomposeapp.ui.AddRecordActivity
import com.example.mycomposeapp.ui.theme.MyComposeAppTheme
import com.example.mycomposeapp.viewmodel.AddRecordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }

@Preview
@Composable
fun MainScreen(addRecordViewModel: AddRecordViewModel = viewModel()){
    Column {
        val context = LocalContext.current

        val list by addRecordViewModel.users.collectAsState(emptyList())

        Row(modifier = Modifier.align(Alignment.End)) {
            OutlinedButton(onClick = {

             startActivity(Intent(context,AddRecordActivity::class.java))

            },
                modifier= Modifier.width(150.dp).padding(10.dp),
                shape = RectangleShape,
                border= BorderStroke(1.dp, Color.Blue),
                contentPadding = PaddingValues(0.dp),  //avoid the little icon
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Blue, contentColor =  Color.Blue)
            ) {
                Text(text = "Add",color = Color.White)
            }
            // Adding a Spacer of height 20dp

        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn{
            items(list){user->

                Card(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                    Column {
                        Text(text = user.name,Modifier.padding(10.dp,10.dp,0.dp,0.dp))
                        Text(text = user.mobile,Modifier.padding(10.dp,5.dp,0.dp,0.dp))
                        Text(text = user.email,Modifier.padding(10.dp,5.dp,0.dp,10.dp))
                    }
                }
            }
        }
    }
}

}