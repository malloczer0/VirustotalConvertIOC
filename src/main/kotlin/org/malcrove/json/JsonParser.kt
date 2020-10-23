package org.malcrove.json

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

open class JsonParser {
    open fun toHashmap(json: String) : Map<String, Any>
            = Gson().fromJson(json, object : TypeToken<Map<String, Any>>() {}.type)
}