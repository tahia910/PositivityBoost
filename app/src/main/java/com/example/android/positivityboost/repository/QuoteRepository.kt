package com.example.android.positivityboost.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.positivityboost.network.QuoteApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class QuoteRepository(private val quoteApi: QuoteApi) : KoinComponent {

    fun getQuote(scope: CoroutineScope): LiveData<String> {
        val result = MutableLiveData<String>()

        try {
            scope.launch {
                val response = quoteApi.getQuote().affirmation
                result.value = response
            }
        } catch (e: Exception) {
            e.printStackTrace()
            // handle error
        }
        return result
    }
}