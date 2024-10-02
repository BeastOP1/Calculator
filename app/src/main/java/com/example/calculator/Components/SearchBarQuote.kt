package com.example.calculator.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.calculator.R
import com.example.calculator.ui.theme.CustomLightGray


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarQuote(modifier: Modifier = Modifier) {

    val value by remember {
        mutableStateOf("")
    }
    Card(onClick = { /*TODO*/ } ,
modifier = Modifier.fillMaxWidth()
        ) {

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = value, onValueChange = {} ,


            trailingIcon = {
                Icon(painter = painterResource(id = R.drawable.searchicon), contentDescription ="" )
            },

            label = {
                Text(text = "Search Quote" , style = TextStyle(
                    fontSize = 18.sp,
                    color = CustomLightGray
                ) )
            }

            )
    }
}


@Preview
@Composable
fun PreViewSearchBarQuote(modifier: Modifier = Modifier) {

    SearchBarQuote()
}