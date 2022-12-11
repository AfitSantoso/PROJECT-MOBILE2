package com.example.tokosembako.ui.theme.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tokosembako.ui.theme.TokosembakoTheme

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel ?= null,
    onNavToHomePage:() -> Unit,
    onNavToSignUp:() -> Unit,
){
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.loginError != null
    val context = LocalContext.current
    
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,) {
        Text(text = "Login", style = MaterialTheme.typography.h3,
        fontWeight =  FontWeight.Black,
        color = MaterialTheme.colors.primary)
        
        if (isError){
            Text(text = loginUiState?.loginError?: "Error", color = Color.Red)
        }
        
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = loginUiState?.userName ?: "",
            onValueChange = {loginViewModel?.onUserNameChange(it)},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = null)
            },
            label = {
                Text(text = "Email")
            },
            isError = isError
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = loginUiState?.password ?: "",
            onValueChange = {loginViewModel?.onPasswordNameChange(it)},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = null)
            },
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )

        Button(onClick = { loginViewModel?.loginUser(context) }) {
            Text(text = "Sign In")
        }
        Spacer(modifier = Modifier.size(16.dp))
        
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "Belum Mempunyai Akun ?")
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = { onNavToSignUp.invoke() }) {
                Text(text = "Sign Up")
            }
        }

        if (loginUiState?.isLoading == true){
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = loginViewModel?.hasUser){
            if (loginViewModel?.hasUser == true){
                onNavToHomePage.invoke()
            }
        }
    
        
        
    }
}

@Composable
fun SignUpScreen(
    loginViewModel: LoginViewModel ?= null,
    onNavToHomePage:() -> Unit,
    onNavToLoginPage:() -> Unit,
){
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.signUpError != null
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,) {
        Text(text = "Sign Up", style = MaterialTheme.typography.h3,
            fontWeight =  FontWeight.Black,
            color = MaterialTheme.colors.primary)

        if (isError){
            Text(text = loginUiState?.signUpError?: "Error", color = Color.Red)
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = loginUiState?.userNameSignUp ?: "",
            onValueChange = {loginViewModel?.onUserNameChangeSignUp(it)},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = null)
            },
            label = {
                Text(text = "Email")
            },
            isError = isError
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = loginUiState?.passwordSignUp ?: "",
            onValueChange = {loginViewModel?.onPasswordChangeSignUp(it)},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = null)
            },
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = loginUiState?.confirmPasswordSignUp ?: "",
            onValueChange = {loginViewModel?.onConfirmPasswordChange(it)},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = null)
            },
            label = {
                Text(text = "Konfirmasi Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )

        Button(onClick = { loginViewModel?.createUser(context) }) {
            Text(text = "Sign In")
        }
        Spacer(modifier = Modifier.size(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "Sudah mempunyai akun ?")
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = { onNavToLoginPage.invoke() }) {
                Text(text = "Sign In")
            }
        }

        if (loginUiState?.isLoading == true){
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = loginViewModel?.hasUser){
            if (loginViewModel?.hasUser == true){
                onNavToHomePage.invoke()
            }
        }



    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevLoginScreen(){
    TokosembakoTheme {
        LoginScreen(onNavToHomePage = { /*TODO*/ }) {
            
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevSignUpScreen(){
    TokosembakoTheme {
       SignUpScreen(onNavToHomePage = { /*TODO*/ }) {

        }
    }
}