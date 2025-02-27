package com.example.details.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.common.presentation.Dimen100dp
import com.example.common.presentation.Dimen10dp
import com.example.common.presentation.Dimen200dp
import com.example.common.presentation.Dimen20dp
import com.example.common.presentation.Dimen50dp
import com.example.common.presentation.Font12sp
import com.example.common.presentation.Font15sp
import com.example.common.util.getPosterUrl
import com.example.details.R
import com.example.listmovies.presentation.viewmodel.MovieViewModel

@Composable
fun DetailsScreen(viewModel: MovieViewModel, navController: NavController, movieId: Int) {

    val movie = viewModel.getSelectedMovie(movieId)

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Dimen20dp, top = Dimen50dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                tint = Color.Magenta,
                contentDescription = "",
                modifier = Modifier
                    .clickable { navController.popBackStack() }
                    .size(Dimen50dp)
            )
        }
        AsyncImage(
            modifier = Modifier
                .padding(top = Dimen100dp, bottom = Dimen10dp)
                .size(Dimen200dp),
            model = getPosterUrl(movie.posterImage),
            contentDescription = null,
            placeholder = painterResource(com.example.common.R.drawable.ic_launcher_foreground)
        )

        Text(
            text = movie.title,
            fontSize = Font15sp,
            style = TextStyle(fontStyle = FontStyle.Normal, fontWeight = FontWeight.Bold)
        )

        Text(
            text = movie.description,
            modifier = Modifier.padding(top = Dimen10dp, start = Dimen20dp, end = Dimen20dp),
            fontSize = Font12sp,
            style = TextStyle(fontStyle = FontStyle.Normal, fontWeight = FontWeight.Medium)
        )

        Text(
            stringResource(R.string.lenguage_label, movie.language),
            modifier = Modifier.padding(top = Dimen10dp),
            fontSize = Font12sp,
            style = TextStyle(fontStyle = FontStyle.Normal, fontWeight = FontWeight.Medium)
        )

        Text(
            stringResource(R.string.release_date_label, movie.releaseDate),
            modifier = Modifier.padding(top = Dimen10dp),
            fontSize = Font12sp,
            style = TextStyle(fontStyle = FontStyle.Normal, fontWeight = FontWeight.Medium)
        )
    }
}