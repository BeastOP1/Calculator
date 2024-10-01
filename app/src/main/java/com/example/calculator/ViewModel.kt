package com.example.calculator

import androidx.lifecycle.ViewModel
import org.mariuszgromada.math.mxparser.Expression

class MainViewModel: ViewModel() {




     fun deleteExpression(expression: String): String {
        return if (expression.isNotEmpty()){
            expression.substring(0,expression.length-1)
        }else{
            expression
        }
    }

    fun solveExpression(expression: String): String {
        var result =""
        try {
            result = Expression(expression
                .replace("÷","/")
                .replace("×","*")
            ).calculate().toString()
        }catch (e : Exception){
            e.printStackTrace()

        }
        return result

    }


}