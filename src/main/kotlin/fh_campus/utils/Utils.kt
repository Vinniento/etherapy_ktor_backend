package fh_campus.utils

import java.util.*

fun getDate(): Calendar {
    val date = Calendar.getInstance(Locale.getDefault())
    date.set(Calendar.HOUR_OF_DAY, 12) //12 hours needed because of rounding errors
    date.set(Calendar.MINUTE, 0)
    date.set(Calendar.SECOND, 0)
    date.set(Calendar.MILLISECOND, 0)

    return date
}