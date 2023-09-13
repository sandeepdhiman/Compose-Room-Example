package com.example.mycomposeapp.screen


import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycomposeapp.Util
import com.example.mycomposeapp.database.entity.User
import com.example.mycomposeapp.viewmodel.AddRecordViewModel

@Preview
@Composable
fun AddTextFields(addRecordViewModel: AddRecordViewModel = viewModel()){
    var name by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        Modifier.fillMaxWidth().absolutePadding(10.dp, 10.dp, 10.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                            name = it
            },
            label = { Text("Name") },

            )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = mobile,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                            mobile = it
            },
            label = { Text("Mobile") },

            )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = email,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                            email = it
            },
            label = { Text("Email") },

            )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedButton(
            onClick = {


                      if(name == ""){
                          Toast.makeText(context,"Name can't be left empty",Toast.LENGTH_LONG).show()
                      }else if(!Util.isValidPhoneNumber(mobile)){
                          Toast.makeText(context,"Please enter a valid phone number",Toast.LENGTH_LONG).show()
                      }else if(!Util.isValidEmail(email)){
                          Toast.makeText(context,"Please enter a valid email address",Toast.LENGTH_LONG).show()
                      }else {
                          val user = User(0, name, mobile, email)

                          addRecordViewModel.insertData(user)

                          // clearing text fields
                          name = ""
                          mobile = ""
                          email = ""
                      }
            },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RectangleShape,
            border = BorderStroke(1.dp, Color.Blue),
            contentPadding = PaddingValues(0.dp),  //avoid the little icon
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Blue,
                contentColor = Color.Blue
            )
        ) {
            Text(text = "Submit", color = Color.White)
        }
    }
}
