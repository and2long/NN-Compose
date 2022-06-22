package com.example.nn.bean

/**
 * 用户积分数据模型
 */
data class UserPoint(
    val point: Int,
    // 积分类型（1：nnApp任务积分）
    val pointType: Int,
    val createBy: String,
    val createTime: String,
    val updateBy: String,
    val updateTime: String,
)