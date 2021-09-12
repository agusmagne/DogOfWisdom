package com.example.dogofwisdom.view

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    protected fun safeCall(dispatcher: CoroutineDispatcher? = null, method: suspend () -> Unit) {
        try {
            if (dispatcher == null) {
                CoroutineScope(Dispatchers.Main).launch {
                    method.invoke()
                }
            } else {
                CoroutineScope(dispatcher).launch {
                    method.invoke()
                }
            }
        } catch (e: Throwable) {

        }

    }

    class Event<out T>(private val content: T) {

        private var hasBeenHandled: Boolean = false

        fun getContentIfNotHandled(): T? {
            return if (hasBeenHandled) {
                null
            } else {
                hasBeenHandled = true
                content
            }
        }
    }

    class VoidEvent {

        var hasBeenHandled: Boolean = false

        fun hasBeenHandled(): Boolean {
            return if (hasBeenHandled) {
                true
            } else {
                hasBeenHandled = true
                false
            }
        }

    }

}

fun <T> MutableLiveData<out BaseViewModel.Event<T>>.postEvent(content: T) {
    value = BaseViewModel.Event(content)
}

fun <T> LiveData<out BaseViewModel.Event<T>>.observeEvent(
    owner: LifecycleOwner,
    onEventUnhandled: (T) -> Unit
) {
    observe(owner, Observer { it?.getContentIfNotHandled()?.let(onEventUnhandled) })
}

fun LiveData<out BaseViewModel.VoidEvent>.observeEvent(
    owner: LifecycleOwner,
    onEventUnhandled: () -> Unit
) {
    observe(owner, Observer { if (!it.hasBeenHandled()) onEventUnhandled() })
}