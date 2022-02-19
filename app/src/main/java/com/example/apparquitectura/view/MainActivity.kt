package com.example.apparquitectura.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.R
import com.example.apparquitectura.model.ApiAdapter
import com.example.apparquitectura.model.CouponRepositoryImpl
import com.example.apparquitectura.presenter.CouponPresenter
import com.example.apparquitectura.presenter.CouponPresenterImpl
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), CouponView  {

    private var couponPresenter: CouponPresenter ? = null
    var rvCoupons: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        couponPresenter = CouponPresenterImpl(this)

        //View
        rvCoupons = findViewById(R.id.rvCoupons)
        rvCoupons?.layoutManager = LinearLayoutManager(this)

        getCoupons()

    }

    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        try {
            rvCoupons!!.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    override fun getCoupons() {
        couponPresenter?.getCoupons()
    }
}