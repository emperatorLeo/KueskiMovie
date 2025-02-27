package com.example.listmovies.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.common.presentation.Dimen10dp
import com.example.common.presentation.Dimen250dp
import com.example.common.presentation.Dimen80dp
import com.example.common.presentation.Font20sp
import com.example.listmovies.R

@Composable
fun LoaderComponent(){

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            Modifier.align(Alignment.Center).fillMaxSize().padding(top = Dimen80dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(Dimen10dp)
                    .size(Dimen250dp)
            )
            Text(
                modifier = Modifier.padding(Dimen10dp),
                text = stringResource(R.string.please_wait),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = Font20sp, color = Color.Magenta, fontWeight = FontWeight.Bold)
            )
        }
    }
}