@file:Suppress("MemberVisibilityCanBePrivate")

package com.dede.android_eggs.util

import java.util.*


object EasterUtils {

    fun isEaster(): Boolean {
        val cal = Calendar.getInstance()
        val easterCal = calculateEasterDate(cal.get(Calendar.YEAR))
        return cal[Calendar.DAY_OF_YEAR] == easterCal[Calendar.DAY_OF_YEAR]
    }

    fun calculateEasterDate(year: Int): Calendar {
        if (year < 1583 || year > 4099) {
            throw IllegalArgumentException("Year must be between 1583 and 4099")
        }
        val a = year % 19
        val b = year / 100
        val c = year % 100
        val d = b / 4
        val e = b % 4
        val f = (b + 8) / 25
        val g = (b - f + 1) / 3
        val h = (19 * a + b - d - g + 15) % 30
        val i = c / 4
        val k = c % 4
        val l = (32 + 2 * e + 2 * i - h - k) % 7
        val m = (a + 11 * h + 22 * l) / 451
        val n = h + l - 7 * m + 114
        val month = n / 31
        val day = n % 31 + 1
        val calendar = Calendar.getInstance()
        calendar.clear()
        calendar.set(year, month - 1, day)
        return calendar
    }
}