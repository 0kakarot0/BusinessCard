package com.example.businesscard

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Blue
                ) {
                    MainContent()
                }
            }
        }
    }
}



@Composable
fun MainContent(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D5))
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
        ) {
            BusinessCard(
                name = "Jennifer Doe",
                jobTitle = "Android Developer Extraordinaire",
                modifier = Modifier
                    .background(Color(0xFFD2E8D5))
                    .fillMaxHeight(0.8F)
                    .padding(16.dp)
            )
        }
        Column(
            verticalArrangement = Arrangement.Bottom
        ) {
            UserContactInformation(
                userPhone = stringResource(R.string.user_phone_number),
                socialHandle = stringResource(R.string.user_social_handle),
                userEmail = stringResource(R.string.user_email_address),
                modifier = Modifier.padding(16.dp)

            )
        }
    }
}

@Composable
fun BusinessCardTextInformation(name: String, jobTitle: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = name,
            fontSize = 36.sp,
            fontWeight = FontWeight.W300,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
        Text(
            text = jobTitle,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        MainContent()
    }
}


@Composable
fun BusinessCard(name: String, jobTitle: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .width(120.dp)
                .height(130.dp)
                .background(color = Color(0xFF063043))
        )
        BusinessCardTextInformation(
            name = name,
            jobTitle = jobTitle,
            modifier = Modifier
                .background(Color(0xFFD2E8D5))
                .padding(16.dp)
        )
    }

}

@Composable
fun UserContactInformation(
    userPhone: String,
    socialHandle: String,
    userEmail: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
    ) {
        val spaceBetweenRows = 10.dp
        val spaceWidthBetweenIconAndText = 20.dp
        val textFontSize = 14.sp

        Row() {
            val image = painterResource(R.drawable.baseline_call_24)
            Image(
                painter = image,
                contentDescription = null
            )
            Spacer(Modifier.width(spaceWidthBetweenIconAndText))
            Text(
                text = userPhone,
                color = Color(0xFF515151),
                fontSize = textFontSize
            )
        }
        Spacer(Modifier.height(spaceBetweenRows))
        Row {
            val image = painterResource(R.drawable.share_24px)
            Image(
                painter = image,
                contentDescription = null
            )
            Spacer(Modifier.width(spaceWidthBetweenIconAndText))
            Text(
                text = socialHandle,
                color = Color(0xFF515151),
                fontSize = textFontSize
            )
        }
        Spacer(Modifier.height(spaceBetweenRows))
        Row {
            val image = painterResource(R.drawable.mail_24px)
            Image(
                painter = image,
                contentDescription = null
            )
            Spacer(Modifier.width(spaceWidthBetweenIconAndText))
            Text(
                text = userEmail,
                color = Color(0xFF515151),
                fontSize = textFontSize
            )
        }
    }
}