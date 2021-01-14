package com.sitytec.pruebaarquitectura.features.remisiones.policy

import com.sitytec.pruebaarquitectura.core.Result

class RemPolicy {
     companion object {
         @JvmStatic
         fun validate(data: String?): Result<Boolean> {
             // TODO: cambiar implementacion real
             return Result(true)
         }
     }
}