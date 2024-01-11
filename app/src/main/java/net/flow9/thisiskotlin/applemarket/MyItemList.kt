package net.flow9.thisiskotlin.applemarket

object MyItemList {

    val list = mutableListOf<MyItem>()

    init {

        add(
            MyItem(
                R.drawable.sample1,
                "산지 한달된 선풍기 팝니다 긴 제목 테스트 긴 제목 테스트 긴 제목 테스트 긴 제목 테스트 긴 제목 테스트",
                "서울 서대문구 창천동",
                "대현동",
                "10000000",
                "13",
                "25",
                "이사가서 필요가 없어졌어요 급하게 내놓습니다"
            )
        )


    }

    fun get(index: Int): MyItem {
        return list[index]
    }

    private fun add(myitem: MyItem) {
        list.add(myitem)
    }

}