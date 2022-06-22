package com.example.nn.bean

/**
 * 任务数据模型
 */
data class TaskBean(
    val id: Int,
    // 图标
    val img: String,
    val taskName: String,
    val createBy: String,
    val createTime: String,
    val description: String,
    // 每日上限次数
    val numberLimit: Int,
    val taskStatus: Int,
    val sort: Int,
    // 任务奖励积分
    val point: Int,
    // 任务平台（0：自有平台 1：穿山甲 2:百度联盟 3：360 4：优量汇）
    val taskPlatform: Int,
    // 广告类型
    // 1-（1开屏广告 2激励视频 3互动视频 4信息流广告 5banner广告 6全屏图片）
    // 4-（1沉浸式视频流广告 2视频贴片广告 3详情页插入广告 4横幅广告 5信息流广告 6插屏广告 7 激励广告 8开屏广告）
    val advertType: Int,
    // 广告id （自有平台时可以多个,为视频id 第三方平台为代码位）
    val advertId: String,
    // 状态（0：禁用 1：启用）
    val status: Int,
    val channel: Int,
)