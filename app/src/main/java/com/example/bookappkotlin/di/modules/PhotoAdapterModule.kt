package com.example.bookappkotlin.di.modules

import com.example.bookappkotlin.screens.home.ui.adapters.PhotoAdapter
import org.koin.dsl.module

val photoAdapterModule = module {

    single {
        PhotoAdapter(get())
    }
}