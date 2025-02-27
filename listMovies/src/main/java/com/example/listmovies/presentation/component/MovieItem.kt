package com.example.listmovies.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import coil3.compose.AsyncImage
import com.example.common.presentation.Dimen10dp
import com.example.common.presentation.Dimen80dp
import com.example.common.presentation.Font12sp
import com.example.common.presentation.Font15sp
import com.example.common.util.getPosterUrl
import com.example.common.R
import com.example.listmovies.domain.PopularMovieDto

@Composable
fun MovieItem(movie: PopularMovieDto, onItemClick: (Int) -> Unit) {
    Column(modifier = Modifier.clickable { onItemClick(movie.id) }) {
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight(), verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .padding(Dimen10dp)
                    .size(Dimen80dp),
                model = getPosterUrl(movie.posterImage),
                contentDescription = null,
                placeholder = painterResource(R.drawable.ic_launcher_foreground)
            )
            Column(modifier = Modifier.fillMaxHeight().padding(vertical = Dimen10dp)) {
                Text(
                    movie.title,
                    fontSize = Font15sp,
                    style = TextStyle(fontStyle = FontStyle.Normal, fontWeight = FontWeight.Bold)
                )
                Text(
                    movie.description,
                    fontSize = Font12sp,
                    style = TextStyle(fontStyle = FontStyle.Normal, fontWeight = FontWeight.Medium)
                )
            }
        }
        HorizontalDivider()
    }
}