package com.sitytec.pruebaarquitectura.features.remisiones.usecase

import com.sitytec.pruebaarquitectura.core.Result
import com.sitytec.pruebaarquitectura.features.remisiones.model.RemModel
import com.sitytec.pruebaarquitectura.features.remisiones.model.RemResponse
import com.sitytec.pruebaarquitectura.features.remisiones.policy.RemPolicy
import com.sitytec.pruebaarquitectura.features.remisiones.services.IRemNetworkService

class PostRemUseCase(private val networkService: IRemNetworkService): IPostRemUseCase{
    override fun execute(remModel: RemModel): Result<RemResponse> {

        val remResponse = networkService.getRemisiones(remModel)

        //save local data
        return Result(remResponse)
    }
}

interface IPostRemUseCase {
    fun execute(mesaModel: RemModel): Result<RemResponse>
}