package com.example.apparquitectura.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.apparquitectura.R
import com.example.apparquitectura.model.Coupon
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class CouponDetailActivity : AppCompatActivity() {

    private var couponSelected: Coupon? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coupon_detail)

        couponSelected = intent.getSerializableExtra("COUPON") as Coupon

        var tvTitleDetail: TextView = findViewById(R.id.tvTitleDetail)
        var tvDescriptionShortDetail: TextView = findViewById(R.id.tvDescriptionShortDetail)
        var tvCategoryDetail: TextView = findViewById(R.id.tvCategoryDetail)
        var tvDateDetail: TextView = findViewById(R.id.tvDateDetail)
        var tvDescriptionDetailData: TextView = findViewById(R.id.tvDescriptionDetailData)
        var tvOffertDetailData: TextView = findViewById(R.id.tvOffertDetailData)
        var tvWebsiteDetailData: TextView = findViewById(R.id.tvWebsiteDetailData)
        var tvDateEndData: TextView = findViewById(R.id.tvDateEndData)
        var imgHeaderDetail: ImageView = findViewById(R.id.imgHeaderDetail)
        var imgCouponDetail: CircleImageView = findViewById(R.id.imgCouponDetail)
        var btnOpenOffer: Button = findViewById(R.id.btnOpenOffer)

        tvTitleDetail.text = couponSelected?.title
        tvDescriptionShortDetail.text = couponSelected?.description
        tvCategoryDetail.text = couponSelected?.category
        tvDateDetail.text = couponSelected?.endDate
        tvDescriptionDetailData.text = couponSelected?.description
        tvOffertDetailData.text = couponSelected?.offer
        tvWebsiteDetailData.text = couponSelected?.website
        tvDateEndData.text = couponSelected?.endDate

        if (couponSelected?.image_url?.isNotEmpty() == true){
            Picasso.get().load(couponSelected?.image_url).resize(520, 520).centerCrop().into(imgHeaderDetail)

        }


        btnOpenOffer.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(couponSelected?.url)
            startActivity(openURL)
        }

    }
}