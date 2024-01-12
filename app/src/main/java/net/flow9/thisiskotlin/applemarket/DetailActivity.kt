package net.flow9.thisiskotlin.applemarket

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import net.flow9.thisiskotlin.applemarket.databinding.ActivityDetailBinding
import java.text.DecimalFormat
import java.text.NumberFormat


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val item: MyItem? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.ITEM_OBJECT, MyItem::class.java)
        } else {
            intent.getParcelableExtra<MyItem>(Constants.ITEM_OBJECT)
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private val itemPosition: Int by lazy {
        intent.getIntExtra(Constants.ITEM_INDEX, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        val tv_back = findViewById<ImageView>(R.id.btn_detail_back)
        tv_back.setOnClickListener {
            finish()
        }

        // Main에서 받은 데이터를 위젯으로 전달
        binding.ivDetailProduct.setImageDrawable(item?.let {
            ResourcesCompat.getDrawable(
                resources,
                it.recycleImg,
                null
            )
        })
        binding.tvDetailProfile.setImageDrawable(item?.let {
            ResourcesCompat.getDrawable(
                resources,
                it.recycleImg,
                null
            )
        })
        binding.tvDetailLocation.text = item?.recycleLocation
        binding.tvDetailSeller.text = item?.recycleSeller
        binding.tvDetailTitle.text = item?.recycleTitle
        binding.tvDetailDescription.text = item?.recycleDescription

        val price = item?.recyclePrice?.toInt()
        val formattedPrice = if (price!! >= 1000000) {
            val changeValue = price / 10000
            "${changeValue}만원"
        } else {
            NumberFormat.getNumberInstance().format(price) + "원"
        }
        binding.tvDetailPrice.text = formattedPrice


    }


}