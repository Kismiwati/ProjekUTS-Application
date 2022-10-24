package com.kismiwati.application.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Resto(
    @StringRes val StringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
