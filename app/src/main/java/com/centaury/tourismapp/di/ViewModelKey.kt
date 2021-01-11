package com.centaury.tourismapp.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * @Author Centaury (alfa.arnialfa@gmail.com)
 * Created by Centaury on 1/11/2021.
 */
@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)

@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
