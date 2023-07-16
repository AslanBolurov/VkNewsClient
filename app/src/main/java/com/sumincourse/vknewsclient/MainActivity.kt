package com.sumincourse.vknewsclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sumincourse.vknewsclient.ui.theme.MainScreen
import com.sumincourse.vknewsclient.ui.theme.VkNewsClientTheme

class MainActivity : ComponentActivity() {

//    private val viewModel by viewModels<NewsFeedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val viewModel=ViewModelProvider(this)[MainViewModel::class.java]
        setContent {
            VkNewsClientTheme {
                MainScreen()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Test() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TopAppBar title") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                },
            )
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                    label = { Text("Favourite")}
                )
            }
        },
        drawerContent = {
            Text(text = "Text 1")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Text 2")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Text 3")
        }


    ) {
        Text(
            modifier = Modifier.padding(it),
            text = "This is scaffold content"
        )
    }

}


