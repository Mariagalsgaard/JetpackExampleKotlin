package org.pondar.jetpackexamplekotlin.converters

import androidx.databinding.InverseMethod

object Converter {

        @InverseMethod("stringToInt")
        @JvmStatic
        fun intToString(value: Long
        ): String {
            if (value==0L)
                return ""
            else
                return value.toString()
        }


        @JvmStatic
        fun stringToInt(value: String
        ): Long {
            if (value.isEmpty())
                return 0
            else
                return value.toLong()
    }

}


