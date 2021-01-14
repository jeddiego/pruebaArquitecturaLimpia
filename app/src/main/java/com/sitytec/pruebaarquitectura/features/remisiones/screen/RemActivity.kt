package com.sitytec.pruebaarquitectura.features.remisiones.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sitytec.pruebaarquitectura.databinding.ActivityMesaBinding
import com.sitytec.pruebaarquitectura.features.remisiones.viewmodel.RemViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class RemActivity: AppCompatActivity() {
    private lateinit var bind: ActivityMesaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMesaBinding.inflate(layoutInflater)
        setContentView(bind.root)

        remViewModel.loadState.observe(this, { processLoadState(it) })
        bind.btnLoad.setOnClickListener {
            remViewModel.dispatch(RemViewModel.Actions.DownloadDataAction)
        }
    }

    private fun processLoadState(loadState: RemViewModel.LoadState?) {
        when(loadState) {
            RemViewModel.LoadState.Loading -> {
                bind.tvLabel.text = "Descargando desde el servidor"
            }
            is RemViewModel.LoadState.LoadRemResult -> bind.tvLabel.text =
                loadState.result.result?.message
            null  -> bind.tvLabel.text = "Is null, damn"
        }
    }

    private val remViewModel: RemViewModel by viewModel()
}