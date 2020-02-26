package littlelang.v3.test

import littlelang.v3.lexer.Lexer
import littlelang.v3.lexer.LexerException
import littlelang.v3.node.Start
import littlelang.v3.parser.Parser
import littlelang.v3.parser.ParserException
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.IOException
import java.io.PushbackReader
import java.io.Reader
import java.io.StringReader

class BasicTest {
    private fun generateParseTree(reader: Reader): Start? {
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
        "1 + (1 + (1 + (1 + (1 + (1 + 1)))))",
        "3 * 4",
        "77 * (8 + 1)",
        "98 * (66 + (7 * 2))",
        "20 * 3 * (9 + 5)",
        "3 - 4",
        "77 - (8 + 1)",
        "98 - (66 + (7 * 2))",
        "20 + 3 * (9 - 5)",
        "88 / 13",
        "75 / (20 + 3)",
        "101 * 333/106",
        "1 - 1/7"
    ])
    @Throws(ParserException::class, IOException::class, LexerException::class)
    fun `should parse correctly`(input: String) {
        val reader = StringReader(input)
        generateParseTree(reader)
    }
}