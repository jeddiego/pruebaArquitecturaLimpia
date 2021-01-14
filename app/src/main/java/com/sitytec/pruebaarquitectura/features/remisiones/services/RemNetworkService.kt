package com.sitytec.pruebaarquitectura.features.remisiones.services

import com.sitytec.pruebaarquitectura.features.remisiones.model.RemModel
import com.sitytec.pruebaarquitectura.features.remisiones.model.RemResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

class RemNetworkService(private val retrofit: RemRetrofitDefinition): IRemNetworkService {
    override fun getRemisiones(remModel: RemModel) : RemResponse = retrofit.getRemisiones(remModel).execute().body()!!
}

interface IRemNetworkService {
    fun getRemisiones(remModel: RemModel): RemResponse
}

interface RemRetrofitDefinition {
    @POST("api/Remisiones/GetRemisiones")
    fun getRemisiones(@Body params: RemModel): Call<RemResponse>
}