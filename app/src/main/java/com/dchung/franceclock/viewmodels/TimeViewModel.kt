package com.dchung.franceclock.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class TimeViewModel : ViewModel() {

    private val _localTime :MutableLiveData<String> = MutableLiveData("")
    private val _easternTime :MutableLiveData<String> = MutableLiveData("")
    private val _centralTime :MutableLiveData<String> = MutableLiveData("")
    private val _pacificTime :MutableLiveData<String> = MutableLiveData("")

    val localTime get() = _localTime
    val easternTime get() = _easternTime
    val centralTime get() = _centralTime
    val pacificTime get() = _pacificTime

    fun updateTimes() {

        val date = Date()

        val dateFormat = SimpleDateFormat("EEE H:mm a", Locale.getDefault())
        _localTime.value = dateFormat.format(date)

        Log.wtf("TIME", _localTime.value.toString())

        dateFormat.timeZone = TimeZone.getTimeZone("America/New_York")
        _easternTime.value = dateFormat.format(date)

        dateFormat.timeZone = TimeZone.getTimeZone("America/Chicago")
        _centralTime.value = dateFormat.format(date)

        dateFormat.timeZone = TimeZone.getTimeZone("America/Los_Angeles")
        _pacificTime.value = dateFormat.format(date)
    }
}

