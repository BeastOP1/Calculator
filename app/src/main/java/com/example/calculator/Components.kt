package com.example.calculator

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.substring
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import org.mariuszgromada.math.mxparser.Expression
import java.nio.file.Files.delete


@Composable
fun MyCustomButton(isFunction: Boolean , text: String,onCLick:(String) -> Unit ) {

    OutlinedButton(
        onClick = { onCLick(text) },

        colors = ButtonDefaults.buttonColors(
            containerColor = if (isFunction) {
                Color.DarkGray
            }
            else {
                if(isFunction && (text == "AC" || text =="=" || text == "⌫")){
                    Color.Red

                } else{
                    Color.White
                }
            },
            contentColor = Color.DarkGray
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp, pressedElevation = 70.dp),
        shape = RoundedCornerShape(33.dp),
        modifier = Modifier
            .size(100.dp)
            .padding(4.dp),
        border = if (isFunction) {
            BorderStroke(
                1.dp,
                Color.Yellow
            )
        } else {
            BorderStroke(1.dp, Color.Green)
        },
        content = {
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 22.sp,
                    color = if (isFunction) {
                        Color.Yellow
                    }
                    else {
                        if(isFunction && (text == "AC" || text == "=")){
                            Color.Red
                        } else {
                            Color.Green
                        }
                    },
                    fontWeight = FontWeight.W700,
                    textAlign = TextAlign.Center
                )
            )
        }
    )

}


@Preview(showSystemUi = true)
@Composable
fun PReViewBUtton(modifier: Modifier = Modifier) {
    
    CalculatorSreen()
}

@Composable
fun CalculatorSreen() {
    val viewModel = MainViewModel()
    var expression by remember {
        mutableStateOf("")
    }
    var result by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {


        Card(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Spacer(modifier = Modifier
                    .height(5.dp)
                    .fillMaxWidth()
                    .background(Color.White))

                Text(text = expression+"|",
                    style = TextStyle(
                        fontSize = 22.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.W700,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.End

                    ), maxLines = 3,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                )

                Spacer(modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color.White))

                if (result.isNotEmpty()){
                    Spacer(modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color.Black))

                }
                Text(text = result , style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.End
                ), maxLines = 2
                )
            }
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .background(Color.Black))

        Column (
            modifier = Modifier.padding(10.dp)
        ){

            Row{
                MyCustomButton(isFunction = true, text = "AC", onCLick = {
                    expression  = ""
                    result = ""
                })
                MyCustomButton(isFunction = true, text = "(", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
                MyCustomButton(isFunction = true, text = ")", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
                MyCustomButton(isFunction = true, text = "÷", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
            }
            Row {
                MyCustomButton(isFunction = false, text = "7", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
                MyCustomButton(isFunction = false, text = "8", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
                MyCustomButton(isFunction = false, text = "9", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
                MyCustomButton(isFunction = true, text = "×", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
            }
            Row {
                MyCustomButton(isFunction = false, text = "4", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
                MyCustomButton(isFunction = false, text = "5", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
                MyCustomButton(isFunction = false, text = "6", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
                MyCustomButton(isFunction = true, text = "-", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
            }
            Row {
                MyCustomButton(isFunction = false, text = "1", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
                MyCustomButton(isFunction = false, text = "2", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
                MyCustomButton(isFunction = false, text = "3", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
                MyCustomButton(isFunction = true, text = "+", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
            }
            Row{
                MyCustomButton(isFunction = false, text = "0", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)

                })
                MyCustomButton(isFunction = false, text = ".", onCLick = {
                    expression += it
                    result = viewModel.solveExpression(expression)


                })
                MyCustomButton(isFunction = true, text = "⌫", onCLick = {
                    expression = viewModel.deleteExpression(expression)
                    result = viewModel.solveExpression(expression)


                })
                MyCustomButton(isFunction = true, text = "=", onCLick = {

                    if(expression.isEmpty())return@MyCustomButton

                    result = viewModel.solveExpression(expression)
                })
            }
        }

    }


}

// public fun deleteExpression(expression: String): String {
//    return if (expression.isNotEmpty()){
//        expression.substring(0,expression.length-1)
//    }else{
//        expression
//    }
//}

//public fun solveExpression(expression: String): String {
//    var result =""
//    try {
//        result = Expression(expression
//            .replace("÷","/")
//            .replace("×","*")
//        ).calculate().toString()
//    }catch (e : Exception){
//        e.printStackTrace()
//
//    }
//    return result
//
//}
