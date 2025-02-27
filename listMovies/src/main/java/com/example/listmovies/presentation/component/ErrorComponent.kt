package com.example.listmovies.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import com.example.common.presentation.Dimen10dp
import com.example.common.presentation.Dimen200dp
import com.example.common.presentation.Font20sp
import com.example.listmovies.R

@Composable
fun ErrorComponent() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(Dimen200dp),
            painter = painterResource(com.example.common.R.drawable.ic_error),
            contentDescription = ""
        )

        Text(
            modifier = Modifier.padding(Dimen10dp),
            text = stringResource(R.string.error),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = Font20sp,
                color = Color.Magenta,
                fontWeight = FontWeight.Bold
            )
        )
    }
}