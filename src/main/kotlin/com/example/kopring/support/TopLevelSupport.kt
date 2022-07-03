package com.example.kopring.support

import java.io.PrintWriter
import java.io.StringWriter

fun Exception.stackTrace(): String {
    val sw = StringWriter()
    val pw = PrintWriter(sw)
    this.printStackTrace(pw)
    return sw.toString()
}