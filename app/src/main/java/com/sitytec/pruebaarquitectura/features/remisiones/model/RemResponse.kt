package com.sitytec.pruebaarquitectura.features.remisiones.model

data class RemResponse(val message: String, val data: DataRemResponse)

data class DataRemResponse(val recolecciones: List<Recoleccion>)

data class Recoleccion(val remisiones: List<Remision>)

data class Remision(val remision: String)

