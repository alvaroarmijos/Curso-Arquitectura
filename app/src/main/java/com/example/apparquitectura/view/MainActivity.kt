package com.example.apparquitectura.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.apparquitectura.R
import com.example.apparquitectura.databinding.ActivityMainBinding
import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.viewmodel.CouponViewModel


class MainActivity : AppCompatActivity()  {


    private var couponsViewModel: CouponViewModel? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        //View
        setUpBindings(savedInstanceState)




    }

    fun setUpBindings(savedInstanceState: Bundle?){
        var activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        couponsViewModel = ViewModelProviders.of(this).get(CouponViewModel::class.java)

        activityMainBinding.setModel(couponsViewModel)
        setUpListUpdate()
    }

    fun setUpListUpdate(){
        //CallCoupons
        couponsViewModel?.callCoupons()

        //getCoupons - Trae la lista de cupones
        couponsViewModel?.getCoupons()?.observe(this, Observer { coupons: List<Coupon> ->
            Log.w("COUPONS", coupons.get(0).title)
            couponsViewModel?.setCouponsInRecyclerAdapter(coupons)
        })
    }

}