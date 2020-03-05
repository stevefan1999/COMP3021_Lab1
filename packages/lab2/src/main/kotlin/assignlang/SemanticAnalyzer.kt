package assignlang

import assignlang.analysis.DepthFirstAdapter
import assignlang.node.AAssignAssignrest
import assignlang.node.AAssignStatement
import assignlang.node.ADeclareStatement
import assignlang.node.TIdentifier

class SemanticAnalyzer : DepthFirstAdapter() {
    private var identSeen = listOf<String>()

    override fun caseTIdentifier(node: TIdentifier) {
        println("ident node seen: $node")
        identSeen = identSeen + node.text
    }

    override fun outAAssignAssignrest(node: AAssignAssignrest) {
        println("AAssignAssignrest node: $node")
        println("AAssignAssignrest right identifier seen: " + node.identifier)
    }

    override fun outADeclareStatement(node: ADeclareStatement) {
        println("ADeclareStatement node: $node")
        println("ADeclareStatement Identifier node: " + node.identifier)
    }

    override fun outAAssignStatement(node: AAssignStatement) {
        println("AAssignStatement node: $node")
        println("AAssignStatement node: " + node.identifier)
    }

}