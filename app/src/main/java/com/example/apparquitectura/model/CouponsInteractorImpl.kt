package com.example.apparquitectura.model

import com.example.apparquitectura.presenter.CouponPresenter

class CouponsInteractorImpl(var couponPresenter: CouponPresenter): CopunsInteractor {

    private var couponRepository: CouponRepository = CouponRepositoryImpl(couponPresenter)

    override fun getCouponsAPI() {
        couponRepository.getCouponsAPI()
    }
}