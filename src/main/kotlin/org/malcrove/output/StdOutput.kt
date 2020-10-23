package org.malcrove.output

class StdOutput: Output {
    override fun write(str: String?) {
        println(str)
    }
}