package com.example.happybirthday

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class BusinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BussinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BussinessCardApp(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Profile Card
        Row(
            modifier = Modifier
                .weight(3F)
        ) {
            val image = painterResource(id = R.drawable.android_logo)
            ProfileCard(fullName = "Muhammad Bagus", title = "Android Developer", logo = image)
        }

        // Contact Card
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1F)
        ) {
            ContactCard(phoneNumber = "+62 (812) 2669 4207", socialMedia = "@sugab.3gp", email = "sugab@gmail.com")
        }
    }
}

@Composable
fun ProfileCard(fullName: String, title: String, logo: Painter, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row {
            Box(
                modifier = Modifier
                    .background(Color(0xFF2c375c))
                    .size(200.dp),
            ) {
                Image(
                    painter = logo,
                    contentDescription = null
                )

            }
        }

        Row {
            Text(
                text = fullName,
                fontSize = 36.sp
            )
        }

        Row {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0d4d1c)
            )
        }
    }
}

@Composable
fun ContactCard(phoneNumber: String, socialMedia: String, email: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactInfoRow(Icons.Filled.Phone, phoneNumber)

        ContactInfoRow(Icons.Filled.Person, socialMedia)

        ContactInfoRow(Icons.Filled.Email, email)
    }
}

@Composable
fun ContactInfoRow(icon: ImageVector, text: String, modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Spacer(Modifier.weight(1f))

        Column(
            modifier = Modifier
                .weight(2f)
        ) {
            Row {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color(0xFF0d4d1c))
                Text(
                    text = text,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .padding(start = 8.dp)
                )
            }
        }

        Spacer(Modifier.weight(1f))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    HappyBirthdayTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFb8ffc8)
        ) {
            BussinessCardApp()
        }
    }
}