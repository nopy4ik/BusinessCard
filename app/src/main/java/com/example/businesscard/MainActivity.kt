package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}
@Composable
fun MyLogo(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.logo)

    Image(
        painter = image,
        contentDescription ="my logo",
        modifier = Modifier
            .size(200.dp)
    )
}


@Composable
fun Intro(name: Int, occupation: Int, modifier: Modifier = Modifier){
    Column (

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = stringResource(name),
            color = Color(0xFF0A6A0E),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier

        )
        Text(
            text = stringResource(occupation),
            modifier = modifier,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
fun ContactDetails(phone: Int, info: Int, email: Int, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier.padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.ic_phone),
                contentDescription = "Phone Icon",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = stringResource(phone),
                modifier = Modifier.padding(start = 8.dp) // Расстояние между иконкой и текстом
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.ic_info),
                contentDescription = "Info Icon",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = stringResource(info),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.ic_email),
                contentDescription = "Email Icon",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = stringResource(email),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun BusinessCard( modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxHeight(0.15F)
        ) {
        }
        Column  (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight(0.5F)
        ){
            MyLogo()
            Intro(name = R.string.user_name, occupation = R.string.occupation)
        }
        Column (
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .padding(start = 10.dp)
                .padding(top = 20.dp)
        ){
            ContactDetails(phone = R.string.phone, info = R.string.info, email = R.string.email)
        }
    }


}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}