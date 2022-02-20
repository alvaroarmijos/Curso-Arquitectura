package com.example.apparquitectura.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class CouponObservable: BaseObservable() {

    private var couponRepository: CouponRepository = CouponRepositoryImpl()

    //Repositorio
    fun callCoupons(){
        couponRepository.callCouponsAPI()
    }

    //View model
    fun getCoupons(): MutableLiveData<List<Coupon>> {
        return couponRepository.getCoupons()
    }
}