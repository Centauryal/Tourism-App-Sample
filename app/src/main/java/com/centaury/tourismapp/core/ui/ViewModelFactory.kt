package com.centaury.tourismapp.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.centaury.tourismapp.di.AppScope
import javax.inject.Inject
import javax.inject.Provider

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/7/2021.
 */
@AppScope
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creators = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        return creators.get() as T
    }
}