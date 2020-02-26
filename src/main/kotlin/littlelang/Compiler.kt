package littlelang

import littlelang.v1.lexer.Lexer
import littlelang.v1.parser.Parser
import java.io.BufferedReader
import java.io.FileReader
import java.io.PushbackReader

object Compiler {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            val `in` = FileReader(args[0])
            val bufferedReader = BufferedReader(`in`)
            val pushbackReader = PushbackReader(bufferedReader, 1024)
            val lexer = Lexer(pushbackReader)
            val p = Parser(lexer)
            val tree = p.parse()
            println(tree.toString())
        } catch (e: Exception) {
            println(e.message)
        }
    }
}