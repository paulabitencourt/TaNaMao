package com.example.bookappkotlin.di

import com.example.bookappkotlin.login.repository.LoginRepository
import com.example.bookappkotlin.login.repository.UserLoginRepository
import com.example.bookappkotlin.login.services.LoginService
import com.example.bookappkotlin.login.services.UserLoginServices
import org.koin.dsl.module


val loginModule = module {
    single<LoginRepository>{
        UserLoginRepository()
    }

    single<LoginService>{
        UserLoginServices()
    }
}