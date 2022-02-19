package com.example.apparquitectura.view

import com.example.apparquitectura.model.Coupon

interface CouponView {
    //Vista
    fun showCoupons(coupons: ArrayList<Coupon>?)

    //Presentador
    fun getCoupons()



}