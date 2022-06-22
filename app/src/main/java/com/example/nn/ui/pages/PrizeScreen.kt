package com.example.nn.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.nn.R
import com.example.nn.bean.TaskBean
import com.example.nn.ui.theme.PrimaryColor

@Composable
fun PrizeScreen(elementState: PrizeScreenElementState) {
    val userPointState by elementState.userPointState.observeAsState()
    val allTasksState by elementState.allTasksState.observeAsState()
    // 用户积分
    val point = if (userPointState is PrizeScreenUserPointState.Loaded) {
        (userPointState as PrizeScreenUserPointState.Loaded).userPoint.point
    } else {
        0
    }
    // 所有任务
    val tasks = mutableListOf<TaskBean>()
    if (allTasksState is PrizeScreenAllTasksState.Loaded) {
        tasks.addAll((allTasksState as PrizeScreenAllTasksState.Loaded).allTasks)
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffeeeeee))
    ) {
        Box {
            ConstraintLayout {
                val (header, spacer, floatingPanel, listTitle) = createRefs()
                Header(
                    modifier = Modifier.constrainAs(header) {
                        top.linkTo(parent.top)
                    },
                    taskCount = tasks.size,
                )
                Spacer(modifier = Modifier
                    .height(60.dp)
                    .constrainAs(spacer) {
                        top.linkTo(header.bottom)
                    })
                ListTitle(modifier = Modifier.constrainAs(listTitle) {
                    top.linkTo(spacer.bottom)
                })
                FloatingPanel(
                    modifier = Modifier
                        .constrainAs(floatingPanel) {
                            top.linkTo(header.bottom)
                            bottom.linkTo(header.bottom)
                        }
                        .padding(bottom = 20.dp),
                    p = point
                )
            }
        }
    }
}


@Composable
private fun Header(modifier: Modifier = Modifier, taskCount: Int = 0) {
    ConstraintLayout(modifier = modifier) {
        val (bg, title, subTitle) = createRefs()
        Image(
            painter = painterResource(id = R.mipmap.prize_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.5F)
                .constrainAs(bg) {
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = "做任务 享免排队加速",
            style = TextStyle(fontSize = 26.sp, color = Color.White),
            modifier = Modifier.constrainAs(title) {
                linkTo(top = bg.top, bottom = bg.bottom, bias = 0.3F)
                start.linkTo(bg.start, margin = 12.dp)
            }
        )
        Box(
            modifier = Modifier
                .constrainAs(subTitle) {
                    top.linkTo(title.bottom, margin = 5.dp)
                    start.linkTo(title.start)
                }
                .background(
                    brush = Brush.horizontalGradient(listOf(Color(0x55FFFFFF), Color(0x00FFFFFF))),
                    shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp),
                )
        ) {
            Text(
                text = "今日还可完成${taskCount}个任务",
                style = TextStyle(fontSize = 14.sp, color = Color.White),
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
            )
        }
    }
}

@Composable
private fun FloatingPanel(modifier: Modifier = Modifier, p: Int = 0) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(96.dp)
            .padding(horizontal = 12.dp)
            .background(
                shape = RoundedCornerShape(12.dp),
                color = Color.White
            )
    ) {
        val (point, subTitle, icon) = createRefs()
        Text(
            text = "$p",
            style = TextStyle(
                fontSize = 32.sp,
                color = PrimaryColor,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .testTag("point")
                .constrainAs(point) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start, margin = 24.dp)
                    bottom.linkTo(subTitle.top)
                    ChainStyle.Packed
                })
        Text(
            text = "已获免排队积分",
            style = TextStyle(
                fontSize = 16.sp,
                color = PrimaryColor,
            ),
            modifier = Modifier.constrainAs(subTitle) {
                top.linkTo(point.bottom)
                start.linkTo(point.start)
                bottom.linkTo(parent.bottom)
                ChainStyle.Packed
            })
        Image(
            painter = painterResource(id = R.mipmap.ic_nav),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(icon) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end, margin = 20.dp)
                }
        )
    }
}

@Composable
private fun ListTitle(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(text = "每日任务", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
        Text(
            text = "任务于每日 00:00 更新",
            style = TextStyle(fontSize = 14.sp, color = Color(0xffb2b2b2))
        )
    }
}
