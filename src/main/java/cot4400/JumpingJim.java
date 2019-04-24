package cot4400;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.SimpleDirectedGraph;

import java.util.ArrayList;
import java.util.List;

public class JumpingJim {

    public static SimpleDirectedGraph<JumpNode, DirectionLabeledEdge> buildGraph(int[][] boardMatrix) {

        SimpleDirectedGraph<JumpNode, DirectionLabeledEdge> graph = new SimpleDirectedGraph<>(DirectionLabeledEdge.class);

        for (int x = 0; x < boardMatrix.length; x++) {

            for (int y = 0; y < boardMatrix[x].length; y++) {

                int jumpedSpaces = boardMatrix[y][x];

                // Not jumping
                if (jumpedSpaces == 0)
                    continue;

                //System.out.println(" (" + x + ", " + y + ") is " + jumpedSpaces);

                for (Direction direction : Direction.values()) {

                    int landing_x = x;
                    int landing_y = y;

                    switch (direction) {
                        case NORTH:
                            landing_y -= jumpedSpaces;
                            break;
                        case SOUTH:
                            landing_y += jumpedSpaces;
                            break;
                        case EAST:
                            landing_x += jumpedSpaces;
                            break;
                        case WEST:
                            landing_x -= jumpedSpaces;
                            break;
                        default:
                            break;
                    }

                    // Check bounds
                    if (landing_x >= 0 && landing_x < boardMatrix.length && landing_y >= 0 && landing_y < boardMatrix[landing_x].length) {

                        JumpNode vertex1 = new JumpNode(x, y, jumpedSpaces);
                        JumpNode vertex2 = new JumpNode(landing_x, landing_y, boardMatrix[landing_y][landing_x]);

                        //System.out.println("Possible jump: " + vertex1 + " <->  " + vertex2);

                        // If duplicating, implementation ignores it
                        graph.addVertex(vertex1);
                        graph.addVertex(vertex2);

                        DirectionLabeledEdge edge = graph.addEdge(vertex1, vertex2);
                        edge.setDirection(direction);

                    }

                }

            }

        }

        /*System.out.println("Graph type: " + graph.getType());

        int sum = 0;
        int count = 0;

        for (JumpNode vertex : graph.vertexSet()) {
            sum += graph.outgoingEdgesOf(vertex).size();
            count++;
        }

        double average = (double) sum / count;

        System.out.println("Average outgoing edges per vertex: " + average);*/

        return graph;

    }

    public static List<Direction> jumpPathSequence(int[][] boardMatrix) {

        List<Direction> directions = new ArrayList<>();

        JumpNode start = new JumpNode(0, 0, boardMatrix[0][0]);
        JumpNode end = new JumpNode(
                boardMatrix.length - 1,
                boardMatrix[boardMatrix.length - 1].length - 1,
                boardMatrix[boardMatrix.length - 1][boardMatrix[boardMatrix.length - 1].length - 1]
        );

        SimpleDirectedGraph<JumpNode, DirectionLabeledEdge> graph = buildGraph(boardMatrix);

        GraphPath<JumpNode, DirectionLabeledEdge> path = DijkstraShortestPath.findPathBetween(graph, start, end);

        for (DirectionLabeledEdge edge : path.getEdgeList())
            directions.add(edge.getDirection());

        return directions;

    }


}
