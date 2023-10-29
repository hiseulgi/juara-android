package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var artSpaceId by remember { mutableStateOf(1) }
    var image = R.drawable.picture_1
    var artworkTitle = R.string.title_1
    var artworkArtist = R.string.artist_1
    var onClickPrev = { artSpaceId = 3}
    var onClickNext = { artSpaceId = 2}

    when(artSpaceId) {
        1 -> {
            image = R.drawable.picture_1
            artworkTitle = R.string.title_1
            artworkArtist = R.string.artist_1
            onClickPrev = { artSpaceId = 3}
            onClickNext = { artSpaceId = 2}
        }
        2 -> {
            image = R.drawable.picture_2
            artworkTitle = R.string.title_2
            artworkArtist = R.string.artist_2
            onClickPrev = { artSpaceId = 1}
            onClickNext = { artSpaceId = 3}
        }
        3 -> {
            image = R.drawable.picture_3
            artworkTitle = R.string.title_3
            artworkArtist = R.string.artist_3
            onClickPrev = { artSpaceId = 2}
            onClickNext = { artSpaceId = 1}
        }
    }

    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(.5f))

        ArtworkWall(
            image = image,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        ArtworkDescriptor(
            artworkTitle = artworkTitle,
            artworkArtist = artworkArtist
        )

        DisplayController(
            onClickNext = onClickNext,
            onClickPrev = onClickPrev
        )
    }
}

@Composable
fun ArtworkWall(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .shadow(
                elevation = 5.dp
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}

@Composable
fun ArtworkDescriptor(
    @StringRes artworkTitle: Int,
    @StringRes artworkArtist: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(horizontal = 32.dp)
            .background(color = Color.LightGray)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = artworkTitle),
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraLight
            )

            Text(
                text = stringResource(id = artworkArtist),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun DisplayController(
    onClickPrev: () -> Unit,
    onClickNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(top = 16.dp)
    ) {
        Button(
            onClick = onClickPrev,
            modifier = modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            Text(text = "Previous")
        }

        Button(
            onClick = onClickNext,
            modifier = modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}