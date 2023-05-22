package uz.yangaliev.tree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static uz.yangaliev.tree.Node.depth;

public class NodeTest {

    @Test
    void nullNodeTest() {
        assertThrows(IllegalArgumentException.class, () -> depth(null));
    }

    @ParameterizedTest
    @MethodSource("testStream")
    void nodeDepthTest(Node input, int expected) {
        assertEquals(depth(input), expected);
    }

    static Stream testStream() {
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
