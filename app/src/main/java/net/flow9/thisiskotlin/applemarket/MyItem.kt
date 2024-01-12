package net.flow9.thisiskotlin.applemarket

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyItem (             //번호는 인덱스 자동
    val recycleImg:Int,         //이미지
    val recycleTitle:String,    //타이틀
    val recycleLocation:String, //위치
    val recycleSeller:String,   //판매자
    val recyclePrice:String,    //가격
    val recycleLike:String,     //조아요 구독 알림 설정
    val recycleChat:String,     //채팅
    val recycleDescription:String
) : Parcelable