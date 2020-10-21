package org.malcrove

import com.google.gson.Gson

object ConvertIOC {
    @JvmStatic
    fun main(args: Array<String>) {
        val apiKey: String = "c25d5ce28215f4ffd76798a4069b976262e8ac100d4f7e81165038d7e92bc40f"
        val resource: String = if (args.isNotEmpty()) args[0] else ""
        if (args.size > 1) {
            print(Gson().toJson(
                mapOf("status" to "false","reason" to "Invalid format")
            ))
        } else {
            VirustotalAPI().getFileScanReports(apiKey, resource)
        }
    }
}