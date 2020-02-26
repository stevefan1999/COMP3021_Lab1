package littlelang.test

import littlelang.v1.lexer.Lexer
import littlelang.v1.lexer.LexerException
import littlelang.v1.parser.Parser
import littlelang.v1.parser.ParserException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.IOException
import java.io.PushbackReader
import java.io.StringReader

class BasicTest {
    @ParameterizedTest
    @ValueSource(strings = [
        "2",
        "44 + 1",
        "2 + (44 + 1)"
    ])
    @Throws(ParserException::class, IOException::class, LexerException::class)
    fun `should parse correctly`(input: String) {
        val reader = StringReader(input)
        val pushbackReader = PushbackReader(reader, 1024)
        val lexer = Lexer(pushbackReader)
        val p = Parser(lexer)
        val tree = p.parse()
        println(tree.toString())
    }
}