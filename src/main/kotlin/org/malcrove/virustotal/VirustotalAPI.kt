package org.malcrove.virustotal

import org.malcrove.json.JsonParser
import org.malcrove.json.JsonPerformance
import org.malcrove.output.Output
import org.malcrove.output.StdOutput
import java.net.URL

open class VirustotalAPI {
    fun getFileScanReports(apiKey: String, resource: String = "", output: Output = StdOutput()) = URL(
            "https://www.virustotal.com/vtapi/v2/file/report?apikey=$apiKey&resource=$resource&allinfo=false")
            .readText()
            .run { JsonParser()
                    .toHashmap(this) }
                    .filterKeys { it in setOf(
                        "md5",
                        "sha256",
                        "sha1",
                        "response_code",
                        "verbose_msg",
                        "scans"
            ) }
            .let {
                JsonPerformance().handleMapping(it)
            }.run {
                output.write(this)
            }
}