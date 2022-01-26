package com.example.linkit.presentation

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.linkit.R
import com.example.linkit.domain.interfaces.IFolder
import com.example.linkit.domain.model.FolderPrivate
import com.example.linkit.domain.model.User
import com.example.linkit.domain.model.cxt
import com.example.linkit.presentation.component.*
import com.example.linkit.presentation.model.IconText
import com.example.linkit.ui.theme.LinkItTheme
import com.example.linkit.viewmodel.HomeViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Home() {
//    val homeViewModel = hiltViewModel<HomeViewModel>()
//    val user = homeViewModel.user.collectAsState(initial = User.GUEST).value
    val dropExpanded by remember { mutableStateOf(false) }
    val dropItems = listOf(
        IconText(Icons.Filled.Person,"개인폴더"),
        IconText(Icons.Filled.Group, "공유폴더"),
        IconText(Icons.Filled.Groups, "모두")
    )
    val folders = getFolderSamples()

    Scaffold(
        topBar = {
            LinkItAppBar(
                modifier = Modifier.height(65.dp)
            )
        },
        bottomBar = {
            LinkItBottomBar(
                iconSize = 32.dp
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                DropDownButton(items = dropItems)
            }
            FolderGrid(
                modifier = Modifier
                    .weight(6.6f)
                    .padding(start = 25.dp, end = 25.dp),
                folders = folders,
                cells = 3
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    shape = CircleShape,
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White
                    ),
                    contentPadding = PaddingValues(20.dp, 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null
                    )
                    Text(text = "폴더 추가")
                }
            }
        }
    }
}

@Composable
fun getFolderSamples() : List<IFolder> {
    return listOf(
        FolderPrivate(1, "취미", getBitmap(R.drawable.ic_sample_image_001)),
        FolderPrivate(2, "운동", getBitmap(R.drawable.ic_sample_image_001)),
        FolderPrivate(3, "공부", getBitmap(R.drawable.ic_sample_image_001)),
        FolderPrivate(4, "대학", getBitmap(R.drawable.ic_sample_image_001)),
        FolderPrivate(5, "취업", getBitmap(R.drawable.ic_sample_image_001)),
        FolderPrivate(6, "놀이", getBitmap(R.drawable.ic_sample_image_001)),
        FolderPrivate(1, "취미", getBitmap(R.drawable.ic_sample_image_001)),
        FolderPrivate(2, "운동", getBitmap(R.drawable.ic_sample_image_001)),
        FolderPrivate(3, "공부", getBitmap(R.drawable.ic_sample_image_001)),
        FolderPrivate(4, "대학", getBitmap(R.drawable.ic_sample_image_001)),
        FolderPrivate(5, "취업", getBitmap(R.drawable.ic_sample_image_001)),
        FolderPrivate(6, "놀이", getBitmap(R.drawable.ic_sample_image_001))
    )
}

@Composable
fun getBitmap(id: Int) : Bitmap? {
    return AppCompatResources.getDrawable(cxt(), id)?.toBitmap()
}

@Preview
@Composable
fun PreviewHome() {
    LinkItTheme {
        Home()
    }
}