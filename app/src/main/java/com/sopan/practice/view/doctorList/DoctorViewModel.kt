package com.sopan.practice.view.doctorList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sopan.practice.room.DoctorDao
import com.sopan.practice.room.TheDataBase

class DoctorViewModel(application: Application) : AndroidViewModel(application) {

    var theDataBase: TheDataBase = TheDataBase.getInstance(application)
    var doctorDao: DoctorDao = theDataBase.doctorDao()


    fun getDoctorsFromServer(): MutableLiveData<List<Doctor>> {
        return DoctorRepository.getDoctorsFromServer()
    }

    fun insertDoctorsToDataBase(doctors: List<Doctor>): MutableLiveData<Boolean> {
        return DoctorRepository.insertDoctorsToDataBase(doctorDao, doctors)
    }

    fun getDoctorsFromDataBase(): LiveData<List<Doctor>> {
        return doctorDao.getDoctorFromDataBase()
    }

    fun deleteAllDoctors(): MutableLiveData<Boolean> {
        return DoctorRepository.deleteAllDoctorsFromDataBase(doctorDao)
    }
}