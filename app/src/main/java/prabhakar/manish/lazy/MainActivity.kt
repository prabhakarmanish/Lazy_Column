package prabhakar.manish.lazy

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            lazycolumn()
        }
    }
}

@Composable
fun lazycolumn() {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize()
    ) {
        items(999) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .shadow(4.dp, RoundedCornerShape(8.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.surface)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                    .clickable {
                        Toast
                            .makeText(context, "item $it Clicked", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .padding(16.dp)

            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "item $it")
                        Text(text = "item $it Description")
                    }
                    Icon(
                        imageVector = Icons.Outlined.Build,
                        contentDescription = "person",
                        modifier = Modifier
                            .clip(CircleShape)
                            .border(1.dp, Color.Black, CircleShape)
                            .background(
                                Color(
                                    Random.nextFloat(),
                                    Random.nextFloat(),
                                    Random.nextFloat()
                                )
                            )
                            .clickable {
                                Toast
                                    .makeText(
                                        context,
                                        "item ${it + 1} Clicked",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }
                            .padding(5.dp)
                    )

                }

            }
        }
    }
}

@Preview(showBackground = true)
//@PreviewLightDark
@Composable
fun PreviewLazyColumn() {
    lazycolumn()
}

