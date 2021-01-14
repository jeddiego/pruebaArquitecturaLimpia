package com.sitytec.pruebaarquitectura.features.remisiones.module

import com.sitytec.pruebaarquitectura.R
import com.sitytec.pruebaarquitectura.core.AppDispatchers
import com.sitytec.pruebaarquitectura.core.IDispatcher
import com.sitytec.pruebaarquitectura.features.remisiones.services.IRemNetworkService
import com.sitytec.pruebaarquitectura.features.remisiones.services.RemNetworkService
import com.sitytec.pruebaarquitectura.features.remisiones.services.RemRetrofitDefinition
import com.sitytec.pruebaarquitectura.features.remisiones.usecase.IPostRemUseCase
import com.sitytec.pruebaarquitectura.features.remisiones.usecase.PostRemUseCase
import com.sitytec.pruebaarquitectura.features.remisiones.viewmodel.RemViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val remModule = module{

    viewModel { RemViewModel(get(), get()) }

    single { AppDispatchers() as IDispatcher }

    factory { PostRemUseCase(get()) as IPostRemUseCase }

    single { RemNetworkService(get()) as IRemNetworkService }

    single {
        Retrofit.Builder()
                .baseUrl(androidApplication().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RemRetrofitDefinition::class.java)
                as RemRetrofitDefinition
    }
}