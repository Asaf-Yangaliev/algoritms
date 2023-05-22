package uz.yangaliev.tree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static uz.yangaliev.tree.Node.iterativeDepth;
import static uz.yangaliev.tree.Node.recursiveDepth;

public class NodeTest {

    @Test
    void nullNodeTest() {
        assertThrows(IllegalArgumentException.class, () -> iterativeDepth(null));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void iterativeNodeDepthTest(Node input, int expected) {
        assertEquals(iterativeDepth(input), expected);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void recursiveNodeDepthTest(Node input, int expected) {
        assertEquals(recursiveDepth(input), expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new Node(
                        new Node(
                                new Node(
                                        new Node(
                                                null,
                                                new Node(
                                                        new Node(
                                                                new Node(),
                                                                new Node()
                                                        ),
                                                        null
                                                )
                                        ),
                                        null
                                ),
                                new Node(
                                        new Node(),
                                        null
                                )
                        ),
                        new Node(
                                new Node(
                                        new Node(),
                                        new Node(
                                                new Node(
                                                        new Node(),
                                                        null
                                                ),
                                                null
                                        )
                                ),
                                null
                        )
                ),
                        7),
                Arguments.of(new Node(
                        new Node(
                                new Node(
                                        new Node(),
                                        null
                                ),
                                new Node(
                                        new Node(),
                                        null
                                )
                        ),
                        new Node(
                                new Node(
                                        new Node(),
                                        new Node(
                                                new Node(
                                                        new Node(),
                                                        null
                                                ),
                                                null
                                        )
                                ),
                                null
                        )
                ),
                        6),
                Arguments.of(new Node(
                                new Node(
                                        new Node(
                                                new Node(),
                                                null
                                        ),
                                        new Node(
                                                new Node(),
                                                null
                                        )
                                ),
                                new Node(
                                        new Node(
                                                new Node(),
                                                new Node(
                                                        new Node(),
                                                        null
                                                )
                                        ),
                                        null
                                )
                        ),
                        5),
                Arguments.of(new Node(
                        new Node(
                                new Node(
                                        new Node(),
                                        null
                                ),
                                new Node(
                                        new Node(),
                                        null
                                )
                        ),
                        new Node(
                                new Node(
                                        new Node(),
                                        null
                                ),
                                null
                        )
                ),
                        4),
                Arguments.of(new Node(
                        new Node(
                                new Node(),
                                null
                        ),
                        new Node(
                        )
                ),
                        3),
                Arguments.of(new Node(
                        new Node(),
                        null
                ),
                        2),
                Arguments.of(new Node(),
                        1)
            );
    }
}
