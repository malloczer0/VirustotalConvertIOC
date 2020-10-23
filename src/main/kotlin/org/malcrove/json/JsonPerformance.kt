package org.malcrove.json

import com.google.gson.Gson

open class JsonPerformance {
    fun handleMapping(json: Map<String, Any>): String? {
        var mutableMap = mutableMapOf<String, Any>("status" to (json["response_code"] == 1.0))
        if (json["response_code"] == 1.0) {
            json.filterKeys { it in setOf(
                    "md5",
                    "sha256",
                    "sha1",
                    "scans")
            }.forEach {
                when(it.key) {
                    "md5" -> mutableMap[it.key.toUpperCase()] = it.value
                    "sha1" -> mutableMap["SHA-1"] = it.value
                    "sha256" -> mutableMap["SHA-256"] = it.value
                    "scans" -> {
                        val namesMapping = @Suppress("UNCHECKED_CAST") it.value as Map<String, Any>
                        mutableMap["names"] = namesMapping.keys.toList()
                    }
                }
            }
        } else mutableMap["reason"] = when(json["verbose_msg"]) {
            "Invalid resource, check what you are submitting" -> "Invalid format"
            "The requested resource is not among the finished, queued or pending scans" -> "no IOC"
            else -> "no IOC"
        }
        return Gson().toJson(mutableMap)
    }
}