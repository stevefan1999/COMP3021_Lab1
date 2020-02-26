package littlelang.v2.test

import littlelang.v2.lexer.Lexer
import littlelang.v2.lexer.LexerException
import littlelang.v2.node.Start
import littlelang.v2.parser.Parser
import littlelang.v2.parser.ParserException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.IOException
import java.io.PushbackReader
import java.io.Reader
import java.io.StringReader

class BasicTest {
    fun generateParseTree(reader: Reader): Start? {
        val pushbackReader = PushbackReader(reader, 1024)
        val lexer = Lexer(pushbackReader)
        val p = Parser(lexer)
        return p.parse()
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "2",
        "44 + 1",
        "2 + (44 + 1)",
        "3 * 4",
        "77 * (8 + 1)",
        "98 * (66 + (7 * 2))",
        "20 * 3 * (9 + 5)"
    ])
    @Throws(ParserException::class, IOException::class, LexerException::class)
    fun `should parse correctly`(input: String) {
        val reader = StringReader(input)
        generateParseTree(reader)
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "3 - 4",
        "77 - (8 + 1)",
        "98 - (66 + (7 * 2))",
        "20 + 3 * (9 - 5)"
    ])
    @Throws(ParserException::class, IOException::class, LexerException::class)
    fun `should not parse correctly`(input: String) {
        assertThrows(LexerException::class.java) {
            val reader = StringReader(input)
            generateParseTree(reader)
        }
    }
}