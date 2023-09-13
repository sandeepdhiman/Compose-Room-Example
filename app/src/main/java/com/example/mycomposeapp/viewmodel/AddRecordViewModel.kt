package com.example.mycomposeapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycomposeapp.database.entity.User
import com.example.mycomposeapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AddRecordViewModel @Inject constructor(private val repository: Repository): ViewModel() {
      val users: Flow<List<User>> = repository.allUsers

     fun insertData(user: User){
         viewModelScope.launch {
             repository.insertRecord(user)
         }
    }


}