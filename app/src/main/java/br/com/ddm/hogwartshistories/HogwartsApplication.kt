package br.com.ddm.hogwartshistories

import android.app.Application

class HogwartsApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        //singleton
        private var appInstance: HogwartsApplication? = null
        fun getInstance(): HogwartsApplication {
            if (appInstance == null)
                throw IllegalAccessException("Configurar application no Android Manifest")
            return appInstance!!
        }
    }
}