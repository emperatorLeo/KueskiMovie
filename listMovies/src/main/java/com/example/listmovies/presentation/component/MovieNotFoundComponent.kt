package com.example.listmovies.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.common.presentation.Dimen10dp
import com.example.common.presentation.Dimen250dp
import com.example.common.presentation.Dimen80dp
import com.example.common.presentation.Font20sp
import com.example.listmovies.R
import com.example.listmovies.util.EMPTY_STRING

@Composable
@Preview(showBackground = true)
fun MovieNotFoundComponent(){
    Column(
        Modifier.fillMaxSize().background(Color.White).padding(top = Dimen80dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(Dimen250dp),
            painter = painterResource(com.example.common.R.drawable.unown),
            contentDescription = EMPTY_STRING
        )

        Text(
            modifier = Modifier.padding(Dimen10dp),
            text = stringResource(R.string.movie_not_found),
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = Font20sp, color = Color.Magenta, fontWeight = FontWeight.Bold)
        )
    }
}