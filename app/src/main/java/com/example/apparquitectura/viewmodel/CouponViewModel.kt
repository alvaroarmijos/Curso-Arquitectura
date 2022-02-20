package com.example.apparquitectura.viewmodel

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apparquitectura.R
import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.model.CouponObservable
import com.example.apparquitectura.view.RecyclerCouponsAdapter
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class CouponViewModel: ViewModel() {

    private var couponObservable: CouponObservable  = CouponObservable()
    private var recyclerCouponsAdapter: RecyclerCouponsAdapter? = null

    fun callCoupons(){
        couponObservable.callCoupons()
    }

    fun getCoupons() : MutableLiveData<List<Coupon>> {
        return couponObservable.getCoupons()
    }

    fun setCouponsInRecyclerAdapter(coupons: List<Coupon>){
        recyclerCouponsAdapter?.setCouponsList(coupons)
        recyclerCouponsAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerCouponsAdapter(): RecyclerCouponsAdapter?{
        recyclerCouponsAdapter = RecyclerCouponsAdapter(this, R.layout.card_coupon)
        return recyclerCouponsAdapter
    }

    fun geteCouponAt(position: Int): Coupon?{
        var coupons: List<Coupon>? = couponObservable.getCoupons().value
        return coupons?.get(position)
    }

    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: CircleImageView, imageUrl: String?){
            imageUrl?.let {
                if (it.isNotEmpty())
                    Picasso.get().load(it).into(imageView)
            }
        }
    }
}