package com.sopan.practice.di

import com.sopan.practice.view.doctorList.Doctor
import com.sopan.practice.view.doctorList.DoctorViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun getDoctor(): Doctor

    fun inject(doctorViewModel: DoctorViewModel)

}