package com.nurlandroid.di


import com.nurlandroid.DummyDataInteractor
import org.koin.dsl.module

val mainModule = module(createdAtStart = true) {

    single { DummyDataInteractor() }
}