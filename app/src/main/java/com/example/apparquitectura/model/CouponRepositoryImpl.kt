package com.example.apparquitectura.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepositoryImpl() : CouponRepository {

    private var coupons = MutableLiveData<List<Coupon>>()
    //Subeject MutableLiveData
    //Observers List Coupon
    //Change List Coupen - MutableLiveData
    //observe

    override fun getCoupons(): MutableLiveData<List<Coupon>> {
        return coupons
    }

    //TODa la logica de conexion
    override fun callCouponsAPI() {
        var couponsList: ArrayList<Coupon>? = ArrayList<Coupon>()
        val apiAdapter= ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message!!)
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Coupon(jsonObject)
                    couponsList?.add(coupon)
                }

                //View
                coupons.value = couponsList


            }
        })

    }


}