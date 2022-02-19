package com.example.apparquitectura.presenter

import com.example.apparquitectura.model.CopunsInteractor
import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.model.CouponsInteractorImpl
import com.example.apparquitectura.view.CouponView

class CouponPresenterImpl(var couponView: CouponView): CouponPresenter {

    private var couponInteractor: CopunsInteractor = CouponsInteractorImpl(this)

    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        couponView.showCoupons(coupons)
    }

    override fun getCoupons() {
        couponInteractor.getCouponsAPI()
    }
}