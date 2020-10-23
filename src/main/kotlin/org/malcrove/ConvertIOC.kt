package org.malcrove

import com.google.gson.Gson
import org.malcrove.virustotal.VirustotalAPI
import java.io.File

object ConvertIOC {
    @JvmStatic
    fun main(args: Array<String>) {
        val apiKey: String = File("src/main/resources/token.txt").readText(Charsets.UTF_8)
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