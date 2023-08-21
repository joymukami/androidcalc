package com.example.augustmidmorningcalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.augustmidmorningcalc.ui.theme.AugustMidMorningCalcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AugustMidMorningCalcTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calculator(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var answer by remember {
            mutableStateOf("")
        }


        Text(
            text = "Answer = $answer",
            color = Color.Red,
            fontSize = 40.sp,
            textDecoration = TextDecoration.Underline,
            modifier = modifier
                .padding(20.dp)
        )
         var firstNumber by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = firstNumber ,
            onValueChange = {firstNumber = it},
            label = {Text(text = "Enter first number...")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = modifier.height(30.dp))

        var secondNumber by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = secondNumber ,
            onValueChange = {firstNumber = it},
            label = {Text(text = "Enter second number...")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = modifier.height(30.dp))
        Row (modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                //Convert the first and second numbers to double
                var convertedFirstNum = firstNumber.text.toDouble()
                var convertedSecondtNum = secondNumber.text.toDouble()
                //Compute the converted numbers
                var jibu = convertedFirstNum + convertedSecondtNum
                //Finally update your answer with jibu
                answer = jibu.toString()

            }) {
            Text(text = "Add")
            }
            Spacer(modifier = modifier.width(150.dp))
            Button(onClick = { //Convert the first and second numbers to double
                var convertedFirstNum = firstNumber.text.toDouble()
                var convertedSecondtNum = secondNumber.text.toDouble()
                //Compute the converted numbers
                var jibu = convertedFirstNum / convertedSecondtNum
                //Finally update your answer with jibu
                answer = jibu.toString()}) {

            Text(text = "Subtract")
            }
        }
        Spacer(modifier = modifier.width(150.dp))
        Row (modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(onClick = { var convertedFirstNum = firstNumber.text.toDouble()
                var convertedSecondtNum = secondNumber.text.toDouble()
                //Compute the converted numbers
                var jibu = convertedFirstNum / convertedSecondtNum
                //Finally update your answer with jibu
                answer = jibu.toString()}) {

                Text(text = "Divide")
            }
            Spacer(modifier = modifier.width(150.dp))
            Button(onClick = { var convertedFirstNum = firstNumber.text.toDouble()
                var convertedSecondtNum = secondNumber.text.toDouble()
                //Compute the converted numbers
                var jibu = convertedFirstNum * convertedSecondtNum
                //Finally update your answer with jibu
                answer = jibu.toString()}) {
                Text(text = "Multiply")
            }
        }
    }
}












@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AugustMidMorningCalcTheme {
       Calculator()
    }
}