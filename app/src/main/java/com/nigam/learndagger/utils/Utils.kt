package com.nigam.learndagger.utils

import android.content.res.Resources
import android.icu.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun Long.toDisplayFormat(): String {
    val calendar = Calendar.getInstance().apply {
        timeInMillis = this@toDisplayFormat
    }
    val dateFormatter = SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH)
    val timeFormatter = SimpleDateFormat("hh:mma", Locale.ENGLISH)
    val today = Calendar.getInstance()
    val yesterday = Calendar.getInstance().apply {
        add(Calendar.DATE, -1)
    }
    val time = timeFormatter.format(calendar.time)
    return if (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR)
        && calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)
    ) {
        "Today, $time";
    } else if (calendar.get(Calendar.YEAR) == yesterday.get(Calendar.YEAR)
        && calendar.get(Calendar.DAY_OF_YEAR) == yesterday.get(Calendar.DAY_OF_YEAR)
    ) {
        "Yesterday, $time";
    } else {
        dateFormatter.format(calendar.time) + " " + time
    }
}

/**
 * Converts dp to pixels
 */
val Int.dpToPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()
