package assignlang

import assignlang.lexer.*
import assignlang.node.*
import assignlang.parser.*
import java.io.BufferedReader
import java.io.FileReader
import java.io.PushbackReader

object Compiler {
    @JvmStatic
    fun main(args: Array<String>) {
        try { // Create a Parser instance.
            val fileReader = FileReader(args[0])
            val bufferedReader = BufferedReader(fileReader)
            val pushbackReader = PushbackReader(bufferedReader, 1024)
            val lexer = Lexer(pushbackReader)
            val p = Parser(lexer)
            // Parse the input.
            val tree: Start = p.parse()
            tree.apply(SemanticAnalyzer())
        } catch (e: Exception) {
            println(e.message)
        }
    }
}