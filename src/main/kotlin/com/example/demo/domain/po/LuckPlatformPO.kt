package com.example.demo.domain.po;

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import io.micronaut.core.annotation.Introspected
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.Date
import java.math.BigDecimal
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.Comment

@Entity
@Table(name = "luck_platform")
@Comment("扫雷群组")
@Introspected
@DynamicUpdate
@DynamicInsert
@AttributeOverride(name = "id", column =Column(name = "id"))
data class LuckPlatformPO(
    @Id @field:Schema(description = "id[112333222]",type="string",example = "1339468674200637453")
    @field:JsonSerialize(using = ToStringSerializer::class)
    @field:Comment("id[112333222]")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    var  id:Long?=null,

    @field:Schema(description = "博弈组ID[112333222]",type="string",example = "1339468674200637453")
    @field:JsonSerialize(using = ToStringSerializer::class)
    @field:Comment("博弈组ID[112333222]")
    var  groupId:Long?=null,

    @field:Schema(description = "博弈组名称[众彩国际]",example = "众彩国际")
    @field:Comment("博弈组名称[众彩国际]")
    var  groupName:String?=null,

    @field:Schema(description = "管理员用户ID[334454555656]",type="string",example = "1339468674200637453")
    @field:JsonSerialize(using = ToStringSerializer::class)
    @field:Comment("管理员用户ID[334454555656]")
    var  adminBotUserId:Long?=null,

    @field:Schema(description = "状态[1-启用中,2-未启用]",example = "1")
    @field:Comment("状态[1-启用中,2-未启用]")
    var  status:Int?=null,

    )  {


}
